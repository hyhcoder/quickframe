package com.hyhcoder.quickframe.common.core.reqres.response;

import lombok.Data;

/**
 * @author hyhcoder
 * @date 2019-06-20
 *
 * 返回给前台的通用包装
 *
 * 返回值可以有两种思想, 一种如果不是纯粹restful的, 就直接返回200, 靠success的值来表示业务;
 * 一种如果是restful的, 就要根据不同的状态码返回, success这个字段可以忽略;
 *
 */
@Data
public class ResponseData {
	
	public static final String DEFAULT_SUCCESS_MESSAGE = "请求成功";
	
	public static final String DEFAULT_ERROR_MESSAGE = "网络异常";
	
	public static final Integer DEFAULT_SUCCESS_CODE = 200;
	
	public static final Integer DEFAULT_ERROR_CODE = 500;
	
	/**
	 * 请求是否成功
	 */
	private Boolean success;
	
	/**
	 * 响应状态码
	 */
	private Integer code;
	
	/**
	 * 响应信息
	 */
	private String message;
	
	/**
	 * 响应对象
	 */
	private Object data;
	
	public ResponseData() {
	}
	
	public ResponseData(Boolean success, Integer code, String message, Object data) {
		this.success = success;
		this.code = code;
		this.message = message;
		this.data = data;
	}
	
	public static SuccessResponseData success() {
		return new SuccessResponseData();
	}
	
	public static SuccessResponseData success(Object object) {
		return new SuccessResponseData(object);
	}
	
	public static SuccessResponseData success(Integer code, String message, Object object) {
		return new SuccessResponseData(code, message, object);
	}
	
	public static ErrorResponseData error(String message) {
		return new ErrorResponseData(message);
	}
	
	public static ErrorResponseData error(Integer code, String message) {
		return new ErrorResponseData(code, message);
	}
	
	public static ErrorResponseData error(Integer code, String message, Object object) {
		return new ErrorResponseData(code, message, object);
	}
}


