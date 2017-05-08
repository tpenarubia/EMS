package com.tog.ems.dao.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.lang.reflect.ParameterizedType;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;


import com.tog.ems.dao.BaseDao;

public class BaseDaoImpl<T extends Serializable> implements BaseDao<T>{

	@Autowired
	SessionFactory sessionFactory;
	
	private Class<T> type;
	
	@SuppressWarnings("unchecked")
	public BaseDaoImpl(){
		this.type = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}
	@Override
	public T findById(Long id) {
		return (T) getCurrentSession().get(type, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> listAllRecord() {
		return getCurrentSession().createCriteria(type).list();
	}

	@Override
	public List<T> search(Map<String, Object> params, int fetchSize, int page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int countSearch(Map<String, Object> params, int fetchSize, int page) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void save(T entity) {
		getCurrentSession().save(entity);
	}

	@Override
	public void update(T entity) {
		getCurrentSession().update(entity);
	}

	@Override
	public void delete(T entity) {
		getCurrentSession().delete(entity);
		
	}

	@Override
	public void deleteById(Long id) {
		T entity = findById(id);
		delete(entity);
	}
	
	protected final Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

}
