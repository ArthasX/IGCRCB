/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.mtp.bl;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 任务调度_常量定义
 * </p>
 * 
 * @version 1.0
 */

public class IGMTP01BLType {
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
	
	
	/** 任务类型(指派工作)*/
	public static final String PROCESS_ENTERPRISE_TYPE = "WA";
	
	public static final String PROCESS_ENTERPRISE_NAME = "指派工作";
	
	/** 任务类型(个人工作)*/
	public static final String PROCESS_PERSON_TYPE = "WB";
	
	public static final String PROCESS_PERSON_NAME = "个人工作";
	
	/** 任务类型(自定义工作)*/
	public static final String PROCESS_USERDEFINED_TYPE = "WD";
	
	public static final String PROCESS_USERDEFINED_NAME = "自定义工作";
	
	/*------------------日常运维计划执行状态------------------*/
	/** 计划已执行*/
	public static final String JOB_TYPE_EXECUTION = "1";
	
	/** 计划未执行*/
	public static final String JOB_TYPE_UNEXECUTION = "0";

	
	/**
	 * make a key for Trigger
 	 *
	 * @param  String
	 * @return String 
	 */
	private static SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmssSSS");
    private static NumberFormat nf = NumberFormat.getInstance(Locale.CHINA);
    static{
        //设置最小整数位
        nf.setMinimumIntegerDigits(4);
        nf.setGroupingUsed(false);
    }
    private static long postfix = 0;//主键最后4位
	public static synchronized String getTriggerKey(){
		String id="";
		Date date=new Date();
		id=df.format(date);
		 
		if(postfix==9999l){
		    postfix = 0;
		}else{
		    postfix++;
		}
		
		return id+nf.format(postfix);//不包含str为21位
		
	}
	
	public static void main(String[] args){
		//System.out.println(getTriggerKey());
		
		//String time = IGStringUtils.getCurrentDateTime();//当前时间
		System.out.println("2010/10/24".compareTo("2010/10/23"));
	}
	
}
