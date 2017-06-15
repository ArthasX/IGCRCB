/*
 * 沈阳递蓝科信息技术有限公司版权所有，保留所有权利。
 * Copyright 2009 Deliverik Co. Ltd.， All rights reserved.
 */

package com.deliverik.infogovernor.fxk.bl;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 风险计划所需常量
 * </p>
 */
public class IGFXK03BLType {

	
	/** 风险计划中负责人所在角色的roleid数组 */
	public static final Integer[] RISK_MANAGER_PERSON = new Integer[]{1224};
	
	/** 风险计划流程类型ID */
	public static final String PROCESS_RISK_PDID = "01003";
	
	/** 风险计划流程-表格式表单名称 */
	public static final String RISK_TABLE_NAME = "工作列表";
	
	/** 风险计划流程-表格式表单-列名-关联工作 */
	public static final String RISK_TABLE_NAME_COLNAMEUM_JOB = "关联工作";
	/** 风险计划流程-表格式表单-列名-工作提醒时间 */
	public static final String RISK_TABLE_NAME_COLNAMEUM_REMTIME = "工作提醒时间";
	/** 风险计划流程-表格式表单-列名-负责人 */
	public static final String RISK_TABLE_NAME_COLNAMEUM_MANAGER = "负责人";
	/** 风险计划流程-表格式表单-列名-工作名称 */
	public static final String RISK_TABLE_NAME_COLNAMEUM_WORKNAME = "工作名称";
	/** 风险计划流程-表格式表单-列名-工作说明 */
	public static final String RISK_TABLE_NAME_COLNAMEUM_WORKDESC = "工作说明";
	/** 风险计划流程-表格式表单-列名-状态 */
	public static final String RISK_TABLE_NAME_COLNAMEUM_STATUS = "状态";
}
