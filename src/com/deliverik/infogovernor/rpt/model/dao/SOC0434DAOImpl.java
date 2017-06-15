/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.rpt.model.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.rpt.model.SOC0434Info;
import com.deliverik.infogovernor.rpt.model.condition.SOC0434SearchCond;
import com.deliverik.infogovernor.rpt.model.entity.SOC0434TB;

/**
  * 概述: PVVIODAO实现
  * 功能描述: PVVIODAO实现
  * 创建记录: 2012/08/20
  * 修改记录: 
  */
@SuppressWarnings("deprecation")
public class SOC0434DAOImpl extends
		BaseHibernateDAOImpl<SOC0434Info> implements SOC0434DAO {

	/**
	 * 构造函数
	 */
	public SOC0434DAOImpl(){
		super(SOC0434TB.class);
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<SOC0434Info> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public SOC0434Info findByPK(Serializable pk) {
		SOC0434Info result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final SOC0434SearchCond cond){
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
	public List<SOC0434Info> findByCond(final SOC0434SearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(SOC0434SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		if(StringUtils.isNotEmpty(cond.getSName())){
			c.add(Expression.eq("SNAME", cond.getSName()));
		}
		if(StringUtils.isNotEmpty(cond.getSN())){
			c.add(Expression.eq("SN", cond.getSN()));
		}
		if(StringUtils.isNotEmpty(cond.getIsUsed())){
			c.add(Expression.eq("ISUSED", cond.getIsUsed()));
		}
		c.addOrder(Order.asc("LUNID"));
		return c;
	}

}