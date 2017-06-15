/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.prr.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.prr.model.DispatchStatisticsVWInfo;
import com.deliverik.infogovernor.prr.model.condition.CopyReadUserSearchCond;
import com.deliverik.infogovernor.prr.model.condition.DispatchStatisticsVWSearchCond;

/**
  * 概述: 发文流程统计DAO接口
  * 功能描述: 发文流程统计DAO接口
  * 创建记录: 2013/02/27
  * 修改记录: 
  */
public interface DispatchStatisticsVWDAO extends BaseHibernateDAO<DispatchStatisticsVWInfo> {

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<DispatchStatisticsVWInfo> findAll();

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public DispatchStatisticsVWInfo findByPK(Serializable pk);

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final DispatchStatisticsVWSearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<DispatchStatisticsVWInfo> findByCond(
			final DispatchStatisticsVWSearchCond cond, final int start,
			final int count);
	
	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	public List<DispatchStatisticsVWInfo> findDispatchStatistics(
			final DispatchStatisticsVWSearchCond cond, final int start,final int count);
	
	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	public int findDispatchStatisticsSearchCount(
			final DispatchStatisticsVWSearchCond cond);

}