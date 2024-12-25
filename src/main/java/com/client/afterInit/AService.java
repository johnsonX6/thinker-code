package com.client.afterInit;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service("A")
public class AService {
	
//我们需要initA()先于initB()得到执行
	
	private static boolean isInitialize;
	@Autowired
	BService B;
	public AService(){
		System.out.println("this is AService construct");
	}
	
	@PostConstruct
	public void init(){
		initA();
	}
	
	public boolean isInitialized(){
		return isInitialize;
	}
	
	public void initA(){
		if(!isInitialized()){
			System.out.println("A init finish!");
			System.out.println(" demo finish!");
		}
		isInitialize=true;
	}

	public static void main(String[] args) {
		CompletableFuture cf = CompletableFuture.supplyAsync(() -> {
			System.out.println("start task");
			return 1;
		});
		cf.thenApply(x -> {
			System.out.println("second task");
			return 2;
		}).thenCompose(x1 -> {
			System.out.println("third task");
			return 3;
		}).thenCompose(x2 -> {
			System.out.println("forth task");
			return 4;
		}).thenCompose(x3 -> {
			System.out.println("fifth task");
			return 5;
		}).thenCompose(x4 -> {
			System.out.println("sixth task");
			return 6;
		}).thenCompose(x5 -> {
			System.out.println("seventh task");
			return 7;
		}).thenCompose(x6 -> {
			System.out.println("eighth task");
			return 8;
		}).thenCompose(x7 -> {
			System.out.println("ninth task");
			return 9;
		}).thenCompose(x8 -> {
			System.out.println("tenth task");
			return 10;
		}).exceptionally(e -> {
			// 记录异常埋点日志
			return 0;
		});
	}

}
