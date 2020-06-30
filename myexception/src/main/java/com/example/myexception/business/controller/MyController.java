package com.example.myexception.business.controller;


import com.example.myexception.business.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MyController {

    @Autowired
    MyService  myService;

    @RequestMapping(value="/sayHello",method = RequestMethod.GET)
    public ResponseEntity sayHello(){
        return new ResponseEntity(myService.sayHello("张三"),HttpStatus.OK);
    }
}
