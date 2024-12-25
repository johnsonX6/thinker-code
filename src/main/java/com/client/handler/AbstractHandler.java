package com.client.handler;

import com.client.entity.Order;

public  abstract class AbstractHandler {

//	public String handle(){
//		System.out.println("abstractHandler");
//		return "abstractHandler";
//	};
	abstract public String handle(Order dto);
}
