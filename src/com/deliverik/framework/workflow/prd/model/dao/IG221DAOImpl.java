/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prd.model.dao;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.framework.workflow.prd.model.IG221Info;
import com.deliverik.framework.workflow.prd.model.condition.IG221SearchCond;
import com.deliverik.framework.workflow.prd.model.entity.IG221VW;

/**
  * 概述: 参与者按钮定义信息表视图DAO实现
  * 功能描述: 参与者按钮定义信息表视图DAO实现
  * 创建记录: 2012/04/19
  * 修改记录: 
  */
public class IG221DAOImpl extends
		BaseHibernateDAOImpl<IG221Info> implements IG221DAO {

	/**
	 * 构造函数
	 */
	public IG221DAOImpl(){
		super(IG221VW.class);
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<IG221Info> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public IG221Info findByPK(Serializable pk) {
		IG221Info result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final IG221SearchCond cond){
		DetachedCriteria c = getCriteria(cond);
		return getCount(c);
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
	public List<IG221Info> findByCond(final IG221SearchCond cond, final int start, final int count){
		HibernateCallback action = new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				query.append(session.getNamedQuery("IG132DAO.ButtonQuery").getQueryString());
				SQLQuery q = session.createSQLQuery(query.toString());
				q.setString("ppdid", cond.getPpdid());
				q.addEntity("pd",IG221VW.class);
				setFetchPoint(q, 0, 0);
				List<IG221Info> list = q.list();
				session.clear();
				return list;
			}
		};
		return (List<IG221Info>) execute(action);
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
	public List<IG221Info> findDefaultByCond(final IG221SearchCond cond, final int start, final int count){
		HibernateCallback action = new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				query.append(session.getNamedQuery("IG132DAO.DefaultButtonQuery").getQueryString());
				SQLQuery q = session.createSQLQuery(query.toString());
				q.setString("psdid", cond.getPsdid());
				q.addEntity("pd",IG221VW.class);
				setFetchPoint(q, 0, 0);
				List<IG221Info> list = q.list();
				session.clear();
				return list;
			}
		};
		return (List<IG221Info>) execute(action);
	}
	
	
	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(IG221SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		return c;
	}

}