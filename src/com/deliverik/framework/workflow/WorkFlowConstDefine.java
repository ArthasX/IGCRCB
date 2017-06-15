package com.deliverik.framework.workflow;

import com.deliverik.framework.utility.ResourceUtility;

public abstract class WorkFlowConstDefine {

	/*------------------流程系统常量------------------*/

	/** 流程角色标识 */
	public static final String PROCESS_ROLE_MARK = "IGBP";
	
	/** 流程管理角色类型 */
	public static final String PROCESSADMIN_ROLE_TYPE = "IGBP01";
	
	/** 流程审批角色类型 */
	public static final String APPROVE_ROLE_TYPE = "IGBP02";
	
	/** 流程参与角色类型 */
	public static final String PARTICIPATE_ROLE_TYPE = "IGBP03";
	
	/** 流程分派角色类型 */
	public static final String DISPATCH_ROLE_TYPE = "IGBP04";
	
	/** 运维自定义角色类型 */
	public static final String DEFINED_ROLE_TYPE = "IGBP05";
	
	/** 流程策略上报人角色类型 */
	public static final String STRATEGY_REPORTER_ROLE_TYPE = "IGBP06";
	
	/** 知识审批人角色 */
	public static final String KNOW_APPROVER_ROLE = "IGKG02";
	
	/** 分派类型-角色 */
	public static final String PPTYPE_ASSIGN_TO_ROLE = "R";
	
	/** 分派类型-人员 */
	public static final String PPTYPE_ASSIGN_TO_PERSON = "P";
	
	/** 日志未指定处理角色时显示的角色名称 */
	public static final String UnspecifiedRoleName = "未指定";
	
	/*** 一级审批人角色ID */
	public static final String DEFAULT_APPROVOR_ROLEID_ONE = "ROLEID_ONE";
	
	/** 一级审批人角色名称 */
	public static final String DEFAULT_APPROVOR_ROLENAME_ONE = "ROLENAME_ONE";
	
	/** 一级审批人用户ID */
	public static final String DEFAULT_APPROVOR_USERID_ONE = "USERID_ONE";
	
	/** 一级审批人用户名称 */
	public static final String DEFAULT_APPROVOR_USERNAME_ONE = "USERNAME_ONE";
	
	/** 一级审批人机构层次码 */
	public static final String DEFAULT_APPROVOR_ORGSYSCODING_ONE = "ORGSYSCODING_ONE";
	
	/** 一级审批人机构名称 */
	public static final String DEFAULT_APPROVOR_ORGNAME_ONE = "ORGNAME_ONE";
	
	/** 一级审批人 */
	public static final String DEFAULT_APPROVOR_ONE = "_ONE";
	
	/** 二级审批人角色ID */
	public static final String DEFAULT_APPROVOR_ROLEID_TWO = "ROLEID_TWO";
	
	/** 二级审批人角色名称 */
	public static final String DEFAULT_APPROVOR_ROLENAME_TWO = "ROLENAME_TWO";
	
	/** 二级审批人用户ID */
	public static final String DEFAULT_APPROVOR_USERID_TWO = "USERID_TWO";
	
	/** 二级审批人用户名称 */
	public static final String DEFAULT_APPROVOR_USERNAME_TWO = "USERNAME_TWO";
	
	/** 二级审批人机构层次码 */
	public static final String DEFAULT_APPROVOR_ORGSYSCODING_TWO = "ORGSYSCODING_TWO";
	
	/** 二级审批人机构名称 */
	public static final String DEFAULT_APPROVOR_ORGNAME_TWO = "ORGNAME_TWO";
	
	/** 二级审批人 */
	public static final String DEFAULT_APPROVOR_TWO = "_TWO";
	
	/** 三级审批人角色ID */
	public static final String DEFAULT_APPROVOR_ROLEID_THREE = "ROLEID_THREE";
	
	/** 三级审批人角色名称 */
	public static final String DEFAULT_APPROVOR_ROLENAME_THREE = "ROLENAME_THREE";
	
	/** 三级审批人用户ID */
	public static final String DEFAULT_APPROVOR_USERID_THREE = "USERID_THREE";
	
	/** 三级审批人用户名称 */
	public static final String DEFAULT_APPROVOR_USERNAME_THREE = "USERNAME_THREE";
	
	/** 三级审批人机构层次码 */
	public static final String DEFAULT_APPROVOR_ORGSYSCODING_THREE = "ORGSYSCODING_THREE";
	
	/** 三级审批人机构名称 */
	public static final String DEFAULT_APPROVOR_ORGNAME_THREE = "ORGNAME_THREE";
	
	/** 三级审批人 */
	public static final String DEFAULT_APPROVOR_THREE = "_THREE";
	
	/** 缺省变量类型,页面不显示 */
	public static final String DEFAULT_PID_TYPE = "S";
	
