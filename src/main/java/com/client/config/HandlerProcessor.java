package com.client.config;

import java.util.Map;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

import com.client.handler.HandlerType;
import com.client.util.ClassScanner;
import com.google.common.collect.Maps;

@Component
public class HandlerProcessor implements BeanFactoryPostProcessor {

	private static String BASE_PACKAGE="com.client.handler";
	/**
	 * 扫描handler包，初始化handlerContext,将handler注册到spring容器
	 */
	@Override
	public void postProcessBeanFactory(
			ConfigurableListableBeanFactory beanFactory) throws BeansException {
		// TODO Auto-generated method stub
		Map<String,Class> handleMap = Maps.newHashMapWithExpectedSize(3);
		ClassScanner.scan(BASE_PACKAGE).forEach(clazz->{
			//获取注解中的类型值
//			String type = clazz.getAnnotation(HandlerType.class).value();
			String type ="";
			if(clazz.getAnnotation(HandlerType.class)!=null){
						type = clazz.getAnnotation(HandlerType.class).value();
			}
			handleMap.put(type, clazz);
		});
		
		HandlerContext context = new HandlerContext(handleMap);
		beanFactory.registerSingleton(HandlerType.class.getName(), context);
		System.out.println("finish regist beanFactory");
	}

}
