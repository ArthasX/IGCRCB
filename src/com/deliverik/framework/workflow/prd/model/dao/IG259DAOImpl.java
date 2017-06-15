/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.framework.workflow.prd.model.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.framework.workflow.prd.model.IG259Info;
import com.deliverik.framework.workflow.prd.model.condition.IG259SearchCond;
import com.deliverik.framework.workflow.prd.model.entity.IG259TB;

/**
 * <p>概述:流程模板DAO实现</p>
 * <p>功能描述：1.全件检索</p>
 * <p>          2.主键检索处理</p>
 * <p>          3.条件检索处理</p>
 * <p>          4.检索条件生成</p>
 * <p>          5.条件检索结果件数取得</p>
 * <p>创建记录：</p>
 */
@SuppressWarnings("deprecation")
public class IG259DAOImpl extends
		BaseHibernateDAOImpl<IG259Info> implements IG259DAO {

	/**
	 * 功能：构造函数
	 */
	public IG259DAOImpl() {
		super(IG259TB.class);
	}

	/**
	 * 功能：全件检索
	 * @return 检索结果集
	 */
	public List<IG259Info> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		c.addOrder(Order.asc("ptid"));
		List<IG259Info> ret = findByCriteria(c);
		return ret;
	}

	/**
	 * 功能：主键检索处理
	 * @param ptid 主键
	 * @return 检索结果
	 */
	public IG259Info findByPK(Serializable ptid) {

		IG259Info pt = super.findByPK(ptid);
		if (pt == null)
			return null;

		return pt;
	}

	/**
	 * 功能：条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<IG259Info> findByCond(final IG259SearchCond cond, final int start,final int count) {
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.asc("ptid"));
		List<IG259Info> ret = findByCriteria(c, start, count);
		return ret;
	}

	/**
	 * 功能：检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(IG259SearchCond cond) {
		DetachedCriteria c = getDetachedCriteria();
		if (cond.getPtid() != null && cond.getPtid() != 0) {
			c.add(Expression.eq("ptid", cond.getPtid()));
		}
		if (!StringUtils.isEmpty(cond.getPtname())) {
			c.add(Expression.eq("ptname", cond.getPtname()));
		}
		if (!StringUtils.isEmpty(cond.getPttype())) {
			c.add(Expression.eq("pttype", cond.getPttype()));
		}
		if (!StringUtils.isEmpty(cond.getPtstatus())) {
			c.add(Expression.eq("ptstatus", cond.getPtstatus()));
		}
		if (!StringUtils.isEmpty(cond.getPtqrtzflag())) {
			c.add(Expression.like("ptqrtzflag", "%"+cond.getPtqrtzflag()+"%"));
		}
		if (cond.getIsWorkPt()==1) {
			c.add(Expression.like("pttype", "W%"));
		}
		if (cond.getPtstatuses() != null && cond.getPtstatuses().length > 0) {
			c.add(Expression.in("ptstatus", cond.getPtstatuses()));
		}
		return c;
	}

	/**
	 * 功能：条件检索结果件数取得
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final IG259SearchCond cond) {
		DetachedCriteria c = getCriteria(cond);
		return getCount(c);
	}

}
