/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.crc.model;

/**	
 * 概述:年度工作查询伪视图
 * 创建记录：lianghongyang    2014-8-7 16:16:51	
 * 修改记录：null
 */	

public interface IGCRC2001VWInfo {

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
