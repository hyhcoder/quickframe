package com.hyhcoder.common.core.reqres.response;

/**
 * @author hyhcoder
 * @date 2019-06-29
 * 成功的返回对象
 */
public class SuccessResponseData extends ResponseData {
	
	public SuccessResponseData() {
		super(true, DEFAULT_SUCCESS_CODE, DEFAULT_SUCCESS_MESSAGE, null);
	}
	
	public SuccessResponseData(Object object) {
		super(true, DEFAULT_SUCCESS_CODE, DEFAULT_SUCCESS_MESSAGE, object);
	}
	
	public SuccessResponseData(Integer code, String message, Object object) {
		super(true, code, message, object);
	}
}


