package com.surfilter.lyc.springJava;

import com.surfilter.lyc.springJava.bm.CD;
import com.surfilter.lyc.springJava.bm.FictionCD;
import com.surfilter.lyc.springJava.bm.SmallCDPlayer;
import org.springframework.context.annotation.*;

@Configuration
@Import(SCConfigA.class)//引入另一个java形式springConfig配置
@ImportResource("classpath:spring-mybatis.xml")//引入一个xml形式的springConfig配置
@ComponentScan
@EnableAspectJAutoProxy//启用AspectJ自动代理
public class SpringContextConfig {
//显示方式创建bean
//    @Bean
//    public SmallCDPlayer smallCDPlayer(){
//        return new SmallCDPlayer(fictionCD("cdAutotest"));
//    }
//    @Bean
//    public CD fictionCD(){
//        return new FictionCD();
//    }
}
