package com.hyhcoder.quickframe.demo.controller;

import com.hyhcoder.quickframe.common.core.reqres.response.ResponseData;
import com.hyhcoder.quickframe.demo.service.DemoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author hyhcoder
 * @date 2020/4/27 21:58
 */
@RestController
public class DemoController {
	
	@Resource
	private DemoService demoService;
	
	@RequestMapping("/getMenu")
	public ResponseData getMenu() {
		
		demoService.getMenu();
		
		return ResponseData.success();
		
	}
}
