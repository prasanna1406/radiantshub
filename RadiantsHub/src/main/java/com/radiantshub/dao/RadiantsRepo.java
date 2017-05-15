package com.radiantshub.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.SessionFactory;

import com.radiantshub.entities.IGenericVO;
import com.radiantshub.exceptions.RadiantsHubException;
import com.radiantshub.util.KeyValue;

// TODO: Auto-generated Javadoc
/**
 * The Interface BInterface.
 *
 * @param <T> the generic type
 */
public interface RadiantsRepo<T extends IGenericVO> {

	/**
	 * Gets the by id.
	 *
	 * @param cls the cls
	 * @param id the id
	 * @return the by id
	 * @throws RadiantsHubException the radiants hub exception
	 */
	public T getById(Class<? extends T> cls, Serializable id) throws RadiantsHubException;


	/**
	 * Gets the by conditions.
	 *
	 * @param cls the cls
	 * @param conditions the conditions
	 * @return the by conditions
	 * @throws RadiantsHubException the radiants hub exception
	 */
	public T getByConditions(Class<? extends T> cls, List<KeyValue> conditions) throws RadiantsHubException;


	/**
	 * Gets the object list.
	 *
	 * @param cls the cls
	 * @param conditions the conditions
	 * @param orderByColumnNames the order by column names
	 * @param startLimit the start limit
	 * @param offset the offset
	 * @return the object list
	 * @throws RadiantsHubException the radiants hub exception
	 */
	public List<T> getObjectList(Class<? extends T> cls,List<KeyValue> conditions,List<KeyValue> orderByColumnNames,Integer startLimit,Integer offset) throws RadiantsHubException;


	/**
	 * Save.
	 *
	 * @param t the t
	 * @return the long
	 * @throws RadiantsHubException the radiants hub exception
	 */
	public Long save(T t) throws RadiantsHubException;


	/**
	 * Save.
	 *
	 * @param objects the objects
	 * @throws RadiantsHubException the radiants hub exception
	 */
	public void save(List<T> objects) throws RadiantsHubException;


	/**
	 * Save or update.
	 *
	 * @param t the t
	 * @throws RadiantsHubException the radiants hub exception
	 */
	public void saveOrUpdate(T t) throws RadiantsHubException;


	/**
	 * Merge.
	 *
	 * @param t the t
	 * @return the t
	 * @throws RadiantsHubException the radiants hub exception
	 */
	public T merge(T t) throws RadiantsHubException;


	/**
	 * Delete.
	 *
	 * @param t the t
	 * @throws RadiantsHubException the radiants hub exception
	 */
	public void delete(T t) throws RadiantsHubException;


	/**
	 * Delete by id.
	 *
	 * @param cls the cls
	 * @param id the id
	 * @throws RadiantsHubException the radiants hub exception
	 */
	public void deleteById(Class<? extends T> cls, Serializable id) throws RadiantsHubException;


	/**
	 * Delete list of objects.
	 *
	 * @param objects the objects
	 * @throws RadiantsHubException the radiants hub exception
	 */
	public void deleteListOfObjects(List<T> objects) throws RadiantsHubException;


	/**
	 * Delete by conditions.
	 *
	 * @param cls the cls
	 * @param conditions the conditions
	 * @throws RadiantsHubException the radiants hub exception
	 */
	public void deleteByConditions(Class<? extends T> cls, List<KeyValue> conditions) throws RadiantsHubException;


	/**
	 * Execute tql query.
	 *
	 * @param sQuery the s query
	 * @param conditions the conditions
	 * @return the list
	 * @throws RadiantsHubException the radiants hub exception
	 */
	public List<Object[]> executeTqlQuery(String sQuery, List<KeyValue> conditions) throws RadiantsHubException;


	/**
	 * Execute tql query for string.
	 *
	 * @param sQuery the s query
	 * @param conditions the conditions
	 * @return the list
	 * @throws RadiantsHubException the radiants hub exception
	 */
	public List<String> executeTqlQueryForString(String sQuery, List<KeyValue> conditions) throws RadiantsHubException;


	/**
	 * Execute hql query.
	 *
	 * @param sQuery the s query
	 * @param conditions the conditions
	 * @return the list
	 * @throws RadiantsHubException the radiants hub exception
	 */
	public List<Object> executeHqlQuery(String sQuery, List<KeyValue> conditions) throws RadiantsHubException;


	/**
	 * Execute hql query distinct root entities.
	 *
	 * @param sQuery the s query
	 * @param conditions the conditions
	 * @return the list
	 * @throws RadiantsHubException the radiants hub exception
	 */
	public List<Object> executeHqlQueryDistinctRootEntities(String sQuery, List<KeyValue> conditions)
			throws RadiantsHubException;


	/**
	 * Delete by hql conditions.
	 *
	 * @param hqlQuery the hql query
	 * @param conditions the conditions
	 * @return the int
	 * @throws RadiantsHubException the radiants hub exception
	 */
	public int deleteByHqlConditions(String hqlQuery, List<KeyValue> conditions)throws RadiantsHubException;



	/**
	 * Gets the tingle column by tql query.
	 *
	 * @param sQuery the s query
	 * @param conditions the conditions
	 * @return the tingle column by tql query
	 * @throws RadiantsHubException the radiants hub exception
	 */
	public Object getTingleColumnByTqlQuery(String sQuery, List<KeyValue> conditions)throws RadiantsHubException;


	/**
	 * Update by tql query.
	 *
	 * @param dbQuery the db query
	 * @param conditions1 the conditions 1
	 * @return the int
	 * @throws RadiantsHubException the radiants hub exception
	 */
	public int updateByTqlQuery(String dbQuery, List<KeyValue> conditions1) throws RadiantsHubException;


	/**
	 * Gets the object list.
	 *
	 * @param getBlockedDomainList the get blocked domain list
	 * @param conditions the conditions
	 * @return the object list
	 * @throws RadiantsHubException the radiants hub exception
	 */
	public List<Object> getObjectList(String getBlockedDomainList, List<KeyValue> conditions) throws RadiantsHubException;

	/**
	 * Gets the column by hql query.
	 *
	 * @param hqlQuery the hql query
	 * @param conditions the conditions
	 * @return the column by hql query
	 * @throws RadiantsHubException the radiants hub exception
	 */
	public List<Object[]> getColumnByHqlQuery(String hqlQuery, List<KeyValue> conditions) throws RadiantsHubException;


	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public SessionFactory getName();
}
