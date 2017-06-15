/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.soc.asset.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.soc.asset.model.Timer01Info;
import com.deliverik.framework.soc.asset.model.condition.Timer01SearchCond;

/**
  * 概述: timer01DAO接口
  * 功能描述: timer01DAO接口
  * 创建记录: 2013/07/04
  * 修改记录: 
  */
public interface Timer01DAO extends BaseHibernateDAO<Timer01Info> {

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<Timer01Info> findAll();

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public Timer01Info findByPK(Serializable pk);

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final Timer01SearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<Timer01Info> findByCond(
			final Timer01SearchCond cond, final int start,
			final int count);

}