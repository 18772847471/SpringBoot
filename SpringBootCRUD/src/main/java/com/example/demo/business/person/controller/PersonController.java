package com.example.demo.business.person.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/person")
public class PersonController {

    @RequestMapping("/hello")
    public String hello(){
        return "hello world";
    }
}
