package com.jdb.demo.service;

import com.jdb.demo.mybatis.mapper.MyPerson;
import com.jdb.demo.mybatis.mapper.PersonMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;

@Service
public class PersonService {

    @Resource
    PersonMapper personMapper;

    //@Transactional(noRollbackFor=ArithmeticException.class)
    // 默认noRollbackFor为RuntimeException启用回滚，隔离级别则默认采用数据库
    @Transactional
    public void addPerson(){
        MyPerson person = new MyPerson(new Date().getTime(),"Name"+new Date().getTime());
        personMapper.insert(person);
        //System.out.println("xxxxxxxxxxxxx555");
        //int i=9/0;
    }
}
