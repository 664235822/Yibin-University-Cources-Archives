package com.dao;

import org.springframework.stereotype.Component;

@Component
public class UserDaoImpl implements UserDao{

    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void say(){
        System.out.println("id为："+id);
        System.out.println("name为："+name);
    }
}
