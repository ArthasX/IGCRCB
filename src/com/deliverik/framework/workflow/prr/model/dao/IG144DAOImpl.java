/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.framework.workflow.prr.model.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.framework.workflow.prr.model.IG500Info;
import com.deliverik.framework.workflow.prr.model.condition.IG019SearchCond;
import com.deliverik.framework.workflow.prr.model.entity.IG500TB;

/**
 * <p>概述:事件和服务请求流程汇总视图DAO实现</p>
 * <p>功能描述：1.事件条件检索处理</p>
 * <p>         2.服务请求条件检索处理</p>
 * <p>          3.事件条件检索处理</p>
 * <p>          4.服务请求条件检索处理</p>
 * <p>          5.服务请求检索条件生成</p>
 * <p>          6.事件检索条件生成</p>
 * <p>创建记录：</p>
 */
public class IG144DAOImpl extends
		BaseHibernateDAOImpl<IG500Info> implements
		IG144DAO {

	/**
	 * 事件和服务请求流程汇总视图构造函数
	 * 
	 */
	public IG144DAOImpl() {
		super(IG500TB.class);
	}
	/**
	 * 功能：事件条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	@SuppressWarnings("unchecked")
	public int getIncidentSearchCount(final IG019SearchCond cond){
		HibernateCallback action = new HibernateCallback() {
			
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				query
				.append(session
						.getNamedQuery(
								"IncidentServiceRequestListVWDAO.incidentListQuery")
								.getQueryString());
				getIncidentSQL(cond, query);
				query
				.append(" ORDER BY prclosetime DESC,propentime ASC");
				SQLQuery q = session.createSQLQuery(query.toString());
				q.setProperties(cond);
				q.addEntity("prcount",IG500TB.class);
				setFetchPoint(q, 0, 0);
				List<IG500Info> list = q.list();
				session.clear();
				return list.size();
			}
		};
		return (Integer) execute(action);
	}
	/**
	 * 功能：服务请求条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	@SuppressWarnings("unchecked")
	public int getServiceRequestSearchCount(final IG019SearchCond cond){
		HibernateCallback action = new HibernateCallback() {
			
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				query
						.append(session
								.getNamedQuery(
										"IncidentServiceRequestListVWDAO.serviceRequestListQuery")
								.getQueryString());
				getServiceRequestSQL(cond, query);
				query
						.append(" ORDER BY prclosetime DESC,propentime ASC");
				SQLQuery q = session.createSQLQuery(query.toString());
				q.setProperties(cond);
				q.addEntity("prcount",IG500TB.class);
				setFetchPoint(q, 0, 0);
				List<IG500Info> list = q.list();
				session.clear();
				return list.size();
			}
		};
		return (Integer) execute(action);
	}

	/**
	 * 功能：事件条件检索处理
	 * 
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	@SuppressWarnings("unchecked")
	public List<IG500Info> findIncidentByCond(
			final IG019SearchCond cond, final int start,
			final int count) {
		HibernateCallback action = new HibernateCallback() {
			
			public Object doInHibernate(Session session)
			throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				query
				.append(session
						.getNamedQuery(
								"IncidentServiceRequestListVWDAO.incidentListQuery")
								.getQueryString());
				getIncidentSQL(cond, query);
				query
				.append(" ORDER BY prclosetime DESC,propentime ASC");
				SQLQuery q = session.createSQLQuery(query.toString());
				q.setProperties(cond);
				q.addEntity("prcount", IG500TB.class);
				setFetchPoint(q, start, count);
				List<IG500Info> list = q.list();
				session.clear();
				return list;
			}
		};
		return (List<IG500Info>) execute(action);
	}
	
	/**
	 * 功能：服务请求条件检索处理
	 * 
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	@SuppressWarnings("unchecked")
	public List<IG500Info> findServiceRequestByCond(
			final IG019SearchCond cond, final int start,
			final int count) {
		HibernateCallback action = new HibernateCallback() {

			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				query
						.append(session
								.getNamedQuery(
										"IncidentServiceRequestListVWDAO.serviceRequestListQuery")
								.getQueryString());
				getServiceRequestSQL(cond, query);
				query
						.append(" AND PRSTATUS <>'D' "+ " ORDER BY prclosetime DESC,propentime ASC");
				SQLQuery q = session.createSQLQuery(query.toString());
				q.setProperties(cond);
				q.addEntity("prcount", IG500TB.class);
				setFetchPoint(q, start, count);
				List<IG500Info> list = q.list();
				session.clear();
				return list;
			}
		};
		return (List<IG500Info>) execute(action);
	}

	/**
	 * 功能：服务请求检索条件生成
	 * 
	 * @param cond 检索条件
	 * @param query sql
	 */
	protected void getServiceRequestSQL(
			IG019SearchCond cond, StringBuffer query) {
		// 机构层次码
		if (StringUtils.isNotEmpty(cond.getOrgsyscoding())) {
			query.append(" AND prorgid like :orgsyscoding");
		}
		// 年度
		if (StringUtils.isNotEmpty(cond.getYear())) {
			query.append(" AND substr(propentime,1,4) =:year");
		}
		// 类型
		if (StringUtils.isNotEmpty(cond.getPrtype())) {
			query.append(" AND prtype = :prtype");
		}
		//流程类型id
        if(StringUtils.isNotEmpty(cond.getSpdid())){
            query.append(" AND prpdid like ('%'||:spdid||'%')");
        }
	}

	/**
	 * 功能：事件检索条件生成
	 * 
	 * @param cond 检索条件
	 * @param query
	 */
	protected void getIncidentSQL(IG019SearchCond cond,
			StringBuffer query) {
		// 机构层次码
		if (StringUtils.isNotEmpty(cond.getOrgsyscoding())) {
			query.append(" AND c.orgsyscoding like :orgsyscoding");
		}
		// 年度
		if (StringUtils.isNotEmpty(cond.getYear())) {
			query.append(" AND substr(prplantime,1,4) =:year");
		}
		// 类型
		if (StringUtils.isNotEmpty(cond.getPrtype())) {
			query.append(" AND prtype = :prtype");
		}
		// 类型
		if (StringUtils.isNotEmpty(cond.getPrtype())) {
		    query.append(" AND prtype = :prtype");
		}
	}
}
