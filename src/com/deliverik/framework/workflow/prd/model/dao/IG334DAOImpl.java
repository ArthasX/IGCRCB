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
import com.deliverik.framework.workflow.prd.model.IG334Info;
import com.deliverik.framework.workflow.prd.model.IG334VWInfo;
import com.deliverik.framework.workflow.prd.model.condition.IG334SearchCond;
import com.deliverik.framework.workflow.prd.model.entity.IG334TB;
import com.deliverik.framework.workflow.prd.model.entity.IG334VW;

/**
  * 概述: 通知策略基本信息DAO实现
  * 功能描述: 通知策略基本信息DAO实现
  * 创建记录: 2013/09/03
  * 修改记录: 
  */
@SuppressWarnings("deprecation")
public class IG334DAOImpl extends
		BaseHibernateDAOImpl<IG334Info> implements IG334DAO {

	/**
	 * 构造函数
	 */
	public IG334DAOImpl(){
		super(IG334TB.class);
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<IG334Info> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public IG334Info findByPK(Serializable pk) {
		IG334Info result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final IG334SearchCond cond){
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
	public List<IG334Info> findByCond(final IG334SearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond
	 *            检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(IG334SearchCond cond) {
		DetachedCriteria c = getDetachedCriteria();
		if (StringUtils.isNotEmpty(cond.getPdid_like())) {
			c.add(Expression.like("pdid", cond.getPdid_like() + "%"));
		}
		if (StringUtils.isNotEmpty(cond.getPdid_eq())) {
			c.add(Expression.eq("pdid", cond.getPdid_eq()));
		}
		//流程表单ID(完全匹配)
		if (StringUtils.isNotEmpty(cond.getPidid_eq())) {
			c.add(Expression.eq("pidid", cond.getPidid_eq()));
		}
		//流程表单ID(模糊匹配)
		if (StringUtils.isNotEmpty(cond.getPidid_like())) {
			c.add(Expression.like("pidid", cond.getPidid_like() + "%"));
		}
		return c;
	}
	
	/**
	 * 条件检索处理
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	@SuppressWarnings("unchecked")
	public List<IG334VWInfo> findByCondTactics(final IG334SearchCond cond){
		HibernateCallback action = new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				query.append(session.getNamedQuery("IG334DAO.searchIG334InfoStactics").getQueryString());
				getSQL(cond, query);
				
				SQLQuery q = session.createSQLQuery(query.toString());
//				q.setString("pdid", cond.getPdid());
				setFetchPoint(q, 0, 0);
				q.addEntity("pi", IG334VW.class);
				List<IG334VWInfo> list = q.list();
				session.clear();
				return list;
			}
		};
		return (List<IG334VWInfo>) execute(action);
	}
	
	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected void getSQL(IG334SearchCond cond, StringBuffer query){
		//流程类型ID模糊查询
		if(StringUtils.isNotEmpty(cond.getPdid_like())){
			query.append(" and pdid like '").append(cond.getPdid_like()).append("%' ");
		}
	}
}