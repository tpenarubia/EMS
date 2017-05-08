package com.tog.ems.dao;

import java.util.List;
import java.util.Map;

public interface BaseDao <T>{
	
	T findById(Long id);
	
	List<T> listAllRecord();
	
	List<T> search(Map<String, Object> params, int fetchSize, int page);
	
	int countSearch(Map<String, Object> params, int fetchSize, int page);
	
	void save(T daoObject);
	
	void update(T daoObject);
	
	void delete(T daoObject);
	
	void deleteById(Long id);
}
