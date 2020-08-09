package com.surfilter.lyc.springJava.bm;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component
public class FictionCD implements CD {
    @Override
    public void printCDContent(String name) {
        System.out.println("it contains wonderful fiction things,the CD name is "+name);
    }
}
