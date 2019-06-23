package com.victor.ssm;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.victor.ssm.mybatis.mapper")
public class SsmBootApplication {

    public static void main(String[] args) {

        System.out.println("看看有没有乱码");
        SpringApplication.run(SsmBootApplication.class, args);
    }

}
