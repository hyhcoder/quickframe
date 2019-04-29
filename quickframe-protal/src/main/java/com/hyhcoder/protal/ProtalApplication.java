package com.hyhcoder.protal;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.hyhcoder.quickframe.mapper")
public class ProtalApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProtalApplication.class, args);
    }

}
