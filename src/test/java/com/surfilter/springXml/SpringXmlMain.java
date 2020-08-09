package com.surfilter.springXml;

import com.surfilter.springXml.jdbc.JdbcUtils;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * 通过加载spring的xml配置方式启动spring
 */
public class SpringXmlMain {
    public static void main(String[] args) {
        //jdbcConnection(4);
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-mybatis.xml");//通过加载xml配置文件启动spring
        JdbcTemplate template = (JdbcTemplate) context.getBean("jdbcTemplate");
        JdbcUtils.jdbcTemplate(template,4);
        String[] strings = context.getBeanDefinitionNames();
        for(int i = 0;i<strings.length;i++){
            System.out.println(strings[i]+",");
        }
    }



}
