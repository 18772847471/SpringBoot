package com.example.manydatasource.business.mapper.test1;

import com.example.manydatasource.business.model.Student;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
@Mapper
public interface StudentMapper {

    @Select("select * from t_student where cid = #{cid}")
    List<Student> getStudentList(@Param("cid") String cid);

    @Insert("INSERT INTO t_student(sid, sname, cid) VALUES (#{sid}, #{sname}, #{cid})")
    void insertStudent(@Param("sid") String sid, @Param("sname") String sname, @Param("cid") String cid);
}
