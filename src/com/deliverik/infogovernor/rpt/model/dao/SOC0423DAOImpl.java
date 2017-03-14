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
import com.deliverik.infogovernor.rpt.model.SOC0423Info;
import com.deliverik.infogovernor.rpt.model.condition.SOC0423SearchCond;
import com.deliverik.infogovernor.rpt.model.entity.SOC0423TB;

/**
  * 概述: 容量对象表DAO实现
  * 功能描述: 容量对象表DAO实现
  * 创建记录: 2012/07/17
  * 修改记录: 2012/08/09 将CapacityObjectListDAOImpl表名改为SOC0423DAOImpl
  */
@SuppressWarnings("deprecation")
public class SOC0423DAOImpl extends
		BaseHibernateDAOImpl<SOC0423Info> implements SOC0423DAO {

	/**
	 * 构造函数
	 */
	public SOC0423DAOImpl(){
		super(SOC0423TB.class);
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<SOC0423Info> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public SOC0423Info findByPK(Serializable pk) {
		SOC0423Info result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final SOC0423SearchCond cond){
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
	public List<SOC0423Info> findByCond(final SOC0423SearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.asc("name"));
		return findByCriteria(c, start, count);
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(SOC0423SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		if (!StringUtils.isEmpty(cond.getName_like())) {
			c.add(Expression.like("name", cond.getName_like()+"_%"));
		}
		if (!StringUtils.isEmpty(cond.getName())) {
			c.add(Expression.eq("name", cond.getName()));
		}
		if (!StringUtils.isEmpty(cond.getObjectType())) {
			c.add(Expression.eq("objectType", cond.getObjectType()));
		}
		if(cond.getStatus()!=null){
			c.add(Expression.eq("status", cond.getStatus()));
		}
		if(!StringUtils.isEmpty(cond.getObjectName())){
			c.add(Expression.eq("objectName", cond.getObjectName()));
		}
		return c;
	}

}