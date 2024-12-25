package com.client.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class EventPublish {

	@Autowired
	ApplicationContext context;
	
	public void publish(String msg){
		context.publishEvent(new EventTest(this,msg));
	}
	
}
