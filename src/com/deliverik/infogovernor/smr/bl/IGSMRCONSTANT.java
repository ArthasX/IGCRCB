/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.smr.bl;

/**
 * 常量
 */
public class IGSMRCONSTANT {

	/** 填报状态：0开启 */
	public static final String REPORT_STATUS_BEGIN = "0";
	/** 填报状态：1关闭*/
	public static final String REPORT_STATUS_END = "1";
	/** 填报状态：2中止 */
	public static final String REPORT_STATUS_STOP = "2";
	
	/** 监管报表管理 */
	public static final String ROLETYPE_REPORT = "IGBP07";
	
	/** 审批意见状态为：有效 */
	public static final String APPROVE_STATUS_YES = "0";
	
	/** 审批意见状态为：无效 */
	public static final String APPROVE_STATUS_NO = "1";

	/** 年报流程类型*/
	public static final String PRYTPE_REPORT = "WD1";
	
	/** 季报流程类型*/
	public static final String PRYTPE_QUARTER = "WD2";
	
	/** 月报流程类型*/
	public static final String PRYTPE_MONTH = "WD4";
	
	/** 待发起状态名*/
	public static final String PRSTATUSNAME_START = "待发起";
	
	/** 填报流程状态名*/
	public static final String PRSTATUSNAME_REPORT = "报表填报";
	
	/** 一级审批流程状态名*/
	public static final String PRSTATUSNAME_FIRSTEXAMINE = "报表审批";

	/** 二级审批流程状态名*/
	public static final String PRSTATUSNAME_SECONDEXAMINE = "年报审批";
	
	/** 季报二级审批流程状态名*/
	public static final String PRSTATUSNAME_SECONDE = "季报审批";
	
	/** 月报二级审批流程状态名*/
	public static final String PRSTATUSNAME_MONTHSECONDE = "月报报表审批";

	/** 是否包含审批意见：是 */
	public static final String HASH_APPROVE_IDEA_YES = "Y";
	/** 是否包含审批意见：否 */
	public static final String HASH_APPROVE_IDEA_NO = "N";
	/** 定时的时刻*/
	public static final String MOMENT = "8";
	
	
	/** 不定期报表流程类型*/
	public static final String PRTYPE_IRREGULAR = "WD3";
	
	/** 不定期二级审批流程状态名*/
	public static final String PRSTATUSNAME_IRREGULAREXAMINE = "不定期报表审批";
	
	/** 年报填报角色类型 */
	public static final String YEAR_REPORT = "IGBP09";
	
	/** 季报填报角色类型 */
	public static final String QUARTER_REPORT = "IGBP10";
	
	/** 不定期报表填报角色类型 */
	public static final String NONSKED_REPORT = "IGBP11";
	
	/** 年报负责人角色类型 */
	public static final String YEAR_REPORT_MANAGER = "IGBP12";
	
	/** 季报负责人角色类型 */
	public static final String QUARTER_REPORT_MANAGER = "IGBP13";
	
	/** 不定期报表负责人角色类型 */
	public static final String NONSKED_REPORT_MANAGER = "IGBP14";
	
	/** 月报负责人角色类型 */
	public static final String MONTH_REPORT_MANAGER = "IGBP10";
	
	/** 报送空表表单名称*/
	public static final String BAOSONG_NULLTABLE = "报送空表";
	
	/** 未指定参与人*/
	public static final String NOAPPOINT = "未指定";
	
	/** 年报发起菜单ID */
	public static final String ACTION_YEAR = "ACT12SMR0201";
	
	/** 季报发起菜单ID */
	public static final String ACTION_QUARTER = "ACT12SMR0301";
	
	/** 不定期发起菜单ID */
	public static final String ACTION_NONSKED = "ACT12SMR0401";
	
	/** 月报发起菜单ID */
	public static final String ACTION_MONTH = "ACT12SMR0601";
}
