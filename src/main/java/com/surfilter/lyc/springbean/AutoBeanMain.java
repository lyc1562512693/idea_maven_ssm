package com.surfilter.lyc.springbean;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AutoBeanMain {
    public static void main(String[] args) {
        //ioc容器初始化，并初始化非懒加载的所有bean，懒加载的bean再第一次使用时初始化
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AutoBeanConfig.class);
        //使用bean
        MyBean myBean = (MyBean)context.getBean("myBean");
        System.out.println("7-AutoBeanMain中已经从容器中获取bean："+myBean);
        //MyBeanPostProcessor process =  (MyBeanPostProcessor)context.getBean("myBeanPostProcessor");
        //System.out.println(process);
        //销毁bean
        context.registerShutdownHook();
        new Thread(() -> System.out.println("123"));
    }
}
