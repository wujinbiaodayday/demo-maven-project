package com.ddc.common.demo.jms;

import com.alibaba.fastjson.JSON;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Objects;
import java.util.UUID;

/**
 * 消息生产者
 */
public abstract class AbstractRabbitMqMessageProducer {
    private static final Logger log = LoggerFactory.getLogger(AbstractRabbitMqMessageProducer.class);

    protected RabbitAdmin rabbitAdmin;

    protected RabbitTemplate rabbitTemplate;

    protected String routingKey;

    protected Queue queue;

    protected Exchange exchange;

    public void commonInitBind() {
        if (null == queue || null == exchange || null == routingKey) {
            throw new IllegalArgumentException("启动异常，MQ设置有问题");
        }
        //如果不转换成DirectExchange 就需要加 .noargs()
        Binding binding = BindingBuilder.bind(queue).to((DirectExchange) exchange).with(routingKey);
        rabbitAdmin.declareBinding(binding);
    }

    public abstract void initBind();

    /**
     * 无返回消息的
     */
    public void send(Object message) {
        if (null == message) {
            throw new IllegalArgumentException("message 不能为空");
        }
        CorrelationData correlationData = new CorrelationData(UUID.randomUUID().toString());
        String messageStr = JSON.toJSONString(message);
        getRabbitTemplate().convertAndSend(getExchange().getName(), getRoutingKey(), messageStr, correlationData);
        log.info("{} 消息体为：{} >>>>>>>>>> Already sent message", correlationData, messageStr);
    }

    /**
     * 无返回消息的
     */
    public void send(String message) {
        if (StringUtils.isEmpty(message)) {
            throw new IllegalArgumentException("message 不能为空");
        }
        CorrelationData correlationData = new CorrelationData(UUID.randomUUID().toString());
        getRabbitTemplate().convertAndSend(getExchange().getName(), getRoutingKey(), message, correlationData);
        log.info("{} 消息体为：{} >>>>>>>>>> Already sent message", correlationData, message);
    }

    /**
     * 有返回消息的，需要注意一些问题
     */
    public void sendAndReceive(Object message) {
        if (null == message) {
            throw new IllegalArgumentException("message 不能为空");
        }
        CorrelationData correlationData = new CorrelationData(UUID.randomUUID().toString());
        String messageStr = JSON.toJSONString(message);
        Object o = getRabbitTemplate().convertSendAndReceive(getExchange().getName(),
                getRoutingKey(), messageStr, correlationData);
        log.info("{} 消息体为：{} >>>>>>>>>>> 接收到返回消息为：{} ", correlationData, messageStr, Objects.toString(o));
    }

    /**
     * 有返回消息的，需要注意一些问题
     */
    public void sendAndReceive(String message) {
        if (null == message) {
            throw new IllegalArgumentException("message 不能为空");
        }
        CorrelationData correlationData = new CorrelationData(UUID.randomUUID().toString());
        Object o = getRabbitTemplate().convertSendAndReceive(getExchange().getName(),
                getRoutingKey(), message, correlationData);
        log.info("{} 消息体为：{} >>>>>>>>>>> 接收到返回消息为：{} ", correlationData, message, Objects.toString(o));
    }


    public RabbitAdmin getRabbitAdmin() {
        return rabbitAdmin;
    }

    public void setRabbitAdmin(RabbitAdmin rabbitAdmin) {
        this.rabbitAdmin = rabbitAdmin;
    }

    public RabbitTemplate getRabbitTemplate() {
        return rabbitTemplate;
    }

    public void setRabbitTemplate(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public Queue getQueue() {
        return queue;
    }

    public void setQueue(Queue queue) {
        this.queue = queue;
    }

    public Exchange getExchange() {
        return exchange;
    }

    public void setExchange(Exchange exchange) {
        this.exchange = exchange;
    }

    /**
     * 获取RoutingKey
     *
     * @return
     */
    public String getRoutingKey() {
        return routingKey;
    }


    public void setRoutingKey(String routingKey) {
        this.routingKey = routingKey;
    }

}
