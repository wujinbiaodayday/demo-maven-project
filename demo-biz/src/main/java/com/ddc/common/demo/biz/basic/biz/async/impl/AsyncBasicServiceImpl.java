package com.ddc.common.demo.biz.basic.biz.async.impl;

import com.ddc.common.demo.biz.basic.biz.async.AsyncBasicService;
import com.ddc.common.logs.LogBetter;
import com.ddc.common.logs.LogLevel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component("asyncBasicService")
public class AsyncBasicServiceImpl implements AsyncBasicService {

    public final static Logger logger = LoggerFactory.getLogger(AsyncBasicServiceImpl.class);

    @Async
    @Override
    public void testAsync(String param) {
        String sName = Thread.currentThread().getName();
        LogBetter.instance(logger)
                .setLevel(LogLevel.INFO)
                .setMsg("实际调用异步方法" + sName)
                .setParams(param)
                .log();

    }
}
