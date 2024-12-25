package com.client.service;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
@Component
public class ListenerTest2 implements ApplicationListener<EventTest> {

	@Override
	public void onApplicationEvent(EventTest event) {
		// TODO Auto-generated method stub
		System.out.println("listener2::"+event.getMessage());
	}

}
