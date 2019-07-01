package com.victor.ssm.controller;

import com.victor.ssm.mybatis.entity.Person;
import com.victor.ssm.mybatis.mapper.PersonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author haojiao
 * @create ${Date}
 */
@RestController
public class PersonController {

    @Autowired
    PersonMapper personMapper;

    @RequestMapping(name = "person/insert")
    public void insert(){
        Person p = new Person();
        p.setId(3);
        p.setAge(27);
        p.setUserName("jordon");
        p.setGender(1);
        p.setEmail("jordon@163.com");
        personMapper.insert(p);
    }

    @RequestMapping(path = "person/selectById/{id}", method = RequestMethod.GET)
    public Person selectById(@PathVariable Integer id) {
        System.out.println("id="+id);
        Person person = personMapper.selectById(id);
        System.out.println("person"+person);
        return person;
    }
}
