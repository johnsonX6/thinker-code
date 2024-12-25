package com.client.util;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

public class BeanToolUtil {

	private BeanToolUtil(){
		
	}
	
	public static Object getBean(Class clazz){
//		ApplicationContext context = new ApplicationContext();
		Object obj =null;
		try {
			obj = clazz.newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return obj;
	}
}
