/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.drm.bl.task;

import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.drm.model.condition.StatisticsSearchCond;

/**
 * 概述：应急管理统计查询BL接口
 * 功能描述：应急管理统计查询BL接口
 * 创建记录：2015/5/23
 * zhangjian
 */
public interface StatisticsBL extends BaseBL {
	/**
	 * 预案统计查询
	 * 统计预案总数,修订数量,演练数量
	 * @return
	 */
	public List<Map<String,Object>> planStatistics(StatisticsSearchCond cond)throws BLException;
	/**
	 * 演练统计查询
	 * 演练计划统计,演练任务统计,演练执行统计
	 * @return
	 */
	public List<Map<String,Object>> drillStatistics(StatisticsSearchCond cond )throws BLException;
	/**
	 * 演练形式统计
	 * 
	 * @return
	 */
	public List<Map<String,Object>> drillTypeStatistics(StatisticsSearchCond cond )throws BLException;
	/**
	 * 预案统计-查询预案资产eiid
	 * @return
	 */
	public List<Map<String, Object>> getSceneEiids(StatisticsSearchCond cond ) throws BLException;
}