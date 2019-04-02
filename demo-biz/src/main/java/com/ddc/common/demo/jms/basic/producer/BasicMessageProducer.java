package com.ddc.common.demo.jms.basic.producer;

import com.alibaba.fastjson.JSON;
import com.ddc.common.demo.jms.AbstractMessageProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;

import java.util.UUID;

/**
 * 消息生产者
 */
public class BasicMessageProducer {
    private static final Logger logger = LoggerFactory.getLogger(AbstractMessageProducer.class);

    private AmqpTemplate amqpTemplate;
    private String routingKey;


    public void sendMessage(Object message) {
        logger.info("to send message:{}", message);
       //CorrelationData correlationData = new CorrelationData(UUID.randomUUID().toString());
        String messageStr = JSON.toJSONString(message);
        amqpTemplate.convertAndSend(getRoutingKey(), message);
        //amqpTemplate.convertAndSend(getRoutingKey(), message);
        logger.info("success send message:{}", messageStr);
    }

    public void sendMessage(String message) {
        logger.info("to send message:{}", message);
        //CorrelationData correlationData = new CorrelationData(UUID.randomUUID().toString());
        amqpTemplate.convertAndSend(getRoutingKey(), message);
        //amqpTemplate.convertAndSend(getRoutingKey(), message);
        logger.info("success send message:{}", message);
    }

    public AmqpTemplate getAmqpTemplate() {
        return amqpTemplate;
    }

    public void setAmqpTemplate(AmqpTemplate amqpTemplate) {
        this.amqpTemplate = amqpTemplate;
    }

    public String getRoutingKey() {
        return routingKey;
    }

    public void setRoutingKey(String routingKey) {
        this.routingKey = routingKey;
    }
}
