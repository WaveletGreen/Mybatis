package test;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.mybatis.dao.BookMapper;
import com.mybatis.entity.Book;
import com.mybatis.entity.Category;


public class MybatisTester {

	public static void main(String[] args) {
		String resource = "Configure.xml";
		try {
			Reader reader = Resources.getResourceAsReader(resource);
			SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);
			SqlSession session = factory.openSession();
			BookMapper bookMapper = session.getMapper(BookMapper.class);
			for (Book book : bookMapper.queryAll()) {
				System.out.print("----" + book.getBname() + "-->");
				for (Category category : book.getCategories()) {
					System.out.println(category.getCname());
				}
				System.out.println();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
