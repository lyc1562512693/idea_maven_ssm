package com.surfilter.lyc.springbean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class MyBean implements InitializingBean, DisposableBean {

    public MyBean(){
        System.out.println("1-MyBean-自定义bean的构造方法执行了");
    }
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("4-MyBean的InitializingBean的afterPropertiesSet()方法执行了");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("9-MyBean的DisposableBean的destroy()方法执行了");
    }
    @PostConstruct
    public void myPostConstruct(){
        System.out.println("3-MyBean-@PostConstruct function is running.");
    }
    @PreDestroy
    public void myPreDestroy(){
        System.out.println("8-MyBean-@PreDestroy function is running.");
    }
    public void myInit(){
        System.out.println("5-MyBean-javaConfig类@Bean创建bean时，指定的init-method方法执行了,这里进行真正bean的初始化工作");
    }
    public void myDestroy(){
        System.out.println("10-MyBean-javaConfig类的@Bean创建时，指定的destroy-method方法执行了.");
    }
}
