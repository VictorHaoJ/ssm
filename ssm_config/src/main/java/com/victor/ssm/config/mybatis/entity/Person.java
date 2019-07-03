package com.victor.ssm.config.mybatis.entity;

import com.victor.ssm.config.enums.GenderEnum;
import lombok.Data;

/**
 * @author haojiao
 * @create ${Date}
 */
@Data
public class Person {

    private Integer id;

    private String userName;

    private Integer age;

    private GenderEnum gender;

    private String email;

}
