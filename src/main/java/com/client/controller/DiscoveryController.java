package com.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DiscoveryController {
	
	@Autowired
	DiscoveryClient discoveryClient;
	
	@Value("${server.port}")
	private String ip;
	
	@GetMapping("/client")
	public String client(){
		String services="Service:"+discoveryClient.getServices()+"Ip:"+ip;
		System.out.println("Service:"+services);
		return services;
	}
}
