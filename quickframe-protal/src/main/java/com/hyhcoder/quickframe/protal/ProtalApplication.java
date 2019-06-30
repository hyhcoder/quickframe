package com.hyhcoder.quickframe.protal;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.hyhcoder.quickframe")
@MapperScan("com.hyhcoder.quickframe.mapper")
public class ProtalApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(ProtalApplication.class, args);
	}
	
}
