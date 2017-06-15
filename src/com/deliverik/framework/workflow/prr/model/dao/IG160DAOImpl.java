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
import com.deliverik.framework.workflow.prr.model.IG160Info;
import com.deliverik.framework.workflow.prr.model.condition.IG160SearchCond;
import com.deliverik.framework.workflow.prr.model.entity.IG160VW;

/**
 * <p>概述:流程相关人员汇总统计查询DAO实现</p>
 * <p>功能描述：1.条件检索处理</p>
 * <p>          2.检索条件生成</p>
 * <p>创建记录：</p>
 */
public class IG160DAOImpl extends BaseHibernateDAOImpl<IG160Info> implements IG160DAO {

	/**
	 * 流程汇总视图构造函数
	 * 
	 */
	public IG160DAOImpl(){
		super(IG160VW.class);
	}
	/**
	 * 功能：条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	@SuppressWarnings("unchecked")
	public List<IG160Info> findByCond(final IG160SearchCond cond, final int start, final int count){
		HibernateCallback action = new HibernateCallback() {

			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				query.append(session.getNamedQuery("IG359DAO.searchUserQuery1").getQueryString());
				getSQL(cond, query);
				query.append(session.getNamedQuery("IG359DAO.searchUserQuery2").getQueryString());
				query.append(" ORDER BY ppusername");
				SQLQuery q = session.createSQLQuery(query.toString());
				q.setProperties(cond);
				q.addEntity("prcount",IG160VW.class);
				setFetchPoint(q, start, count);
				List<IG160Info> list = q.list();
				session.clear();
				return list;
			}
		};
		return (List<IG160Info>) execute(action);
	}
	
	/**
	 * 功能：检索条件生成
	 * 
	 * @param cond 检索条件
	 * @param query sql
	 * @return 检索用检索条件类
	 */
	protected void getSQL(IG160SearchCond cond, StringBuffer query){
		//机构编号
		if( StringUtils.isNotEmpty(cond.getOrgid()) ){
			query.append(" AND prorgid like :orgid");
		}	
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
