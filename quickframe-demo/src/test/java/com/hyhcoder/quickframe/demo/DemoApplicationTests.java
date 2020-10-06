package com.hyhcoder.quickframe.demo;


import cn.hutool.core.date.DateUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {
	
	
	@Test
	public void contextLoads() {
		System.out.println(DateUtil.date().month());
	}
	
}
