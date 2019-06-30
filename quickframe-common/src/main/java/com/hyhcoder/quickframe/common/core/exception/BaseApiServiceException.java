package com.hyhcoder.quickframe.common.core.exception;

import lombok.Getter;
import lombok.Setter;

/**
 * @author hyhcoder
 * @date 2019/6/29 15:55
 * 接口调用出现的业务异常
 *
 */

@Getter
@Setter
public abstract class BaseApiServiceException extends Exception {
	
	/**
	 * 错误编码
	 */
	private Integer code;
	
	/**
	 * 错误的提示信息
	 */
	private String errorMessage;
	
	public BaseApiServiceException(AbstractBaseExceptionEnum exception) {
		super(exception.getMessage());
		this.code = exception.getCode();
		this.errorMessage = exception.getMessage();
	}
	
	/**
	 * 获取异常的类的具体名称
	 */
	public abstract String getExceptionClassName();
}

