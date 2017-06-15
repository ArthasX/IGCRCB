/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.soc.mnt.model.condition;

/**
  * 概述: 监控任务主表检索条件接口
  * 功能描述: 监控任务主表检索条件接口
  * 创建记录: 2012/05/10
  * 修改记录: 
  */
public interface SOC0304SearchCond {
	
	/**
	 * 任务状态取得
	 *
	 * @return mtStatus 任务状态
	 */
	public String getMtStatus();
	
	/**
	 * 磁盘序列号取得
	 *
	 * @return mtSsn 磁盘序列号
	 */
	public String getMtSsn();
}