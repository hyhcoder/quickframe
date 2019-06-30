package com.hyhcoder.quickframe.common.core.reqres.response;

import lombok.Data;

/**
 * @author hyhcoder
 * @date 2019-06-29
 * 请求失败的返回
 */
@Data
public class ErrorResponseData extends ResponseData {
	
	/**
	 * 异常的具体类名称, 若有必要可以进行设置;
	 */
	private String exceptionClazz;
	
	public ErrorResponseData(String message) {
		super(false, ResponseData.DEFAULT_ERROR_CODE, message, null);
	}
	
	public ErrorResponseData(Integer code, String message) {
		super(false, code, message, null);
	}
	
	public ErrorResponseData(Integer code, String message, Object object) {
		super(false, code, message, object);
	}
}
