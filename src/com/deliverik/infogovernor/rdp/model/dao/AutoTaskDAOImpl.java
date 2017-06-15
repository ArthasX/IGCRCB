/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.rdp.model.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.rdp.model.AutoTaskInfo;
import com.deliverik.infogovernor.rdp.model.condition.AutoTaskSearchCond;
import com.deliverik.infogovernor.rdp.model.entity.AutoTaskTB;

/**
  * 概述: AutoTaskDAO实现
  * 功能描述: AutoTaskDAO实现
  * 创建记录: 2014/04/16
  * 修改记录: 
  */
@SuppressWarnings("deprecation")
public class AutoTaskDAOImpl extends
		BaseHibernateDAOImpl<AutoTaskInfo> implements AutoTaskDAO {

	/**
	 * 构造函数
	 */
	public AutoTaskDAOImpl(){
		super(AutoTaskTB.class);
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<AutoTaskInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public AutoTaskInfo findByPK(Serializable pk) {
		AutoTaskInfo result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final AutoTaskSearchCond cond){
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
	public List<AutoTaskInfo> findByCond(final AutoTaskSearchCond cond, final int start, final int count){
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
	protected DetachedCriteria getCriteria(AutoTaskSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		if(StringUtils.isNotEmpty(cond.getTaskName_like())){
			c.add(Expression.like("taskName", "%" + cond.getTaskName_like() + "%"));
		}
		if(StringUtils.isNotEmpty(cond.getTime_from())){
			c.add(Expression.ge("excutetime", cond.getTime_from()));
		}
		if(StringUtils.isNotEmpty(cond.getTime_to())){
			c.add(Expression.le("excutetime", cond.getTime_to()));
		}
		if(cond.getSystemid_eq() != null){
			c.add(Expression.eq("businessSystemid", cond.getSystemid_eq()));
		}
		return c;
	}

}