package com.hyhcoder.quickframe.protal;

import com.hyhcoder.quickframe.mapper.OmsMenuMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProtalApplicationTests {
	
	@Autowired
	private OmsMenuMapper omsMenuMapper;
	
	@Test
	public void contextLoads() {
		
		List<Integer> a = new ArrayList<>();
		a.add(2);
		a.add(3);
		a.add(4);
		a.add(3);
		List<Integer> b = new ArrayList<>();
		for (Integer integer : a) {
			
			if (!b.contains(integer)) {
				b.add(integer);
			}
		}
		
		System.out.println(b.size());
	}
	
}
