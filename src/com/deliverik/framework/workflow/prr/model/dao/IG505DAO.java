/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prr.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.workflow.prr.model.IG505Info;
import com.deliverik.framework.workflow.prr.model.condition.IG505SearchCond;

/**
  * 概述: 流程表单值表DAO接口
  * 功能描述: 流程表单值表DAO接口
  * 创建记录: 2013/08/28
  * 修改记录: 
  */
public interface IG505DAO extends BaseHibernateDAO<IG505Info> {

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<IG505Info> findAll();

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public IG505Info findByPK(Serializable pk);

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final IG505SearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<IG505Info> findByCond(
			final IG505SearchCond cond, final int start,
			final int count);

}