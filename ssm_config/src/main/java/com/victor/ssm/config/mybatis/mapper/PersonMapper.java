package com.victor.ssm.config.mybatis.mapper;

import com.victor.ssm.config.mybatis.entity.Person;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author haojiao
 * @create ${Date}
 */
public interface PersonMapper {

    @Select("select * from t_person where id = #{id}")
    public Person selectById(@Param("id") Integer id);

    @Insert("insert into t_person values (#{id}, #{name}, #{age}, #{gender})")
    public void insert(Person person);
}
