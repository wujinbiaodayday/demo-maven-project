package com.ddc.common.demo.common.util.lock.redislock;

import com.ddc.common.api.exception.BusinessException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;

import java.util.Collections;
import java.util.List;

@Component
public class RedisAtomicClient {
    private static final Logger logger = LoggerFactory.getLogger(RedisAtomicClient.class);
    private static final String LOCK_SUCCESS = "OK";
    private static final String SET_IF_NOT_EXIST = "NX";
    private static final String SET_WITH_EXPIRE_TIME = "PX";
    @Autowired
    private final RedisTemplate redisTemplate;
    @Autowired
    private final StringRedisTemplate stringRedisTemplate;

    private static final String COMPARE_AND_DELETE =
            "if redis.call('get',KEYS[1]) == ARGV[1]\n" +
                    "then\n" +
                    "    return redis.call('del',KEYS[1])\n" +
                    "else\n" +
                    "    return 0\n" +
                    "end";

    public RedisAtomicClient(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
        this.stringRedisTemplate = new StringRedisTemplate();
        this.stringRedisTemplate.setConnectionFactory(redisTemplate.getConnectionFactory());
        this.stringRedisTemplate.afterPropertiesSet();
    }




    /**
     * 获取redis的分布式锁，内部实现使用了redis的setnx。只会尝试一次，如果锁定失败返回null，如果锁定成功则返回RedisLock对象，调用方需要调用RedisLock.unlock()方法来释放锁.
     * <br/>使用方法：
     * <pre>
     * RedisLock lock = redisAtomicClient.getLock(key, 2);
     * if(lock != null){
     *      try {
     *          //lock succeed, do something
     *      }finally {
     *          lock.unlock();
     *      }
     * }
     * </pre>
     * 由于RedisLock实现了AutoCloseable,所以可以使用更简介的使用方法:
     * <pre>
     *  try(RedisLock lock = redisAtomicClient.getLock(key, 2)) {
     *      if (lock != null) {
     *          //lock succeed, do something
     *      }
     *  }
     * </pre>
     *
     * @param key           要锁定的key
     * @param expireSeconds key的失效时间
     * @return 获得的锁对象（如果为null表示获取锁失败），后续可以调用该对象的unlock方法来释放锁.
     */
    public RedisLock getLock(final String key, long expireSeconds) throws BusinessException {
        return getLock(key, expireSeconds, 0, 0);
    }

    /**
     * 获取redis的分布式锁，内部实现使用了redis的setnx。如果锁定失败返回null，如果锁定成功则返回RedisLock对象，调用方需要调用RedisLock.unlock()方法来释放锁
     * <br/>
     * <span style="color:red;">此方法在获取失败时会自动重试指定的次数,由于多次等待会阻塞当前线程，请尽量避免使用此方法</span>
     *
     * @param key                     要锁定的key
     * @param expireSeconds           key的失效时间
     * @param maxRetryTimes           最大重试次数,如果获取锁失败，会自动尝试重新获取锁；
     * @param retryIntervalTimeMillis 每次重试之前sleep等待的毫秒数
     * @return 获得的锁对象（如果为null表示获取锁失败），后续可以调用该对象的unlock方法来释放锁.
     */
    public RedisLock getLock(final String key, final long expireSeconds, int maxRetryTimes, long retryIntervalTimeMillis) throws BusinessException {
        final String value = key.hashCode() + "";
        int maxTimes = maxRetryTimes + 1;
        for (int i = 0; i < maxTimes; i++) {
            String status = null;
            try {
                status = stringRedisTemplate.execute(new RedisCallback<String>() {
                    @Override
                    public String doInRedis(RedisConnection connection) throws DataAccessException {
                        Jedis jedis = (Jedis) connection.getNativeConnection();
                        String status = jedis.set(key, value, SET_IF_NOT_EXIST, SET_WITH_EXPIRE_TIME, expireSeconds);
                        return status;
                    }
                });
            } catch (Exception e) {
                logger.error("连接redis失败");
                throw new BusinessException("连接redis失败",e);
            }
            if (LOCK_SUCCESS.equals(status)) {//抢到锁
                logger.info("获取到redis锁");
                return new RedisLockInner(true, stringRedisTemplate, key, value);
            }
            if (retryIntervalTimeMillis > 0) {
                try {
                    Thread.sleep(retryIntervalTimeMillis);
                } catch (InterruptedException e) {
                    logger.error("线程等待打断");
                    break;
                }
            }
            if (Thread.currentThread().isInterrupted()) {
                break;
            }
        }
        return new RedisLockInner(false, stringRedisTemplate, key, value);
    }

    private class RedisLockInner implements RedisLock {
        private boolean isSuccess;
        private StringRedisTemplate stringRedisTemplate;
        private String key;
        private String expectedValue;

        protected RedisLockInner(boolean isSuccess, StringRedisTemplate stringRedisTemplate, String key, String expectedValue) {
            this.stringRedisTemplate = stringRedisTemplate;
            this.key = key;
            this.expectedValue = expectedValue;
            this.isSuccess = isSuccess;
        }

        /**
         * 释放redis分布式锁
         */
        @Override
        public void unlock() {
            try {
                if(isSuccess){
                    List<String> keys = Collections.singletonList(key);
                    stringRedisTemplate.execute(new DefaultRedisScript<>(COMPARE_AND_DELETE, String.class), keys, expectedValue);
                }
            } catch (Exception e) {
                logger.error("锁关闭失败，锁自动关闭", e);
            }
        }

        @Override
        public void close() throws Exception {
            this.unlock();
        }

        @Override
        public boolean isSuccess(){
            return isSuccess;
        }
    }
}
