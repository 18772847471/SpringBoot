package com.example.mytest.business.model;

import org.springframework.web.servlet.DispatcherServlet;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

public class mapTest {
    public static void main(String[] args){
        Map<String,Object> map= new HashMap<String,Object>();
        Map<String,Object> hashTable = new Hashtable<String,Object>();
        Map<String,Object> concurrentHashMap =new ConcurrentHashMap<String,Object>();
        Map<String,Object> linkHashMap = new LinkedHashMap<String,Object>();
        Set<String> hashSet =new HashSet<String>();
        ReentrantLock reentrantLock =new ReentrantLock();

        //map.put(null,null);
        //hashTable.put("1",null);
        concurrentHashMap.put("1",null);

         
        //System.out.println(map.get(null));
        //System.out.println(hashTable.get(null));
        //System.out.println(concurrentHashMap.get(null));
        //System.out.println(linkHashMap.get(null));
    }


}
