package com.example.annotation.business;

import com.example.annotation.business.annotation.Color;
import com.example.annotation.business.annotation.Hello;
import com.example.annotation.business.annotation.Line;

public class Shape {

    @Line
    private  int line;

    @Color(color = "红色")
    private String color;

    @Hello(sayHello = "测试注解")
    public  void say(String name){
        System.out.println(name+"来了");
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line = line;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
