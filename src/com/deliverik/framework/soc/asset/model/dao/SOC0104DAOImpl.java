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
import com.deliverik.framework.soc.asset.model.SOC0104Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0104SearchCond;
import com.deliverik.framework.soc.asset.model.entity.SOC0104TB;

/**
  * 概述: 审计任务表DAO实现
  * 功能描述: 审计任务表DAO实现
  * 创建记录: 2011/05/18
  * 修改记录: 
  */
@SuppressWarnings("deprecation")
public class SOC0104DAOImpl extends
		BaseHibernateDAOImpl<SOC0104Info> implements SOC0104DAO {

	/**
	 * 构造函数
	 */
	public SOC0104DAOImpl(){
		super(SOC0104TB.class);
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<SOC0104Info> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public SOC0104Info findByPK(Serializable pk) {
		SOC0104Info result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}
	
	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final SOC0104SearchCond cond){
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
	public List<SOC0104Info> findByCond(final SOC0104SearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.desc("autid"));
		return findByCriteria(c, start, count);
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(SOC0104SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		
		//审计任务描述
		if (StringUtils.isNotEmpty(cond.getAutdesc_like())) {
			c.add(Expression.like("autdesc", "%" + cond.getAutdesc_like() + "%"));
		}
		//状态
		if (StringUtils.isNotEmpty(cond.getAutstatus_eq())) {
			c.add(Expression.eq("autstatus", cond.getAutstatus_eq()));
		}
		//时间
		if(StringUtils.isNotEmpty(cond.getAuttime_from())){
			c.add(Expression.ge("auttime", cond.getAuttime_from()));
		}
		if(StringUtils.isNotEmpty(cond.getAuttime_to())){
			c.add(Expression.le("auttime", cond.getAuttime_to()+" 23:59"));
		}
		return c;
	}

}