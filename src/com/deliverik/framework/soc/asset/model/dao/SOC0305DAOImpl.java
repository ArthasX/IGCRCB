/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.soc.asset.model.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.framework.soc.asset.model.SOC0305Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0305SearchCond;
import com.deliverik.framework.soc.asset.model.entity.SOC0305TB;

/**
 * 概述: StorageEventDAO实现 功能描述: StorageEventDAO实现 创建记录: 2011/06/13 修改记录:
 */
@SuppressWarnings("deprecation")
public class SOC0305DAOImpl extends BaseHibernateDAOImpl<SOC0305Info>
		implements SOC0305DAO {

	/**
	 * 构造函数
	 */
	public SOC0305DAOImpl() {
		super(SOC0305TB.class);
	}

	/**
	 * 全件检索
	 * 
	 * @return 检索结果集
	 */
	public List<SOC0305Info> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * 主键检索处理
	 * 
	 * @param pk
	 *            主键
	 * @return 检索结果
	 */
	public SOC0305Info findByPK(Serializable pk) {
		SOC0305Info result = super.findByPK(pk);
		if (result == null)
			return null;
		return result;
	}

	/**
	 * 条件检索结果件数取得
	 * 
	 * @param cond
	 *            检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final SOC0305SearchCond cond) {
		DetachedCriteria c = getCriteria(cond);
		return getCount(c);
	}

	/**
	 * 条件检索处理
	 * 
	 * @param cond
	 *            检索条件
	 * @param start
	 *            检索记录起始行号
	 * @param count
	 *            检索记录件数
	 * @return 检索结果列表
	 */
	public List<SOC0305Info> findByCond(final SOC0305SearchCond cond,
			final int start, final int count) {
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.desc("detectiontime"));
		return findByCriteria(c, start, count);
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond
	 *            检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(SOC0305SearchCond cond) {
		DetachedCriteria c = getDetachedCriteria();
		if (!StringUtils.isEmpty(cond.getImpcitype())) {
			c.add(Expression.eq("imptypeid", Integer.parseInt(cond.getImpcitype())));
		}
		if (!StringUtils.isEmpty(cond.getEirootmark_eq())) {
			c.add(Expression.eq("eirootmark", "'"+cond.getEirootmark_eq().trim()+"'"));
		}
		if (!StringUtils.isEmpty(cond.getDir_eq())) {
			c.add(Expression.eq("dir", "'"+cond.getDir_eq().trim().toUpperCase()+"'"));
		}
		if (!StringUtils.isEmpty(cond.getErrornum_eq())) {
			c.add(Expression.eq("errornum", "'"+cond.getErrornum_eq().trim()
					.toLowerCase()+"'"));
		}
		if (!StringUtils.isEmpty(cond.getDetectiontime_from())) {
			c.add(Expression.ge("detectiontime", "'"+cond.getDetectiontime_from()+"'"));
		}
		if (!StringUtils.isEmpty(cond.getDetectiontime_to())) {
			c.add(Expression.le("detectiontime", "'"+cond.getDetectiontime_to()+"'"));
		}
		if (!StringUtils.isEmpty(cond.getSeverity_eq())) {
			c.add(Expression.eq("severity", "'"+cond.getSeverity_eq()+"'"));
		}
		if (!StringUtils.isEmpty(cond.getAlarmType())) {
			c.add(Expression.eq("alarmType", cond.getAlarmType()));
		}
		if (!StringUtils.isEmpty(cond.getErrorDesc())) {
			c.add(Expression.like("errordesc", "%"+cond.getErrorDesc()+"%"));
		}
		if (!StringUtils.isEmpty(cond.getId())) {
			c.add(Expression.eq("id", Integer.parseInt(cond.getId())));
		}
		if (!StringUtils.isEmpty(cond.getStatus())) {
			c.add(Expression.eq("status", cond.getStatus()));
		}
		return c;
	}

}