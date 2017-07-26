package dao.impl;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import util.Page;

import dao.BaseDao;
import entity.Users;

public class BaseDaoImpl<T> implements BaseDao<T> {

	private SqlSessionFactory sessionFactory;
	private Reader reader;

	public BaseDaoImpl() {
		try {
			reader = Resources.getResourceAsReader("Configure.xml");
			sessionFactory = new SqlSessionFactoryBuilder().build(reader);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void setSessionFactory(SqlSessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void setReader(Reader reader) {
		this.reader = reader;
	}

	@Override
	public String add(T t) {
		return null;
	}

	@Override
	public String delet(T t) {
		return null;
	}

	@Override
	public String update(T t) {
		return null;
	}

	@Override
	public T getById(T t, int id) {
		SqlSession session = sessionFactory.openSession();
		Users users = (Users) session.selectOne("my.GetUserByID", id);
		if (users != null) {
			System.out.println("姓名:" + users.getName() + ",电话:"
					+ users.getPhone());
		}
		return null;
	}

	@Override
	public List<T> getByPage(T t, Page page) {
		return null;
	}

	@Override
	public List<T> getAll(T t) {
		return null;
	}

}
