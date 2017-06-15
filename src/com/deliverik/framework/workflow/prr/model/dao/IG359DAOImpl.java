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
import com.deliverik.framework.workflow.prr.model.IG359Info;
import com.deliverik.framework.workflow.prr.model.condition.IG359SearchCond;
import com.deliverik.framework.workflow.prr.model.entity.IG359VW;

/**
 * <p>概述:相关资产流程统计汇总统计DAO实现</p>
 * <p>功能描述：1.条件检索处理</p>
 * <p>			 2.检索条件生成</p>
 * <p>创建记录：</p>
 */
public class IG359DAOImpl extends BaseHibernateDAOImpl<IG359Info> implements IG359DAO {

	/**
	 * 功能：流程汇总视图构造函数
	 * 
	 */
	public IG359DAOImpl(){
		super(IG359VW.class);
	}
	/**
	 * 功能：条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	@SuppressWarnings("unchecked")
	public List<IG359Info> findByCond(final IG359SearchCond cond, final int start, final int count){
		HibernateCallback action = new HibernateCallback() {

			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				query.append(session.getNamedQuery("IG359DAO.searchQuery1").getQueryString()).append("  ");
				getSQL(cond, query);
				query.append(session.getNamedQuery("IG359DAO.searchQuery2").getQueryString());
				SQLQuery q = session.createSQLQuery(query.toString());
				q.setProperties(cond);
				q.addEntity("prcount",IG359VW.class);
				setFetchPoint(q, start, count);
				List<IG359Info> list = q.list();
				session.clear();
				return list;
			}
		};
		return (List<IG359Info>) execute(action);
	}
	
	/**
	 * 功能：检索条件生成
	 * 
	 * @param cond 检索条件
	 * @param query sql
	 */
	protected void getSQL(IG359SearchCond cond, StringBuffer query){
		//开始日期
		if( StringUtils.isNotEmpty(cond.getPropentime_from()) ){
			query.append(" AND propentime >= :propentime_from ");
		}	
		//结束日期
		if( StringUtils.isNotEmpty(cond.getPropentime_to()) ){
			query.append(" AND propentime <= (:propentime_to||' 23:59') ");
		}	
	}
}
