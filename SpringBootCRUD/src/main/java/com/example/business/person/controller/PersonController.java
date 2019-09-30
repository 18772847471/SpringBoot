package com.example.business.person.controller;


import com.example.business.person.entity.Person;
import com.example.business.person.service.PersonService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/v1/person")
public class PersonController {

    private static Logger logger=Logger.getLogger(PersonController.class);

    @Resource(name="personServiceImpl")
    private PersonService personService;

    @ApiOperation(value = "hello接口",notes = "hello接口")
    @RequestMapping(value ="/hello", method = RequestMethod.GET)
    public String hello(){
        logger.info("普通Info信息");
        return "hello world";
    }

    @ApiOperation(value = "获取所有人员信息接口(分页)",notes = "获取所有人员信息接口(分页)")
    @RequestMapping(value ="/selectPersonAll", method = RequestMethod.GET)
    public PageInfo selectPersonAll(@RequestParam Integer pageNum, @RequestParam Integer pageSize){
        return personService.selectPersonAll(pageNum,pageSize);
    }

    @ApiOperation(value = "获取所有人员信息接口",notes = "获取所有人员信息接口")
    @RequestMapping(value ="/findPersonAll", method = RequestMethod.GET)
    public List<Person> findPersonAll(){
        return personService.findPersonAll();
    }

    @ApiOperation(value = "根据人员id获取所有人员信息接口",notes = "根据人员id获取所有人员信息接口")
    @RequestMapping(value ="/getPersonByPersonguid", method = RequestMethod.GET)
    public List<Person> getPersonByPersonguid(@RequestParam String personguid){
        return personService.getPersonByPersonguid(personguid);
    }

    @ApiOperation(value = "插入人员信息接口",notes = "插入人员信息接口")
    @RequestMapping(value ="/insertPerson", method = RequestMethod.POST)
    public void insertPerson(@RequestBody Person person){
        personService.insertPerson(person);
    }

    @ApiOperation(value = "修改人员信息接口",notes = "修改人员信息接口")
    @RequestMapping(value ="/updatePerson", method = RequestMethod.PUT)
    public void updatePerson(@RequestBody Person person){
        personService.updatePerson(person);
    }

    @ApiOperation(value = "删除人员信息接口",notes = "删除人员信息接口")
    @RequestMapping(value ="/deletePerson", method = RequestMethod.DELETE)
    public void deletePerson(@RequestBody List<String> ids){
        personService.deletePerson(ids);
    }
}
