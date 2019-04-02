package com.ddc.common.demo.jms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;

public class MsgSendConfirmCallback implements RabbitTemplate.ConfirmCallback {
    private static final Logger log = LoggerFactory.getLogger(MsgSendConfirmCallback.class);

    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String cause) {
        if (ack) {
            log.info(">>>>>>> 消息id:{} 发送成功", correlationData.getId());
        } else {
            log.info(">>>>>>> 消息id:{} 发送失败  原因为：{}", correlationData.getId(), cause);
        }
    }
}
