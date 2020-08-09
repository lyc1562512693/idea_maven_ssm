package com.surfilter.ssm.core;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class AppContext implements ApplicationContextAware {
	
	private static ApplicationContext applicationContext ;

	private static final AppContext APP_CONTEXT = new AppContext();

	public static Object getBean(String beanId){
		return APP_CONTEXT.getContextBean(beanId);
	}
	public Object getContextBean(String beanId){
		return applicationContext.getBean(beanId);
	}
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		// TODO Auto-generated method stub
		this.applicationContext=applicationContext;
	}
	
}
