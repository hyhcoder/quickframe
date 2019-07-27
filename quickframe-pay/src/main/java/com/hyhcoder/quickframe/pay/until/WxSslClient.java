package com.hyhcoder.quickframe.pay.until;

import com.mimoprint.mmcentre.base.core.exception.WxRuntimeException;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.StatusLine;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContexts;
import org.apache.http.util.EntityUtils;

import javax.net.ssl.SSLContext;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.KeyStore;

@Slf4j
public class WxSslClient {
	
	protected CloseableHttpClient httpClient;
	RequestConfig requestConfig;
	
	public WxSslClient(String certPath, String certPassword) {
		
		KeyStore keyStore = null;
		SSLContext sslcontext = null;
		try {
			keyStore = KeyStore.getInstance("PKCS12");
			FileInputStream inputStream = new FileInputStream(new File(certPath));
			keyStore.load(inputStream, certPassword.toCharArray());
			sslcontext = SSLContexts.custom().loadKeyMaterial(keyStore, certPassword.toCharArray()).build();
		} catch (Exception e) {
			log.error("initializing WxHttpsClient failed.", e);
			throw new WxRuntimeException(999, e.getMessage());
		}
		
		// Allow TLSv1 protocol only
		SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslcontext, new String[]{"TLSv1"}, null,
				SSLConnectionSocketFactory.getDefaultHostnameVerifier());
		
		httpClient = HttpClients.custom().setSSLSocketFactory(sslsf).build();
		;
		
		requestConfig = RequestConfig.custom().setSocketTimeout(10000).setConnectTimeout(30000)
				.setConnectionRequestTimeout(30000).build();
		
	}
	
	public String get(String url) {
		
		HttpGet httpGet = new HttpGet(url);
		httpGet.setConfig(requestConfig);
		
		try (CloseableHttpResponse response = httpClient.execute(httpGet)) {
			return getResponseContent(response);
		} catch (IOException ex) {
			log.error("http get: {} failed.", url, ex);
			throw new WxRuntimeException(999, ex.getMessage());
		}
	}
	
	public String post(String url, String content) {
		
		HttpPost httpPost = new HttpPost(url);
		httpPost.setConfig(requestConfig);
		httpPost.addHeader("Content-Type", "text/xml");
		
		if (content != null) {
			StringEntity entity = new StringEntity(content, Consts.UTF_8);
			httpPost.setEntity(entity);
		}
		
		try (CloseableHttpResponse response = httpClient.execute(httpPost)) {
			return getResponseContent(response);
		} catch (IOException ex) {
			log.error("http post: {} failed", url, ex);
			throw new WxRuntimeException(999, ex.getMessage());
		}
	}
	
	private String getResponseContent(CloseableHttpResponse response) throws IOException {
		
		StatusLine statusLine = response.getStatusLine();
		HttpEntity entity = response.getEntity();
		if (statusLine.getStatusCode() >= 300) {
			EntityUtils.consume(entity);
			throw new WxRuntimeException(statusLine.getStatusCode(), statusLine.getReasonPhrase());
		}
		return entity == null ? null : EntityUtils.toString(entity, Consts.UTF_8);
	}
}
