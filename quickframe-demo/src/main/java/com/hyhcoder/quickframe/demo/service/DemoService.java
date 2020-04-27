package com.hyhcoder.quickframe.demo.service;

import com.hyhcoder.quickframe.mapper.OmsMenuMapper;
import com.hyhcoder.quickframe.model.OmsMenuDO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author hyhcoder
 * @date 2020/4/27 21:43
 */
@Service
public class DemoService {
	
	@Resource
	private OmsMenuMapper omsMenuMapper;
	
	public void getMenu() {
		OmsMenuDO omsMenuDO = omsMenuMapper.selectById(1);
		System.out.println(omsMenuDO.getName());
	}
}
