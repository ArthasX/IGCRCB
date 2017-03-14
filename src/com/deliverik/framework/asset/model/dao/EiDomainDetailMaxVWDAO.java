/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.asset.model.dao;

import java.util.List;

import com.deliverik.framework.asset.EiDomainDetailCIInfo;
import com.deliverik.framework.asset.model.EiDomainDetailMaxVWInfo;
import com.deliverik.framework.asset.model.condition.EiDomainDetailMaxVWSearchCond;

/**
 * 概述: 资产域明细表DAO接口
 * 功能描述: 资产域明细表DAO接口
 * 创建记录: 2011/05/25
 * 修改记录: 
 */
public interface EiDomainDetailMaxVWDAO {
	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final EiDomainDetailMaxVWSearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<EiDomainDetailMaxVWInfo> findByCond(
			final EiDomainDetailMaxVWSearchCond cond, final int start,
			final int count);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<EiDomainDetailMaxVWInfo> findBySQL(final EiDomainDetailMaxVWSearchCond cond, final int start, final int count);

	/**
	 * 根据影响CI查询条数
	 * @param eiDomainDetailVWSearchCond
	 * @return
	 */
	public int getSearchCountCI(EiDomainDetailMaxVWSearchCond cond);

	/**
	 * 根据影响CI查询
	 * @param eiDomainDetailVWSearchCond
	 * @param fromCount
	 * @param pageDispCount
	 * @return
	 */
	public List<EiDomainDetailCIInfo> findBySQLCI(
			EiDomainDetailMaxVWSearchCond cond, int start, int count);

}
