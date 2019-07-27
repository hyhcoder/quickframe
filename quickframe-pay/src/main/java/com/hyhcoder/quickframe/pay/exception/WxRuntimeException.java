package com.hyhcoder.quickframe.pay.exception;

import com.hyhcoder.quickframe.common.core.exception.ServiceException;
import com.hyhcoder.quickframe.common.core.exception.enums.BizExceptionEnum;


/**
 * @author hyhcoder
 * 微信支付运行时错误
 */
public class WxRuntimeException extends ServiceException {
	
	public WxRuntimeException() {
		
		super(BizExceptionEnum.NO_PERMITION);
	}
	
	public WxRuntimeException(Integer code, String errorMessage) {
		
		super(code, errorMessage);
	}
}
