package com.victor.ssm.typehandler;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author haojiao
 * @desc: TODO
 * @create 2019/7/1
 */
public class AgeTypeHandler implements TypeHandler<Integer> {

    @Override
    public void setParameter(PreparedStatement preparedStatement, int i, Integer age, JdbcType jdbcType) throws SQLException {
        System.out.println("======================preparedStatement...i="+i+",age="+age);
        preparedStatement.setInt(i, age+100);
    }

    @Override
    public Integer getResult(ResultSet resultSet, String s) throws SQLException {
        System.out.println("======================resultSet...s="+s);
        return resultSet.getInt(s) - 100;
    }

    @Override
    public Integer getResult(ResultSet resultSet, int i) throws SQLException {
        System.out.println("======================resultSet...i="+i);
        return resultSet.getInt(i) - 100;
    }

    @Override
    public Integer getResult(CallableStatement callableStatement, int i) throws SQLException {
        System.out.println("======================callableStatement...i="+i);
        return callableStatement.getInt(i) - 100;
    }
}
