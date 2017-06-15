/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.ven.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.ven.model.MonitoringWorkInfo;
import com.deliverik.infogovernor.ven.model.condition.MonitoringWorkSearchCond;

/**
  * 概述: 监测工作填报表DAO接口
  * 功能描述: 监测工作填报表DAO接口
  * 创建记录: 2014/12/01
  * 修改记录: 
  */
public interface MonitoringWorkDAO extends BaseHibernateDAO<MonitoringWorkInfo> {

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<MonitoringWorkInfo> findAll();

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public MonitoringWorkInfo findByPK(Serializable pk);

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final MonitoringWorkSearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<MonitoringWorkInfo> findByCond(
			final MonitoringWorkSearchCond cond, final int start,
			final int count);

}