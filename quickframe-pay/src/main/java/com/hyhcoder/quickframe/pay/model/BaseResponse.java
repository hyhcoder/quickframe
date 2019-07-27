package com.hyhcoder.quickframe.pay.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BaseResponse {
	
	@JsonProperty("return_code")
	private String returnCode;
	@JsonProperty("return_msg")
	private String returnMessage;
	@JsonProperty("result_code")
	private String resultCode;
	@JsonProperty("err_code")
	private String errorCode;
	@JsonProperty("err_code_des")
	private String errorCodeDesc;
	
	public BaseResponse() {
	
	}
	
	public boolean success() {
		
		return "SUCCESS".equals(this.returnCode) && "SUCCESS".equals(this.resultCode);
	}
	
	public String getReturnCode() {
		
		return this.returnCode;
	}
	
	public void setReturnCode(String returnCode) {
		
		this.returnCode = returnCode;
	}
	
	public String getReturnMessage() {
		
		return this.returnMessage;
	}
	
	public void setReturnMessage(String returnMessage) {
		
		this.returnMessage = returnMessage;
	}
	
	public String getResultCode() {
		
		return this.resultCode;
	}
	
	public void setResultCode(String resultCode) {
		
		this.resultCode = resultCode;
	}
	
	public String getErrorCode() {
		
		return this.errorCode;
	}
	
	public void setErrorCode(String errorCode) {
		
		this.errorCode = errorCode;
	}
	
	public String getErrorCodeDesc() {
		
		return this.errorCodeDesc;
	}
	
	public void setErrorCodeDesc(String errorCodeDesc) {
		
		this.errorCodeDesc = errorCodeDesc;
	}
}
