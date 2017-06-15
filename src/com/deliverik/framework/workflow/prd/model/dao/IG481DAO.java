/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prd.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.workflow.prd.model.IG480Info;
import com.deliverik.framework.workflow.prd.model.IG481Info;
import com.deliverik.framework.workflow.prd.model.condition.IG481SearchCond;

/**
  * 概述: 流程组成员表DAO接口
  * 功能描述: 流程组成员表DAO接口
  * 创建记录: 2015/02/03
  * 修改记录: 
  */
public interface IG481DAO extends BaseHibernateDAO<IG481Info> {

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<IG481Info> findAll();

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public IG481Info findByPK(Serializable pk);

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final IG481SearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<IG481Info> findByCond(
			final IG481SearchCond cond, final int start,
			final int count);
	/**
	 * 根据条件删除
	 * @param cond
	 */
	public void deleteByCond(final IG481SearchCond cond);
	
	/**
	 * 根据流程定义ID查询组定义列表
	 * @param pdid 流程定义ID
	 * @return 组定义列表
	 */
	public List<IG480Info> searchIG480(final String pdid);
}