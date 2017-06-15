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
 * Description: 事件管理（SVC）事件业务逻辑所需常量
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */

public class IGSRV02BLType {
	
	/*------------------事件状态------------------*/

	/** 发起 */
	public static final String PROCESS_STATUS_WAITING_INIT = "I";
	/** 等待分派 */
	public static final String PROCESS_STATUS_WAITING_DISPATCH = "P";
	/** 等待确认 */
	public static final String PROCESS_STATUS_WAITING_CONFIRM = "D";
	/** 等待处理 */
	public static final String PROCESS_STATUS_WAITING_IMPLEMENT = "E";
	/** 等待审核 */
	public static final String PROCESS_STATUS_WAITING_VERIFY = "V";
	/** 已经关闭 */
	public static final String PROCESS_STATUS_CLOSE = "C";
	
	/** 等待分派 */
	public static final char PROCESS_STATUS_WAITING_DISPATCH_CHAR = 'P';
	/** 等待处理 */
	public static final char PROCESS_STATUS_WAITING_IMPLEMENT_CHAR = 'E';
	/** 等待审核 */
	public static final char PROCESS_STATUS_WAITING_VERIFY_CHAR = 'V';
	/** 已经关闭 */
	public static final char PROCESS_STATUS_CLOSE_CHAR = 'C';

	/*------------------事件参与者状态------------------*/
	
	/** 发起 */
	public static final String PARTICIPANT_STATUS_INITIAL = "I";
	/** 分派 */
	public static final String PARTICIPANT_STATUS_DISPATCH = "P";
	/** 处理 */
	public static final String PARTICIPANT_STATUS_IMPLEMENT = "E";
	/** 审核 */
	public static final String PARTICIPANT_STATUS_VERIFY = "V";

	/*------------------事件处理可能出现的结果(暂时没用)------------------*/

	/** 审批通过 */
	public static final String PARTICIPANT_RESULTS_YES = "Y";
	/** 审批不通过 */
	public static final String PARTICIPANT_RESULTS_NO = "N";
	/** 异常中止 */
	public static final String PARTICIPANT_RESULTS_CANCEL = "C";
	/** 审核通过 */
	public static final String PARTICIPANT_RESULTS_SUCCESS = "S";
	/** 审核部通过 */
	public static final String PARTICIPANT_RESULTS_FAIL = "F";
	
	public static final String PROCESS_RLDESC_INITIAL_MESSAGE = "发起事件";
	public static final String PROCESS_RLDESC_ADD_COMMENT_MESSAGE = "更新信息";
	public static final String PROCESS_RLDESC_NOTARIZE_MESSAGE = "确认事件";
	public static final String PROCESS_RLDESC_ADD_IMPLEMENTOR_MESSAGE = "添加处理人";
	public static final String PROCESS_RLDESC_ASSIGNPERSON_MESSAGE = "设定执行人";
	public static final String PROCESS_RLDESC_ADD_VERIFIOR_MESSAGE = "添加审核人";
	public static final String PROCESS_RLDESC_REMOVE_VERIFIOR_MESSAGE = "删除审核人";
	public static final String PROCESS_RLDESC_REMOVE_IMPLEMENTOR_MESSAGE = "删除处理人";
	public static final String PROCESS_RLDESC_ADD_ASSIGN_MESSAGE = "分派处理人";
	public static final String PROCESS_RLDESC_IMPLEMENT_MESSAGE = "处理事件";
	public static final String PROCESS_RLDESC_TERMINATE_MESSAGE = "中止事件";
	public static final String PROCESS_RLDESC_CONFIRM_MESSAGE = "确认事件";
	public static final String PROCESS_RLDESC_ADJUST_LEVEL_MESSAGE = "调整事件级别";
	public static final String PROCESS_RLDESC_VERIFY_SUCCESS_MESSAGE = "审核结果：通过";
	public static final String PROCESS_RLDESC_VERIFY_FAIL_MESSAGE = "审核结果：不通过";
	
