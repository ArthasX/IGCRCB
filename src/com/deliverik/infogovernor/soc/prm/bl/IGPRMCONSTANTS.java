/*
 * 沈阳递蓝科信息技术有限公司版权所有，保留所有权利。
 * Copyright 2009 Deliverik Co. Ltd.， All rights reserved.
 */

package com.deliverik.infogovernor.soc.prm.bl;

import com.deliverik.infogovernor.svc.bl.IGPROCESSType;

/**
 * 快捷发起相关常量类
 * 
 */
public class IGPRMCONSTANTS {

	/** 事件可以快捷发起的流程类型标识（问题，变更） */
	public static final String[] QUICK_PROCESS_RELATION_TYPE_I = {
			IGPROCESSType.PROBLEM_PRTYPE, IGPROCESSType.CHANGE_PRTYPE};
			
	/** 问题可以快捷发起的流程类型标识（变更） */
	public static final String[] QUICK_PROCESS_RELATION_TYPE_P = {
		IGPROCESSType.CHANGE_PRTYPE};
	
	/** 变更通过快捷发起关联的流程类型标识（事件，问题） */
	public static final String[] QUICK_PROCESS_RELATION_TYPE_C = {
		IGPROCESSType.INCIDENT_PRTYPE, IGPROCESSType.PROBLEM_PRTYPE};
	
	/** 弹出查看页面用，显示相关流程（事件，问题，变更） */
	public static final String[] PROCESSDISP_ALL = {
		IGPROCESSType.INCIDENT_PRTYPE, IGPROCESSType.PROBLEM_PRTYPE,IGPROCESSType.CHANGE_PRTYPE};
	
	/** 服务工单通过快捷发起关联的流程类型标识（事件，问题，服务） */
	public static final String[] QUICK_PROCESS_RELATION_TYPE_SF = {
		IGPROCESSType.INCIDENT_PRTYPE, IGPROCESSType.PROBLEM_PRTYPE, IGPROCESSType.SERVICE_PRTYPE};
	
	/** 事件查看页面显示相关流程（问题，变更） */
	public static final String[] PROCESSDISP_I = {
		IGPROCESSType.PROBLEM_PRTYPE,IGPROCESSType.CHANGE_PRTYPE};
	
	/** 问题查看页面显示相关流程（事件，变更） */
	public static final String[] PROCESSDISP_P = {
		IGPROCESSType.INCIDENT_PRTYPE, IGPROCESSType.CHANGE_PRTYPE};
	
	/** 变更查看页面显示相关流程（事件，问题） */
	public static final String[] PROCESSDISP_C = {
		IGPROCESSType.INCIDENT_PRTYPE, IGPROCESSType.PROBLEM_PRTYPE};
	
	/** 服务工单查看页面显示相关流程（事件，问题，服务） */
	public static final String[] PROCESSDISP_SF = {
		IGPROCESSType.INCIDENT_PRTYPE, IGPROCESSType.PROBLEM_PRTYPE, IGPROCESSType.SERVICE_PRTYPE};
	
	
	/** 问题快捷发起页面URL */
	public static final String QUICK_PROCESS_INIT_PAGE_P = "/IGSVC0315_Disp.do";
	
	/** 变更快捷发起页面URL */
	public static final String QUICK_PROCESS_INIT_PAGE_C = "/IGSVC0422_Disp.do";
		
	/** 服务工单快捷发起事件页面URL */
	public static final String QUICK_PROCESS_INIT_PAGE_SF_I = "/IGSVC0217_Disp.do";
	
	/** 服务工单快捷发起问题页面URL */
	public static final String QUICK_PROCESS_INIT_PAGE_SF_P = "/IGSVC0317_Disp.do";
	
	/** 服务工单快捷发起服务页面URL */
	public static final String QUICK_PROCESS_INIT_PAGE_SF_S = "/IGSVC0822_Disp.do";
	
	/** 服务工单快捷发起自定义事件页面URL */
	public static final String QUICK_PROCESS_INIT_PAGE_SF_W = "/IGPRR0113_Disp.do";
}
