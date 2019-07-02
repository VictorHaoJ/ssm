package com.victor.ssm.controller;

import com.github.pagehelper.PageHelper;
import com.victor.ssm.mybatis.entity.Person;
import com.victor.ssm.mybatis.mapper.PersonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author haojiao
 * @create ${Date}
 */
@RestController
public class PersonController {

    @Autowired
    PersonMapper personMapper;

    @RequestMapping(value = "person/insert/{batchFlag}", method = RequestMethod.GET)
    public void insert(@PathVariable("batchFlag") boolean batchFlag){
        if (!batchFlag) {
            Person p = new Person();
            p.setAge(27);
            p.setUserName("jordon");
            p.setGender(1);
            p.setEmail(p.getUserName()+"@163.com");
            personMapper.insert(p);
            return ;
        }
        for (int i = 0 ; i<10 ;i++ ) {
            Person p = new Person();
            p.setAge(27+i);
            p.setUserName("jordon"+i);
            p.setGender(1);
            p.setEmail(p.getUserName()+"@163.com");
            personMapper.insert(p);
        }
    }

    @RequestMapping(path = "person/selectById/{id}", method = RequestMethod.GET)
    public Person selectById(@PathVariable Integer id) {
        System.out.println("id="+id);
        Person person = personMapper.selectById(id);
        System.out.println("person"+person);
        return person;
    }

    @RequestMapping(path = "person/listPerson/{pageNum}/{pageSize}", method = RequestMethod.GET)
    public List<Person> listPerson(@PathVariable("pageNum") Integer pageNum, @PathVariable("pageSize") Integer pageSize){
        PageHelper.startPage(pageNum, pageSize);
        return personMapper.listPerson();
    }

    @RequestMapping(path = "person/countPerson", method = RequestMethod.GET)
    public List<Integer> countPerson(){
        List<Integer> list = new ArrayList<>();
        list.add(personMapper.countPerson1());
        list.add(personMapper.countPerson2());
        return list;
    }
}
