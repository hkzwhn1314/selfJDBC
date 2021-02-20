package com.lagou.sqlSession;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;

public interface SqlSession {
    // 查询所有
    public <E> List<E> selectList(String statementId, Object... params) throws SQLException, ClassNotFoundException, InvocationTargetException, IntrospectionException, InstantiationException, IllegalAccessException, NoSuchFieldException, Exception;

    //根据条件查询单个
    public <T> T selectOne(String statementId, Object... params) throws Exception;
}
