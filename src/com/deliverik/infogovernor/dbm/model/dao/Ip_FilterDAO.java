/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.dbm.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.dbm.model.Ip_FilterInfo;
import com.deliverik.infogovernor.dbm.model.condition.Ip_FilterSearchCond;

/**
  * 概述: 全网IP过滤DAO接口
  * 功能描述: 全网IP过滤DAO接口
  * 创建记录: 2012/11/07
  * 修改记录: 
  */
public interface Ip_FilterDAO extends BaseHibernateDAO<Ip_FilterInfo> {

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<Ip_FilterInfo> findAll();

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public Ip_FilterInfo findByPK(Serializable pk);

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final Ip_FilterSearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<Ip_FilterInfo> findByCond(
			final Ip_FilterSearchCond cond, final int start,
			final int count);

}