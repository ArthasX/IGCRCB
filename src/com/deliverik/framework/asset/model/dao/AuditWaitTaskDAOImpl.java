/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.asset.model.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

import com.deliverik.framework.asset.bl.task.CMDBConstants;
import com.deliverik.framework.asset.model.AuditWaitTaskInfo;
import com.deliverik.framework.asset.model.condition.AuditWaitTaskSearchCond;
import com.deliverik.framework.asset.model.entity.AuditWaitTaskTB;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;

/**
  * 概述: 审计待处理任务DAO实现
  * 功能描述: 审计待处理任务DAO实现
  * 创建记录: 2011/05/18
  * 修改记录: 
  */
@SuppressWarnings("deprecation")
public class AuditWaitTaskDAOImpl extends
		BaseHibernateDAOImpl<AuditWaitTaskInfo> implements AuditWaitTaskDAO {

	/**
	 * 构造函数
	 */
	public AuditWaitTaskDAOImpl(){
		super(AuditWaitTaskTB.class);
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<AuditWaitTaskInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		c.addOrder(Order.desc("auwtid"));
		return findByCriteria(c);
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public AuditWaitTaskInfo findByPK(Serializable pk) {
		AuditWaitTaskInfo result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final AuditWaitTaskSearchCond cond){
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.desc("auwtid"));
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
	public List<AuditWaitTaskInfo> findByCond(final AuditWaitTaskSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(AuditWaitTaskSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		//任务是否发生错误
		if(cond.isTaskError()) {
			c.add(Expression.gt("auwtstatus", CMDBConstants.TASK_STATUS_DONE));//已完成
		} else {
			//任务状态是否完成
			if(cond.isTaskDone()) {
				c.add(Expression.eq("auwtstatus", CMDBConstants.TASK_STATUS_DONE));//已完成
			} else {
				c.add(Expression.lt("auwtstatus", CMDBConstants.TASK_STATUS_DONE));//未完成
			}
		}
		
		//删除标志
		if (StringUtils.isNotEmpty(cond.getDeleteflag_eq())) {
			c.add(Expression.eq("deleteflag", cond.getDeleteflag_eq()));
		}
		return c;
	}

}