/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.framework.workflow.prr.model.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.framework.workflow.prr.model.IG941Info;
import com.deliverik.framework.workflow.prr.model.condition.IG941SearchCond;
import com.deliverik.framework.workflow.prr.model.entity.IG941TB;

/**
 * 服务工单日志DAO实现
 */
@SuppressWarnings("deprecation")
public class IG941DAOImpl extends BaseHibernateDAOImpl<IG941Info> implements IG941DAO {

	/**
	 * 构造函数
	 */
	public IG941DAOImpl(){
		super(IG941TB.class);
	}

	/**
	 * 全件检索
	 * @return 检索结果集
	 */
	public List<IG941Info> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		c.addOrder(Order.desc("sflid"));
		List<IG941Info> ret = findByCriteria(c);

		return ret;
	}

	/**
	 * 主键检索处理
	 * @param sflid 主键
	 * @return 检索结果
	 */
	public IG941Info findByPK(Serializable sflid) {

		IG941Info result = super.findByPK(sflid);
		if(result == null) return null;

		return result;
	}

	/**
	 * 条件检索结果件数取得
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final IG941SearchCond cond){
		DetachedCriteria c = getCriteria(cond);
		return getCount(c);
	}

	/**
	 * 条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<IG941Info> findByCond(final IG941SearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.asc("sflid"));
		List<IG941Info> ret = findByCriteria(c, start, count);
		return ret;
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(IG941SearchCond cond){
		
		DetachedCriteria c = getDetachedCriteria();
		
		if(cond.getSfid() != null && cond.getSfid() > 0){
			c.add(Expression.eq("sfid", cond.getSfid()));
		}
		return c;
	}

}
