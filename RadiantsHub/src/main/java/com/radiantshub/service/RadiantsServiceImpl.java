package com.radiantshub.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.radiantshub.dao.RadiantsRepoImpl;
import com.radiantshub.entities.IGenericVO;
import com.radiantshub.exceptions.RadiantsHubException;
import com.radiantshub.util.KeyValue;

public class RadiantsServiceImpl<T extends IGenericVO> implements RadiantsService<T>{

	@Autowired
	RadiantsRepoImpl<T> b;
	
	/**
	 * @param name
	 */
	public RadiantsServiceImpl(String name) {
		super();
		this.name = name;
	}

	String name;

	/**
	 * @return the name
	 */
	public String getName() {
		return name+b.getName();
	}

	@Override
	public T getById(Class<? extends T> cls, Serializable id) throws RadiantsHubException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T getByConditions(Class<? extends T> cls, List<KeyValue> conditions) throws RadiantsHubException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<T> getObjectList(Class<? extends T> cls, List<KeyValue> conditions, List<KeyValue> orderByColumnNames,
			Integer startLimit, Integer offset) throws RadiantsHubException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long save(T t) throws RadiantsHubException {
		return b.save(t);
	}

	@Override
	public void save(List<T> objects) throws RadiantsHubException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveOrUpdate(T t) throws RadiantsHubException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public T merge(T t) throws RadiantsHubException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(T t) throws RadiantsHubException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Class<? extends T> cls, Serializable id) throws RadiantsHubException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteListOfObjects(List<T> objects) throws RadiantsHubException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteByConditions(Class<? extends T> cls, List<KeyValue> conditions) throws RadiantsHubException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Object[]> executeTqlQuery(String sQuery, List<KeyValue> conditions) throws RadiantsHubException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> executeTqlQueryForString(String sQuery, List<KeyValue> conditions) throws RadiantsHubException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Object> executeHqlQuery(String sQuery, List<KeyValue> conditions) throws RadiantsHubException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Object> executeHqlQueryDistinctRootEntities(String sQuery, List<KeyValue> conditions)
			throws RadiantsHubException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteByHqlConditions(String hqlQuery, List<KeyValue> conditions) throws RadiantsHubException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object getTingleColumnByTqlQuery(String sQuery, List<KeyValue> conditions) throws RadiantsHubException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateByTqlQuery(String dbQuery, List<KeyValue> conditions1) throws RadiantsHubException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Object> getObjectList(String getBlockedDomainList, List<KeyValue> conditions)
			throws RadiantsHubException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Object[]> getColumnByHqlQuery(String hqlQuery, List<KeyValue> conditions) throws RadiantsHubException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @param name the name to set
	 *//*
	public void setName(String name) {
		this.name = name;
	}*/
	
	
	
	
}
