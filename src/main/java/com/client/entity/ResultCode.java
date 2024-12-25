package com.client.entity;

public enum ResultCode {
	ResultSuccess(200,"成功！"),
	ResultFail(400,"参数错误!"),
	ResultError(500,"服务异常！");
	
	private int code;
	private String message;
	
	ResultCode(int code,String message){
		this.code=code;
		this.message=message;
	}
	
	public Integer code(){
		return code;
	}
	
	public String message(){
		return message;
	}

}
