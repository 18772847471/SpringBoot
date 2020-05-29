package com.example.manydatasource.business.mapper.test2;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import com.example.manydatasource.business.model.Class;
import java.util.List;


@Repository
@Mapper
public interface ClassMapper {

    @Select("select * from t_class")
    List<Class> getClassList();

    @Insert("INSERT INTO t_class(cid, cname) VALUES (#{cid}, #{cname})")
    void insertClass(@Param("cid") String sid, @Param("cname") String cname);
}
