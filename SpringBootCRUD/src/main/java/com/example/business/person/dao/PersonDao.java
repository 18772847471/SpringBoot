package com.example.business.person.dao;

import com.example.business.person.entity.Person;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface PersonDao {

    /**
     * 获取所有人员信息（分页）
     * @return
     */
     List<Person>  selectPersonAll();

    /**
     * 获取所有人员信息
     * @return
     */
    List<Person> findPersonAll();

    /**
     * 根据人员id获取人员信息
     * @return
     */
    List<Person> getPersonByPersonguid(String personguid);

    /**
     * 插入人员信息
     * @param person
     */
    void insertPerson(Person person);

    /**
     * 更新人员信息
     * @param person
     */
    void updatePerson(Person person);

    /**
     * 删除人员信息
     * @param id
     */
    void deletePerson(String id);
}
