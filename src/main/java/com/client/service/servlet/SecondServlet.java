package com.client.service.servlet;

import com.client.service.GPRequest;
import com.client.service.GPResponse;

public class SecondServlet extends GPServlet {

	public void doGet(GPRequest request,GPResponse response){
		this.doPost(request,response);
	}
	
	public void doPost(GPRequest request,GPResponse response){
		response.write("this is secondServlet!");
	}
}
