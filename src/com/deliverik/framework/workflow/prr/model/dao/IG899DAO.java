/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prr.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.workflow.prr.model.IG899Info;
import com.deliverik.framework.workflow.prr.model.condition.IG899SearchCond;

/**
  * 概述: 流程私有变量表DAO接口
  * 功能描述: 流程私有变量表DAO接口
  * 创建记录: 2012/03/27
  * 修改记录: 
  */
public interface IG899DAO extends BaseHibernateDAO<IG899Info> {

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<IG899Info> findAll();

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public IG899Info findByPK(Serializable pk);

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final IG899SearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<IG899Info> findByCond(
			final IG899SearchCond cond, final int start,
			final int count);

}