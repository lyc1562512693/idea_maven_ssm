package com.surfilter.ioc;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IOCInit implements Runnable{
    //目前只是获取bean名字即别名（后续可以加上获取方法属性）
    @Override
    public void run() {
       List<Class> classes = new ArrayList<>();
       Map<String, BeanDefinetion> beanMap = new HashMap<>();
       //获取指定包所有的类
       List<Class> clazzs = AnnotationUtil.getAllClazzByPackageName("com.surfilter.ioc");
       //获取指定注解的类
       for(Class clazz : clazzs){
           if(clazz.isAnnotationPresent(CustomAnnotation.class)){
               classes.add(clazz);
           }
       }
       for(Class clazz : classes){
           BeanDefinetion beanDefinetion = new BeanDefinetion();
           beanDefinetion.setBeanName(clazz.getName());
           beanDefinetion.setAlias(getBeanAlias(clazz.getName()));
           beanMap.put(clazz.getName(), beanDefinetion);
       }
       //工厂去初始化beanDefinetion
    }

    public String  getBeanAlias(String beanName){
        String className = beanName.substring(0, beanName.length()-6);
        return className.substring(0,1).toLowerCase() + className.substring(1,className.length());
    }
}
