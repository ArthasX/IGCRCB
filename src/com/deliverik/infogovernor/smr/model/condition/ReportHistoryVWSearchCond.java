/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.smr.model.condition;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 报表历史填报记录视图查询条件接口
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public interface ReportHistoryVWSearchCond {
	
	/**
	 * 组类型取得
	 * @return prtype 组类型
	 */
	public String getPrtype();

	/**
	 * 流程定义ID取得
	 * @return pdid 流程定义ID
	 */
	public String getPdid();
	
	/**
	 * 当前流程ID取得
	 * @return currentPrid 当前流程ID
	 */
	public Integer getCurrentPrid();
}
