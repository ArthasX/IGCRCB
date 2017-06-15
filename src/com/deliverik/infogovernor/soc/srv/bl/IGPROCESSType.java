/*
 * 沈阳递蓝科信息技术有限公司版权所有，保留所有权利。
 * Copyright 2009 Deliverik Co. Ltd.， All rights reserved.
 */

package com.deliverik.infogovernor.soc.srv.bl;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 流程管理_流程类型常量类（最大长度为3位，工作类型以W开头）
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @History 2010-7-13     0000000: 增加服务工单快捷发起流程类别
 * @version 1.0
 */

public class IGPROCESSType {
	/*------------------流程类型------------------*/
	
	/** 事件 */
	public static final String INCIDENT_PRTYPE = "I";
	/** 变更 */
	public static final String CHANGE_PRTYPE = "C";
	/** 问题 */
	public static final String PROBLEM_PRTYPE = "P";
	/** 发布 */
	public static final String DEPLOYMENT_PRTYPE = "D";	
	/** 服务请求 */
	public static final String SERVICE_PRTYPE = "S";
	//update by 0000000 begin
	/** 工单请求 */
	public static final String SERVICE_FORM = "SF";
	//update by 0000000 end
	/** 自定义事件 */
	public static final String INCIDENT_PRTYPE_D = "ID";
	/** 自定义问题 */
	public static final String PROBLEM_PRTYPE_D = "PD";
	/** 自定义变更 */
	public static final String CHANGE_PRTYPE_D = "CD";
	/** 自定义发布 */
	public static final String DEPLOYMENT_PRTYPE_D = "DD";
	/** 自定义服务请求 */
	public static final String SERVICE_PRTYPE_D = "SD";
	
	/** 工作类型起始字母 */
	public static final String WORK_PRTYPE = "W";
	/** 指派工作 */
	public static final String NEW_WORK_PRTYPE_1 = "WA";
	/** 个人工作 */
	public static final String NEW_WORK_PRTYPE_2 = "WB";
	/** 自定义工作 */
	public static final String SELF_DEFINING_WORK_PRTYPE = "WD";
	
	/** 
	 * 根据流程类型返回流程类型对应的名称，供图形化统计流程数量使用，新增流程类型时需同时增加对应的流程名称
	 */
	public static String getTypeName(String type){
		String name = "";
		if(INCIDENT_PRTYPE.equals(type)){
			name = "事件";
		}else if(CHANGE_PRTYPE.equals(type)){
			name = "变更";
		}else if(PROBLEM_PRTYPE.equals(type)){
			name = "问题";
		}else if(DEPLOYMENT_PRTYPE.equals(type)){
			name = "发布";
		}else if(SERVICE_PRTYPE.equals(type)){
			name = "服务请求";
		}else if(NEW_WORK_PRTYPE_1.equals(type)){
			name = "指派工作";
		}else if(NEW_WORK_PRTYPE_2.equals(type)){
			name = "个人工作";
		}else if(SELF_DEFINING_WORK_PRTYPE.equals(type)){
			name = "自定义工作";
		}
		return name;
	}
}
