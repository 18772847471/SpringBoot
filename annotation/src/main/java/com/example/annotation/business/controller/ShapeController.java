package com.example.annotation.business.controller;


import com.example.annotation.business.Shape;
import com.example.annotation.business.service.ShapeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShapeController {

    @Autowired
    private ShapeService  shapeService;


    @RequestMapping("/getShape")
    public Shape getShape() throws Exception{
        Shape shape  = shapeService.getShape();
        return shape;
    }
}
