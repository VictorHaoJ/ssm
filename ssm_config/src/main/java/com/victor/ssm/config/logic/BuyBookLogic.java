package com.victor.ssm.config.logic;

import com.victor.ssm.config.mybatis.entity.Account;
import com.victor.ssm.config.mybatis.entity.Book;
import com.victor.ssm.config.mybatis.mapper.AccountMapper;
import com.victor.ssm.config.mybatis.mapper.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author haojiao
 * @desc: 买车
 * @create 2019/7/3
 */
@Service
public class BuyBookLogic {

    @Autowired
    AccountMapper accountMapper;
    @Autowired
    BookMapper bookMapper;

    public void buy(Integer bookId, Integer personId, Integer quantity) {

        Book book = bookMapper.selectById(bookId);
        Account account = accountMapper.selectByPersonId(personId);

        if (book.getStock() < quantity) {
            throw new RuntimeException("库存不足");
        }

        book.setStock(book.getStock() - quantity);
        int rows = bookMapper.updateStockById(book);
        System.out.println("rows = " + rows);

        if (account.getBalance() < quantity * book.getUnitPrice() ) {
            throw new RuntimeException("余额不足");
        }

        account.setBalance(account.getBalance() - quantity * book.getUnitPrice());
        rows = accountMapper.updateBalanceById(account);
        System.out.println("rows = " + rows);

    }
}
