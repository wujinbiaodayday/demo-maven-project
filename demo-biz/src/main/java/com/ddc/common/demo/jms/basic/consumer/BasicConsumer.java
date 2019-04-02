package com.ddc.common.demo.jms.basic.consumer;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;

public class BasicConsumer implements MessageListener {
    private Logger LOGGER = LoggerFactory.getLogger(BasicConsumer.class);

    @Override
    public void onMessage(Message message) {
        LOGGER.info("chris receive message------->:{}", message);
    }
}