package com.hyhcoder.quickframe.pay.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class WxBaseSettings {
	
	@JsonProperty("appid")
	private String appId;
	@JsonProperty("mch_id")
	private String mchId;
	@JsonProperty("nonce_str")
	private String nonce;
	private String sign;
}
