package com.example.business.person.service;

import com.example.business.person.entity.Person;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface PersonService {
    /**
     * 获取人员信息(分页)
     * @param pageNum
     * @param pageSize
     * @return
     */
    public PageInfo selectPersonAll(Integer pageNum, Integer pageSize);

    /**
     * 获取人员信息
     * @return
     */
    public List<Person> findPersonAll();

    /**
     * 根据id获取人员信息
     * @param personguid
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
     * @param ids
     */
    void deletePerson(List<String> ids);
}
