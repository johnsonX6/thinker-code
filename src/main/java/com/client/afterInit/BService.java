package com.client.afterInit;

import javax.annotation.PostConstruct;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class BService {

	@Autowired 
	AService A;
	
	
	public BService(){
		System.out.println("BService construct!");
	}
	
	@PostConstruct
	public void init(){
		initB();
	}
	
	private void initB(){
//		if(!A.isInitialized()){
//			A.initA();
//		}
//		A.initA();
		System.out.println("initB finish");
	}

	public static void main(String[] args) {
		List<String> stringList = new ArrayList<>();
		stringList.add("a");
		stringList.add("e111");
		stringList.add("1");
		stringList.add(null);
		stringList.add("");
		stringList.add(null);
		sort(stringList);
		System.out.println(stringList);
	}

	static Comparator<String> cmp = (s1, s2) -> {
		if (StringUtils.isBlank(s1) || StringUtils.isBlank(s2)){
			return 0;
		}
		return s1.length() - s2.length(); //按照字符串长度升序排序
	};

	public static void sort(List<String> list) {
		list.sort(cmp);
	}
}
