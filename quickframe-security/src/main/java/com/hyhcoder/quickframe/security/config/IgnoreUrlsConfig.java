package com.hyhcoder.quickframe.security.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hyhcoder
 * @date 2020-05-05
 * 用于配置不需要保护的资源路径
 */
@Getter
@Setter
@ConfigurationProperties(prefix = "secure.ignored")
public class IgnoreUrlsConfig {
	
	private List<String> urls = new ArrayList<>();
	
}
