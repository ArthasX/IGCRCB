/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.asset.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.asset.model.CIWaitTaskInfo;
import com.deliverik.framework.asset.model.condition.CIWaitTaskSearchCond;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;

/**
  * 概述: CI变更待处理任务DAO接口
  * 功能描述: CI变更待处理任务DAO接口
  * 创建记录: 2011/05/18
  * 修改记录: 
  */
public interface CIWaitTaskDAO extends BaseHibernateDAO<CIWaitTaskInfo> {

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<CIWaitTaskInfo> findAll();

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public CIWaitTaskInfo findByPK(Serializable pk);

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final CIWaitTaskSearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<CIWaitTaskInfo> findByCond(
			final CIWaitTaskSearchCond cond, final int start,
			final int count);

}