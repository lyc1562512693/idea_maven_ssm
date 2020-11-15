package com.surfilter.lyc.springbean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

//@ImportResource("classpath:spring-mybatis.xml")//引入一个xml形式的springConfig配置
@Configuration
@ComponentScan("com.surfilter.lyc.springbean")
public class AutoBeanConfig {
    @Bean(initMethod = "myInit",destroyMethod = "myDestroy")
    public MyBean myBean(){
        return new MyBean();
    }
}
