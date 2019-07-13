package com.victor.ssm.config.service.impl;

import com.victor.ssm.config.mybatis.entity.Book;
import com.victor.ssm.config.mybatis.mapper.BookMapper;
import com.victor.ssm.config.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author haojiao
 * @desc: TODO
 * @create 2019/7/13
 */
@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookMapper bookMapper;

    @Override
    public Book selectById(Integer id) {
        return bookMapper.selectById(id);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Override
    public int updateStockById(Book book) {
        return bookMapper.updateStockById(book);
    }
}
