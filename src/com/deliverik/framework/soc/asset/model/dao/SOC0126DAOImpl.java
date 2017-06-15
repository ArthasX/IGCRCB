/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.framework.soc.asset.model.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.framework.soc.asset.SOC0136;
import com.deliverik.framework.soc.asset.SOC0136Info;
import com.deliverik.framework.soc.asset.SOC0138;
import com.deliverik.framework.soc.asset.SOC0138Info;
import com.deliverik.framework.soc.asset.model.SOC0126Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0126SearchCond;
import com.deliverik.framework.soc.asset.model.entity.SOC0126VW;

/**
 * 概述: 资产域明细表DAO实现
 * 功能描述: 资产域明细表DAO实现
 * 创建记录: 2011/05/25
 * 修改记录: 
 */
public class SOC0126DAOImpl extends
BaseHibernateDAOImpl<SOC0126Info> implements SOC0126DAO {
	
	private Integer eiid;
	
	
	
	public Integer getEiid() {
		return eiid;
	}



	public void setEiid(Integer eiid) {
		this.eiid = eiid;
	}



	/**
	 * 构造函数
	 */
	public SOC0126DAOImpl(){
		super(SOC0126VW.class);
	}
	
	
	
	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final SOC0126SearchCond cond){
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
	public List<SOC0126Info> findByCond(final SOC0126SearchCond cond, final int start, final int count){
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
	public List<SOC0138Info> findBySQL(final SOC0126SearchCond cond, final int start, final int count){
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
				q.addEntity("e",SOC0138.class);
				setFetchPoint(q, start, count);
				List<SOC0138Info> list = q.list();
				return list;
			}		
		};
		return (List<SOC0138Info>)execute(action);
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
	public List<SOC0126Info> findAllBySQL(final SOC0126SearchCond cond, final int start, final int count){
		HibernateCallback action = new HibernateCallback(){
			public Object doInHibernate(Session session)throws HibernateException, SQLException {
				session.flush();
				StringBuffer query  = new StringBuffer();
				query.append(session.getNamedQuery("EiDomainDetailVWDAO.findAllBySQLAll").getQueryString());
				getAllSQL(cond, query);
				SQLQuery q = session.createSQLQuery(query.toString());
				q.addEntity("e",SOC0126VW.class);
				setFetchPoint(q, start, count);
				List<SOC0126VW> list = q.list();
				return list;
			}		
		};
		return (List<SOC0126Info>)execute(action);
	}
	
	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(SOC0126SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		return c;
	}
	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected void getSQL(SOC0126SearchCond cond, StringBuffer query){
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
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected void getAllSQL(SOC0126SearchCond cond, StringBuffer query){
		if(StringUtils.isNotEmpty(cond.getEiname())){
			query.append(" AND einame ='"+cond.getEiname()+"'");
		}

	}

	
	/**
	 * 根据影响CI查询
	 * @param cond
	 * @param start
	 * @param count
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<SOC0136Info> findBySQLCI(
			final SOC0126SearchCond cond, final int start, final int count,Integer eiid) {
		setEiid(eiid);
		HibernateCallback action = new HibernateCallback(){
			public Object doInHibernate(Session session)throws HibernateException, SQLException {
				session.flush();
				StringBuffer query  = new StringBuffer();
					query.append(session.getNamedQuery("EiDomainDefVWDAO.findBySQLHead").getQueryString());
				getSQLCI(cond, query);
				query.append(session.getNamedQuery(
				"EiDomainDefVWDAO.sqlEnd").getQueryString());
				SQLQuery q = session.createSQLQuery(query.toString());
				q.addEntity("e",SOC0136.class);
				setFetchPoint(q, start, count);
				List<SOC0136> list = q.list();
				return list;
			}		
		};
		return (List<SOC0136Info>)execute(action);
	}

	
	/**
	 * 根据影响CI查询条数
	 * @param cond
	 * @return
	 */
	public int getSearchCountCI(final SOC0126SearchCond cond,Integer eiid) {
		setEiid(eiid);
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
	protected void getSQLCI(SOC0126SearchCond cond, StringBuffer query){
		
		if(getEiid()!=null && getEiid()>0){
			query.append(" AND p.eiid ="+getEiid()+" ");
		}else if(StringUtils.isNotEmpty(cond.getEiid())){
			query.append(" AND p.eiid ="+Integer.parseInt(cond.getEiid())+" ");
		}
		if(StringUtils.isNotEmpty(cond.getEiddid())){
			query.append(" AND p.domainid = "+Integer.parseInt(cond.getEiddid())+" ");
		}
		
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected void getSQLCIByDisk(SOC0126SearchCond cond, StringBuffer query){
		
		if(getEiid()!=null && getEiid()>0){
			query.append(" AND sr.srcldeiid ="+getEiid()+" ");
		}else if(StringUtils.isNotEmpty(cond.getEiid())){
			query.append(" AND sr.srcldeiid ="+Integer.parseInt(cond.getEiid())+" ");
		}
		if(StringUtils.isNotEmpty(cond.getEiddversion())){
			query.append(" AND sr.srdomainversion = "+Integer.parseInt(cond.getEiddversion())+" ");
		}
		
	}


	/**
	 * 根据硬盘检索主机条数
	 * @param eiDomainDetailVWSearchCond
	 * @param eiid
	 * @return
	 */
	public int getSearchCountCIByDisk(final SOC0126SearchCond cond,
			Integer eiid) {
		setEiid(eiid);
		HibernateCallback action = new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				query.append(session.getNamedQuery(
							"EiDomainDefVWDAO.getSearchCountHeadByDisk").getQueryString());
				
				getSQLCIByDisk(cond, query);
				query.append(")");
				SQLQuery q = session.createSQLQuery(query.toString());
				q.setProperties(cond);
				session.clear();
				return getCount(q.list());
			}
		};
		return (Integer) execute(action);
	}



	/**
	 * 根据硬盘检索主机信息
	 * @param eiDomainDetailVWSearchCond
	 * @param fromCount
	 * @param pageDispCount
	 * @param eiid
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<SOC0136Info> searchEiDomainDetailVWCIByDisk(
			final SOC0126SearchCond cond, final int start, final int count,
			Integer eiid) {
		setEiid(eiid);
		HibernateCallback action = new HibernateCallback(){
			public Object doInHibernate(Session session)throws HibernateException, SQLException {
				session.flush();
				StringBuffer query  = new StringBuffer();
					query.append(session.getNamedQuery("EiDomainDefVWDAO.findBySQLHeadByDisk").getQueryString());
				getSQLCIByDisk(cond, query);
				query.append(")");
				SQLQuery q = session.createSQLQuery(query.toString());
				q.addEntity("e",SOC0136.class);
				setFetchPoint(q, start, count);
				List<SOC0136> list = q.list();
				return list;
			}		
		};
		return (List<SOC0136Info>)execute(action);
	}




}
