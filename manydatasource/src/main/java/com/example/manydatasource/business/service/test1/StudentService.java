package com.example.manydatasource.business.service.test1;


import com.baomidou.dynamic.datasource.annotation.DS;
import com.example.manydatasource.business.mapper.test1.StudentMapper;

import com.example.manydatasource.business.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@DS("master")
public class StudentService {

    @Autowired
    private StudentMapper studentMapper;

    public List<Student> getStudentList(String cid) {
        System.out.println("执行了test1中getStudentList");
        return  studentMapper.getStudentList(cid);
    }

    @Transactional
    public void insertStudent(Student student) throws Exception{
        System.out.println("执行了test1中insertStudent");
       /* if(1==1){
            throw  new RuntimeException("111111");
        }*/
        studentMapper.insertStudent(student.getSid(),student.getSname(),student.getCid());
    }
}
