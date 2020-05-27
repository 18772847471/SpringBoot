package com.example.annotation.business.util;

import com.example.annotation.business.annotation.Color;
import com.example.annotation.business.annotation.Hello;
import com.example.annotation.business.annotation.Line;
import com.example.annotation.business.service.Callback;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class AnnotationUtil {

    public static void addAnnotation(Object object) throws  Exception{
       Class classInfo = object.getClass();
        Field[] fields = classInfo.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            if (field.isAnnotationPresent(Color.class)) {
                Color color = (Color) field.getAnnotation(Color.class);
                field.set(object,color.color());
            } else if (field.isAnnotationPresent(Line.class)) {
                Line line = (Line) field.getAnnotation(Line.class);
                field.set(object,line.line());
            }
        }

        Method[] methods = classInfo.getDeclaredMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(Hello.class)) {
                Callback callback =new Callback();
                Class callbackClass = callback.getClass();
                Method callbackClassethod = callbackClass.getDeclaredMethod("sayTest", String.class);
                callbackClassethod.invoke(callbackClass.newInstance(),"李四");
            }
        }
    }
}
