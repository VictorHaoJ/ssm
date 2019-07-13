package com.victor.ssm.config.controller;

import com.victor.ssm.config.mybatis.entity.Person;
import com.victor.ssm.config.mybatis.mapper.PersonMapper;
import com.victor.ssm.config.service.PersonService;
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

    PersonService personService;

    @RequestMapping(path = "person/selectById/{id}", method = RequestMethod.GET)
    public Person selectById(@PathVariable Integer id) {
        System.out.println("id="+id);
        Person person = personMapper.selectById(id);
        System.out.println("person"+person);
        return person;
    }

    @RequestMapping(path = "person/buyBook/{person_id}/{book_id}/{quantity}", method = RequestMethod.GET)
    public String buyBook(@PathVariable("personId") Integer personId, @PathVariable("book_id") Integer bookId,
                          @PathVariable("quantity") Integer quantity){

        personService.buyBook(personId, bookId, quantity);

        return "购买成功";
    }

//    @RequestMapping(path = "person/listPerson/{pageNum}/{pageSize}", method = RequestMethod.GET)
//    public List<Person> listPerson(@PathVariable("pageNum") Integer pageNum, @PathVariable("pageSize") Integer pageSize){
//        PageHelper.startPage(pageNum, pageSize);
//        return personMapper.listPerson();
//    }
}
