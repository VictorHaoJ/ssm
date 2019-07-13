package com.victor.ssm.config.mybatis.entity;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author haojiao
 * @desc: TODO
 * @create 2019/7/3
 */
@Data
public class Book {

    private Integer id;

    private String bookName;


    private Long unitPrice;

    // 库存
    private Integer stock;

    // 上架时间
    private LocalDateTime upShelfTime;

    private LocalDateTime createTime;

}
