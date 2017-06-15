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
import com.deliverik.framework.workflow.prd.model.IG212Info;
import com.deliverik.framework.workflow.prd.model.IG238Info;
import com.deliverik.framework.workflow.prd.model.condition.IG212SearchCond;
import com.deliverik.framework.workflow.prd.model.entity.IG212TB;
import com.deliverik.framework.workflow.prd.model.entity.IG238VW;

/**
  * 概述: 流程通知策略DAO实现
  * 功能描述: 流程通知策略DAO实现
  * 创建记录: 2012/04/24
  * 修改记录: 
  */
@SuppressWarnings("deprecation")
public class IG212DAOImpl extends
		BaseHibernateDAOImpl<IG212Info> implements IG212DAO {

	/**
	 * 构造函数
	 */
	public IG212DAOImpl(){
		super(IG212TB.class);
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<IG212Info> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public IG212Info findByPK(Serializable pk) {
		IG212Info result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final IG212SearchCond cond){
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
	public List<IG212Info> findByCond(final IG212SearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(IG212SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		if(StringUtils.isNotEmpty(cond.getPsdid_like())){
			c.add(Expression.like("pdid", cond.getPsdid_like() + "%"));
		}
		
		if(StringUtils.isNotEmpty(cond.getPdid())){
			c.add(Expression.eq("pdid", cond.getPdid()));
		}
		return c;
	}
	
	/**
	 * 流程通知策略查询
	 * 
	 * @param pdid 流程定义ID
	 * @return 流程通知策略列表
	 */
	@SuppressWarnings("unchecked")
	public List<IG238Info> searchIG238Info(final String pdid){
			HibernateCallback action = new HibernateCallback() {
				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					session.flush();
					StringBuffer query = new StringBuffer();
					query.append(session.getNamedQuery("IG212DAO.searchIG238").getQueryString());
					SQLQuery q = session.createSQLQuery(query.toString());
					q.setString("pdid", pdid);
					setFetchPoint(q, 0, 0);
					q.addEntity(IG238VW.class);
					List<IG238Info> list = q.list();
					session.clear();
					return list;
				}
			};
			return (List<IG238Info>) execute(action);
		}

}