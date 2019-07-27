package com.hyhcoder.quickframe.pay.model;

import lombok.Data;

/**
 * 微信支付的基本设置
 */
@Data
public class WxPaySetting {
	
	private String mchId;
	private String appId;
	private String key;
	private String certPath;
	private String certPassword;
}
