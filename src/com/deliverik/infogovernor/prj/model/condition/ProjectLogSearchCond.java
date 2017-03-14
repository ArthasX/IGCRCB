package com.deliverik.infogovernor.prj.model.condition;

/**
 * 概述: projectlog表检索条件接口
 * 功能描述: projectlog表检索条件接口
 * 创建记录: 2012/04/19
 * 修改记录: 
 */
public interface ProjectLogSearchCond {

	public abstract Integer getPid();	
	/**日志内容*/
	public String getPlinfo();
	/**日志类型*/
	public String getPltype();
	/**日志开始时间*/
	public String getPltime_from();
	/**日志结束时间*/
	public String getPltime_to();
	/**日志类型不为空*/
	public String getPltype_ne();
	

}