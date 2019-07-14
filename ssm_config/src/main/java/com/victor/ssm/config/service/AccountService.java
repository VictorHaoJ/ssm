package com.victor.ssm.config.service;

import com.victor.ssm.config.mybatis.entity.Account;

/**
 * @author haojiao
 * @desc: TODO
 * @create 2019/7/3
 */
public interface AccountService {

    Account selectByPersonId(Integer personId);

    int updateBalanceById(Account account);
}
