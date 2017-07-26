package test;

import dao.BaseDao;
import dao.impl.BaseDaoImpl;

public class MybatisTester {

	public static void main(String[] args) {
		BaseDao dao = new BaseDaoImpl();
		dao.getById("Users");
	}

}
