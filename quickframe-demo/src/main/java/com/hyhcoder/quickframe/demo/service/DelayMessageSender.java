package com.hyhcoder.quickframe.demo.service;

import com.hyhcoder.quickframe.demo.constants.DelayTypeEnum;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.hyhcoder.quickframe.demo.config.DelayedRabbitMQConfig.DELAYED_EXCHANGE_NAME;
import static com.hyhcoder.quickframe.demo.config.DelayedRabbitMQConfig.DELAYED_ROUTING_KEY;
import static com.hyhcoder.quickframe.demo.config.RabbitMQConfig.*;

/**
 * @author hyhcoder
 * @date 2020/5/9 6:32
 */
@Component
public class DelayMessageSender {
	
	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	/**
	 * 固定时间类型的
	 */
	public void sendMsg(String msg, DelayTypeEnum delayType) {
		switch (delayType) {
			case DELAY_10s:
				rabbitTemplate.convertAndSend(DELAY_EXCHANGE_NAME, DELAY_QUEUEA_ROUTING_KEY, msg);
				break;
			
			case DELAY_60s:
				rabbitTemplate.convertAndSend(DELAY_EXCHANGE_NAME, DELAY_QUEUEB_ROUTING_KEY, msg);
				break;
		}
	}
	
	/**
	 * 自由时间类型的
	 */
	public void sendMsg(String msg, Integer delayTime) {
		rabbitTemplate.convertAndSend(DELAY_EXCHANGE_NAME, DELAY_QUEUEC_ROUTING_KEY, msg, a -> {
			a.getMessageProperties().setExpiration(String.valueOf(delayTime));
			return a;
		});
	}
	
	/**
	 * 插件类型的
	 */
	public void sendDelayMsg(String msg, Integer delayTime) {
		rabbitTemplate.convertAndSend(DELAYED_EXCHANGE_NAME, DELAYED_ROUTING_KEY, msg, a -> {
			a.getMessageProperties().setDelay(delayTime);
			return a;
		});
	}
	
}
