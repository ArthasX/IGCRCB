package com.deliverik.framework.dao.hibernate;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import javax.persistence.Table;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.FastDateFormat;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.CriteriaQuery;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.SimpleExpression;
import org.hibernate.criterion.Example.PropertySelector;
import org.hibernate.transform.ResultTransformer;
import org.hibernate.type.Type;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.framework.base.BasePK;
import com.deliverik.framework.dao.ExclusionException;


/**
 * Implementation of interface BaseDAO. Used as the base class of all DAO classes.
 * It integrates Hibernate by extending org.springframework.orm.hibernate3.support.HibernateDaoSupport class.
 *
 * @param <T> 
 */
@SuppressWarnings({ "unchecked", "rawtypes" })
public class BaseHibernateDAOImpl<T> extends HibernateDaoSupport implements BaseHibernateDAO<T> {

	protected static FastDateFormat dateFormat = FastDateFormat.getInstance("yyyyMMdd");

	protected static FastDateFormat timeFormat = FastDateFormat.getInstance("HHmmssSSS");
	
	protected static Random random = new Random();

	/**  */
	protected Class<T> type;

	/**
	 * 
	 *
	 */
	public BaseHibernateDAOImpl() {
	}

	/**
	 * 
	 *
	 * @param cls 
	 */
	public BaseHibernateDAOImpl(Class cls) {
		this.type = cls;
	}


	/**
	 * 
	 *
	 * @param type 
	 */
	public void setEntityClass(T type) {
		this.type = (Class<T>) type.getClass();
	}


