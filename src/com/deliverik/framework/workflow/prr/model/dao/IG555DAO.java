/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prr.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.workflow.prr.model.IG555Info;
import com.deliverik.framework.workflow.prr.model.condition.IG555SearchCond;

/**
  * 概述: 流程处理页返回配置信息DAO接口
  * 功能描述: 流程处理页返回配置信息DAO接口
  * 创建记录: 2013/08/29
  * 修改记录: 
  */
public interface IG555DAO extends BaseHibernateDAO<IG555Info> {

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<IG555Info> findAll();

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public IG555Info findByPK(Serializable pk);

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final IG555SearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<IG555Info> findByCond(
			final IG555SearchCond cond, final int start,
			final int count);

}