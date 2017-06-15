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

import com.csebank.lom.model.PersonLoanDetail;
import com.csebank.lom.model.condition.PersonLoanDetailSearchCond;
import com.csebank.lom.model.entity.PersonLoanDetailVW;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;

/**
 * 
 * 人员借款统计DAO实现
 * 
 */
public class PersonLoanDetailVWDAOImpl extends
		BaseHibernateDAOImpl<PersonLoanDetail> implements
		PersonLoanDetailVWDAO {

	/**
	 * 构造函数
	 */
	public PersonLoanDetailVWDAOImpl() {
		super(PersonLoanDetailVW.class);
	}
	
	/**
	 * 条件检索处理
	 * 
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	@SuppressWarnings("unchecked")
	public int getSearchCount(final PersonLoanDetailSearchCond cond) {
		HibernateCallback action = new HibernateCallback() {
			public Object doInHibernate(Session session)
			throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				List<PersonLoanDetail> list = null;
				query.append(session.getNamedQuery(
				"PersonLoanDetailVWDAO.findByCond1").getQueryString());
				if(StringUtils.isNotEmpty(cond.getGoreqorg())){
					query.append(" AND A.LPDUSERORG = "+cond.getGoreqorg());
				}
				getSQL1(cond, query);
				query.append(" UNION ALL ");
				query.append(session.getNamedQuery(
				"PersonLoanDetailVWDAO.findByCond2").getQueryString());
				if(StringUtils.isNotEmpty(cond.getGoreqorg())){
					query.append(" AND A.LPDUSERORG = "+cond.getGoreqorg());
				}
				getSQL2(cond, query);
				SQLQuery q = session.createSQLQuery(query.toString());
				q.setProperties(cond);
				q.addEntity("PersonLoanDetailVW", PersonLoanDetailVW.class);
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
	public List<PersonLoanDetail> findByCond(
			final PersonLoanDetailSearchCond cond, final int start,
			final int count) {
		HibernateCallback action = new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				List<PersonLoanDetail> list = null;
				query.append("SELECT PersonLoanDetailVW.* FROM (");
				query.append(session.getNamedQuery(
				"PersonLoanDetailVWDAO.findByCond1").getQueryString());
				if(StringUtils.isNotEmpty(cond.getGoreqorg())){
					query.append(" AND A.LPDUSERORG = "+cond.getGoreqorg());
				}
				getSQL1(cond, query);
				query.append(" UNION ALL ");
				query.append(session.getNamedQuery(
				"PersonLoanDetailVWDAO.findByCond2").getQueryString());
				if(StringUtils.isNotEmpty(cond.getGoreqorg())){
					query.append(" AND A.LPDUSERORG = "+cond.getGoreqorg());
				}
				getSQL2(cond, query);
				query.append(") AS PersonLoanDetailVW ORDER BY DATE,TYPE,ID");
				SQLQuery q = session.createSQLQuery(query.toString());
				q.setProperties(cond);
				q.addEntity("PersonLoanDetailVW", PersonLoanDetailVW.class);
				setFetchPoint(q, start, count);
				list = q.list();
				session.clear();
				session.close();
				
				return list;
			}
		};
		return (List<PersonLoanDetail>) execute(action);
	}
	
	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected void getSQL1(PersonLoanDetailSearchCond cond, StringBuffer query){
		//时间开始
		if( StringUtils.isNotEmpty(cond.getDate_from()) ){
			query.append(" AND A.LPDDATE >=:date_from ");
		}	
		//时间结束
		if( StringUtils.isNotEmpty(cond.getDate_to()) ){
			query.append(" AND A.LPDDATE <=:date_to ");
		}	
	}
	
	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected void getSQL2(PersonLoanDetailSearchCond cond, StringBuffer query){
		//时间开始
		if( StringUtils.isNotEmpty(cond.getDate_from()) ){
			query.append(" AND A.LPDDATE >=:date_from ");
		}	
		//时间结束
		if( StringUtils.isNotEmpty(cond.getDate_to()) ){
			query.append(" AND A.LPDDATE <=:date_to ");
		}	
	}
	
}