	/**
	 * 
	 *
	 * @param pk 
	 * @return 
	 */
	public T findByPK(Serializable pk) {

		if( pk == null ) return null;

		Serializable pk2;
		if( pk instanceof String || pk instanceof Integer || pk instanceof BasePK ){
			pk2 = pk;
		} else{
			pk2 = ((BaseEntity)getEntityClassInstance()).getPK();
			try {
				PropertyUtils.copyProperties(pk2, pk);
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}

		T entity = (T) getHibernateTemplate().get(type, pk2);

		if( entity == null ) return null;

		return entity;
	}
	
	public void saveOrUpdateAll(Collection entities) {
//		getHibernateTemplate().saveOrUpdateAll(entities);
		Iterator it1 = entities.iterator();
		while(it1.hasNext()) {
			T t1 = (T)it1.next();
			save(t1);
		}
	}
	
	public void saveOrUpdateAllSync(Collection entities) {
		Iterator it2 = entities.iterator();
		while(it2.hasNext()) {
			T t2 = (T)it2.next();
			saveSync(t2);
		}
	}

	public T saveSync(T entity) {
		return save(entity, false);
	}
	
	/**
	 * 
	 *
	 * @param entity 
	 * @param uid 
	 * @return 
	 */
	public T saveSync(T entity,boolean isLogicalDelete) {
		Date nowDateTime = new Date();
//		String date = dateFormat.format(nowDateTime);
		String time = timeFormat.format(nowDateTime);
		Integer i = new Integer(random.nextInt());
		String rd = i.toString();
		
		String fp = time + rd;

		T target = getTarget(entity);
		
		if (isLogicalDelete) {
			((LogicalDelete)target).setDeleteflag("1");
		}
		
		
		if ( target instanceof LogicalDelete ) {
			if( StringUtils.isEmpty(((LogicalDelete)target).getDeleteflag())){
				((LogicalDelete)target).setDeleteflag("0");
			}
		}

		if( target instanceof BaseEntity ){
			// 
			Object check = findByPK(((BaseEntity)target).getPK());

			if( check != null ){
				if( !((BaseEntity)check).getFingerPrint().equals(
						((BaseEntity)target).getFingerPrint()) ){

					// 
					throw new ExclusionException();
				}
			}

			// 
			BaseEntity e = (BaseEntity) target;
			e.setFingerPrint(fp);

		}

		return (T) getHibernateTemplate().merge(target);
	}

	public T save(T entity) {
		return save(entity, false);
	}
	
	/**
	 * 
	 *
	 * @param entity 
	 * @param uid 
	 * @return 
	 */
	public T save(T entity,boolean isLogicalDelete) {

		T target = getTarget(entity);
		
		if (isLogicalDelete) {
			((LogicalDelete)target).setDeleteflag("1");
		}
		
		
		if ( target instanceof LogicalDelete ) {
			if( StringUtils.isEmpty(((LogicalDelete)target).getDeleteflag())){
				((LogicalDelete)target).setDeleteflag("0");
			}
		}

		return (T) getHibernateTemplate().merge(target);
	}

	/**
	 * 
	 *
	 * @param entity 
	 * @param uid 
	 */
	public void delete(T entity) {
		T target = getTarget(entity);

		if ( target instanceof LogicalDelete ) {
			save(target, true);
		} else {
			Object o = getHibernateTemplate().merge(target);
			getHibernateTemplate().delete(o);
		}
	}

	/**
	 * 
	 *
	 * @param entity 
	 */
	public void notLogicalDelete(T entity) {
		T target = getTarget(entity);
		Object o = getHibernateTemplate().merge(target);
		getHibernateTemplate().delete(o);
		getHibernateTemplate().flush();
	}

	/**
	 * 
	 *
	 * @param entityList 
	 * @param uid 
	 */
	public void delete(List<T> entityList){

		for(T entity: entityList)
			delete(entity);
	}


	/**
	 * 
	 * @param exampleEntity 
	 * @return 
	 */
	public List<T> findByExample(T exampleEntity)  {
		T target = getTarget(exampleEntity);

		return getHibernateTemplate().findByExample(target);
	}

	/**
	 * 
	 * @param exampleEntity 
	 * @return 
	 */
	public int getCountByExample(T exampleEntity) {
		T target = getTarget(exampleEntity);

		DetachedCriteria c = getDetachedCriteria();
		c.add(Example.create(target));
		c.setProjection( Projections.rowCount() );

		return ((Number)findByCriteria(c).get(0)).intValue();

	}

	/**
	 * 
	 * @param exampleEntity 
	 * @return 
	 */
	public List<T> findByExampleOr(T exampleEntity)  {
		T target = getTarget(exampleEntity);

		DetachedCriteria c = getDetachedCriteria();
		c.add(ExampleOr.create(target));
		return findByCriteria(c);
	}


	/**
	 * 
	 * @param exampleEntity 
	 * @return 
	 */
	public int getCountByExampleOr(T exampleEntity) {
		T target = getTarget(exampleEntity);

		DetachedCriteria c = getDetachedCriteria();
		c.add(ExampleOr.create(target));
		c.setProjection( Projections.rowCount() );

		return ((Number)findByCriteria(c).get(0)).intValue();

	}


	/**
	 * 
	 *
	 * @return 
	 */
	public List<T> findAll() {
		return (List<T>) getHibernateTemplate().loadAll(type);
	}

	/**
	 * 
	 * @param name 
	 * @return nextval
	 */
	protected int getSequenceNextValue(final String name){

		HibernateCallback action = new HibernateCallback(){

			public Object doInHibernate(Session session) throws HibernateException, SQLException {

				Query query = session.createSQLQuery("select " + name + ".nextval from sysibm.sysdummy1" );
				return ((Number) query.list().get(0)).intValue();

			}
		};

		return (Integer)execute(action);

	}

	/**
	 * 
	 * @param name 
	 */
	protected void lockTable(final String name){

		HibernateCallback action = new HibernateCallback(){

			public Object doInHibernate(Session session) throws HibernateException, SQLException {

				Query query = session.createSQLQuery("Lock Table " + name + " IN EXCLUSIVE MODE" );
				query.executeUpdate();

				return null;

			}
		};

		execute(action);

	}

	/**
	 * 
	 * @param entityData 
	 * @param otherKeyName 
	 * @param seqName 
	 * @return 
	 */
	protected Integer getNextDetailNo(Object entityData,String otherKeyName, String seqName ){

		// 
		String query = String.format(
						"select max(a.%s) + 1 " +
						"  from %s as a " +
						" where a.%s = ?", seqName, getEntityClass().getName(), otherKeyName );
		Object otherKeyValue;
		try {
			otherKeyValue = PropertyUtils.getProperty(entityData, otherKeyName);

		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		// 
		Table t = getEntityClass().getAnnotation(Table.class);
		lockTable(t.name());


		Number ret = (Number) getHibernateTemplate().find(query , otherKeyValue).get(0);
		if( ret== null ) ret = 1;

		return ret.intValue();

	}

	/**
	 * 
	 * @param c Criteria
	 * @return 
	 */
	protected int getCount(DetachedCriteria c){
		c.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		c.setProjection( Projections.rowCount() );
		return getCount(getHibernateTemplate().findByCriteria(c));
	}

	/**
	 * 
	 * @param result 
	 * @return 
	 */
	protected int getCount(List result){

		if(result.size()>0){
			return ((Number)result.get(0)).intValue();
		}else{
			return 0;
		}
	}

	/**
	 * 
	 * @return 
	 */
	public T getEntityClassInstance() {
		try {
			return type.newInstance();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 
	 * @return 
	 */
	public Class<T> getEntityClass() {
		return type;
	}

	/**
	 * 
	 * @param entity 
	 * @return 
	 */
	protected T getTarget(T entity){
		if( entity.getClass() == type )
			return entity;

		try {
			T target = getEntityClassInstance();
			PropertyUtils.copyProperties(target, entity);
			return target;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}

	/**
	 * HibernateCallback
	 * @param action HibernateCallback
	 * @return HibernateCallback
	 */
	protected Object execute(HibernateCallback action){
    	return getHibernateTemplate().execute(action);
    }


	/**
	 * DetachedCriteria
	 * @return DetachedCriteria
	 */
	protected DetachedCriteria getDetachedCriteria(){
		return DetachedCriteria.forClass(type);
	}

	/**
	 * 
	 * @param q 
	 * @param start 
	 * @param count 
	 */
	protected void setFetchPoint(Query q, int start, int count){
		if (start >= 0) {
			q.setFirstResult(start);
		}
		if (count > 0) {
			q.setMaxResults(count);
		}
	}

	/**
	 * DetachedCriteria
	 * @param c DetachedCriteria
	 * @return DetachedCriteria
	 */
	public List<T> findByCriteria(DetachedCriteria c) {
		c.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		return getHibernateTemplate().findByCriteria(c);
	}

	/**
	 * DetachedCriteria
	 * @param c DetachedCriteria
	 * @param start 
	 * @param count 
	 * @return DetachedCriteria
	 */
	public List<T> findByCriteria(DetachedCriteria c, int start, int count) {
		c.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		return getHibernateTemplate().findByCriteria(c, start, count);
	}

	/**
	 * 
	 * @param sql 
	 * @param paramMap 
	 * @return 
	 */
	protected List findByNamedParamMap(String sql, NamedParamMap paramMap){
		String[] names = paramMap.param.keySet().toArray(new String[paramMap.param.keySet().size()]);
		Object[] values = paramMap.param.values().toArray();

		return getHibernateTemplate().findByNamedParam(sql,names,values);
	}

	/**
	 * 
	 * @param sql 
	 * @param paramMap 
	 * @return 
	 */
	protected List findByNamedQuery(String queryName, NamedParamMap paramMap){
		String[] names = paramMap.param.keySet().toArray(new String[paramMap.param.keySet().size()]);
		Object[] values = paramMap.param.values().toArray();

		return getHibernateTemplate().findByNamedQueryAndNamedParam(queryName,names,values);
	}

	/**
	 * 
	 * @return 
	 */
	protected NamedParamMap getNamedParamMap(){
		return new NamedParamMap();
	}

	/**
	 * 
	 */
	public class NamedParamMap {
		/**  */
		HashMap<String, Object> param = new HashMap<String, Object>();

		/**
		 * 
		 * @param name 
		 * @param value 
		 */
		public void setString(String name,String value){
			param.put(name, value);
		}

		/**
		 * 
		 * @param name 
		 * @param value 
		 */
		public void setInteger(String name,Integer value){
			param.put(name, value);
		}

	}

	/**
	 * NativeSQL ResultTransformer
	 */
	@SuppressWarnings("serial")
	protected class BeanTransformer implements ResultTransformer {

        private String alias;

        BeanTransformer(String alias) {
            this.alias = alias;
        }

        /**
         * @see org.hibernate.transform.ResultTransformer#transformList(java.util.List)
         */
		public List transformList(List collection) {
            return collection;
        }

        /**
         * @see org.hibernate.transform.ResultTransformer#transformTuple(java.lang.Object[], java.lang.String[])
         */
        public Object transformTuple(Object[] tuple, String[] aliases) {
            for (int i = 0; i < aliases.length; i++) {
                if (alias.equals(aliases[i])) {
                    return tuple[i];
                }
            }
            return null;
        }

	}
}

/**
 * Query by Example
 */
@SuppressWarnings("serial")
class ExampleOr extends Example {

	public ExampleOr(Object entity) {
		super(entity,new PropertySelectorOr());
	}

	public static ExampleOr create(Object entity) {
		if (entity==null) throw new NullPointerException("null example");
		return new ExampleOr(entity);
	}

	/**
	 * 
	 * @see Example#appendPropertyCondition
	 */
	@Override
	protected void appendPropertyCondition(String propertyName, Object propertyValue,
			Criteria criteria, CriteriaQuery cq, StringBuffer buf) throws HibernateException {
		if (propertyValue != null) {
			Criterion crit = new SimpleOrExpression(propertyName, propertyValue, "=");
			String critCondition = crit.toSqlString(criteria, cq);
			if (buf.length() > 1 && critCondition.trim().length() > 0)
				buf.append(" or ");
			buf.append(critCondition);
		}
	}

	protected class SimpleOrExpression extends SimpleExpression {
		protected SimpleOrExpression(String propertyName, Object value, String op) {
			super(propertyName, value, op);
		}

	}

}
@SuppressWarnings("serial")
class PropertySelectorOr implements PropertySelector{
	public boolean include(Object object, String propertyName, Type type) {
		return object!=null;
	}
}

