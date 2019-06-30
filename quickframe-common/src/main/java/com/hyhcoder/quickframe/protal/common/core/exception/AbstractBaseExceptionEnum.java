package com.hyhcoder.quickframe.protal.common.core.exception;

/**
 * @author hyhcoder
 * @date 2019-06-29
 * 异常规范
 * 每个模块可以自己扩展一些异常枚举
 */
public interface AbstractBaseExceptionEnum {
	
	/**
	 * 获取异常的状态码
	 */
	Integer getCode();
	
	/**
	 * 获取异常的提示信息
	 */
	String getMessage();
}

