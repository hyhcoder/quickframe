package com.hyhcoder.quickframe.pay.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * 微信支付下单请求对象
 */
@Data
public class UnifiedOrderRequest {
	
	@JsonProperty("device_info")
	private String deviceInfo;
	@JsonProperty("sign_type")
	private String signType;
	private String body;
	private String detail;
	private String attach;
	@JsonProperty("out_trade_no")
	private String tradeNumber;
	@JsonProperty("fee_type")
	private String feeType;
	@JsonProperty("total_fee")
	private int totalFee;
	@JsonProperty("spbill_create_ip")
	private String billCreatedIp;
	@JsonProperty("time_start")
	private String timeStart;
	@JsonProperty("time_expire")
	private String timeExpire;
	@JsonProperty("goods_tag")
	private String goodsTag;
	@JsonProperty("notify_url")
	private String notifyUrl;
	@JsonProperty("trade_type")
	private String tradeType;
	@JsonProperty("product_id")
	private String productId;
	@JsonProperty("limit_pay")
	private String limitPay;
	@JsonProperty("openid")
	private String openId;
	@JsonProperty("scene_info")
	private String sceneInfo;
}