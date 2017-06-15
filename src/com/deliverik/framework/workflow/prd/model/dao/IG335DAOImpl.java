/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prd.model.dao;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.framework.workflow.prd.model.IG238Info;
import com.deliverik.framework.workflow.prd.model.IG335Info;
import com.deliverik.framework.workflow.prd.model.condition.IG335SearchCond;
import com.deliverik.framework.workflow.prd.model.entity.IG335TB;

/**
  * 概述: 表单策略表DAO实现
  * 功能描述: 表单策略表DAO实现
  * 创建记录: 2013/09/03
  * 修改记录: 
  */
@SuppressWarnings("deprecation")
public class IG335DAOImpl extends
		BaseHibernateDAOImpl<IG335Info> implements IG335DAO {

	/**
	 * 构造函数
	 */
	public IG335DAOImpl(){
		super(IG335TB.class);
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<IG335Info> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public IG335Info findByPK(Serializable pk) {
		IG335Info result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final IG335SearchCond cond){
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
	public List<IG335Info> findByCond(final IG335SearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(IG335SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		
		// 表单定义Id全等
		if (StringUtils.isNotEmpty(cond.getPidid_eq())) {
			c.add(Expression.eq("pidid", cond.getPidid_eq()));
		}
		
		// 表单定义IdLike
		if (StringUtils.isNotEmpty(cond.getPidid_like())) {
		    c.add(Expression.like("pidid", cond.getPidid_like() + "%"));
		}
		
		// 表单状态Id全等
		if (StringUtils.isNotEmpty(cond.getPsdid_eq())) {
			c.add(Expression.eq("psdid", cond.getPsdid_eq() ));
		}
		
		// 表单状态Id like
		if (StringUtils.isNotEmpty(cond.getPsdid_like())) {
			c.add(Expression.like("psdid", cond.getPsdid_like() + "%"));
		}
		
		// 表单值全等
		if (StringUtils.isNotEmpty(cond.getPivalue_eq())) {
			c.add(Expression.eq("pivalue", cond.getPivalue_eq()));
		}

		// 流程定义ID(完全匹配)
		if (StringUtils.isNotEmpty(cond.getPdid_eq())) {
			c.add(Expression.eq("pdid", cond.getPdid_eq()));
		}
		// 流程定义ID(模糊匹配)_只提供右模糊匹配
		if (StringUtils.isNotEmpty(cond.getPdid_like())) {
		    c.add(Expression.like("pdid", cond.getPdid_like() + "%"));
		}

		return c;
	}

	/**
	 * 超时通知策略查询
	 * 
	 * @param pdid 流程定义ID
	 * @param psdid 状态定义ID
	 * @param pidid 表单定义ID
	 * @return  超时通知策略列表
	 */
	@SuppressWarnings("unchecked")
	public List<IG335Info> searchIG335Info(final String pdid, final  String psdid, final String pidid, final String psdconfirm){
		HibernateCallback action = new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				query.append(session.getNamedQuery("IG335DAO.searchIG335Info").getQueryString());
				SQLQuery q = session.createSQLQuery(query.toString());
				q.setString("pdid", pdid);
				q.setString("psdid", psdid);
				q.setString("pidid", pidid);
				q.setString("psdconfirm", psdconfirm);
				setFetchPoint(q, 0, 0);
				q.addEntity(IG335TB.class);
				List<IG238Info> list = q.list();
				session.clear();
				return list;
			}
		};
		return (List<IG335Info>) execute(action);
	}
}