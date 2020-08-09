package com.surfilter.lyc.springJava;

import com.surfilter.lyc.springJava.bm.FictionCD;
import com.surfilter.lyc.springJava.bm.SmallCDPlayer;
import com.surfilter.ssm.controller.UserController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringContextMain {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringContextConfig.class);
        String[] strings = context.getBeanDefinitionNames();
        for(int i=0;i<strings.length;i++){
            System.out.println(strings[i]+",");
        }
        SmallCDPlayer sp = (SmallCDPlayer)context.getBean("smallCDPlayer");
        FictionCD fcd = (FictionCD)context.getBean("fictionCD");
        sp.play(fcd);
        sp.playAuto("SmallCDAuto");
    }
}
