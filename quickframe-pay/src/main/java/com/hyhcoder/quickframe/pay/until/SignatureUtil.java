package com.hyhcoder.quickframe.pay.until;

import com.google.common.base.Joiner;
import org.apache.commons.codec.digest.DigestUtils;

import java.util.Map;


/**
 * 微信签名
 */
public class SignatureUtil {
	
	public SignatureUtil() {
	
	}
	
	public static String sign(Map<String, Object> map, String key) {
		
		String str = Joiner.on("&").withKeyValueSeparator("=").join(map);
		str = str + "&key=" + key;
		return DigestUtils.md5Hex(str).toUpperCase();
	}
}
