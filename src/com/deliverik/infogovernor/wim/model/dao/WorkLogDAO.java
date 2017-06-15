/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.wim.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.wim.model.WorkLogInfo;
import com.deliverik.infogovernor.wim.model.condition.WorkLogSearchCond;

/**
  * 概述: 工作日志DAO接口
  * 功能描述: 工作日志DAO接口
  * 创建记录: 2017/06/09
  * 修改记录: 
  */
public interface WorkLogDAO extends BaseHibernateDAO<WorkLogInfo> {

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<WorkLogInfo> findAll();

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public WorkLogInfo findByPK(Serializable pk);

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final WorkLogSearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<WorkLogInfo> findByCond(
			final WorkLogSearchCond cond, final int start,
			final int count);

}