package com.hyhcoder.quickframe.security.jwt;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hyhcoder
 * jwt的第二部分, payLoad
 */
@Data
public class JwtPayLoad {
	
	/**
	 * 用户id
	 */
	private Long userId;
	
	/**
	 * 名称
	 */
	private String userName;
	
	private String sub;
	
	private Long created;
	
	private Long exp;
	
	/**
	 * payload转化为map形式
	 */
	public Map<String, Object> toMap() {
		HashMap<String, Object> map = new HashMap<>();
		map.put("userId", this.userId);
		map.put("userName", this.userName);
		map.put("sub", this.sub);
		map.put("created", this.created);
		map.put("exp", this.exp);
		return map;
	}
	
	/**
	 * payload转化为map形式
	 */
	public static JwtPayLoad toBean(Map<String, Object> map) {
		if (map == null || map.size() == 0) {
			return new JwtPayLoad();
		} else {
			JwtPayLoad jwtPayLoad = new JwtPayLoad();
			
			Object userId = map.get("userId");
			if (userId instanceof Integer) {
				jwtPayLoad.setUserId(Long.valueOf(map.get("userId").toString()));
			}
			
			jwtPayLoad.setUserName((String) map.get("userName"));
			jwtPayLoad.setSub((String) map.get("sub"));
			
			Object exp = map.get("exp");
			if (exp instanceof Long) {
				jwtPayLoad.setExp(Long.valueOf(map.get("exp").toString()));
			}
			
			Object created = map.get("created");
			if (created instanceof Long) {
				jwtPayLoad.setCreated(Long.valueOf(map.get("created").toString()));
			}
			
			return jwtPayLoad;
		}
	}
	
}
