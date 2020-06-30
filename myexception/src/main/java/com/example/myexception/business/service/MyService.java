package com.example.myexception.business.service;


import org.springframework.stereotype.Service;

@Service
public class MyService {

    public String sayHello(String name){
        System.out.println("你好："+name);
        return "成功";
    }
}
