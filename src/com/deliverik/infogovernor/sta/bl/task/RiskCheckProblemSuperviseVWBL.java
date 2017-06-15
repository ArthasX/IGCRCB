/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.sta.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.prr.model.entity.DispatchStatisticsVW;
import com.deliverik.infogovernor.sta.model.RiskCheckProblemSuperviseVWInfo;
import com.deliverik.infogovernor.sta.model.condition.RiskCheckProblemSuperviseVWSearchCond;

/**
  * 概述: 问题整改监督业务逻辑接口
  * 功能描述: 问题整改监督业务逻辑接口
  * 创建记录: 2013/02/27
  * 修改记录: 
  */
public interface RiskCheckProblemSuperviseVWBL extends BaseBL {

	/**
	 * 发文流程统计实例取得
	 *
	 * @return 发文流程统计实例
	 */
	public DispatchStatisticsVW getDispatchStatisticsVWTBInstance();

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<RiskCheckProblemSuperviseVWInfo> searchDispatchStatisticsVW();

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public RiskCheckProblemSuperviseVWInfo searchDispatchStatisticsVWByPK(String pk)
		throws BLException;

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(RiskCheckProblemSuperviseVWSearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<RiskCheckProblemSuperviseVWInfo> searchDispatchStatisticsVW(
			RiskCheckProblemSuperviseVWSearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<RiskCheckProblemSuperviseVWInfo> searchDispatchStatisticsVW(
			RiskCheckProblemSuperviseVWSearchCond cond, int start,
			int count);

	
	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<RiskCheckProblemSuperviseVWInfo> findDispatchStatisticsVW(
			RiskCheckProblemSuperviseVWSearchCond cond, int start,int count);
	
	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getRiskCheckProblemSuperviseSearchCount(RiskCheckProblemSuperviseVWSearchCond cond);

}