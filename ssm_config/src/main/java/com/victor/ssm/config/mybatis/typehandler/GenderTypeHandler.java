package com.victor.ssm.config.mybatis.typehandler;

import com.victor.ssm.config.enums.GenderEnum;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author haojiao
 * @desc:
 *  注意事项：
 *      1，实体 Person 改为 GenderEnum 类型
 *      2，在 SqlSessionFactory 配置中 添加以下配置
 *          <property name="typeHandlersPackage" value="com.victor.ssm.config.mybatis.typehandler" />
 *      3，在 Mapper.xml 中的gender字段添加
 *           typeHandler="com.victor.ssm.config.mybatis.typehandler.GenderTypeHandler"
 * @create 2019/7/3
 */
public class GenderTypeHandler implements TypeHandler<GenderEnum> {

    @Override
    public void setParameter(PreparedStatement preparedStatement, int i, GenderEnum genderEnum, JdbcType jdbcType) throws SQLException {
        System.out.println("setParameter() i = " + i + ", genderEnum = "+genderEnum);
        preparedStatement.setInt(i, genderEnum.getGender());
    }

    @Override
    public GenderEnum getResult(ResultSet resultSet, String s) throws SQLException {

        GenderEnum genderEnum = GenderEnum.of(resultSet.getInt(s));
        System.out.println("resultSet...====s=" + s + "genderEnum=" + genderEnum);
        return genderEnum;
    }

    @Override
    public GenderEnum getResult(ResultSet resultSet, int i) throws SQLException {
        GenderEnum genderEnum = GenderEnum.of(resultSet.getInt(i));
        System.out.println("resultSet...====i=" + i + "genderEnum=" + genderEnum);
        return genderEnum;
    }

    @Override
    public GenderEnum getResult(CallableStatement callableStatement, int i) throws SQLException {
        GenderEnum genderEnum = GenderEnum.of(callableStatement.getInt(i));
        System.out.println("callableStatement...====i=" + i + "genderEnum=" + genderEnum);
        return genderEnum;
    }
}
