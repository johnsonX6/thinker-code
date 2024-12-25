package com.client.service.servlet;

import com.client.service.GPRequest;
import com.client.service.GPResponse;

public class FirstServlet extends GPServlet {

	@Override
	public void doGet(GPRequest request, GPResponse response) {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}

	@Override
	public void doPost(GPRequest request, GPResponse response) {
		// TODO Auto-generated method stub
		response.write("this is first servlet!");
	}

}
