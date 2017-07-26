package dao.impl;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import dao.BaseDao;
import entity.Users;

public class BaseDaoImpl<T> implements BaseDao<T> {

	private SqlSessionFactory sessionFactory;
	private Reader reader;

	public BaseDaoImpl() {
		try {
			// 获取配置文件
			reader = Resources.getResourceAsReader("Configure.xml");
			// 根据配置文件构建sessionFactory
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

	@SuppressWarnings("hiding")
	@Override
	public <T> T getById(T t) {
		// 打开session
		SqlSession session = sessionFactory.openSession();
		Users users = (Users) session.selectOne("my.GetUserByID", 1);
		if (users != null) {
			System.out.println("姓名:" + users.getName() + ",电话"
					+ users.getPhone());
		}
		return null;
	}

}
