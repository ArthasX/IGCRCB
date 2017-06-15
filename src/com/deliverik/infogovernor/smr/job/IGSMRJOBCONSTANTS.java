/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.smr.job;

/**
 * 概述:常量 
 * 功能描述：常量 
 * 创建人：赵梓廷
 * 创建记录： 2013-08-06
 * 修改记录：
 */
public class IGSMRJOBCONSTANTS {

	//*******************************年报定时提醒*******************************
	
		//定时提醒工作组标识
		public final static String YEAR_TIMING_REMIND_GROUP = "YEAR_TIMING_REMIND_GROUP";
		
		//定时提醒工作标识
		public final static String YEAR_TIMING_REMIND = "YEAR_TIMING_REMIND";
		
		//定时提醒工作组标识
		public final static String YEAR_TIMING_REMIND_TRI_GROUP = "YEAR_TIMING_REMIND_TRI_GROUP";
		
		//定时提醒工作标识
		public final static String YEAR_TIMING_REMIND_TRI = "YEAR_TIMING_REMIND_TRI";
		
		//3分钟一检查
		public final static int YEAR_TIMING_INTERVAL = 1;
		
		//定时提醒工作周期表达式：3分钟  
		public final static String YEAR_TIMING_REMIND_PARSE = "0 */"+YEAR_TIMING_INTERVAL+" * * * ?";
		
		
		//*******************************一季度的季报报定时提醒*******************************
		
		//定时提醒工作组标识
		public final static String QUARTER1_TIMING_REMIND_GROUP = "QUARTER1_TIMING_REMIND_GROUP";
		
		//定时提醒工作标识
		public final static String QUARTER1_TIMING_REMIND = "QUARTER1_TIMING_REMIND";
		
		//定时提醒工作组标识
		public final static String QUARTER1_TIMING_REMIND_TRI_GROUP = "QUARTER1_TIMING_REMIND_TRI_GROUP";
		
		//定时提醒工作标识
		public final static String QUARTER1_TIMING_REMIND_TRI = "QUARTER1_TIMING_REMIND_TRI";
		

		
		
		//*******************************二季度的季报报定时提醒*******************************
		
		//定时提醒工作组标识
		public final static String QUARTER2_TIMING_REMIND_GROUP = "QUARTER2_TIMING_REMIND_GROUP";
				
		//定时提醒工作标识
		public final static String QUARTER2_TIMING_REMIND = "QUARTER2_TIMING_REMIND";
				
		//定时提醒工作组标识
		public final static String QUARTER2_TIMING_REMIND_TRI_GROUP = "QUARTER2_TIMING_REMIND_TRI_GROUP";
				
		//定时提醒工作标识
		public final static String QUARTER2_TIMING_REMIND_TRI = "QUARTER2_TIMING_REMIND_TRI";
				

		
		
		//*******************************三季度的季报报定时提醒*******************************
		
		//定时提醒工作组标识
		public final static String QUARTER3_TIMING_REMIND_GROUP = "QUARTER3_TIMING_REMIND_GROUP";
				
		//定时提醒工作标识
		public final static String QUARTER3_TIMING_REMIND = "QUARTER3_TIMING_REMIND";
				
		//定时提醒工作组标识
		public final static String QUARTER3_TIMING_REMIND_TRI_GROUP = "QUARTER3_TIMING_REMIND_TRI_GROUP";
				
		//定时提醒工作标识
		public final static String QUARTER3_TIMING_REMIND_TRI = "QUARTER3_TIMING_REMIND_TRI";
				
		
		
		
	//*******************************四季度的季报报定时提醒*******************************
		
		//定时提醒工作组标识
		public final static String QUARTER4_TIMING_REMIND_GROUP = "QUARTER4_TIMING_REMIND_GROUP";
				
		//定时提醒工作标识
		public final static String QUARTER4_TIMING_REMIND = "QUARTER4_TIMING_REMIND";
				
		//定时提醒工作组标识
		public final static String QUARTER4_TIMING_REMIND_TRI_GROUP = "QUARTER4_TIMING_REMIND_TRI_GROUP";
				
		//定时提醒工作标识
		public final static String QUARTER4_TIMING_REMIND_TRI = "QUARTER4_TIMING_REMIND_TRI";		
		
		
		
		/** 信息状态为未过期 */
		public final static String INFOMATION_NODATED = "2";
		
		/** 信息状态为已过期 */
		public final static String INFOMATION_DATED = "1";
		
		/** 年报报表类型 */
		public final static String YEARREPORT_TYPE = "1";
		
		/** 一季度季报报表类型 */
		public final static String QUARTER1REPORT_TYPE = "2";
		
		/** 二季度报表类型 */
		public final static String QUARTER2REPORT_TYPE = "3";
		
		/** 三季度报表类型 */
		public final static String QUARTER3REPORT_TYPE = "4";
		
		/** 四季度报表类型 */
		public final static String QUARTER4REPORT_TYPE = "5";
		
		
		/** 填报发起人角色名称*/
		public final static String INITIATOR_ROLENAME = "填报发起人";
}
