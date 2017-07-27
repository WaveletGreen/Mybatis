package com.mybatis.dao;

import com.mybatis.entity.Middle;

public interface MiddleMapper {
    int insert(Middle record);

    int insertSelective(Middle record);
}