	public static final String ACTION_NONE = "None";
	//事件详细页面中的ActionName
	public static final String PROCESS_ACTION_ADDCOMMENT = "ACT01SVC02031";
	public static final String PROCESS_ACTION_IMPLEMENTORS = "ACT01SVC02032";
	public static final String PROCESS_ACTION_VERIFIORS = "ACT01SVC02033";
	public static final String PROCESS_ACTION_IMPLEMENT = "ACT01SVC02034";
	public static final String PROCESS_ACTION_VERIFY = "ACT01SVC02035";
	public static final String PROCESS_ACTION_ADJUSTLEVEL = "ACT01SVC02036";
	public static final String PROCESS_ACTION_TERMINATE = "ACT01SVC02037";
	public static final String PROCESS_ACTION_DISPATCH = "ACT01SVC02038";
	public static final String PROCESS_ACTION_MANAGER = "ACT01SVC02039";
	
	//事件页面中的info表单
	public static final String PROCESS_PRT_USERNAME = "报告人姓名";
	public static final String PROCESS_PRT_ORGNAME = "报告人部门";
	public static final String PROCESS_PRT_ORGSYSCODING = "报告人部门编码";
	public static final String PROCESS_PRT_USERCONNECT = "报告人联系方式";
	public static final String PROCESS_AFT_USERNAME = "影响人姓名";
	public static final String PROCESS_AFT_ORGNAME = "影响人部门";
	public static final String PROCESS_AFT_ORGSYSCODING = "影响人部门编码";
	public static final String PROCESS_AFT_USERCONNECT = "影响人联系方式";
	
	public static final String PROCESS_PRT_USERNAME_ID = "PRT_USERNAME";
	public static final String PROCESS_PRT_ORGNAME_ID = "PRT_ORGNAME";
	public static final String PROCESS_PRT_ORGSYSCODING_ID = "PRT_ORGSYSCODING";
	public static final String PROCESS_PRT_USERCONNECT_ID = "PRT_USERCONNECT";
	public static final String PROCESS_AFT_USERNAME_ID = "AFT_USERNAME";
	public static final String PROCESS_AFT_ORGNAME_ID = "AFT_ORGNAME";
	public static final String PROCESS_AFT_ORGSYSCODING_ID = "AFT_ORGSYSCODING";
	public static final String PROCESS_AFT_USERCONNECT_ID = "AFT_USERCONNECT";

	public static final String OPTION_TYPE = "2";
	
	
	/*------------------日志信息------------------*/
	public static final String COMMENT_WAITING_DISPATCH = "等待分派";
	public static final String COMMENT_DISPATCH = "已经分派";
	public static final String COMMENT_WAITING_IMPLEMENT = "等待处理";
	public static final String COMMENT_IMPLEMENT = "已经处理";
	public static final String COMMENT_WAITING_VERIFY = "等待审核";
	public static final String COMMENT_VERIFY = "已经审核";
	public static final String COMMENT_SAVE_INITIALOR = "保存发起人";
	public static final String COMMENT_SAVE_DISPATCHOR = "保存分派人";
	public static final String COMMENT_SAVE_VERIFIOR = "保存审核人";
	
	public static final String STATUS_COMMENT_DISPATCH = "流程状态转至等待分派";
	public static final String STATUS_COMMENT_CONFIRM = "流程状态转至等待确认";
	public static final String STATUS_COMMENT_IMPLEMENT = "流程状态转至等待处理";
	public static final String STATUS_COMMENT_VERIFY = "流程状态转至等待审核";
	public static final String STATUS_COMMENT_CLOSE = "流程已经关闭";
	
	public static final String COMMENT_MESSAGE_DISPATCH = "进行分派";
	public static final String COMMENT_MESSAGE_ADJUST = "调整";
	/*------------------参与者子状态信息------------------*/
	/** 已确认 */
	public static final String PROCESS_SUB_STATUS_CONFIRMED = "0";
	/** 未确认 */
	public static final String PROCESS_SUB_STATUS_CONFIRM = "1";
	
	
	/*------------------流程类型-----------------------*/
	/** 事件 */
	public static final String PROCESS_INCIDENT_I = "1";
	/** 自定义事件 */
	public static final String PROCESS_INCIDENT_ID = "9";
}
