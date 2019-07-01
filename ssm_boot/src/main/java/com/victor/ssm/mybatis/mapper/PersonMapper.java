package com.victor.ssm.mybatis.mapper;

import com.victor.ssm.mybatis.entity.Person;
import org.apache.ibatis.annotations.Param;

/**
 * @author haojiao
 * @create ${Date}
 */
public interface PersonMapper {

//    @Select("select * from person where id = #{id}")
    Person selectById(@Param("id") Integer id);

//    @Insert("insert into t_person values (#{id}, #{name}, #{age}, #{gender})")
    void insert(Person person);
}
