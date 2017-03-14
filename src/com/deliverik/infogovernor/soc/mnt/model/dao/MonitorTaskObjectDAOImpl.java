/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.soc.mnt.model.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.soc.mnt.model.MonitorTaskObjectInfo;
import com.deliverik.infogovernor.soc.mnt.model.condition.MonitorTaskObjectSearchCond;
import com.deliverik.infogovernor.soc.mnt.model.entity.MonitorTaskObjectTB;

/**
  * 概述: 监控任务对象表DAO实现
  * 功能描述: 监控任务对象表DAO实现
  * 创建记录: 2012/05/10
  * 修改记录: 
  */
@SuppressWarnings("deprecation")
public class MonitorTaskObjectDAOImpl extends
		BaseHibernateDAOImpl<MonitorTaskObjectInfo> implements MonitorTaskObjectDAO {

	/**
	 * 构造函数
	 */
	public MonitorTaskObjectDAOImpl(){
		super(MonitorTaskObjectTB.class);
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<MonitorTaskObjectInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public MonitorTaskObjectInfo findByPK(Serializable pk) {
		MonitorTaskObjectInfo result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final MonitorTaskObjectSearchCond cond){
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
	public List<MonitorTaskObjectInfo> findByCond(final MonitorTaskObjectSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(MonitorTaskObjectSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		if(cond.getMtid()!=null){
			c.add(Expression.eq("mtId", cond.getMtid()));
		}
		return c;
	}

}