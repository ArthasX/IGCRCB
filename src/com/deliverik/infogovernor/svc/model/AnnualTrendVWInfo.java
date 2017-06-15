/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.svc.model;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 年度工作趋势统计接口
 * </p>
 * 
 * @author wanglei@deliverik.com
 * @version 1.0
 */
public interface AnnualTrendVWInfo {

	/**
	 * 事件统计数量取得
	 * @return incidentnum 事件统计数量
	 */
	public Integer getIncidentnum();
	
	/**
	 * 问题统计数量取得
	 * @return problemnum 问题统计数量
	 */
	public Integer getProblemnum();
	
	/**
	 * 变更统计数量取得
	 * @return changenum 变更统计数量
	 */
	public Integer getChangenum();
	
	/**
	 * 服务请求统计数量取得
	 * @return servicenum 服务请求统计数量
	 */
	public Integer getServicenum();
	
	/**
	 * 服务工单统计数量取得
	 * @return sfnum 服务工单统计数量
	 */
	public Integer getSfnum();
	
	/**
	 * 日期取得
	 * @return propentime 日期
	 */
	public String getPropentime();
}
