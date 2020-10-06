package com.hyhcoder.quickframe.protal.module.rabbitmq;

import com.hyhcoder.quickframe.protal.module.rabbitmq.model.MessageBody;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.SerializerMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

import static com.hyhcoder.quickframe.protal.module.rabbitmq.RabbitMQConfig.MULTI_EXCHANGE;
import static com.hyhcoder.quickframe.protal.module.rabbitmq.RabbitMQConfig.ROUNTING_KEY_A;

/**
 * @author hyhcoder
 * @date 2020/10/5 21:06
 *
 * mq消息发送
 *
 * 主要就3种;
 * 1.普通
 * 2.事务
 * 3.异步ack;(这个是主要用的)(配合开启客户端手动ack消息来保证消息的不丢失)
 *
 */
@Component
@Slf4j
public class MessageSender {
	
	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	
	/**
	 * 最简单的直接发送数据
	 * 这种发送是没有任何保障的, 最基本的发送
	 *
	 * 消息发送一般是string和byte[], 一般要进行序列化发送
	 */
	public void sendMessage(String message) {
		
		MessageBody messageBody = new MessageBody();
		messageBody.setId(1235);
		messageBody.setName(message);
		
		rabbitTemplate.setMessageConverter(new SerializerMessageConverter());
		rabbitTemplate.convertAndSend(MULTI_EXCHANGE, ROUNTING_KEY_A, messageBody);
	}
	
	/**
	 * 事务发送
	 *
	 * 配合spring的事务注解, 可以达到错误回滚的目的;
	 */
	@Transactional(rollbackFor = Exception.class)
	public void sendMessageTransaction(String message) {
		
		MessageBody messageBody = new MessageBody();
		messageBody.setId(1277);
		messageBody.setName(message);
		
		// 重点, 信道开启事务
		rabbitTemplate.setChannelTransacted(true);
		rabbitTemplate.setMessageConverter(new SerializerMessageConverter());
		rabbitTemplate.convertAndSend(MULTI_EXCHANGE, ROUNTING_KEY_A, messageBody);
		
		// 异常
		//int a = 1/0;
	}
	
	/**
	 * 发送后ack, 这种比事务好在可以批量和异步ack, 增加吞吐量, 10倍左右
	 */
	public void sendMessageAck(String message) {
		
		MessageBody messageBody = new MessageBody();
		// id可以用于客户端业务去重, 幂等
		messageBody.setId(1299898);
		messageBody.setName(message);
		
		// 设置ack的确认回调
		rabbitTemplate.setConfirmCallback(new MessageConfirmCallback());
		
		// 消息投递到队列失败回调处理
		// 记录, 或者补偿处理
		rabbitTemplate.setReturnCallback((message1, replyCode, replyText, exchange, routingKey) -> log
				.info("returnedMessage ===> replyCode={} ,replyText={} ,exchange={} ,routingKey={}", replyCode,
						replyText, exchange, routingKey));
		
		// 赋予应答的id;
		// 这个用业务字段来也可以, 注意就是每个rabbitTemplate对象, 每个一样的只能发一次
		// Only one ConfirmCallback is supported by each RabbitTemplate
		CorrelationData correlationData = new CorrelationData(UUID.randomUUID().toString());
		rabbitTemplate.setMessageConverter(new SerializerMessageConverter());
		rabbitTemplate.convertAndSend(MULTI_EXCHANGE, ROUNTING_KEY_A, messageBody, correlationData);
	}
	
}
