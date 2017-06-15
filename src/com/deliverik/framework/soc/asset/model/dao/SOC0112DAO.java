/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.soc.asset.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.soc.asset.model.SOC0112Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0112SearchCond;

/**
  * 概述: 资产域明细表DAO接口
  * 功能描述: 资产域明细表DAO接口
  * 创建记录: 2011/04/20
  * 修改记录: 
  */
public interface SOC0112DAO extends BaseHibernateDAO<SOC0112Info> {

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<SOC0112Info> findAll();

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public SOC0112Info findByPK(Serializable pk);

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final SOC0112SearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<SOC0112Info> findByCond(
			final SOC0112SearchCond cond, final int start,
			final int count);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<SOC0112Info> findBySQL(final SOC0112SearchCond cond, final int start, final int count);
}