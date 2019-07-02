package com.victor.ssm.config.mybatis.controller;

import com.victor.ssm.config.mybatis.entity.Person;
import com.victor.ssm.config.mybatis.mapper.PersonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author haojiao
 * @desc: TODO
 * @create 2019/7/2
 */
@RestController
public class PersonController {

    @Autowired
    PersonMapper personMapper;

    @RequestMapping(path = "person/selectById/{id}", method = RequestMethod.GET)
    public Person selectById(@PathVariable Integer id) {
        System.out.println("id="+id);
        Person person = personMapper.selectById(id);
        System.out.println("person"+person);
        return person;
    }

//    @RequestMapping(path = "person/listPerson/{pageNum}/{pageSize}", method = RequestMethod.GET)
//    public List<Person> listPerson(@PathVariable("pageNum") Integer pageNum, @PathVariable("pageSize") Integer pageSize){
//        PageHelper.startPage(pageNum, pageSize);
//        return personMapper.listPerson();
//    }
}
