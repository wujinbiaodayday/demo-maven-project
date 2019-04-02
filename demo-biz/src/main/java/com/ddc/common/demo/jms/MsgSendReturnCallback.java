package com.ddc.common.demo.jms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;


public class MsgSendReturnCallback implements RabbitTemplate.ReturnCallback {
    private static final Logger log = LoggerFactory.getLogger(MsgSendReturnCallback.class);


    /**
     * Returned message callback.
     *
     * @param message    the returned message.
     * @param replyCode  the reply code.
     * @param replyText  the reply text.
     * @param exchange   the exchange.
     * @param routingKey the routing key.
     */
    @Override
    public void returnedMessage(Message message, int replyCode, String replyText, String exchange, String routingKey) {
        log.info("消息return-message:[{}] replyCode:[{}] replyText:[{}] exchange:[{}] routingKey:[{}] 发送失败",
                new String(message.getBody()), replyCode, replyText, exchange, routingKey);
    }
}
