package com.victor.ssm.mybatis.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author haojiao
 * @create ${Date}
 */
@Data
public class Person implements Serializable {

    private Integer id;

    private String userName;

    private Integer age;

    private Integer gender;

    private String email;

}
