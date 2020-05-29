package com.example.manydatasource.business.service;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.example.manydatasource.business.mapper.ClassMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.manydatasource.business.model.Class;
import java.util.List;

@Service
@DS("slave")
public class ClassService {

    @Autowired
    private ClassMapper classMapper;


    public List<Class> getClassList() {
        System.out.println("执行了test2中getClassList");
        return classMapper.getClassList();
    }
}
