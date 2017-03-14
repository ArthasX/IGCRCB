/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.soc.mnt.model.condition;

/**
  * 概述: 监控任务主表检索条件实现
  * 功能描述: 监控任务主表检索条件实现
  * 创建记录: 2012/05/10
  * 修改记录: 
  */
public class SOC0304SearchCondImpl implements
		SOC0304SearchCond {
	/** 任务状态 */
	protected String mtStatus;
	
	/** 磁盘序列号 */
	protected String mtSsn;
	/**
	 * 任务状态取得
	 *
	 * @return mtStatus 任务状态
	 */
	public String getMtStatus() {
		return mtStatus;
	}

	/**
	 * 任务状态设定
	 *
	 * @param mtStatus 任务状态
	 */
	public void setMtStatus(String mtStatus) {
		this.mtStatus = mtStatus;
	}

	/**
	 * 磁盘序列号取得
	 *
	 * @return mtSsn 磁盘序列号
	 */
	public String getMtSsn() {
		return mtSsn;
	}

	/**
	 * 磁盘序列号设定
	 *
	 * @param mtSsn 磁盘序列号
	 */
	public void setMtSsn(String mtSsn) {
		this.mtSsn = mtSsn;
	}
	
	
	
}