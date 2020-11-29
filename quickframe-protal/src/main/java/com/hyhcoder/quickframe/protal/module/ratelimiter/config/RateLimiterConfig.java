package com.hyhcoder.quickframe.protal.module.ratelimiter.config;

import com.google.common.util.concurrent.RateLimiter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author hyhcoder
 * @date 2020/10/9 14:40
 */
@Configuration
public class RateLimiterConfig {
	
	
	@Bean
	public RateLimiter myRateLimiter() {
		
		RateLimiter rateLimiter = RateLimiter.create(2);
		//RateLimiter.create()
		return rateLimiter;
	}
	
}
