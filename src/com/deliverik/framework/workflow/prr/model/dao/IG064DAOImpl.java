/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prr.model.dao;

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
import com.deliverik.framework.workflow.prr.model.IG064Info;
import com.deliverik.framework.workflow.prr.model.condition.IG064SearchCond;
import com.deliverik.framework.workflow.prr.model.entity.IG064VW;

/**
  * 概述: 流程记录节点提醒视图DAO实现
  * 功能描述: 流程记录节点提醒视图DAO实现
  * 创建记录: 2012/04/25
  * 修改记录: 
  */
public class IG064DAOImpl extends
		BaseHibernateDAOImpl<IG064Info> implements IG064DAO {

	/**
	 * 构造函数
	 */
	public IG064DAOImpl(){
		super(IG064VW.class);
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<IG064Info> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public IG064Info findByPK(Serializable pk) {
		IG064Info result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final IG064SearchCond cond){
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
	public List<IG064Info> findByCond(final IG064SearchCond cond, final int start, final int count){
		HibernateCallback action = new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				query.append(session.getNamedQuery("IG064DAO.Query").getQueryString());
				SQLQuery q = session.createSQLQuery(query.toString());
				q.addEntity("pd",IG064VW.class);
				setFetchPoint(q, 0, 0);
				List<IG221Info> list = q.list();
				session.clear();
				return list;
			}
		};
		return (List<IG064Info>) execute(action);
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(IG064SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		return c;
	}

}