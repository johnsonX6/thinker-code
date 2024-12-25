package com.client.entity;

public class Result {

	public Integer code;
	
	public String message;
	
	public Object body;
	
	public Result(ResultCode code,Object body){
		this.code = code.code();
		this.message = code.message();
		this.body = body;
	}
	
	public Result ok(Object body){
		this.code =200;
		this.message="SUCCESS!";
		this.body =body;
		return this;
	}
	
	public Result fail(Object body){
		this.code = 500;
		this.message = "fail";
		this.body = body;
		return this;
	}
	
}
