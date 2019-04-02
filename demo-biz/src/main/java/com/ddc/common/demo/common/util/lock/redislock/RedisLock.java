package com.ddc.common.demo.common.util.lock.redislock;

public interface RedisLock extends AutoCloseable{
    /**
     * 释放分布式锁
     */
    void unlock();

    /**
     * 是否获取到锁
     * @return
     */
    boolean isSuccess();
}
