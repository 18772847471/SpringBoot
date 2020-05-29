package com.example.manydatasource.business.controller;

import com.example.manydatasource.business.VO.ClassInfoVO;
import com.example.manydatasource.business.service.ClassInfoService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class ClassInfoController {
    @Autowired
    private ClassInfoService classInfoService;

    @ApiOperation(value = "获取信息",notes = "获取信息")
    @RequestMapping(value ="/getClassInfoList", method = RequestMethod.GET)
    public List<ClassInfoVO> getClassInfoList(){
        return classInfoService.getClassInfoList();
    }

    @ApiOperation(value = "插入信息",notes = "插入信息")
    @RequestMapping(value ="/insertClassInfoVO", method = RequestMethod.POST)
    public void insertClassInfoVO(@RequestBody ClassInfoVO classInfoVO) throws Exception{
        classInfoService.insertClassInfoVO(classInfoVO);
    }
}
