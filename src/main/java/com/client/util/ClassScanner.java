package com.client.util;

import java.util.ArrayList;
import java.util.List;

import com.client.handler.HandlerType;

public class ClassScanner {

	public static List<Class<?>> scan(String packageName){
		//获取当前包下以及子包所有class
		List<Class<?>> returnClassList =ClassUtil.getAllClassByPackageName(packageName);
		
		return returnClassList;
	}
	
}
