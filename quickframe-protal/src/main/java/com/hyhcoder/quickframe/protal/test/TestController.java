package com.hyhcoder.quickframe.protal.test;

import com.hyhcoder.quickframe.common.core.reqres.response.ResponseData;
import com.hyhcoder.quickframe.protal.module.rabbitmq.MessageSender;
import com.hyhcoder.quickframe.protal.module.ratelimiter.RateLimiterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hyhcoder
 * @date 2020/10/5 21:11
 */
@RequestMapping("/test")
@RestController
public class TestController {
	
	@Autowired
	private MessageSender messageSender;
	
	@Autowired
	private RateLimiterService rateLimiterService;
	
	
	@RequestMapping("/sendMessage")
	private ResponseData sendMessage(@RequestParam("message") String message) {
		
		//messageSender.sendMessage(message);
		return ResponseData.success();
	}
	
	@RequestMapping("/sendMessageTransaction")
	@Transactional
	private ResponseData sendMessageTransaction(@RequestParam("message") String message) {
		
		messageSender.sendMessageTransaction(message);
		return ResponseData.success();
	}
	
	
	@RequestMapping("/sendMessageAck")
	private ResponseData sendMessageAck(@RequestParam("message") String message) {
		
		messageSender.sendMessageAck(message);
		return ResponseData.success();
	}
	
	@RequestMapping("/raterun")
	private ResponseData raterun(@RequestParam("code") Integer code) {
		
		rateLimiterService.rateRun(code);
		return ResponseData.success();
	}
	
	
}
