package com.hyhcoder.quickframe;

import com.hyhcoder.quickframe.mapper.PmsProductMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProtalApplicationTests {
    @Autowired
    private PmsProductMapper pmsProductMapper;
    @Test
    public void contextLoads() {

        System.out.println(pmsProductMapper.selectById(1));
    }

}
