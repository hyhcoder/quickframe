package com.hyhcoder.quickframe.protal.module.rabbitmq;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author hyhcoder
 * @date 2020/10/5 20:11
 *
 * 用于声明mq的队列, 交换器, 绑定等
 *
 * 这里一启动就会自动的创建相应的交换机, 队列, 绑定等;
 *
 * 如果需要统一的rabbitMqTemplate这些统一设置, 都可以搞一个
 *
 */
@Configuration
public class RabbitMQConfig {
	
	
	/**
	 * 交换机
	 */
	public final static String MULTI_EXCHANGE = "multiExchange";
	
	public final static String FANOUT_EXCHANGE = "fanoutExchange";
	
	/**
	 * 相关routingKey和queue
	 */
	public final static String ROUNTING_KEY_A = "x_A";
	public final static String QUEUE_A = "queue_A";
	public final static String QUEUE_B = "queue_B";
	
	
	/**
	 * 声明交换机
	 * 这里主要可以声明各种交换机的类型, 最多用的就是direct, fanout, topic
	 *
	 * 默认创建的是持久化的, 可以加各种参数
	 */
	@Bean("multiExchange")
	public DirectExchange multiExchange() {
		return new DirectExchange(MULTI_EXCHANGE);
	}
	
	/**
	 * 声明fanout交换器
	 */
	@Bean("fanoutExchange")
	public FanoutExchange fanoutExchange() {
		return new FanoutExchange(FANOUT_EXCHANGE);
	}
	
	/**
	 * 声明队列A
	 */
	@Bean("queueA")
	public Queue queueA() {
		
		return QueueBuilder.durable(QUEUE_A).build();
	}
	
	/**
	 * 声明队列B
	 */
	@Bean("queueB")
	public Queue queueB() {
		
		return QueueBuilder.durable(QUEUE_B).build();
	}
	
	/**
	 * 绑定队列到对应的交换机
	 */
	@Bean
	public Binding queueBindingA(@Qualifier("queueA") Queue queue,
			@Qualifier("multiExchange") DirectExchange exchange) {
		return BindingBuilder.bind(queue).to(exchange).with(ROUNTING_KEY_A);
	}
	
	@Bean
	public Binding queueBindingB(@Qualifier("queueB") Queue queue,
			@Qualifier("fanoutExchange") FanoutExchange exchange) {
		return BindingBuilder.bind(queue).to(exchange);
	}
	
	@Bean
	public Binding queueBindingFanoutA(@Qualifier("queueA") Queue queue,
			@Qualifier("fanoutExchange") FanoutExchange exchange) {
		return BindingBuilder.bind(queue).to(exchange);
	}
	
	
}
