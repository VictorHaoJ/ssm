package com.victor.ssm.config.service.impl;

import com.victor.ssm.config.mybatis.entity.Account;
import com.victor.ssm.config.mybatis.mapper.AccountMapper;
import com.victor.ssm.config.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author haojiao
 * @desc: TODO
 * @create 2019/7/13
 */
@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountMapper accountMapper;

    @Override
    public Account selectByPersonId(Integer personId) {
        return accountMapper.selectByPersonId(personId);
    }

    @Transactional
    @Override
    public int updateBalanceById(Account account) {
        return accountMapper.updateBalanceById(account);
    }
}
