/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.smr.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.smr.model.AnnualReportVWInfo;
import com.deliverik.infogovernor.smr.model.BatchExamineVWInfo;
import com.deliverik.infogovernor.smr.model.RegulatoryReportInstanceInfo;
import com.deliverik.infogovernor.smr.model.ReportHistorySearchVWInfo;
import com.deliverik.infogovernor.smr.model.condition.RegulatoryReportInstanceSearchCond;

/**
  * 概述: 报表填报实例表DAO接口
  * 功能描述: 报表填报实例表DAO接口
  * 创建记录: 2013/07/18
  * 修改记录: 
  */
public interface RegulatoryReportInstanceDAO extends BaseHibernateDAO<RegulatoryReportInstanceInfo> {

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<RegulatoryReportInstanceInfo> findAll();

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public RegulatoryReportInstanceInfo findByPK(Serializable pk);

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final RegulatoryReportInstanceSearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<RegulatoryReportInstanceInfo> findByCond(
			final RegulatoryReportInstanceSearchCond cond, final int start,
			final int count);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<RegulatoryReportInstanceInfo> findByCond(
			final RegulatoryReportInstanceSearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<AnnualReportVWInfo> findAnnualReportByCond(
			final RegulatoryReportInstanceSearchCond cond,final int start,final int count);
	
	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<RegulatoryReportInstanceInfo> findSectionAnnualReportByCond(
			final RegulatoryReportInstanceSearchCond cond,final int start,final int count);
	
	/**
	 * 查询年报审批节点的所有流程
	 * @return 检索结果列表
	 */
	public List<BatchExamineVWInfo> findBatchExanmie(final RegulatoryReportInstanceSearchCond cond);
	
	
	/**
	 * 查询报表历史
	 * @return 检索结果列表
	 */
	public List<ReportHistorySearchVWInfo> findReportHistory(final RegulatoryReportInstanceSearchCond cond,final int start,final int count);
	
	/**
	 * 查询报表历史条数
	 * @return 检索结果列表
	 */
	public int findReportHistoryCount(final RegulatoryReportInstanceSearchCond cond);
	
	/**
	 * 条件检索处理
	 * 
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public void deleteTestInstance() throws BLException;
	
	/**
	 * 填报监督
	 * 
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public List<AnnualReportVWInfo> lookatFillIn(final RegulatoryReportInstanceSearchCond cond);
}