package com.hyhcoder.quickframe.pay;


import com.hyhcoder.quickframe.pay.exception.WxRuntimeException;
import com.hyhcoder.quickframe.pay.model.UnifiedOrderRequest;
import com.hyhcoder.quickframe.pay.model.UnifiedOrderResponse;
import com.hyhcoder.quickframe.pay.model.Wrapper.UnifiedOrderRequestWrapper;
import com.hyhcoder.quickframe.pay.model.Wrapper.UnifiedOrderResponseWrapper;
import com.hyhcoder.quickframe.pay.model.WxBaseSettings;
import com.hyhcoder.quickframe.pay.model.WxPaySetting;
import com.hyhcoder.quickframe.pay.until.*;
import lombok.extern.slf4j.Slf4j;

import java.util.SortedMap;

/**
 * @author hyhcoder
 * 微信支付方法
 */
@Slf4j
@SuppressWarnings("unchecked")
public class WxPayUtil {
	
	private WxPaySetting wxPaySetting;
	private WxSslClient wxSslClient;
	
	public void setPaySetting(WxPaySetting wxPaySetting) {
		
		this.wxPaySetting = wxPaySetting;
	}
	
	public void setWxSslClient(WxSslClient wxSslClient) {
		
		this.wxSslClient = wxSslClient;
	}
	
	/**
	 * 初始化构造
	 */
	public static WxPayUtil with(WxPaySetting wxPaySetting) {
		
		WxPayUtil wxPayUtil = new WxPayUtil();
		wxPayUtil.setPaySetting(wxPaySetting);
		wxPayUtil.setWxSslClient(PayWxClientFactory.getInstance().with(wxPaySetting));
		return wxPayUtil;
	}
	
	/**
	 * 微信统一下单接口
	 */
	public UnifiedOrderResponse unifiedOrder(UnifiedOrderRequest unifiedOrderRequest) {
		
		UnifiedOrderRequestWrapper wrapper = new UnifiedOrderRequestWrapper();
		wrapper.setRequest(unifiedOrderRequest);
		this.setBaseSettings(wrapper);
		SortedMap<String, Object> unifiedOrderRequestMap = (SortedMap) JsonMapper.nonEmptyMapper().getMapper()
				.convertValue(wrapper, SortedMap.class);
		this.sign(wrapper, unifiedOrderRequestMap);
		String url = "https://api.mch.weixin.qq.com/pay/unifiedorder";
		
		try {
			String xml = XmlObjectMapper.nonEmptyMapper().toXml(wrapper);
			log.info("支付 unified order request: {}", xml);
			String response = this.wxSslClient.post(url, xml);
			log.info("支付 unified order response: {}", response);
			UnifiedOrderResponseWrapper responseWrapper = XmlObjectMapper.defaultMapper()
					.fromXml(response, UnifiedOrderResponseWrapper.class);
			return responseWrapper.getResponse();
		} catch (Exception var8) {
			throw new WxRuntimeException(999, "pre order failed:" + var8.getMessage());
		}
	}
	
	private void sign(WxBaseSettings wrapper, SortedMap<String, Object> generals) {
		
		String nonce = RandomStringGenerator.getRandomStringByLength(32);
		generals.put("nonce_str", nonce);
		generals.put("mch_id", this.wxPaySetting.getMchId());
		wrapper.setNonce(nonce);
		wrapper.setSign(SignatureUtil.sign(generals, this.wxPaySetting.getKey()));
	}
	
	private void setBaseSettings(WxBaseSettings wrapper) {
		
		wrapper.setAppId(this.wxPaySetting.getAppId());
		wrapper.setMchId(this.wxPaySetting.getMchId());
	}
}
