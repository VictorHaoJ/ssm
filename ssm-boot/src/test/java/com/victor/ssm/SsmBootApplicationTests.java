package com.victor.ssm;

import com.victor.ssm.mybatis.entity.Person;
import com.victor.ssm.mybatis.mapper.PersonMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SsmBootApplicationTests {

    @Test
    public void contextLoads() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        PersonMapper personMapper = context.getBean(PersonMapper.class);
        Person person = personMapper.selectById(1);
        System.out.println(person);

    }

}
