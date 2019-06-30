package com.hyhcoder.quickframe.protal.common.core.exception.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author hyhcoder
 * @date 2019/6/30 15:41
 */
@Controller
@RequestMapping("/global")
public class GlobalController {
	
	/**
	 * 跳转到404页面
	 */
	@RequestMapping(path = "/error")
	public String errorPage() {
		// 这里需要弄个页面
		return "/404.html";
	}
}