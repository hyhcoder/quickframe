package com.hyhcoder.quickframe.protal.module.rabbitmq;

import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.RabbitListenerContainerFactory;
import org.springframework.amqp.support.converter.SerializerMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author hyhcoder
 * @date 2020/10/6 8:57
 *
 * 自定义一个消息接收转换器
 *
 */
@Configuration
public class MessageAdaptCover {
	
	@Bean("myContainerFactory")
	public RabbitListenerContainerFactory<?> rabbitListenerContainerFactory(ConnectionFactory connectionFactory) {
		
		SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
		// 赋值
		factory.setConnectionFactory(connectionFactory);
		factory.setMessageConverter(new SerializerMessageConverter());
		//new MessageContentsDelegate
		return factory;
	}
	
}
