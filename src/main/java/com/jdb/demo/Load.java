package com.jdb.demo;

import com.jdb.demo.utils.SpringUtil;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;


@Configuration
public class Load implements CommandLineRunner {

    @Override
    public void run(String... args) {
        System.out.println("Spring加载完->开始启动");
        SpringUtil.getBean("person1");
//        JmsTemplate jmsTemplate = SpringUtil.getBean(JmsTemplate.class);
//        jmsTemplate.setSessionAcknowledgeMode(4);
    }

}