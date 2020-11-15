package com.surfilter.lyc.springbean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class MyBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {

        if(MyBean.class.equals(bean.getClass())){
            System.out.println("2-MyBeanPostProcessor的postProcessBeforeInitialization method is running.");
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {

        if(MyBean.class.equals(bean.getClass())){
            System.out.println("6-MyBeanPostProcessor的postProcessAfterInitialization method is running.");
        }
        return bean;
    }
}
