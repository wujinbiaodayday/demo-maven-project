package com.ddc.common.demo.job;

import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@JobHandler("xxlJobExample")
public class XXLjobExample extends IJobHandler {

    private final static Logger LOGGER = LoggerFactory.getLogger(XXLjobExample.class);

    @Override
    public ReturnT<String> execute(String s) throws Exception {
        LOGGER.info("###########XXLjobExample start ##########");

        //to do 业务

        LOGGER.info("###########XXLjobExample end ##########");
        return new ReturnT<>("XXLjobExample success");
    }
}
