package com.surfilter.aop;

public class StaticProxyTest {
    public static void main(String[] args) {
        //直接表演
        Perform perform = new PerformImpl();
        perform.perform();
        //添加准备的表演
        Perform performProxy = new ProxyPerformImpl(perform);
        performProxy.perform();
    }
}
