package com.victor.ssm.config;

import com.victor.ssm.config.mybatis.entity.Person;
import com.victor.ssm.config.mybatis.mapper.PersonMapper;
import com.victor.ssm.config.service.PersonService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author haojiao
 * @create ${Date}
 */
public class MybatisTest {

    @Test
    public void test4(){
        ApplicationContext ioc = getApplicationContext();

        PersonService personService = ioc.getBean(PersonService.class);

        personService.buyBook(1, 1, 1);



    }

    public ApplicationContext getApplicationContext() {
        String resouce = "classpath*:spring.xml";
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(resouce);
        return context;
    }

    @Test
    public void testSelectById() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();
        PersonMapper mapper = sqlSession.getMapper(PersonMapper.class);
        Person person = mapper.selectById(1);
        System.out.println(person);

    }

    @Test
    public void test2() throws IOException {
        String resouce = "classpath*:spring.xml";
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(resouce);

        PersonMapper personMapper = context.getBean(PersonMapper.class);
        Person person = personMapper.selectById(24);
        System.out.println(person);
    }


    @Test
    public void test3() throws IOException {
        String resouce = "classpath*:spring.xml";
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(resouce);

        PersonMapper personMapper = context.getBean(PersonMapper.class);

        Person p = new Person();
        p.setAge(27);
        p.setUserName("meila");
//        p.setGender(GenderEnum.FEMALE);
        p.setEmail(p.getUserName()+"@163.com");
        personMapper.insert(p);
        System.out.println(p);

    }
}
