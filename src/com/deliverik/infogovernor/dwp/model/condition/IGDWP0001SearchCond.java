/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.dwp.model.condition;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 日常工作计划查询条件接口
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public interface IGDWP0001SearchCond {

	/**
	 * 开始时间：从取得
	 * @return startdate_from 开始时间：从
	 */
	public String getStartdate_from();

	/**
	 * 开始时间：到取得
	 * @return startdate_to 开始时间：到
	 */
	public String getStartdate_to();
	
	/**
	 * 是否添加JOB取得
	 * @return isAddJob 是否添加JOB
	 */
	public String getIsAddJob();
	
	/**
	 * 任务发起人ID取得
	 * @return puserid 任务发起人ID
	 */
	public String getPuserid();
}
