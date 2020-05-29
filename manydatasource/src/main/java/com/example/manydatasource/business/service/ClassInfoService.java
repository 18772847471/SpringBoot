package com.example.manydatasource.business.service;



import com.example.manydatasource.business.VO.ClassInfoVO;
import com.example.manydatasource.business.model.Student;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.manydatasource.business.model.Class;
import java.util.ArrayList;
import java.util.List;

@Service
public class ClassInfoService {

    @Autowired
    private StudentService  studentService;
    @Autowired
    private ClassService  classService;

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
}
