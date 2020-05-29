package com.example.aop.controller;


import com.example.aop.annotation.SystemControllerLog;
import com.example.aop.service.ActionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ActionController {

    @Autowired
    private ActionService  actionService;

    @RequestMapping("/hello")
    @SystemControllerLog(description = "测试controller注解")
    public String hello(){
        String hello = actionService.hello();
        return  hello;
    }
}
