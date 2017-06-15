/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.dut.bl;


/**
 * 
 * 值班管理常量类
 *
 */
public final class IGDUTCONSTANTS {
	
	//------------------------------------值班检查项使用状态-----------------------------------------------------

	/** 值班检查项状态 启用 */
	public static final String DUTY_STATUS_ENABLE = "1";
	/** 值班检查项状态 停用 */
	public static final String DUTY_STATUS_DISABLE = "2";
	
	//------------------------------------值班检查管理查询-----------------------------------------------------

	/** 值班检查状态 启用 */
	public static final String DUTYAUDIT_STATUS_ENABLE = "0";
	/** 值班检查状态 停用 */
	public static final String DUTYAUDIT_STATUS_DISABLE = "1";
	
	//------------------------------------值班交接-----------------------------------------------------
	
	/** 值班计划状态 未执行 */
	public static final String PLAN_STATUS_UNEXECUTE= "1";
	/** 值班计划状态 执行中 */
	public static final String PLAN_STATUS_EXECUTING= "2";
	/** 值班计划状态 已执行 */
	public static final String PLAN_STATUS_EXECUTED= "3";
	/** 值班计划状态 中止 */
	public static final String PLAN_STATUS_TERMINATE= "4";
	
	//------------------------------------值班人设定-----------------------------------------------------
	public static final String USER_ROLE_TYPE= "IGDU01";
	//白班
	public static final String DAY_SHIFT= "1";
	//夜班
	public static final String NIGHT_SHIFT= "2";
	//值班管理夜班时间段CCID
	public static final String NIGHT_SHIFT_PERIOD = "202";
	//值班管理夜班时间段CCID
	public static final String DUTY_RESULT_NORMAL = "0001";
	
	
	//------------------------------------值班日报-----------------------------------------------------
	/** 检查结果 可选择 */
	public static final String DADCONTENT_SHOW_ABLE = "show";
	/** 检查结果 不可选择 */
	public static final String DADCONTENT_SHOW_DISABLE = "disabled";
	
	
	//------------------------------------日常维修进入区域设定-----------------------------------------------------
	/** 进入区域CheckBOX ccid */
	public static final String ODPRAREA_LIST_KEY = "275";
	//------------------------------------延时解锁申请标题-----------------------------------------------------
	
	public static final String 	DELAY_TITLE = "1";
}
