package com.hyhcoder.quickframe.common.core.exception;

import lombok.Data;

/**
 * 业务异常的封装(特定的)
 *
 * @author hyhcoder
 * @date 2019/6/29 16:00
 */

@Data
public class RequestEmptyException extends ServiceException {
	
	public RequestEmptyException() {
		super(400, "请求数据不完整或格式错误！");
	}
	
	public RequestEmptyException(String errorMessage) {
		super(400, errorMessage);
	}
	
	/**
	 * 不拷贝栈信息，提高性能
	 */
	@Override
	public synchronized Throwable fillInStackTrace() {
		return null;
	}
}

