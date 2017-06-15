/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.prr.bl;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 服务请求管理（SVC）服务请求业务逻辑所需常量
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */

public class IGPRR01BLType {
	/**点击“执行人”按钮时的标识*/
	public static final String PROCESS_PEOPLE="people";
	/**OA模式*/
	public static final String PROCESSMODE_OA="2";
	/**普通模式*/
	public static final String PROCESSMODE_MO="1";
	//====目标工作流程用常量值Begin
	/**  表单“申请状态”的名字 */
	public static final String PROCESSINFODEF_PIDNAME_TIME_FINISHED="预计办结时间";
	/**  表单“申请状态”的名字 */
	public static final String PROCESSINFODEF_PIDNAME_STATUS="申请状态";
	/**  表单“申请状态”的值，阶段处理完成 */
	public static final String PROCESSINFODEF_PIDNAME_STATUS_STAGE="阶段处理完成";
	/**  表单“申请状态”的值，全部处理完成 */
	public static final String PROCESSINFODEF_PIDNAME_STATUS_WHOLE="全部处理完成";
	/** 目标工作发起 */
	public static final String TARGETWORK_START_STATUS = "Z";
	/** 目标工作结束 */
	public static final String TARGETWORK_END_STATUS = "C";
	/** 目标工作分派 */
	public static final String TARGETWORK_ALLOT_STATUS = "Y";
	/** 目标工作实施处理 */
	public static final String TARGETWORK_DISPOSAL_STATUS = "X";
	/** 目标工作审批确认 */
	public static final String TARGETWORK_VALIDATE_STATUS = "W";
	/** 目标工作中止 */
	public static final String TARGETWORK_CUTOFF_STATUS = "F";
	/** 目标工作类型 */
	public static final String TARGETWORK_WORK_TYPE = "工作类型";
	/** 目标工作角色类型（首页可见目标工作的角色类型） */
	public static final String TARGETWORK_ROLE_TYPE = "IGTW01";
	//====目标工作流程用常量值End
	
	//====创意流程用常量值Begin
	/**  创意流程中“意见建议”表单的名字（pivarname） */
	public static final String PROCESSINFO_OPINION="部门意见";
	/**  创意流程中“意见建议汇总”表单的名字（pivarname） */
	public static final String PROCESSINFO_OPINION_COLLECT="部门意见汇总_collect";
	/**  创意流程中“分析评估”节点的状态 */
	public static final String PROCESS_PRSTATUS_CREATIVE_V="V";
	/**  创意流程中“提交人确认”节点的状态 */
	public static final String PROCESS_PRSTATUS_CREATIVE_Y="Y";
	/**  创意流程中“初审时请示行长”节点的状态 */
	public static final String PROCESS_PRSTATUS_CREATIVE_W="W";
	/**  创意流程中“汇总时请示行长”节点的状态 */
	public static final String PROCESS_PRSTATUS_CREATIVE_T="T";
	//====创意流程用常量值End
	
	//====凭证入库用常量值Begin
	/**  凭证入库保管员审批状态 */
	public static final String PROCESS_VOUCHER_INTO_NAME="审批状态";
	/**  凭证入库保管员审批通过 */
	public static final String PROCESS_VOUCHER_INTO_YES="通过";
	/**  凭证入库保管员审批未通过 */
	public static final String PROCESS_VOUCHER_INTO_NO="不通过";
	/**  凭证出库、入库流程中记录凭证份数信息的字段 */
	public static final String PROCESS_VOUCHER_NAME="凭证份数信息";
	//====凭证入库用常量值End
	
	//====凭证出库用常量值Begin
	/**  凭证入库保管员审批状态 */
	public static final String PROCESS_VOUCHER_OUT_NAME="审批状态";
	/**  凭证入库保管员审批通过 */
	public static final String PROCESS_VOUCHER_OUT_YES="通过";
	/**  凭证入库保管员审批未通过 */
	public static final String PROCESS_VOUCHER_OUT_NO="不通过";
	//====凭证出库用常量值End
	
	//====电子交接常量值Begin
	public static final String PROCESS_DZJJ_PDID="1015";
	public static final String PROCESS_YXSF_PDID="1016";
	public static final String PROCESS_DZJJ_QYZH="企业账号";
	public static final String PROCESS_DZJJ_JSBMBM="接收部门编码";
	public static final String PROCESS_DZJJ_JSBM="接收部门";
	public static final String STATES_WJS = "W";//未接收
	public static final String STATES_DQR = "D";//待确认
	public static final String STATES_YJS = "Y";	//已接收
	public static final String STATES_JS = "接收";
	//====电子交接常量值End
	
	/** 可全局控制表单标识 */
	public static final String FORM_GLOBAL_CONTROL_Y = "Y";
	/** 不可全局控制表单标识 */
	public static final String FORM_GLOBAL_CONTROL_N = "N";
	
	public static final String PROCESS_FWPR_PRPDID="01004";
	
	public static final String PROCESS_INFO_ISOPEN ="信息是否公开";
	
	public static final String PROCESS_INFO_CLOSE ="否";
	
	
	/** 抄阅人角色类型标识 */
	public static final String COPYUSER_TYPE ="IGCR01";
	
	/** 角色类型标识 */
	public static final String ROLE_TYPE ="100";
	

	
}
