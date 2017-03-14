/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.dbm.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.dbm.model.WorkmanagerInfo;
import com.deliverik.infogovernor.dbm.model.condition.WorkmanagerSearchCond;
import com.deliverik.infogovernor.dbm.model.entity.WorkmanagerVW;

/**
  * 概述: 工作管理DAO接口
  * 功能描述: 工作管理DAO接口
  * 创建记录: 2016/04/19
  * 修改记录: 
  */
public interface WorkmanagerDAO extends BaseHibernateDAO<WorkmanagerInfo> {

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<WorkmanagerInfo> findAll();

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public WorkmanagerInfo findByPK(Serializable pk);

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final WorkmanagerSearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<WorkmanagerInfo> findByCond(
			final WorkmanagerSearchCond cond, final int start,
			final int count);

	/**
	 * 统计待处理工作
	 * 
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<WorkmanagerVW> searchSumByCond(final WorkmanagerSearchCond cond);
}