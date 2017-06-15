/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prd.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.workflow.prd.model.IG212Info;
import com.deliverik.framework.workflow.prd.model.IG238Info;
import com.deliverik.framework.workflow.prd.model.condition.IG212SearchCond;

/**
  * 概述: 流程通知策略DAO接口
  * 功能描述: 流程通知策略DAO接口
  * 创建记录: 2012/04/24
  * 修改记录: 
  */
public interface IG212DAO extends BaseHibernateDAO<IG212Info> {

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<IG212Info> findAll();

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public IG212Info findByPK(Serializable pk);

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final IG212SearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<IG212Info> findByCond(
			final IG212SearchCond cond, final int start,
			final int count);
	
	/**
	 * 流程通知策略查询
	 * 
	 * @param pdid 流程定义ID
	 * @return 流程通知策略列表
	 */
	public List<IG238Info> searchIG238Info(final String pdid);

}