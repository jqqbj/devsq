package com.jdb.demo.config;


import com.jdb.demo.utils.SpringUtil;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.listener.DefaultMessageListenerContainer;

import javax.jms.Queue;

//@Configuration
public class ActiveQueueConfig implements CommandLineRunner {

    @Bean
    public Queue queue() {
        return new ActiveMQQueue("default.queue");
    }


    @Override
    public void run(String... args) {
        System.out.println("Spring加载完->开始启动");
//        SpringUtil.getBean("person1");
//        JmsTemplate jmsTemplate = SpringUtil.getBean(JmsTemplate.class);
//        jmsTemplate.setSessionAcknowledgeMode(4);
    }

}