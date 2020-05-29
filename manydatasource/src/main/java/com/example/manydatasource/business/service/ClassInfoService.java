package com.example.manydatasource.business.service;



import com.example.manydatasource.business.VO.ClassInfoVO;
import com.example.manydatasource.business.model.Student;
import com.example.manydatasource.business.service.test1.StudentService;
import com.example.manydatasource.business.service.test2.ClassService;
import com.example.manydatasource.business.util.UUIDGenerator;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.manydatasource.business.model.Class;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClassInfoService {

    @Autowired
    private StudentService studentService;
    @Autowired
    private ClassService classService;

    public List<ClassInfoVO>  getClassInfoList() {
        List<Class> classes = classService.getClassList();
        List<ClassInfoVO> list = new ArrayList<ClassInfoVO>();
        if (classes != null && classes.size() > 0) {
            for (Class classinfo : classes) {
                ClassInfoVO c =new ClassInfoVO();
                BeanUtils.copyProperties(classinfo,c);
                List<Student> students = studentService.getStudentList();
                c.setStudents(students);
                list.add(c);
            }
        }
        return  list;
    }

    @Transactional(transactionManager = "atomikosTransactionManager")
    public void insertClassInfoVO(ClassInfoVO classInfoVO) throws Exception{
        Class cla = new Class();
        cla.setCid(UUIDGenerator.randomUUID());
        cla.setCname(classInfoVO.getCname());
        classService.insetClass(cla);

        List<Student> list = classInfoVO.getStudents();
        if(list!= null && list.size()>0){
            for(Student student:list){
                student.setSid(UUIDGenerator.randomUUID());
                student.setCid(cla.getCid());
                studentService.insertStudent(student);
            }
        }
    }
}
