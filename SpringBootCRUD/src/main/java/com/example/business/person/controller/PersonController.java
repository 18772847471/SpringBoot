package com.example.business.person.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/person")
public class PersonController {

    @ApiOperation(value = "hello接口",notes = "hello接口")
    @RequestMapping(value ="/hello", method = RequestMethod.GET)
    public String hello(){
        return "hello world";
    }
}
