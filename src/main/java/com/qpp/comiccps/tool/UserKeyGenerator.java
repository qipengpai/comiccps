package com.qpp.comiccps.tool;

import org.springframework.cache.interceptor.KeyGenerator;

import java.lang.reflect.Method;

public class UserKeyGenerator implements KeyGenerator {

	@Override
	public Object generate(Object arg0, Method arg1, Object... arg2) {
		// TODO Auto-generated method stub
		return arg0.toString();
	}

}
