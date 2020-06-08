package com.example.mymapperscan.business.mapper;


import org.apache.ibatis.annotations.Select;

public interface MyMapper {


    @Select("select * from dual")
    void  selectTest();
}
