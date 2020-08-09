package com.surfilter.aop.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class DynamicProxyHandler implements InvocationHandler {
    private Object object;
    public DynamicProxyHandler(final Object object){
        this.object = object;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("开演唱会前要卖票！");
        Object result = method.invoke(object,args);
        System.out.println("开演唱会后要收拾现场！");
        return result;
    }
}
