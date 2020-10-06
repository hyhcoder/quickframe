package com.hyhcoder.quickframe.demo.controller;

import com.hyhcoder.quickframe.demo.constants.DelayTypeEnum;
import com.hyhcoder.quickframe.demo.service.DelayMessageSender;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * @author hyhcoder
 * @date 2020/5/9 6:44
 */
@Slf4j
@RequestMapping("/rabbitmq")
@RestController
public class RabbitMqMsgController {
	
	@Autowired
	private DelayMessageSender sender;
	
	@RequestMapping("sendmsg")
	public void sendMsg(String msg, Integer delayType) {
		log.info("当前时间：{},收到请求，msg:{},delayType:{}", LocalDateTime.now(), msg, delayType);
		sender.sendMsg(msg, Objects.requireNonNull(DelayTypeEnum.getDelayTypeEnumByValue(delayType)));
	}
	
	@RequestMapping("delayMsg")
	public void delayMsg(String msg, Integer delayTime) {
		log.info("当前时间：{},收到请求，msg:{},delayTime:{}", LocalDateTime.now(), msg, delayTime);
		sender.sendMsg(msg, delayTime);
	}
	
	@RequestMapping("delayMsg2")
	public void delayMsg2(String msg, Integer delayTime) {
		log.info("当前时间：{},收到请求，msg:{},delayTime:{}", LocalDateTime.now(), msg, delayTime);
		sender.sendDelayMsg(msg, delayTime);
	}
}
