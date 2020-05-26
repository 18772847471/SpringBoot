package com.example.jstack;

public class TryTest {
    public String sayHello(){
        String msg = null;
        try {
            msg = "hello";
            if(1==1){
                throw  new RuntimeException("123");
            }
            return msg;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            msg="789";
        }
        return msg;
    }

    public static void  main(String[] args){
        TryTest tryTest =new TryTest();
        System.out.println(tryTest.sayHello());
    }
}
