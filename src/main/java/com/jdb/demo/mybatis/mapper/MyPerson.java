package com.jdb.demo.mybatis.mapper;

import java.io.Serializable;

public class MyPerson implements Serializable {

    public Long id;

    public String name;

    public MyPerson(){}

    public MyPerson(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "MyPerson{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
