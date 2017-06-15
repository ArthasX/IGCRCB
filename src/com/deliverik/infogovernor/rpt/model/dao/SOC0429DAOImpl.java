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
import com.deliverik.infogovernor.rpt.model.SOC0429Info;
import com.deliverik.infogovernor.rpt.model.condition.SOC0429SearchCond;
import com.deliverik.infogovernor.rpt.model.entity.SOC0429VW;

/**
  * 概述: 主机容量视图DAO实现
  * 功能描述: 主机容量视图DAO实现
  * 创建记录: 2012/07/03
  * 修改记录: 2012/08/09 将HostCapacityRealTimeVWDAOImpl表名改为SOC0429DAOImpl
  */
@SuppressWarnings("deprecation")
public class SOC0429DAOImpl extends
		BaseHibernateDAOImpl<SOC0429Info> implements SOC0429DAO {

	/**
	 * 构造函数
	 */
	public SOC0429DAOImpl(){
		super(SOC0429VW.class);
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<SOC0429Info> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		c.addOrder(Order.asc("hostName"));
		return findByCriteria(c);
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public SOC0429Info findByPK(Serializable pk) {
		SOC0429Info result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final SOC0429SearchCond cond){
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
	public List<SOC0429Info> findByCond(final SOC0429SearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(SOC0429SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		if(cond.getBcId_eq()!=0){
			c.add(Expression.eq("bcid",cond.getBcId_eq()));
		}
		if(!StringUtils.isEmpty(cond.getSName_eq())){
			c.add(Expression.eq("sName",cond.getSName_eq()));
		}
		if(!StringUtils.isEmpty(cond.getBcName_eq())){
			c.add(Expression.eq("bcName",cond.getBcName_eq()));
		}
		return c;
	}

}