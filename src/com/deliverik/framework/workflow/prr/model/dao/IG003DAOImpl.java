/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.framework.workflow.prr.model.dao;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.framework.workflow.prr.model.IG003Info;
import com.deliverik.framework.workflow.prr.model.condition.IG003SearchCond;
import com.deliverik.framework.workflow.prr.model.entity.IG003VW;
import com.deliverik.framework.workflow.prr.model.entity.IG160VW;

/**
 * <p>概述:流程年度汇总统计DAO实现</p>
 * <p>功能描述：1.条件检索处理</p>
 * <p>创建记录：</p>
 */
public class IG003DAOImpl extends BaseHibernateDAOImpl<IG003Info> implements IG003DAO {

	/**
	 * 流程汇总视图构造函数
	 * 
	 */
	public IG003DAOImpl(){
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
	public List<IG003Info> findByCond(final IG003SearchCond cond, final int start, final int count){
		HibernateCallback action = new HibernateCallback() {

			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				query.append(session.getNamedQuery("IG003DAO.searchIG003").getQueryString());
				SQLQuery q = session.createSQLQuery(query.toString());
				q.setProperties(cond);
				q.addEntity("yearSummary",IG003VW.class);
				setFetchPoint(q, start, count);
				List<IG003Info> list = q.list();
				session.clear();
				return list;
			}
		};
		return (List<IG003Info>) execute(action);
	}
	

}
