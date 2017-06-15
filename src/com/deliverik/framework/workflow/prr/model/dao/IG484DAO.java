/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prr.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.workflow.prr.model.IG484Info;
import com.deliverik.framework.workflow.prr.model.condition.IG484SearchCond;

/**
  * 概述: 流程组成员实例DAO接口
  * 功能描述: 流程组成员实例DAO接口
  * 创建记录: 2015/02/03
  * 修改记录: 
  */
public interface IG484DAO extends BaseHibernateDAO<IG484Info> {

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<IG484Info> findAll();

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public IG484Info findByPK(Serializable pk);

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final IG484SearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<IG484Info> findByCond(
			final IG484SearchCond cond, final int start,
			final int count);

}