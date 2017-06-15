/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.igflow.parameter;

/**
 * 流程中止信息
 */
public class SuspendProcess implements SuspendProcessInfo {
	
	/** 日志参数信息 */
	private WorkFlowLogInfo logInfo;
	
	/**
	 * 构造函数
	 * 
	 * @param logInfo 日志参数信息
	 */
	public SuspendProcess(WorkFlowLogInfo logInfo) {
		this.logInfo = logInfo;
	}

	/**
	 * 日志参数信息取得
	 * 
	 * @return 日志参数信息
	 */
	public WorkFlowLogInfo getLogInfo() {
		return logInfo;
	}

	/**
	 * 日志参数信息设定
	 * 
	 * @param logInfo 日志参数信息
	 */
	public void setLogInfo(WorkFlowLogInfo logInfo) {
		this.logInfo = logInfo;
	}
}
