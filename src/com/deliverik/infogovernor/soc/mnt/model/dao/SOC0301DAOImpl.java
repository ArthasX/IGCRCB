/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.soc.mnt.model.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.soc.mnt.model.SOC0301Info;
import com.deliverik.infogovernor.soc.mnt.model.condition.SOC0301SearchCond;
import com.deliverik.infogovernor.soc.mnt.model.entity.SOC0301TB;

/**
  * 概述: DMX实时监控性能表DAO实现
  * 功能描述: DMX实时监控性能表DAO实现
  * 创建记录: 2012/05/16
  * 修改记录: 
  */
@SuppressWarnings("deprecation")
public class SOC0301DAOImpl extends
		BaseHibernateDAOImpl<SOC0301Info> implements SOC0301DAO {

	/**
	 * 构造函数
	 */
	public SOC0301DAOImpl(){
		super(SOC0301TB.class);
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<SOC0301Info> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public SOC0301Info findByPK(Serializable pk) {
		SOC0301Info result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final SOC0301SearchCond cond){
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
	public List<SOC0301Info> findByCond(final SOC0301SearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.desc("id"));
		return findByCriteria(c, start, count);
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(SOC0301SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		if(StringUtils.isNotEmpty(cond.getMtId_eq().toString())){
			c.add(Expression.eq("mtId", cond.getMtId_eq()));
		}
		if(StringUtils.isNotEmpty(cond.getMtoName_eq())){
			c.add(Expression.eq("mtoName", cond.getMtoName_eq()));
		}
		if(StringUtils.isNotEmpty(cond.getMtKpi_eq())){
			c.add(Expression.eq("mtKpi", cond.getMtKpi_eq()));
		}
		if(StringUtils.isNotEmpty(cond.getTimestamp_ge())){
			c.add(Expression.ge("timestamp", cond.getTimestamp_ge()));
		}
		return c;
	}
	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<SOC0301Info> findByCondOrderByTimeAndName(
			SOC0301SearchCond cond, final int start,
			final int count) {
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.asc("mtoName"));
		c.addOrder(Order.asc("timeStamp"));
		return findByCriteria(c, start, count);
	}


}