/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.cic.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.cic.model.CompareresultInfo;
import com.deliverik.infogovernor.cic.model.CompareresultVWInfo;
import com.deliverik.infogovernor.cic.model.condition.CompareresultSearchCond;

/**
  * 概述: 比对结果DAO接口
  * 功能描述: 比对结果DAO接口
  * 创建记录: 2014/04/22
  * 修改记录: 
  */
public interface CompareresultDAO extends BaseHibernateDAO<CompareresultInfo> {

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<CompareresultInfo> findAll();

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public CompareresultInfo findByPK(Serializable pk);

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final CompareresultSearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<CompareresultInfo> findByCond(
			final CompareresultSearchCond cond, final int start,
			final int count);
	/**
     * 根据对象比对结果标题List
     * 
     * @param cond 检索条件
     * @param version 版本
     * @return 检索结果列表
     */
    public List<Object[]> getEnameList(final CompareresultSearchCond cond);
    
	/**
     * 根据对象比对结果
     * 
     * @param cond 检索条件
     * @param version 版本
     * @return 检索结果列表
     */
    public List<CompareresultVWInfo> searchCompareresultVW(final CompareresultSearchCond cond);
}