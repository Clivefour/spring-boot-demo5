package com.clive.springbootdemo5.controller;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SendQueueController {
    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;


    @RequestMapping("/sendQueue/{message}")
    public void sendQueue(@PathVariable String message) {
        ActiveMQQueue queue = new ActiveMQQueue("ptp");
        jmsMessagingTemplate.convertAndSend(queue, message);
        System.out.println("发送成功了");
    }
    @RequestMapping("/sendTopic/{message}")
    public void sendTopic(@PathVariable String message){
        ActiveMQTopic topic = new ActiveMQTopic("sap");
        jmsMessagingTemplate.convertAndSend(topic,message);
        System.out.println("发送成功了");
    }



}
