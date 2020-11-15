package com.surfilter.lyc.kafka;

import com.surfilter.lyc.springbean.MyBean;

public class KafkaConsumer<K,V> {
    K k;
    V v;
    public static void main(String[] args) {

    }
    public void createConsumer(){
        ThreadLocal<MyBean> i = new ThreadLocal<MyBean>();
    }
}
