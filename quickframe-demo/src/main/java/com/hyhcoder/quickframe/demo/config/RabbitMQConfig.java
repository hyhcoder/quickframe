package com.hyhcoder.quickframe.demo.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hyhcoder
 * @date 2020/5/7 21:56
 */
@Configuration
public class RabbitMQConfig {
	
	/**
	 * 	延迟交换机
	 */
	public static final String DELAY_EXCHANGE_NAME = "delay.queue.exchange";
	/**
	 * 相关routingKey和queue
	 */
	public static final String DELAY_QUEUEA_NAME = "delay.queue.queuea";
	public static final String DELAY_QUEUEB_NAME = "delay.queue.queueb";
	public static final String DELAY_QUEUEC_NAME = "delay.queue.queuec";
	public static final String DELAY_QUEUEA_ROUTING_KEY = "delay.queue.queuea.routingkey";
	public static final String DELAY_QUEUEB_ROUTING_KEY = "delay.queue.queueb.routingkey";
	public static final String DELAY_QUEUEC_ROUTING_KEY = "delay.queue.queuec.routingkey";
	
	/**
	 * 死信交换机
	 */
	private static final String DEAD_LETTER_EXCHANGE = "delay.queue.deadletter.exchange";
	/**
	 * 死信routingKey和queue
	 */
	private static final String DEAD_LETTER_QUEUEA_ROUTING_KEY = "delay.queue.deadletter.delay_10s.routingkey";
	private static final String DEAD_LETTER_QUEUEB_ROUTING_KEY = "delay.queue.deadletter.delay_60s.routingkey";
	private static final String DEAD_LETTER_QUEUEC_ROUTING_KEY = "delay.queue.deadletter.delay_anytime.routingkey";
	public static final String DEAD_LETTER_QUEUEA_NAME = "delay.queue.deadletter.queuea";
	public static final String DEAD_LETTER_QUEUEB_NAME = "delay.queue.deadletter.queueb";
	public static final String DEAD_LETTER_QUEUEC_NAME = "delay.queue.deadletter.queuec";
	
	/**
	 * 声明延迟交换机
	 */
	@Bean("delayExchange")
	public DirectExchange delayExchange() {
		return new DirectExchange(DELAY_EXCHANGE_NAME);
	}
	
	/**
	 * 声明延时队列A 延时10s
	 * 并绑定到对应的死信交换机
	 */
	@Bean("delayQueueA")
	public Queue delayQueueA() {
		Map<String, Object> args = new HashMap<>(3);
		
		args.put("x-dead-letter-exchange", DEAD_LETTER_EXCHANGE);
		args.put("x-dead-letter-routing-key", DEAD_LETTER_QUEUEA_ROUTING_KEY);
		// x-message-ttl  声明队列的TTL, 毫秒
		args.put("x-message-ttl", 10000);
		
		return QueueBuilder.durable(DELAY_QUEUEA_NAME).withArguments(args).build();
	}
	
	/**
	 * 声明延时队列B 延时60s
	 * 并绑定到对应的死信交换机
	 */
	@Bean("delayQueueB")
	public Queue delayQueueB() {
		Map<String, Object> args = new HashMap<>(3);
		
		args.put("x-dead-letter-exchange", DEAD_LETTER_EXCHANGE);
		args.put("x-dead-letter-routing-key", DEAD_LETTER_QUEUEB_ROUTING_KEY);
		// x-message-ttl  声明队列的TTL, 毫秒
		args.put("x-message-ttl", 60000);
		
		return QueueBuilder.durable(DELAY_QUEUEB_NAME).withArguments(args).build();
	}
	
	
	/**
	 * 声明延时队列C 不设置TTL
	 * 并绑定到对应的死信交换机
	 */
	@Bean("delayQueueC")
	public Queue delayQueueC() {
		Map<String, Object> args = new HashMap<>(3);
		
		args.put("x-dead-letter-exchange", DEAD_LETTER_EXCHANGE);
		args.put("x-dead-letter-routing-key", DEAD_LETTER_QUEUEC_ROUTING_KEY);
		
		return new Queue(DELAY_QUEUEC_NAME, true, false, false, args);
	}
	
	/**
	 * 声明死信交换机
	 */
	@Bean("deadLetterExchange")
	public DirectExchange deadLetterExchange() {
		return new DirectExchange(DEAD_LETTER_EXCHANGE);
	}
	
	/**
	 * 死信队列A, 用于接收延时10s处理的消息
	 */
	@Bean("deadLetterQueueA")
	public Queue deadLetterQueueA() {
		return new Queue(DEAD_LETTER_QUEUEA_NAME);
	}
	
	/**
	 * 死信队列B, 用于接收延时60s处理的消息
	 */
	@Bean("deadLetterQueueB")
	public Queue deadLetterQueueB() {
		return new Queue(DEAD_LETTER_QUEUEB_NAME);
	}
	
	/**
	 * 死信队列C, 用于接收任意时长的消息
	 */
	@Bean("deadLetterQueueC")
	public Queue deadLetterQueueC() {
		return new Queue(DEAD_LETTER_QUEUEC_NAME);
	}
	
	/**
	 * 声明延时队列A绑定关系
	 */
	@Bean
	public Binding delayBindingA(@Qualifier("delayQueueA") Queue queue,
			@Qualifier("delayExchange") DirectExchange exchange) {
		return BindingBuilder.bind(queue).to(exchange).with(DELAY_QUEUEA_ROUTING_KEY);
	}
	
	/**
	 * 声明延时队列B绑定关系
	 */
	@Bean
	public Binding delayBindingB(@Qualifier("delayQueueB") Queue queue,
			@Qualifier("delayExchange") DirectExchange exchange) {
		return BindingBuilder.bind(queue).to(exchange).with(DELAY_QUEUEB_ROUTING_KEY);
	}
	
	/**
	 * 声明延时队列C绑定关系
	 */
	@Bean
	public Binding delayBindingC(@Qualifier("delayQueueC") Queue queue,
			@Qualifier("delayExchange") DirectExchange exchange) {
		return BindingBuilder.bind(queue).to(exchange).with(DELAY_QUEUEC_ROUTING_KEY);
	}
	
	/**
	 * 声明死信队列A绑定关系
	 */
	@Bean
	public Binding deadLetterBindingA(@Qualifier("deadLetterQueueA") Queue queue,
			@Qualifier("deadLetterExchange") DirectExchange exchange) {
		return BindingBuilder.bind(queue).to(exchange).with(DEAD_LETTER_QUEUEA_ROUTING_KEY);
	}
	
	/**
	 * 声明死信队列B绑定关系
	 */
	@Bean
	public Binding deadLetterBindingB(@Qualifier("deadLetterQueueB") Queue queue,
			@Qualifier("deadLetterExchange") DirectExchange exchange) {
		return BindingBuilder.bind(queue).to(exchange).with(DEAD_LETTER_QUEUEB_ROUTING_KEY);
	}
	
	/**
	 * 声明死信队列C绑定关系
	 */
	@Bean
	public Binding deadLetterBindingC(@Qualifier("deadLetterQueueC") Queue queue,
			@Qualifier("deadLetterExchange") DirectExchange exchange) {
		return BindingBuilder.bind(queue).to(exchange).with(DEAD_LETTER_QUEUEC_ROUTING_KEY);
	}
	
}
