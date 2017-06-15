/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prd.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.workflow.prd.model.IG243Info;
import com.deliverik.framework.workflow.prd.model.condition.IG243SearchCond;

/**
  * 概述: 流程标题定义表DAO接口
  * 功能描述: 流程标题定义表DAO接口
  * 创建记录: 2012/03/30
  * 修改记录: 
  */
public interface IG243DAO extends BaseHibernateDAO<IG243Info> {

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<IG243Info> findAll();

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public IG243Info findByPK(Serializable pk);

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final IG243SearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<IG243Info> findByCond(
			final IG243SearchCond cond, final int start,
			final int count);
	
	/**
	 * PTDID主键值取得
	 * 
	 * @param 流程定义ID
	 * @return PTDID主键值
	 */
	public String getPtdidSequenceNextValue(String pdid);

}