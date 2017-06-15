/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.scheduling.bl;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 任务调度_常量定义
 * </p>
 * 
 * @author maozhipeng@deliverik.com
 * @version 1.0
 */

public class IGSCH01BLType {
	/*------------------流程状态------------------*/

	/** 等待分派 */
	public static final String PROCESS_STATUS_WAITING_ASSIGNEE = "P";
	/** 等待审核 */
	public static final String PROCESS_STATUS_WAITING_VERIFY = "V";
	/** 等待处理 */
	public static final String PROCESS_STATUS_WAITING_IMPLEMENT = "E";
	

	/*------------------流程参与者状态------------------*/
	
	/** 审核 */
	public static final String PARTICIPANT_STATUS_VERIFY = "V";
	/** 分派*/
	public static final String PARTICIPANT_STATUS_DISPATCHER = "P";
	/** 发起 */
	public static final String PARTICIPANT_STATUS_INITIAL = "I";
	/** 处理 */
	public static final String PARTICIPANT_STATUS_IMPLEMENT = "E";
	
	/*------------------流程用户参与类型------------------*/
	
	public static final String PARTICIPANT_TYPE = "P";
	
	
	/** 任务类型*/
	public static final String PROCESS_ENTERPRISE_TYPE = "WA";
	
	public static final String PROCESS_ENTERPRISE_NAME = "指派工作";
	
	public static final String PROCESS_PERSON_TYPE = "WB";
	
	public static final String PROCESS_PERSON_NAME = "个人工作";

}
