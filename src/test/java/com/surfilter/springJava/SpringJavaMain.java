package com.surfilter.springJava;

import com.surfilter.model.Factory;
import com.surfilter.ssm.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * 使用java代替xml配置启动一个spring
 */
public class SpringJavaMain {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);//通过加载java方式实现的spring配置启动spring
        Factory factory = (Factory) context.getBean("factory");
        System.out.println(factory);
        System.out.println((UserService)context.getBean(UserService.class));
        ApplicationContext contextF = new FileSystemXmlApplicationContext("c:/knight.xml");
        String[] beans = contextF.getBeanDefinitionNames();
    }
}
