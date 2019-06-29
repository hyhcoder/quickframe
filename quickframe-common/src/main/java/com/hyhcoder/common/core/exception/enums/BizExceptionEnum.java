package com.hyhcoder.common.core.exception.enums;

import com.hyhcoder.common.core.exception.AbstractBaseExceptionEnum;

/**
 * 一些业务异常的枚举
 *
 * @author hyhcoder
 * @date 2019-06-29
 */
public enum BizExceptionEnum implements AbstractBaseExceptionEnum {
	
	/**
	 * 权限和数据问题
	 */
	DB_RESOURCE_NULL(400, "数据库中没有该资源"), NO_PERMITION(405, "权限异常"), REQUEST_INVALIDATE(400, "请求数据格式不正确"),
	
	/**
	 * 账户问题
	 */
	NOT_LOGIN(401, "当前用户未登录"), USER_NOT_EXISTED(400, "没有此用户"),
	
	
	/**
	 * 错误的请求
	 */
	REQUEST_NULL(400, "请求有错误"), SESSION_TIMEOUT(400, "会话超时"), SERVER_ERROR(500, "服务器异常"),
	
	/**
	 * token异常
	 */
	TOKEN_EXPIRED(700, "token过期"), TOKEN_ERROR(700, "token验证失败"),
	
	/**
	 * 签名异常
	 */
	SIGN_ERROR(700, "签名验证失败"),
	
	/**
	 * 其他
	 */
	AUTH_REQUEST_ERROR(400, "账号密码错误");
	
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
