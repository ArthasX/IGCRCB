/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.plugin.change.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.plugin.change.model.InitiateChangLogInfo;
import com.deliverik.plugin.change.model.condition.InitiateChangLogSearchCond;

/**
  * 概述: 发起变更流程日志DAO接口
  * 功能描述: 发起变更流程日志DAO接口
  * 创建记录: 2015/07/02
  * 修改记录: 
  */
public interface InitiateChangLogDAO extends BaseHibernateDAO<InitiateChangLogInfo> {

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<InitiateChangLogInfo> findAll();

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public InitiateChangLogInfo findByPK(Serializable pk);

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final InitiateChangLogSearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<InitiateChangLogInfo> findByCond(
			final InitiateChangLogSearchCond cond, final int start,
			final int count);

}