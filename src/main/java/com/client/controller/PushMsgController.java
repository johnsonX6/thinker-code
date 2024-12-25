package com.client.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PushMsgController {
	//服务器推送
	
	@RequestMapping(value ="/pushPrice",produces ="text/event-stream;charset=UTF-8")
	@ResponseBody
	public String push(){
		//交给SpringMVC，还是不停的请求服务器
		Random r = new Random();
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return makeResponse(r);
	}
	
	public String makeResponse(Random r){
		StringBuilder sb = new StringBuilder("");
		sb.append("source:200\n").append("data:").append(r.nextInt(10)+50+",")
		.append(r.nextInt(10)+30).append("\n\n");
		return sb.toString();
	}
	
	@RequestMapping(value ="/pushPricer")
	@ResponseBody
	public void printResponse(HttpServletResponse response){
		response.setContentType("text/event-stream");
		response.setCharacterEncoding("UTF-8");
		int i =0;
		Random r = new Random();
		
			try {
				PrintWriter pw = response.getWriter();
				while(i<10){
				if(pw.checkError()){
					return;
				}
				Thread.sleep(1000);
				pw.print(makeResponse(r));
				pw.flush();
				i++;
				}
				System.out.println("达到阈值，放弃输出...");
				pw.print("data:stop\n\n");
				pw.flush();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	
}