	/**具有审批步骤中的流程类型的初始变量，用于记录流程默认的审批分派人人
	 * IG007表piddesc中格式：
	 * roleid!##!rolename!##!userid!##!username!##!orgsyscoding!##!orgname!##!...
	 * */
	public static final String DEFAULT_APPROVEDISPATCHER = "DEFAULT_APPROVEDISPATCHER";
	
	/**可以在流程类型中设置流程缺省审批人*/
	public static final String DEFAULT_PROCESS_APPROVOR_TYPE = "DEFAULT_PROCESS_APPROVOR_TYPE";
	
	/**可以在流程类型中设置流程缺省审批分派人*/
	public static final String DEFAULT_PROCESS_APPROVEDISPATCH_TYPE = "DEFAULT_PROCESS_APPROVEDISPATCH_TYPE";
	
	/** 是否判断 */
	public static final String YES = "Y";
	
	/** 是否判断 */
	public static final String NO = "N";
	
	/** 缺省一级审批人审批级次 */
	public static final String DEFAULT_APPROVOR_LEVEL_ONE = "A";
	
	/** 追加一级审批人审批级次 */
	public static final String ADD_APPROVOR_LEVEL_ONE = "a";
	
	/** 缺省二级审批人审批级次 */
	public static final String DEFAULT_APPROVOR_LEVEL_TWO = "B";
	
	/** 追加二级审批人审批级次 */
	public static final String ADD_APPROVOR_LEVEL_TWO = "b";
	
	/** 缺省三级审批人审批级次 */
	public static final String DEFAULT_APPROVOR_LEVEL_THREE = "C";
	
	/** 追加三级审批人审批级次 */
	public static final String ADD_APPROVOR_LEVEL_THREE = "c";
	
	/** 缺省四级审批人审批级次 */
	public static final String DEFAULT_APPROVOR_LEVEL_FOUR = "D";
	
	/** 追加四级审批人审批级次 */
	public static final String ADD_APPROVOR_LEVEL_FOUR = "d";

	/** 审批人分隔符 */
	public static final String SPILT_APPROVORS = "!##!";
	
	/** 流程状态类型-开始*/
	public static final int STATUSTYPE_BEGIN = 0;
	
	/** 流程状态类型-普通*/
	public static final int STATUSTYPE_NORMAL = 1;
	
	/** 流程状态类型——结束*/
	public static final int STATUSTYPE_END = 2;
	
	/** 流程状态类型——中止*/
	public static final int STATUSTYPE_END_TERMINATE = 3;
	
	/** 流程相关资产 */
	public static final String PROCESS_PIVRLABEL = "相关资产";
	
	/** 自定义流程相关资产 */
	public static final String PROCESS_PIVRLABEL_PRD = "资产";
	
	/** 流程相关资产特殊标识 */
	public static final String PROCESS_PIVRNAME = "相关资产";
	
	/** 流程相关资产中类型 */
	public static final String PROCESS_PIVRTYPE = "4";
	

	/** 流程相关可过滤资产 */
	public static final String PROCESS_ASSET_PIVRTYPE = "W";

	/*------------------流程日志排序标识------------------*/

	/** 降序 */
	public static final String RECORDLOG_ORDER_DESC = "DESC";
	
	/** 升序 */
	public static final String RECORDLOG_ORDER_ASC = "ASC";
	
	/** 流程状态日志处理超时 */
	public static final String RECORDSTATUSLOG_EXPECT_YES = "1";
	
	/** 流程状态日志处理未超时 */
	public static final String RECORDSTATUSLOG_EXPECT_NO = "0";
	
	//=====================匿名标识====================================
	/** 匿名标识 */
	public static final String PROCESS_ANONYMOUS = "***";
	
	//=====================生成流程编号标识====================================
	/** 生成原格式流程编号标识 */
	public static final String FLOW_NUMBER_0 = "0";
	/** 生成新格式流程编号标识 */
	public static final String FLOW_NUMBER_1 = "1";
	/** 生成新格式流程编号标识 */
	public static final String WORKFLOW_SERIALNUM_MODE = ResourceUtility.getString("WORKFLOW_SERIALNUM_MODE");
	
	/*---------------------参数标识---------------------*/
	/** 表格式表单列值集合参数标识 */
	public static final String PARAMS_TABLE_COLUMN_VALUE = "column_value";
	/** 表格式表单列定义集合参数标识 */
	public static final String PARAMS_TABLE_COLUMN_PIDID = "column_pidid";
	/** 表格式表单列行号标识集合参数定义 */
	public static final String PARAMS_TABLE_COLUMN_ROWNUMBER = "column_rownumber";
	/** 表格式表单附件信息参数标识 */
	public static final String PARAMS_TABLE_COLUMN_FILE = "tableFormFile";
	/** 表格式表单增加附件参数标识 */
	public static final String PARAMS_TABLE_COLUMN_FILE_ADD_FLAG = "tableFormFileAddFlag";
	/** 表格式表单删除附件参数标识 */
	public static final String PARAMS_TABLE_COLUMN_FILE_DELETE_FLAG = "tableFormFileDeleteFlag";
	
}
