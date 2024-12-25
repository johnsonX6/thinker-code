package com.client.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.client.config.HandlerContext;
import com.client.entity.Order;
import com.client.handler.AbstractHandler;

@Service
public  class OrderServiceImpl implements IOrderService {

	@Autowired
	HandlerContext context;
	@Override
	public String handle(Order dto) {
		AbstractHandler handler = context.getInstance(dto.getType());
		return handler.handle(dto);
	}

}
