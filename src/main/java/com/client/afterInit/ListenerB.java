package com.client.afterInit;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ApplicationContextEvent;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

@Component
public class ListenerB implements ApplicationListener<ApplicationContextEvent>,Ordered {

	@Override
	public int getOrder() {
		// TODO Auto-generated method stub
		return Ordered.HIGHEST_PRECEDENCE-1;
	}

	@Override
	public void onApplicationEvent(ApplicationContextEvent event) {
		// TODO Auto-generated method stub
		initB();
	}

	public static void initB(){
		System.out.println("B init");
	}
}
