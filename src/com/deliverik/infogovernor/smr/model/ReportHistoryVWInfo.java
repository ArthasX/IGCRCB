/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.smr.model;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 报表历史填报记录视图实体接口
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public interface ReportHistoryVWInfo {

	/**
	 * 流程主键取得
	 * @return prid 流程主键
	 */
	public Integer getPrid() ;

	/**
	 * 组标识取得
	 * @return key 组标识
	 */
	public String getKey() ;

	/**
	 * 组类型取得
	 * @return prtype 组类型
	 */
	public String getPrtype() ;

	/**
	 * 说明取得
	 * @return reportdesc 说明
	 */
	public String getReportdesc();
}
