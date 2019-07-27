package com.hyhcoder.quickframe.pay;


import com.hyhcoder.quickframe.pay.model.WxPaySetting;
import com.hyhcoder.quickframe.pay.until.WxSslClient;

import java.util.concurrent.ConcurrentHashMap;

/**
 * 微信支付factory
 */
public class PayWxClientFactory {
	
	private static PayWxClientFactory instance = null;
	private static ConcurrentHashMap<String, WxSslClient> wxClients = new ConcurrentHashMap();
	
	public PayWxClientFactory() {
	
	}
	
	public static PayWxClientFactory getInstance() {
		
		if (instance == null) {
			instance = new PayWxClientFactory();
		}
		
		return instance;
	}
	
	public WxSslClient with(WxPaySetting wxPaySetting) {
		
		if (!wxClients.containsKey(this.key(wxPaySetting))) {
			WxSslClient wxClient = new WxSslClient(wxPaySetting.getCertPath(), wxPaySetting.getCertPassword());
			wxClients.putIfAbsent(this.key(wxPaySetting), wxClient);
		}
		
		return (WxSslClient) wxClients.get(this.key(wxPaySetting));
	}
	
	private String key(WxPaySetting wxPaySetting) {
		
		return wxPaySetting.getAppId() + ":" + wxPaySetting.getMchId();
	}
}
