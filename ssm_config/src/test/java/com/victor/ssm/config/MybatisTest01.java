package com.victor.ssm.config;

import com.victor.ssm.config.mybatis.entity.Person;
import com.victor.ssm.config.mybatis.mapper.PersonMapper;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * @author haojiao
 * @create ${Date}
 */
public class MybatisTest01 {

    private ApplicationContext context ;

    @Before
    public void before(){
        context = new ClassPathXmlApplicationContext("spring.xml");
    }

    @Test
    public void testSelectById() throws IOException {
        PersonMapper mapper = context.getBean(PersonMapper.class);
        Person person = mapper.selectById(1);
        System.out.println(person);

    }
}
