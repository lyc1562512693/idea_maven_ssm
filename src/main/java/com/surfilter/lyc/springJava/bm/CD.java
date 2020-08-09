package com.surfilter.lyc.springJava.bm;

import org.springframework.context.annotation.ComponentScan;

@ComponentScan
public interface CD {
    void printCDContent(String name);
}
