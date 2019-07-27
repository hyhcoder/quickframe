package com.hyhcoder.quickframe.pay.model.Wrapper;


import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.hyhcoder.quickframe.pay.model.UnifiedOrderRequest;
import com.hyhcoder.quickframe.pay.model.WxBaseSettings;


@JacksonXmlRootElement(localName = "xml")
public class UnifiedOrderRequestWrapper extends WxBaseSettings {
	
	@JsonUnwrapped
	private UnifiedOrderRequest request;
	
	public UnifiedOrderRequestWrapper() {
	
	}
	
	public void setRequest(UnifiedOrderRequest request) {
		
		this.request = request;
	}
	
	public UnifiedOrderRequest getRequest() {
		
		return this.request;
	}
}
