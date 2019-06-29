package com.hyhcoder.common.core.exception.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author hyhcoder
 * @date 2019/6/29 16:34
 */
@Controller
@RequestMapping("/global")
public class GlobalController {
	
	/**
	 * 跳转到404页面
	 */
	@RequestMapping(path = "/error")
	public String errorPage() {
		return "/404.html";
	}
}
