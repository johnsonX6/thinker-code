package com.client.handler;

import org.springframework.stereotype.Component;

import com.client.entity.Order;

@Component
@HandlerType("1")
public class NormalHandler extends AbstractHandler {

	public String handle(Order dto) {
		System.out.println("this is normal handle");
		return "normalHandler";
	}
}
