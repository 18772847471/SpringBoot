package com.example.annotation.business.service;

import com.example.annotation.business.Shape;
import com.example.annotation.business.util.AnnotationUtil;
import org.springframework.stereotype.Service;

@Service
public class ShapeService {

    public Shape getShape() throws Exception{
        Shape shape = new Shape();
        AnnotationUtil.addAnnotation(shape);
        shape.say("张三");
        return shape;
    }
}
