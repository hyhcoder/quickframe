package com.hyhcoder.quickframe.common.core.exception;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * 业务异常的封装(常用)
 *
 * @author hyhcoder
 * @date 2019/6/29 15:58
 */
@Setter
@Getter
public class ServiceException extends RuntimeException {
	
	private Integer code;
	
	private String errorMessage;
	
	public ServiceException(Integer code, String errorMessage) {
		super(errorMessage);
		this.code = code;
		this.errorMessage = errorMessage;
	}
	
	public ServiceException(AbstractBaseExceptionEnum exception) {
		super(exception.getMessage());
		this.code = exception.getCode();
		this.errorMessage = exception.getMessage();
	}
}

