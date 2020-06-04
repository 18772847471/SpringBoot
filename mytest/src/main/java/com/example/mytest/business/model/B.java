package com.example.mytest.business.model;

public class B {

    static {
        System.out.println("B类中静态代码块");
    }
    {
        System.out.println("B类中普通代码块");
    }

    public B(){
        System.out.println("B类中构造函数");
    }

    public void say(){
        System.out.println("B说");
    }
}
