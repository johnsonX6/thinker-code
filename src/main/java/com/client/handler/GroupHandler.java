package com.client.handler;

import org.springframework.stereotype.Component;

import com.client.entity.Order;

@Component
@HandlerType("2")
public class GroupHandler extends AbstractHandler {

	@Override
	public String handle(Order dto) {
		System.out.println("GroupHandler:");
		return "GroupHandler handle";
	}

}
