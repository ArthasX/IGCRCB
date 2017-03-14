package com.deliverik.framework.dao.hibernate;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * Base class of all DAO classes.
 * This class is designed to be an interface, implemented by class BaseDAOImpl.
 *
 * @param <T> 
 */
public interface BaseHibernateDAO<T> {

	/**
	 * 
	 *
	 * @param pk 
	 * @return 
	 */
	public T findByPK(Serializable pk);

	/**
	 * 
	 *
	 * @return 
	 */
	public List<T> findAll();

	public T save(T entity);

	/**
	 * 
	 *
	 * @param entity 
	 * @param uid 
	 * @return 
	 */
	public T save(T entity, boolean isLogicalDelete);
	
	public T saveSync(T entity);
	
	public T saveSync(T entity, boolean isLogicalDelete);

	public void saveOrUpdateAll(Collection<T> entities);
	
	public void saveOrUpdateAllSync(Collection<T> entities);
	
	/**
	 * 
	 *
	 * @param entity 
	 * @param uid 
	 */
	public void delete(T entity);

	/**
	 * 
	 *
	 * @param entity 
	 */
	public void notLogicalDelete(T entity);

	/**
	 * 
	 *
	 * @param entityList 
	 * @param uid 
	 */
	public void delete(List<T> entityList);

	/**
	 * 
	 * @param exampleEntity 
	 * @return 
	 */
	public List<T> findByExample(T exampleEntity);

	/**
	 * 
	 * @param exampleEntity 
	 * @return 
	 */
	public int getCountByExample(T exampleEntity);

	/**
	 * 
	 * @param exampleEntity 
	 * @return 
	 */
	public List<T> findByExampleOr(T exampleEntity);

	/**
	 * 
	 * @param exampleEntity 
	 * @return 
	 */
	public int getCountByExampleOr(T exampleEntity);


	/**
	 * 
	 * @return 
	 */
	public T getEntityClassInstance();

	/**
	 * 
	 * @return 
	 */
	public Class<T> getEntityClass();

}
