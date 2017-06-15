/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.smr.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.smr.model.AnnualReportVWInfo;
import com.deliverik.infogovernor.smr.model.BatchExamineVWInfo;
import com.deliverik.infogovernor.smr.model.RegulatoryReportInstanceInfo;
import com.deliverik.infogovernor.smr.model.ReportHistorySearchVWInfo;
import com.deliverik.infogovernor.smr.model.condition.RegulatoryReportInstanceSearchCond;
import com.deliverik.infogovernor.smr.model.entity.RegulatoryReportInstanceTB;

/**
  * 概述: 报表填报实例表业务逻辑接口
  * 功能描述: 报表填报实例表业务逻辑接口
  * 创建记录: 2013/07/18
  * 修改记录: 
  */
public interface RegulatoryReportInstanceBL extends BaseBL {

	/**
	 * 报表填报实例表实例取得
	 *
	 * @return 报表填报实例表实例
	 */
	public RegulatoryReportInstanceTB getRegulatoryReportInstanceTBInstance();

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<RegulatoryReportInstanceInfo> searchRegulatoryReportInstanceInfo();

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public RegulatoryReportInstanceInfo searchRegulatoryReportInstanceInfoByPK(Integer pk)
		throws BLException;

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(RegulatoryReportInstanceSearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<RegulatoryReportInstanceInfo> searchRegulatoryReportInstanceInfo(
			RegulatoryReportInstanceSearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<RegulatoryReportInstanceInfo> searchRegulatoryReportInstanceInfo(
			RegulatoryReportInstanceSearchCond cond, int start,
			int count);

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public RegulatoryReportInstanceInfo registRegulatoryReportInstanceInfo(RegulatoryReportInstanceInfo instance)
		throws BLException;

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public RegulatoryReportInstanceInfo updateRegulatoryReportInstanceInfo(RegulatoryReportInstanceInfo instance)
		throws BLException;

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteRegulatoryReportInstanceInfoByPK(Integer pk)
		throws BLException;

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteRegulatoryReportInstanceInfo(RegulatoryReportInstanceInfo instance)
		throws BLException;

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<AnnualReportVWInfo> findAnnualReportByCond(
			final RegulatoryReportInstanceSearchCond cond,int start, int count);
	
	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<RegulatoryReportInstanceInfo> findSectionAnnualReportByCond(
			final RegulatoryReportInstanceSearchCond cond,int start, int count);
	
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
	 * 删除无效填报实例
	 * 当流程均停用后，报表流程会被删除
	 * 但实例还在且无效
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