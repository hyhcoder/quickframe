package com.hyhcoder.quickframe.pay.until;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.IOException;

public class XmlObjectMapper {
	
	private static XmlObjectMapper defaultXmlObjectMapper = null;
	private static XmlObjectMapper nonEmptyXmlObjectMapper = null;
	private static XmlObjectMapper prettyFormatXmlObjectMapper = null;
	private XmlMapper xmlMapper = new XmlMapper();
	
	private XmlObjectMapper() {
	
	}
	
	public static synchronized XmlObjectMapper defaultMapper() {
		
		if (defaultXmlObjectMapper == null) {
			defaultXmlObjectMapper = new XmlObjectMapper();
		}
		
		return defaultXmlObjectMapper;
	}
	
	public static synchronized XmlObjectMapper nonEmptyMapper() {
		
		if (nonEmptyXmlObjectMapper == null) {
			nonEmptyXmlObjectMapper = new XmlObjectMapper();
			nonEmptyXmlObjectMapper.xmlMapper.setSerializationInclusion(Include.NON_EMPTY);
		}
		
		return nonEmptyXmlObjectMapper;
	}
	
	public static synchronized XmlObjectMapper prettyFormatMapper() {
		
		if (prettyFormatXmlObjectMapper == null) {
			prettyFormatXmlObjectMapper = new XmlObjectMapper();
			prettyFormatXmlObjectMapper.xmlMapper.enable(SerializationFeature.INDENT_OUTPUT);
		}
		
		return prettyFormatXmlObjectMapper;
	}
	
	public String toXml(Object o) throws JsonProcessingException {
		
		return this.xmlMapper.writeValueAsString(o);
	}
	
	public <T> T fromXml(String xml, Class<T> clazz) throws IOException {
		
		return this.xmlMapper.readValue(xml, clazz);
	}
}