package com.surfilter.aop.cglib;

import com.surfilter.aop.Perform;
import com.surfilter.aop.PerformImpl;

/**
 * cglib代理解决目标对象没有实现接口，又要进行功能扩展问题（即解决动态代理所不能）
 */
public class CglibProxyTest {
    public static void main(String[] args) {
        PerformImpl perform = new PerformImpl();//不使用接口，直接使用实现类
        CglibProxy cglibProxy = new CglibProxy();
        PerformImpl performCglibProxy = (PerformImpl) cglibProxy.getInstance(perform);
        performCglibProxy.perform();
    }
}
