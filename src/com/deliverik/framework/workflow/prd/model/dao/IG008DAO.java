/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prd.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.workflow.prd.model.IG008Info;
import com.deliverik.framework.workflow.prd.model.condition.IG008SearchCond;

/**
  * 概述: 人员表单角色限定DAO接口
  * 功能描述: 人员表单角色限定DAO接口
  * 创建记录: 2013/11/27
  * 修改记录: 
  */
public interface IG008DAO extends BaseHibernateDAO<IG008Info> {

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<IG008Info> findAll();

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public IG008Info findByPK(Serializable pk);

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final IG008SearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<IG008Info> findByCond(
			final IG008SearchCond cond, final int start,
			final int count);

}