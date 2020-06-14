package com.example.business.person.impl;

import com.example.business.person.dao.PersonDao;
import com.example.business.person.entity.Person;
import com.example.business.person.service.PersonService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("personServiceImpl")
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonDao personDao;

    @Override
    public PageInfo selectPersonAll(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Person> list =personDao.selectPersonAll();
        PageInfo pageInfo = new PageInfo(list);
        return  pageInfo;
    }

    @Override
    public List<Person> findPersonAll() {
        return  personDao.findPersonAll();
    }

    @Override
    public List<Person> getPersonByPersonguid(String personguid) {
        return personDao.getPersonByPersonguid(personguid);
    }

    @Override
    public void insertPerson(Person person) {

        personDao.insertPerson(person);
    }

    @Override
    @Transactional
    public void updatePerson(Person person) {
        personDao.updatePerson(person);
    }

    @Override
    public void deletePerson(List<String> ids) {
        for(String id :ids){
            personDao.deletePerson(id);
        }
    }
}
