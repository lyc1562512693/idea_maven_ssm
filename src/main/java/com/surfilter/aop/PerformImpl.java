package com.surfilter.aop;

/**
 * 被代理类（邓紫琪）
 */
public class PerformImpl implements Perform {
    @Override
    public void perform() {
        System.out.println("邓紫琪开演唱会！");
    }
}
