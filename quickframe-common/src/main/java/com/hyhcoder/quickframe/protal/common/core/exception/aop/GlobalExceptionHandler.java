package com.hyhcoder.quickframe.protal.common.core.exception.aop;


import com.hyhcoder.quickframe.protal.common.core.exception.ServiceException;
import com.hyhcoder.quickframe.protal.common.core.exception.enums.BizExceptionEnum;
import com.hyhcoder.quickframe.protal.common.core.reqres.response.ErrorResponseData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.UndeclaredThrowableException;

import static com.hyhcoder.quickframe.protal.common.core.util.HttpContext.getRequest;

/**
 * 全局的的异常拦截器（拦截所有的控制器）
 * （带有@RequestMapping注解的方法上都会拦截）
 *
 * @author hyhcoder
 * @date 2019-06-29
 *
 **/
@ControllerAdvice
@Order(-1)
public class GlobalExceptionHandler {
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	/**
	 * 拦截业务异常
	 */
	@ExceptionHandler(ServiceException.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ResponseBody
	public ErrorResponseData bussiness(ServiceException e) {
		if (getRequest() != null) {getRequest().setAttribute("tip", e.getMessage());}
		log.error("业务异常:", e);
		return new ErrorResponseData(e.getCode(), e.getMessage());
	}
	
	/**
	 * 无权访问该资源异常
	 */
	@ExceptionHandler(UndeclaredThrowableException.class)
	@ResponseStatus(HttpStatus.UNAUTHORIZED)
	@ResponseBody
	public ErrorResponseData credentials(UndeclaredThrowableException e) {
		if (getRequest() != null) {getRequest().setAttribute("tip", "权限异常");}
		log.error("权限异常!", e);
		return new ErrorResponseData(BizExceptionEnum.NO_PERMITION.getCode(),
				BizExceptionEnum.NO_PERMITION.getMessage());
	}
	
	/**
	 * 拦截未知的运行时异常
	 */
	@ExceptionHandler(RuntimeException.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ResponseBody
	public ErrorResponseData notFount(RuntimeException e) {
		if (getRequest() != null) {getRequest().setAttribute("tip", "服务器未知运行时异常");}
		log.error("运行时异常:", e);
		return new ErrorResponseData(BizExceptionEnum.SERVER_ERROR.getCode(),
				BizExceptionEnum.SERVER_ERROR.getMessage());
	}
}
