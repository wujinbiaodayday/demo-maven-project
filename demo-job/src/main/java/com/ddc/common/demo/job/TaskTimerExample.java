package com.ddc.common.demo.job;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class TaskTimerExample {
    private static final Logger LOGGER = LoggerFactory.getLogger(TaskTimerExample.class);

    @Scheduled(cron = "0 0/1 * * * ? ")
    public void createExample() {
        LOGGER.info("###########createExample start ##########");

        //to do 业务

        LOGGER.info("###########createExample end ##########");
    }
}
