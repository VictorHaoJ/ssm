package com.victor.ssm.config.mybatis.mapper;

import com.victor.ssm.config.mybatis.entity.Book;

/**
 * @author haojiao
 * @desc: TODO
 * @create 2019/7/3
 */
public interface BookMapper {

    Book selectById(Integer id);

    int updateStockById(Book book);
}
