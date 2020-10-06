package com.hyhcoder.quickframe.protal.module.rabbitmq;

import com.hyhcoder.quickframe.protal.module.rabbitmq.model.MessageBody;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import static com.hyhcoder.quickframe.protal.module.rabbitmq.RabbitMQConfig.QUEUE_A;

/**
 * @author hyhcoder
 * @date 2020/10/5 21:41
 *
 *  mq队列消费
 *
 *  主要看是否开启手动ack
 *
 */
@Component
public class MessageCustomer {
	
	/**
	 * 消费
	 */
	@RabbitListener(queues = QUEUE_A)
	@Transactional(rollbackFor = Exception.class)
	public void messageCustomer(Channel channel, @Payload MessageBody message,
			@Header(AmqpHeaders.DELIVERY_TAG) long deliveryTag) throws Exception {
		
		
		try {
			// 执行逻辑
			System.out.println(message);
			//int a = 1 / 0;
			
			// 进行ack回应;
			// 如果是开启自动ack的, 可能会因为报错而丢数据
			// 一般使用手动ack, 第二个参数muliple, 如果为true, 就是确认所有将比第一个参数指定的 delivery tag 小的consumer都获得的消息
			channel.basicAck(deliveryTag, false);
			
		} catch (Exception e) {
			
			// 失败重新放回, 这个放回, 还是会直接到达队列的头部, 所以这样其实可能会堵死
			// 一个比较好的解决方案就是累积一定的重试次数, 删除队列数据;
			// 然后推送报警, 或者推送到其他队列, 后面对此数据做补偿处理
			channel.basicNack(deliveryTag, false, true);
		}
		
		
	}
	
}
