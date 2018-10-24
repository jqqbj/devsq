package com.jdb.demo.config;

import com.jdb.demo.entity.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class TestBean {

    @Bean
    public Person person1() {
        Person p = new Person();
        p.setId(1L);
        return p;
    }

    @Bean
    public Person person2() {
        Person p = new Person();
        p.setId(2L);
        return p;
    }

    @Bean(name="person3")
    public Person person3() {
        Person p = new Person();
        p.setId(1L);
        return p;
    }

}
