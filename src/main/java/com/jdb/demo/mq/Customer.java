package com.jdb.demo.mq;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.TextMessage;

@Component
public class Customer {

    @JmsListener(destination = "jdb.queue")
    public void receiveQueue(String text){
        System.out.println("test.queue收到报文："+text);
    }

    @JmsListener(destination = "jdb.topic", containerFactory="topicListenerContainer")
    public void receiveTopic(String text){
        System.out.println("jdb.topic收到报文："+text);
    }


//    @JmsListener(destination = "jdb.queue")
//    public void receiveQueue(TextMessage text) throws JMSException {
//        System.out.println("jdb.queue收到报文："+text.getText());
//    }
}
