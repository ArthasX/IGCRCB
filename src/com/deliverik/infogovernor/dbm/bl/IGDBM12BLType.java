/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.dbm.bl;


/**
 * CRCB_Dashboard添加
 */
public final class IGDBM12BLType {
	//-----------流程定义主键-----------
	//服务工单
	public static final String PROCESSRECORD_PRPDID_L = "01380";
	//故障申报与事件
	public static final String PROCESSRECORD_PRPDID_I = "01080";
	//业务服务请求
	public static final String PROCESSRECORD_PRPDID_YS = "01101";
	//问题
	public static final String PROCESSRECORD_PRPDID_P = "01083";
	//变更
	public static final String PROCESSRECORD_PRPDID_C = "01084";
	//科技服务请求
	public static final String PROCESSRECORD_PRPDID_S = "01100";
	//指派工作
	public static final String PROCESSRECORD_PRPDID_AW = "01382";
	
	//-----------角色主键-----------
	//业务人员
	public static final int ROLE_ROLEID_1146 = 1146;
	//业务领导审批
	public static final int ROLE_ROLEID_1201 = 1201;

	//-----------流程定义主键-科技风险-----------
	//风险计划0100301
	public static final String PROCESSRECORD_PRPDID_RISK1 = "0100301";
	//评估任务0100101
	public static final String PROCESSRECORD_PRPDID_RISK2 = "0100101";
	//问题整改0100201
	public static final String PROCESSRECORD_PRPDID_RISK3 = "0100201";
	
	//-----------资产定义主键-科技风险-----------
	//风险点>风险点分类
	public static final String PROCESSRECORD_EID_RISK1 = "CM14000000";
	//检查项
	public static final String PROCESSRECORD_EID_RISK2 = "CM15000000";
	//风险清单>风险事件
	public static final String PROCESSRECORD_EID_RISK3 = "CM20000000";
	
	
}
	
	
	
	
