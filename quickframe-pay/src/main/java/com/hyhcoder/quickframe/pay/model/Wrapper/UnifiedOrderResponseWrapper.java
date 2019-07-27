package com.hyhcoder.quickframe.pay.model.Wrapper;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.hyhcoder.quickframe.pay.model.UnifiedOrderResponse;
import com.hyhcoder.quickframe.pay.model.WxBaseSettings;


public class UnifiedOrderResponseWrapper extends WxBaseSettings {
	
	@JsonUnwrapped
	private UnifiedOrderResponse response;
	
	public UnifiedOrderResponseWrapper() {
	
	}
	
	public UnifiedOrderResponse getResponse() {
		
		return this.response;
	}
	
	public void setResponse(UnifiedOrderResponse response) {
		
		this.response = response;
	}
}
