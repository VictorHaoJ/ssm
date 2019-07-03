package com.victor.ssm.config;

import com.victor.ssm.config.mybatis.entity.Person;
import com.victor.ssm.config.mybatis.mapper.PersonMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author haojiao
 * @create ${Date}
 */
public class MybatisTest {

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
}
