package com.radiantshub.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.radiantshub.entities.IGenericVO;
import com.radiantshub.exceptions.RadiantsHubException;
import com.radiantshub.util.KeyValue;

public class RadiantsRepoImpl<T extends IGenericVO> implements RadiantsRepo<T>{

	private SessionFactory sessionFactory;
	
	public RadiantsRepoImpl(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public SessionFactory getName(){
		return this.sessionFactory;
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
		Session session = null;
		Long id = 0l;
		System.out.println("dao autowired");
		System.out.println(sessionFactory);
		try {
			
			session = sessionFactory.openSession();
			session.getTransaction().begin();
			id = (Long) session.save(t);
			if (!session.getTransaction().wasCommitted()) {
				session.getTransaction().commit();
			}
		} catch (HibernateException he) {
			if (session.getTransaction() != null) {
				session.getTransaction().rollback();
			}
			throw new RadiantsHubException(he.getMessage());
		}

		finally {
			if (session != null) {
				session.close();
			}
		}
		//System.out.println("dao autowied" + (getCurrentSession()==null?"\n\n\n\n\n\n\nnull":"not null\n\n\n\n\n\n"));
		return id;
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
	
}
