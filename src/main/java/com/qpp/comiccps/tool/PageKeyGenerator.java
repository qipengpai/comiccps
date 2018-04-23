package com.qpp.comiccps.tool;


import org.springframework.cache.interceptor.KeyGenerator;

import java.lang.reflect.Method;

public class PageKeyGenerator implements KeyGenerator {
    @Override
    public Object generate(Object o, Method method, Object... objects) {
        return null;
    }
}
