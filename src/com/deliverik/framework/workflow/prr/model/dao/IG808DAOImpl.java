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
import com.deliverik.framework.workflow.prr.model.IG160Info;
import com.deliverik.framework.workflow.prr.model.IG808Info;
import com.deliverik.framework.workflow.prr.model.entity.IG808VW;

/**
 * <p>概述:首页上按部门统计工作数量查询DAO实现</p>
 * <p>功能描述：获取sql执行查询</p>
 * <p>创建记录：宋海洋 2010/11/13</p>
 */
public class IG808DAOImpl extends BaseHibernateDAOImpl<IG808Info> implements IG808DAO {

	/**
	 * 视图构造函数
	 * 
	 */
	public IG808DAOImpl(){
		super(IG808VW.class);
	}
	
	/**
	 * 功能：获取工作数量
	 * @return 检索结果列表
	 */
	@SuppressWarnings("unchecked")
	public List<IG808Info> findIG808Info(){
		HibernateCallback action = new HibernateCallback() {

			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				query.append(session.getNamedQuery("IG808DAO.searchIG808").getQueryString());
				SQLQuery q = session.createSQLQuery(query.toString());
				q.addEntity("prcount",IG808VW.class);
				List<IG160Info> list = q.list();
				session.clear();
				return list;
			}
		};
		return (List<IG808Info>) execute(action);
	}
	
	
}
