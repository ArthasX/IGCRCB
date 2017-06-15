/*
 * 沈阳递蓝科信息技术有限公司版权所有，保留所有权利。
 * Copyright 2009 Deliverik Co. Ltd.， All rights reserved.
 */

package com.deliverik.infogovernor.prj.bl;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 项目管理（prj）所需常量
 * </p>
 */

public class IGPRJ01BLType {
	
	//项目详细页面中的按钮ActionName
	public static final String PROJECT_ACTION_MAXDOMAIN = "ACT01PRJ01000";//同管理域下的审批角色的人员可以看见所有按钮
	
	public static final String PROJECT_ACTION_XMJH = "ACT01PRJ01001";//项目计划
	public static final String PROJECT_ACTION_TZJH = "ACT01PRJ01002";//调整计划
	public static final String PROJECT_ACTION_XMJZ = "ACT01PRJ01003";//项目进展
	public static final String PROJECT_ACTION_ZTJK = "ACT01PRJ01004";//状态监控
	public static final String PROJECT_ACTION_XMRZ = "ACT01PRJ01005";//项目日志
	public static final String PROJECT_ACTION_XMGB = "ACT01PRJ01006";//项目关闭
	public static final String PROJECT_ACTION_XMZC = "ACT01PRJ01007";//项目支出
	public static final String PROJECT_ACTION_XMGZ = "ACT01PRJ01008";//项目工作
	public static final String PROJECT_ACTION_CKLS = "ACT01PRJ01009";//查看历史
	public static final String PROJECT_ACTION_FZR = "ACT01PRJ01010";//调整负责人
	public static final String PROJECT_ACTION_CYR = "ACT01PRJ01011";//调整参与人
	public static final String PROJECT_LOG_ContractTypeC = "C";//项目日志合同类型为合同签订
	public static final String PROJECT_LOG_ContractTypeJ = "J";//项目日志合同类型为付款
	public static final String USE_BUDGET="0001";//标记使用预算
	public static final String OPEN_STATUS="O";//项目状态为开启
	public static final String HASPC_Y="Y";//标记项目存在合同
	public static final String HASPC_N="N";//标记项目不存在合同
	
}
