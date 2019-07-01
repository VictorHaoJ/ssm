package com.victor.ssm;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.victor.ssm.mybatis.mapper")
public class SsmBootApplication {

    public static void main(String[] args) {

        SpringApplication.run(SsmBootApplication.class, args);
    }

}
