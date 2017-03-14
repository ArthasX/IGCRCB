/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.igflow.api;

import com.deliverik.framework.workflow.IGPRDCONSTANTS;

/**
 * 流程二次开发常量类定义
 */
public final class Constants {

	/** 流程定义启用状态标识 */
	public static final String PD_STATUS_ENABLE = "a";

	/** 流程定义测试状态标识 */
	public static final String PD_STATUS_TEST = "t";
	
	/** 流程发起状态标识 */
	public static final String PROCESS_STATUS_START = "Z";

	/** 流程日志系统类型标识 */
	public static final String PROCESS_LOG_TYPE_SYSTEM = IGPRDCONSTANTS.RECORDLOG_TYPE_XTRZ;
	
	/** 流程日志处理类型标识 */
	public static final String PROCESS_LOG_TYPE_PROCESSING = IGPRDCONSTANTS.RECORDLOG_TYPE_CL;
	
	/** 二次开发调试日志别名 */
	public static final String IGFLOW_LOG_NAME = "igflow";
	
	/** 监管报表类型_年报 */
	public static final String REGULATORYREPORT_TYPE_YEAR = "WD1";
	
	/** 监管报表类型_季报 */
	public static final String REGULATORYREPORT_TYPE_SEASON = "WD2";
	
	/** 监管报表类型_不定期报表 */
	public static final String REGULATORYREPORT_TYPE_IRREGULAR = "WD3";

}
