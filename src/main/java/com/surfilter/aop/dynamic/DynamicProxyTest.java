package com.surfilter.aop.dynamic;

import com.surfilter.aop.Perform;
import com.surfilter.aop.PerformImpl;

import java.lang.reflect.Proxy;

public class DynamicProxyTest {
    public static void main(String[] args) {
        Perform perform = new PerformImpl();
        Perform performProxy = (Perform) Proxy.newProxyInstance(Perform.class.getClassLoader(), new Class[]{Perform.class},new DynamicProxyHandler(perform));
        performProxy.perform();
    }
}
