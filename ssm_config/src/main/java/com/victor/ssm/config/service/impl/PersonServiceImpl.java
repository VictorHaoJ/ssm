package com.victor.ssm.config.service.impl;

import com.victor.ssm.config.mybatis.entity.Account;
import com.victor.ssm.config.mybatis.entity.Book;
import com.victor.ssm.config.mybatis.mapper.BookMapper;
import com.victor.ssm.config.mybatis.mapper.PersonMapper;
import com.victor.ssm.config.service.AccountService;
import com.victor.ssm.config.service.BookService;
import com.victor.ssm.config.service.PersonService;
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
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonMapper personMapper;
    @Autowired
    private BookMapper bookMapper;

    @Autowired
    private BookService bookService;
    @Autowired
    private AccountService accountService;

    /**
     * @Transactional 生效需要配置
     *  1,
     *      <bean id="transactionManager" class="org.springframework.jdbc.datasource.DataSourceTransactionManager" >
     *         <property name="dataSource" ref="dataSource" />
     *      </bean>
     *  2,
     *      <tx:annotation-driven transaction-manager="transactionManager" />
     */
    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void buyBook(Integer personId, Integer bookId, Integer quantity) {

        Account account = accountService.selectByPersonId(personId);

        Book book = bookService.selectById(bookId);

        if (book.getStock() < quantity) {
            throw new RuntimeException("库存不足");
        }

        book.setStock(book.getStock() - quantity);
//        bookService.updateStockById(book);
        this.updateBook(book);

        Long comsumerAmount = quantity * book.getUnitPrice();
        if (account.getBalance() < comsumerAmount) {
            throw new RuntimeException("余额不足");
        }
        account.setBalance(account.getBalance() - comsumerAmount);
        accountService.updateBalanceById(account);

    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void updateBook(Book book) {
        bookMapper.updateStockById(book);
    }
}
