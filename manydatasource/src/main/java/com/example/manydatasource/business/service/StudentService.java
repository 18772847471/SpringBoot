package com.example.manydatasource.business.service;


import com.baomidou.dynamic.datasource.annotation.DS;
import com.example.manydatasource.business.mapper.StudentMapper;

import com.example.manydatasource.business.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@DS("master")
public class StudentService {

    @Autowired
    private StudentMapper studentMapper;

    public List<Student> getStudentList() {
        System.out.println("执行了test1中getStudentList");
        return  studentMapper.getStudentList();
    }
}
