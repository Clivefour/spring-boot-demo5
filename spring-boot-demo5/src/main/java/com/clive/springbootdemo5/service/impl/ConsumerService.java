package com.clive.springbootdemo5.service.impl;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class ConsumerService {
    //只要已监听立马就获取
    @JmsListener(destination = "ptp")
    public void getQueue(String message) {
        System.out.println("获取到了数据 " + message);
        System.out.println("完毕了");
    }
    //只要已监听立马就获取
    @JmsListener(destination = "sap")
    public void getTopic01(String message){
        System.out.println("获取到了数据1 " + message);
        System.out.println("完毕了1");

    }
    //只要已监听立马就获取
    @JmsListener(destination = "sap")
    public void getTopic02(String message){
        System.out.println("获取到了数据2 " + message);
        System.out.println("完毕了2");

    }
}
