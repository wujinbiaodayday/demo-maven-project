package com.ddc.common.demo.service.system;

import com.ddc.common.demo.api.system.DemoSystemService;
import com.ddc.common.demo.biz.basic.biz.async.AsyncBasicService;
import com.ddc.common.demo.jms.basic.producer.BasicMessageProducer;
import com.ddc.common.logs.LogBetter;
import com.ddc.common.logs.LogLevel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component("demoSystemService")
public class DemoSystemServiceImpl implements DemoSystemService {

    public final static Logger logger = LoggerFactory.getLogger(DemoSystemServiceImpl.class);

    @Resource
    private BasicMessageProducer basicMessageProducer;

    @Resource
    private AsyncBasicService asyncBasicService;

    @Override
    public void testSendMsg(String msg) {
        basicMessageProducer.sendMessage(msg);
    }

    /**
     * 在@Async标注的方法，同时也适用了@Transactional进行了标注；在其调用数据库操作之时，
     * 将无法产生事务管理的控制，原因就在于其是基于异步处理的操作。
     *
     *那该如何给这些操作添加事务管理呢？
     * 可以将需要事务管理操作的方法放置到异步方法内部，在内部被调用的方法上添加@Transactional.
     *
     *     例如： 方法A，使用了@Async/@Transactional来标注，但是无法产生事务控制的目的。
     *           方法B，使用了@Async来标注，  B中调用了C、D，C/D分别使用@Transactional做了标注，则可实现事务控制的目的。
     * @param msg
     */
    @Override
    public void testAsyncFunc(String msg) {
        LogBetter.instance(logger)
                .setLevel(LogLevel.INFO)
                .setMsg("开始调用异步方法" + Thread.currentThread().getName())
                .setParams(msg)
                .log();
        asyncBasicService.testAsync(msg);
        LogBetter.instance(logger)
                .setLevel(LogLevel.INFO)
                .setMsg("结束调用异步方法" + Thread.currentThread().getName())
                .setParams(msg)
                .log();
    }
}
