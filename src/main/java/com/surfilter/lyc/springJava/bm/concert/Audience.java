package com.surfilter.lyc.springJava.bm.concert;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;
import org.springframework.test.context.transaction.BeforeTransaction;

/**
 * 实现一个切面
 */
@Aspect//表明这是一个切面类
@Component
public class Audience {
    @Before("execution(* com.surfilter.lyc.springJava.bm.concert.*.perform(..))")//定义切点
    public void practice(){
        System.out.println("Before the performance, we shoule practice hardly!");
    }
    @After("execution(* com.surfilter.lyc.springJava.bm.concert.Performance.perform(..))")
    public void applause(){
        System.out.println("After the performance, we shoule gain applause!");
    }
}
