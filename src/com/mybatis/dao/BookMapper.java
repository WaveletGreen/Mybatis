package com.mybatis.dao;

import java.util.List;

import com.mybatis.entity.Book;

public interface BookMapper {
	int deleteByPrimaryKey(Integer bid);

	int insert(Book record);

	int insertSelective(Book record);

	Book selectByPrimaryKey(Integer bid);

	int updateByPrimaryKeySelective(Book record);

	int updateByPrimaryKey(Book record);

	List<Book> queryAll();
}