package dao;

public interface BaseDao<T> {
	public <T> T getById(T t);
}
