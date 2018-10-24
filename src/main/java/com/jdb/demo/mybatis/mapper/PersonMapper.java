package com.jdb.demo.mybatis.mapper;

import com.jdb.demo.entity.Person;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.Map;


//@MapperScan已经定义这里无需定义
//@Mapper
public interface PersonMapper {

    @Select("select * from person where id=#{id}")
    MyPerson getId(Long id);

    Map getOne(Long id);

    @Insert("insert into person(id,name) values(#{id},#{name})")
    public void insert(MyPerson person);

}
