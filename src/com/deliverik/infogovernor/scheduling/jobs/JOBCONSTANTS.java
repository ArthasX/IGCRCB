/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.scheduling.jobs;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 服务管理_服务策略_工作相关常量
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */

public class JOBCONSTANTS {
	
	//*******************************事件监督*******************************
	
	//事件监督工作组标识
	public final static String INCIDENT_MONITOR_GROUP = "INCIDENT_MONITOR_GROUP";
	
	//事件监督工作标识
	public final static String INCIDENT_MONITOR = "INCIDENT_MONITOR";
	
	//事件监督工作组标识
	public final static String INCIDENT_MONITOR_TRI_GROUP = "INCIDENT_MONITOR_TRI_GROUP";
	
	//事件监督工作标识
	public final static String INCIDENT_MONITOR_TRI = "INCIDENT_MONITOR_TRI";
	
	//3分钟一检查
	public final static int INCIDENT_INTERVAL = 3;
	
	//事件监督工作周期表达式：3分钟  
	public final static String INCIDENT_MONITOR_PARSE = "0 */"+INCIDENT_INTERVAL+" * * * ?";
	
	
}
