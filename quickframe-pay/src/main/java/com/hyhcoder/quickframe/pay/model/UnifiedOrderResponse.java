package com.hyhcoder.quickframe.pay.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UnifiedOrderResponse extends BaseResponse {
	
	@JsonProperty("device_info")
	private String deviceInfo;
	@JsonProperty("trade_type")
	private String tradeType;
	@JsonProperty("prepay_id")
	private String prepayId;
	@JsonProperty("code_url")
	private String codeUrl;
	/**
	 * 当用h5支付下单时, 会返回这个地址用于跳转, 有效时长为5分钟
	 */
	@JsonProperty("mweb_url")
	private String mwebUrl;
	
	public UnifiedOrderResponse() {
	
	}
	
	public String getDeviceInfo() {
		
		return this.deviceInfo;
	}
	
	public void setDeviceInfo(String deviceInfo) {
		
		this.deviceInfo = deviceInfo;
	}
	
	public String getTradeType() {
		
		return this.tradeType;
	}
	
	public void setTradeType(String tradeType) {
		
		this.tradeType = tradeType;
	}
	
	public String getPrepayId() {
		
		return this.prepayId;
	}
	
	public void setPrepayId(String prepayId) {
		
		this.prepayId = prepayId;
	}
	
	public String getCodeUrl() {
		
		return this.codeUrl;
	}
	
	public void setCodeUrl(String codeUrl) {
		
		this.codeUrl = codeUrl;
	}
	
	public String getMwebUrl() {
		
		return this.mwebUrl;
	}
	
	public void setMwebUrl(String mwebUrl) {
		
		this.mwebUrl = mwebUrl;
	}
}
