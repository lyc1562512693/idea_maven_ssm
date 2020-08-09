package com.surfilter.aop;

/**
 * 代理类（邓紫棋经纪人）
 */
public class ProxyPerformImpl implements Perform {
    //代理类中维护一个公共接口属性，供被代理类传入
    private Perform perform;
    public ProxyPerformImpl(Perform perform){
        this.perform = perform;
    }
    @Override
    public void perform() {
        System.out.println("开演唱会前先买票！");
        perform.perform();
        System.out.println("开演唱会后收拾场地！");
    }
}
