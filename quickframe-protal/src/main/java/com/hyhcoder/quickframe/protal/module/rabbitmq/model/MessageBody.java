package com.hyhcoder.quickframe.protal.module.rabbitmq.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @author hyhcoder
 * @date 2020/10/6 7:47
 *
 * 作为测试的消息体, 注意一般需要发送, 就需要序列化
 *
 */
@Data
public class MessageBody implements Serializable {
	
	private static final long serialVersionUID = 21212121L;
	
	private Integer id;
	private String name;
	
}
