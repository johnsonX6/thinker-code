package com.client.config;

import java.util.Map;

import org.springframework.stereotype.Component;

import com.client.handler.AbstractHandler;
import com.client.handler.NormalHandler;
import com.client.util.BeanToolUtil;
public class HandlerContext {

	private Map<String,Class> handleMap;
	
	public HandlerContext(Map<String,Class> handleMap){
		this.handleMap=handleMap;
	}
	
	public AbstractHandler getInstance(String type){
		Class clazz = handleMap.get(type);
		if(clazz ==null){
			throw new IllegalArgumentException("illegalArgumentException"+type);
		}
		AbstractHandler handler = (AbstractHandler) BeanToolUtil.getBean(clazz);
//		AbstractHandler handler = new NormalHandler();
		return handler;
	}
	
}
