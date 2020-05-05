package com.hyhcoder.quickframe.security.component;

import cn.hutool.json.JSONUtil;
import com.hyhcoder.quickframe.common.core.exception.enums.BizExceptionEnum;
import com.hyhcoder.quickframe.common.core.reqres.response.ResponseData;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author hyhcoder
 * 自定义返回结果：没有权限访问时
 */
public class RestfulAccessDeniedHandler implements AccessDeniedHandler {
	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException e)
			throws IOException, ServletException {
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		response.setStatus(HttpStatus.FORBIDDEN.value());
		response.getWriter().println(JSONUtil.parse(
				JSONUtil.parse(ResponseData.error(BizExceptionEnum.NO_PERMITION.getCode(), e.getMessage()))));
		response.getWriter().flush();
	}
}
