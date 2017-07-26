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
			// ��ȡ�����ļ�
			reader = Resources.getResourceAsReader("Configure.xml");
			// ���������ļ�����sessionFactory
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
		// ��session
		SqlSession session = sessionFactory.openSession();
		Users users = (Users) session.selectOne("my.GetUserByID", 1);
		if (users != null) {
			System.out.println("����:" + users.getName() + ",�绰"
					+ users.getPhone());
		}
		return null;
	}

}
