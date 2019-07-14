package com.victor.ssm.config.mybatis.mapper;

import com.victor.ssm.config.mybatis.entity.Person;
import org.apache.ibatis.annotations.Param;

/**
 * @author haojiao
 * @create ${Date}
 */
public interface PersonMapper {

    //    @Select("select * from t_person where id = #{id}")
    Person selectById(@Param("id") Integer id);

    //    @Insert("insert into t_person values (#{id}, #{name}, #{age}, #{gender})")
    void insert(Person person);
}
