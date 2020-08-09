package com.surfilter.lyc.springJava.bm.concert;

import org.springframework.stereotype.Component;

@Component
public class DiscoPerformance implements Performance{

    @Override
    public void perform() {
        System.out.println("disco performance is acting");
    }
}
