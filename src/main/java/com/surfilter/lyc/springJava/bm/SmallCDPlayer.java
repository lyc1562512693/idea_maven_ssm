package com.surfilter.lyc.springJava.bm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class SmallCDPlayer implements CDPlayer{
    protected String name="SmallCD";
    @Autowired
    protected CD cd;
    @Override
    public void play(CD cd) {
        cd.printCDContent(name);
    }
    public void playAuto(String nameAuto){
        cd.printCDContent(nameAuto);
    }
}
