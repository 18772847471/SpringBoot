package com.example.aop.service;

import com.example.aop.annotation.SystemServiceLog;
import org.springframework.stereotype.Service;

@Service
public class ActionService {

    @SystemServiceLog(description = "测试service注解")
    public String hello() {
        String hello ="你好";
        return hello;
    }
}
