package com.example.manydatasource.business.VO;

import com.example.manydatasource.business.model.Student;

import java.util.List;

public class ClassInfoVO {
    private String cid;
    private String cname;
    List<Student>  students;

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
