package com.example.mytest.business.model;

public class A extends  B{

    static {
        System.out.println("A类中静态代码块");
    }
    {
        System.out.println("A类中普通代码块");
    }

    public A(){
        System.out.println("A类中构造函数");
    }

    public void say(){
        System.out.println("A说");
    }
}
