package com.hyhcoder.quickframe.protal.controller;


import com.hyhcoder.quickframe.protal.common.core.reqres.response.ResponseData;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author hyhcoder
 * @date 2019/6/29 17:28
 */

@RestController
public class DemoController {
	
	@RequestMapping("/demotest")
	public ResponseEntity demotest() {
		
		return ResponseEntity.badRequest().body(ResponseData.error("你错误了"));
	}
	
}
