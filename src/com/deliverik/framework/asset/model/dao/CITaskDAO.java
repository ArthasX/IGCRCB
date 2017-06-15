/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.asset.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.asset.model.CITaskInfo;
import com.deliverik.framework.asset.model.condition.CITaskSearchCond;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;

/**
  * 概述: CI变更任务表DAO接口
  * 功能描述: CI变更任务表DAO接口
  * 创建记录: 2011/05/18
  * 修改记录: 
  */
public interface CITaskDAO extends BaseHibernateDAO<CITaskInfo> {

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<CITaskInfo> findAll();

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public CITaskInfo findByPK(Serializable pk);

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final CITaskSearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<CITaskInfo> findByCond(
			final CITaskSearchCond cond, final int start,
			final int count);

}