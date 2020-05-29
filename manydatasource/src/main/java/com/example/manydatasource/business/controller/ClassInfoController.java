package com.example.manydatasource.business.controller;

import com.example.manydatasource.business.VO.ClassInfoVO;
import com.example.manydatasource.business.service.ClassInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class ClassInfoController {
    @Autowired
    private ClassInfoService classInfoService;

    @RequestMapping("/getClassInfoList")
    public List<ClassInfoVO> getClassInfoList(){
        return classInfoService.getClassInfoList();
    }
}
