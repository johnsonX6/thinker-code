package com.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.client.service.AppInfoService;

@RestController
public class DemoController {

	@Autowired
	AppInfoService appInfoService;
	
	@Value("${test.putThrough}")
	String putThrough;
	
	
	@RequestMapping("/demo/xmlInfo")
	public String xmlInfo(){
		String str=appInfoService.getAppInfo();
		return str;
	}
	
	@RequestMapping("/demo/putThroughFlag")
	public String testChangeInfo(){
		String str=putThrough;
		return  str;
	}
}
