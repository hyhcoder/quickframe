package com.hyhcoder.quickframe.security.component;

import cn.hutool.json.JSONUtil;
import com.hyhcoder.quickframe.common.core.exception.enums.BizExceptionEnum;
import com.hyhcoder.quickframe.common.core.reqres.response.ResponseData;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author hyhcoder
 * 自定义返回结果：未登录或登录过期
 */
public class RestAuthenticationEntryPoint implements AuthenticationEntryPoint {
	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException, ServletException {
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		response.setStatus(HttpStatus.FORBIDDEN.value());
		response.getWriter().println(JSONUtil.parse(JSONUtil.parse(
				ResponseData.error(BizExceptionEnum.NO_PERMITION.getCode(), authException.getMessage()))));
		response.getWriter().flush();
	}
}
