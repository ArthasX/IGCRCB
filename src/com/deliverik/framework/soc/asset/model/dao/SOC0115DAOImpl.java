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
import com.deliverik.framework.soc.asset.bl.task.CMDBConstants;
import com.deliverik.framework.soc.asset.model.SOC0115Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0115SearchCond;
import com.deliverik.framework.soc.asset.model.entity.SOC0115TB;

/**
  * 概述: 待处理任务DAO实现
  * 功能描述: 待处理任务DAO实现
  * 创建记录: 2011/04/29
  * 修改记录: 
  */
@SuppressWarnings("deprecation")
public class SOC0115DAOImpl extends
		BaseHibernateDAOImpl<SOC0115Info> implements SOC0115DAO {

	/**
	 * 构造函数
	 */
	public SOC0115DAOImpl(){
		super(SOC0115TB.class);
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<SOC0115Info> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		c.addOrder(Order.desc("eitid"));
		return findByCriteria(c);
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public SOC0115Info findByPK(Serializable pk) {
		SOC0115Info result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final SOC0115SearchCond cond){
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
	public List<SOC0115Info> findByCond(final SOC0115SearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.desc("eitid"));
		return findByCriteria(c, start, count);
	}

	/**
	 * 检索条件生成,默认查询未完成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(SOC0115SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		
		//任务是否发生错误
		if(cond.isTaskError()) {
			c.add(Expression.gt("eitstatus", CMDBConstants.TASK_STATUS_DONE));//已完成
		} else {
			//任务状态是否完成
			if(cond.isTaskDone()) {
				c.add(Expression.eq("eitstatus", CMDBConstants.TASK_STATUS_DONE));//已完成
			} else {
				c.add(Expression.lt("eitstatus", CMDBConstants.TASK_STATUS_DONE));//未完成
			}
		}
		
		//删除标志
		if (StringUtils.isNotEmpty(cond.getDeleteflag_eq())) {
			c.add(Expression.eq("deleteflag", cond.getDeleteflag_eq()));
		}
		return c;
	}

}