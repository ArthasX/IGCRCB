/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.framework.asset.model.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.deliverik.framework.asset.EiDomainDetailCI;
import com.deliverik.framework.asset.EiDomainDetailCIInfo;
import com.deliverik.framework.asset.model.EiDomainDetailMaxVWInfo;
import com.deliverik.framework.asset.model.condition.EiDomainDetailMaxVWSearchCond;
import com.deliverik.framework.asset.model.entity.EiDomainDetailMaxVW;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;

/**
 * 概述: 资产域明细表DAO实现
 * 功能描述: 资产域明细表DAO实现
 * 创建记录: 2011/05/25
 * 修改记录: 
 */
public class EiDomainDetailMaxVWDAOImpl extends
BaseHibernateDAOImpl<EiDomainDetailMaxVWInfo> implements EiDomainDetailMaxVWDAO {
	
	/**
	 * 构造函数
	 */
	public EiDomainDetailMaxVWDAOImpl(){
		super(EiDomainDetailMaxVW.class);
	}
	
	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final EiDomainDetailMaxVWSearchCond cond){
		HibernateCallback action = new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
					if("1".equals(cond.getTypeId())){
					query.append(session.getNamedQuery(
							"EiDomainDefVWDAO.getSearchCount").getQueryString());
					}
					if("2".equals(cond.getTypeId())){
						query.append(session.getNamedQuery("EiDomainDefVWDAO.getSearchCountAll").getQueryString());
					}
				getSQL(cond, query);
				SQLQuery q = session.createSQLQuery(query.toString());
				q.setProperties(cond);
				session.clear();
				session.close();
				return getCount(q.list());
			}
		};
		return (Integer) execute(action);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<EiDomainDetailMaxVWInfo> findByCond(final EiDomainDetailMaxVWSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}
	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	@SuppressWarnings("unchecked")
	public List<EiDomainDetailMaxVWInfo> findBySQL(final EiDomainDetailMaxVWSearchCond cond, final int start, final int count){
		HibernateCallback action = new HibernateCallback(){
			public Object doInHibernate(Session session)throws HibernateException, SQLException {
				session.flush();
				StringBuffer query  = new StringBuffer();
					if("1".equals(cond.getTypeId())){
					query.append(session.getNamedQuery("EiDomainDetailVWDAO.findBySQL").getQueryString());
					}
					if("2".equals(cond.getTypeId())){
						query.append(session.getNamedQuery("EiDomainDetailVWDAO.findBySQLAll").getQueryString());
					}
				getSQL(cond, query);
				SQLQuery q = session.createSQLQuery(query.toString());
				q.addEntity("e",EiDomainDetailMaxVW.class);
				setFetchPoint(q, start, count);
				List<EiDomainDetailMaxVW> list = q.list();
				session.clear();
				session.close();
				return list;
			}		
		};
		return (List<EiDomainDetailMaxVWInfo>)execute(action);
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(EiDomainDetailMaxVWSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		return c;
	}
	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected void getSQL(EiDomainDetailMaxVWSearchCond cond, StringBuffer query){
		if(StringUtils.isNotEmpty(cond.getEiddid())){
			query.append(" AND ei.eiddid ="+Integer.parseInt(cond.getEiddid()));
		}
		if(StringUtils.isNotEmpty(cond.getEiname())){
			query.append(" AND ei.einame ='"+cond.getEiname()+"'");
		}
		query.append(" ) e");
//		if(cond.getEiddversion()!=null){
//			query.append(" AND ei.eiddversion ="+cond.getEiddversion());
//		}
	}

	/**
	 * 根据影响CI查询
	 * @param cond
	 * @param start
	 * @param count
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<EiDomainDetailCIInfo> findBySQLCI(
			final EiDomainDetailMaxVWSearchCond cond, final int start, final int count) {
		HibernateCallback action = new HibernateCallback(){
			public Object doInHibernate(Session session)throws HibernateException, SQLException {
				session.flush();
				StringBuffer query  = new StringBuffer();
					query.append(session.getNamedQuery("EiDomainDefVWDAO.findBySQLHead").getQueryString());
				getSQLCI(cond, query);
				query.append(session.getNamedQuery(
				"EiDomainDefVWDAO.sqlEnd").getQueryString());
				SQLQuery q = session.createSQLQuery(query.toString());
				q.addEntity("e",EiDomainDetailCI.class);
				setFetchPoint(q, start, count);
				List<EiDomainDetailCI> list = q.list();
				session.clear();
				session.close();
				return list;
			}		
		};
		return (List<EiDomainDetailCIInfo>)execute(action);
	}

	
	/**
	 * 根据影响CI查询条数
	 * @param cond
	 * @return
	 */
	public int getSearchCountCI(final EiDomainDetailMaxVWSearchCond cond) {
		HibernateCallback action = new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				query.append(session.getNamedQuery(
							"EiDomainDefVWDAO.getSearchCountHead").getQueryString());
				getSQLCI(cond, query);
				query.append(session.getNamedQuery(
				"EiDomainDefVWDAO.sqlEnd").getQueryString());
				SQLQuery q = session.createSQLQuery(query.toString());
				q.setProperties(cond);
				session.clear();
				session.close();
				return getCount(q.list());
			}
		};
		return (Integer) execute(action);
	}
	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected void getSQLCI(EiDomainDetailMaxVWSearchCond cond, StringBuffer query){
		if(StringUtils.isNotEmpty(cond.getEiid())){
			query.append(" AND p.eiid ="+Integer.parseInt(cond.getEiid())+" ");
		}
		if(StringUtils.isNotEmpty(cond.getEiddid())){
			query.append(" AND p.domainid = "+Integer.parseInt(cond.getEiddid())+" ");
		}
	}


}
