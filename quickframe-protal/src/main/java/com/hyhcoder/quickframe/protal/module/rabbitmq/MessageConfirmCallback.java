package com.hyhcoder.quickframe.protal.module.rabbitmq;

import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

/**
 * @author hyhcoder
 * @date 2020/10/6 15:17
 *
 * 用于消息的ack确认
 */
public class MessageConfirmCallback implements RabbitTemplate.ConfirmCallback {
	
	
	@Override
	public void confirm(CorrelationData correlationData, boolean ack, String cause) {
		// 这里的ack是Broker对发布者消息达到服务端的确认
		System.out.println("callback confirm: " + correlationData.getId() + " ACK : " + ack + " cause : " + cause);
	}
}
