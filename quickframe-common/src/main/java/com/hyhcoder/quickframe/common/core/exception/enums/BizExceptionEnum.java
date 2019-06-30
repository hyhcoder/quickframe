package com.hyhcoder.quickframe.common.core.exception.enums;

import com.hyhcoder.quickframe.common.core.exception.AbstractBaseExceptionEnum;

/**
 * 一些业务异常的枚举
 * 建议code用4位数以上的, 与http协议的区分开来;做另外一种细分;
 *
 * @author hyhcoder
 * @date 2019-06-29
 */
public enum BizExceptionEnum implements AbstractBaseExceptionEnum {
	
	/**
	 * 权限和数据问题
	 */
	NO_PERMITION(4005, "权限异常"),
	
	
	/**
	 * 错误的请求
	 */
	SERVER_ERROR(9999, "服务器异常");
	
	
	BizExceptionEnum(int code, String message) {
		this.code = code;
		this.message = message;
	}
	
	private Integer code;
	
	private String message;
	
	@Override
	public Integer getCode() {
		return code;
	}
	
	public void setCode(Integer code) {
		this.code = code;
	}
	
	@Override
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
}
