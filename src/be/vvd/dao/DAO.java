package be.vvd.dao;

import java.sql.Connection;

public interface DAO<T> {
	
	public boolean create(T obj);
	
	public boolean delete(T obj);
	
	public boolean update(T obj);
	
	public T find(int id);
}