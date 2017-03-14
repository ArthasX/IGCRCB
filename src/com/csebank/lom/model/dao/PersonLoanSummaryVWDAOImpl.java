/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */

package com.csebank.lom.model.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.csebank.lom.model.PersonLoanSummary;
import com.csebank.lom.model.condition.PersonLoanSummarySearchCond;
import com.csebank.lom.model.entity.PersonLoanSummaryVW;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;

/**
 * 
 * 预支人员统计DAO实现
 * 
 */
public class PersonLoanSummaryVWDAOImpl extends
		BaseHibernateDAOImpl<PersonLoanSummary> implements
		PersonLoanSummaryVWDAO {

	/**
	 * 构造函数
	 */
	public PersonLoanSummaryVWDAOImpl() {
		super(PersonLoanSummaryVW.class);
	}

	/**
	 * 条件检索处理
	 * 
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	@SuppressWarnings("unchecked")
	public int getSearchCount(final PersonLoanSummarySearchCond cond) {
		HibernateCallback action = new HibernateCallback() {
			public Object doInHibernate(Session session)
			throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				List<PersonLoanSummary> list = null;
				query.append(session.getNamedQuery(
						"PersonLoanSummaryVWDAO.findByCond").getQueryString());
				getSQL(cond, query);
				query.append(" GROUP BY A.LPDUSER,A.lpduserorg ");
				SQLQuery q = session.createSQLQuery(query.toString());
				q.setProperties(cond);
				q.addEntity("PersonLoanSummaryVW", PersonLoanSummaryVW.class);
				setFetchPoint(q, 0, 0);
				list = q.list();
				session.clear();
				session.close();
				return list.size();
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
	@SuppressWarnings("unchecked")
	public List<PersonLoanSummary> findByCond(
			final PersonLoanSummarySearchCond cond, final int start,
			final int count) {
		HibernateCallback action = new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				List<PersonLoanSummary> list = null;
				query.append(session.getNamedQuery(
						"PersonLoanSummaryVWDAO.findByCond").getQueryString());
				getSQL(cond, query);
				query.append(" GROUP BY A.LPDUSER,A.lpduserorg ");
				SQLQuery q = session.createSQLQuery(query.toString());
				q.setProperties(cond);
				q.addEntity("PersonLoanSummaryVW", PersonLoanSummaryVW.class);
				setFetchPoint(q, start, count);
				list = q.list();
				session.clear();
				session.close();
				return list;
			}
		};
		return (List<PersonLoanSummary>) execute(action);
	}
	
	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected void getSQL(PersonLoanSummarySearchCond cond, StringBuffer query){
		//机构层次码
		if( StringUtils.isNotEmpty(cond.getLpduserorg()) ){
			query.append(" AND A.lpduserorg = :lpduserorg");
		}	
		//时间开始
		if( StringUtils.isNotEmpty(cond.getLpddate_from()) ){
			query.append(" AND A.lpddate >=:lpddate_from");
		}	
		//时间结束
		if( StringUtils.isNotEmpty(cond.getLpddate_to()) ){
			query.append(" AND A.lpddate <=:lpddate_to");
		}	
	}
	
}
