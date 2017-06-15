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
import com.deliverik.infogovernor.rpt.model.SOC0409Info;
import com.deliverik.infogovernor.rpt.model.condition.SOC0409SearchCond;
import com.deliverik.infogovernor.rpt.model.entity.SOC0409TB;

/**
  * 概述: 主机pv实时表DAO实现
  * 功能描述: 主机pv实时表DAO实现
  * 创建记录: 2012/07/03
  * 修改记录: 2012/08/09 将PVHostRealTimeDAOImpl表名改为SOC0409DAOImpl
  */
@SuppressWarnings("deprecation")
public class SOC0409DAOImpl extends
		BaseHibernateDAOImpl<SOC0409Info> implements SOC0409DAO {

	/**
	 * 构造函数
	 */
	public SOC0409DAOImpl(){
		super(SOC0409TB.class);
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<SOC0409Info> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public SOC0409Info findByPK(Serializable pk) {
		SOC0409Info result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final SOC0409SearchCond cond){
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
	public List<SOC0409Info> findByCond(final SOC0409SearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(SOC0409SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		if(!StringUtils.isEmpty(cond.getHostName_eq())){
			c.add(Expression.eq("hostName", cond.getHostName_eq()));
		}
		if(!StringUtils.isEmpty(cond.getSName_eq())){
			c.add(Expression.eq("sName", cond.getSName_eq()));
		}
		if("-1".equals(cond.getHostName_eq()) && cond.getHostName_notin()!=null && !StringUtils.isEmpty(cond.getSName_eq())){//查询未使用LUNID
			c.add(Expression.not(Expression.in("hostName",cond.getHostName_notin())));
			c.add(Expression.eq("sName",cond.getSName_eq()));
		}
		c.addOrder(Order.asc("lunid"));
		return c;
	}

}