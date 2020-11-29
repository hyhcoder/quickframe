package com.hyhcoder.quickframe.protal.module.ratelimiter;

import com.google.common.util.concurrent.RateLimiter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author hyhcoder
 * @date 2020/10/9 11:55
 *
 * 测试限流
 *
 */
@Component
@Slf4j
public class RateLimiterService {
	
	
	@Autowired
	private RateLimiter rateLimiter;
	
	
	public void rateRun(Integer code) {
		
		for (int i = 0; i < 10; i++) {
			rateLimiter.acquire(1);
			log.info(code + "  执行 " + i);
		}
		
	}
	
	
	public static void main(String[] args) throws Exception {
		// qps设置为5，代表一秒钟只允许处理五个并发请求
		RateLimiter rateLimiter = RateLimiter.create(2);
		
		ExecutorService executorService = Executors.newFixedThreadPool(5);
		int nTasks = 10;
		//CountDownLatch countDownLatch = new CountDownLatch(nTasks);
		
		
		long start = System.currentTimeMillis();
		for (int i = 0; i < nTasks; i++) {
			
			rateLimiter.acquire(1);
			System.out.println("处理完毕" + " " + i);
		}
		executorService.shutdown();
		//countDownLatch.await();
		long end = System.currentTimeMillis();
		
		System.out.println("10 jobs gets done by 5 threads concurrently in " + (end - start) + " milliseconds");
		
	}
	
	
}
