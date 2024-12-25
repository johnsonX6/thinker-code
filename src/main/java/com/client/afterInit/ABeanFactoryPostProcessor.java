//package com.client.AfterInit;
//
//import org.springframework.beans.BeansException;
//import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
//import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
//import org.springframework.stereotype.Component;
//
//@Component
//public class ABeanFactoryPostProcessor implements BeanFactoryPostProcessor  {
//
//	@Override
//	public void postProcessBeanFactory(
//			ConfigurableListableBeanFactory beanFactory) throws BeansException {
//		// TODO Auto-generated method stub
//		AService A=(AService)beanFactory.getBean("A");
//		A.initA();
//	}
//
//}
