package com.client.service;

import org.springframework.context.ApplicationEvent;

public class EventTest extends ApplicationEvent {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String message;
	
	public EventTest(Object source,String message) {
		super(source);
		// TODO Auto-generated constructor stub
		this.message=message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}



}
