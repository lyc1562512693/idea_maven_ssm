package com.surfilter.springJava;

import com.surfilter.model.Factory;
import com.surfilter.model.Worker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(value={"com.surfilter.model"})
public class SpringConfig {

    @Bean
    public Factory factory(){
        return new Factory(worker());
    }
    @Bean
    public Worker worker(){
        return new Worker(123);
    }

}
