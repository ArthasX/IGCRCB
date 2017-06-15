/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.asset.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.asset.model.EiWaitTaskInfo;
import com.deliverik.framework.asset.model.condition.EiWaitTaskSearchCond;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;

/**
  * 概述: 待处理任务DAO接口
  * 功能描述: 待处理任务DAO接口
  * 创建记录: 2011/04/29
  * 修改记录: 
  */
public interface EiWaitTaskDAO extends BaseHibernateDAO<EiWaitTaskInfo> {

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<EiWaitTaskInfo> findAll();

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public EiWaitTaskInfo findByPK(Serializable pk);

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final EiWaitTaskSearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<EiWaitTaskInfo> findByCond(
			final EiWaitTaskSearchCond cond, final int start,
			final int count);

}