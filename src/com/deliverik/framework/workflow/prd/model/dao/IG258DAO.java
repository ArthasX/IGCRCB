/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prd.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.workflow.prd.model.IG258Info;
import com.deliverik.framework.workflow.prd.model.condition.IG258SearchCond;

/**
  * 概述: 流程状态参与者调整DAO接口
  * 功能描述: 流程状态参与者调整DAO接口
  * 创建记录: 2012/05/09
  * 修改记录: 
  */
public interface IG258DAO extends BaseHibernateDAO<IG258Info> {

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<IG258Info> findAll();

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public IG258Info findByPK(Serializable pk);

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final IG258SearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<IG258Info> findByCond(
			final IG258SearchCond cond, final int start,
			final int count);

	public String getPspcdSequenceNextValue(final String psdid);
}