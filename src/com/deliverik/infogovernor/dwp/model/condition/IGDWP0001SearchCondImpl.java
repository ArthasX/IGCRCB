/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.dwp.model.condition;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 日常工作计划查询条件实现
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class IGDWP0001SearchCondImpl implements IGDWP0001SearchCond{

	/** 开始时间：从 */
	protected String startdate_from;
	
	/** 开始时间：到 */
	protected String startdate_to;
	
	/** 是否添加JOB */
	protected String isAddJob;
	
	/** 任务发起人ID */
	protected String puserid;

	/**
	 * 开始时间：从取得
	 * @return startdate_from 开始时间：从
	 */
	public String getStartdate_from() {
		return startdate_from;
	}

	/**
	 * 开始时间：从设定
	 * @param startdate_from 开始时间：从
	 */
	public void setStartdate_from(String startdate_from) {
		this.startdate_from = startdate_from;
	}

	/**
	 * 开始时间：到取得
	 * @return startdate_to 开始时间：到
	 */
	public String getStartdate_to() {
		return startdate_to;
	}

	/**
	 * 开始时间：到设定
	 * @param startdate_to 开始时间：到
	 */
	public void setStartdate_to(String startdate_to) {
		this.startdate_to = startdate_to;
	}

	/**
	 * 是否添加JOB取得
	 * @return isAddJob 是否添加JOB
	 */
	public String getIsAddJob() {
		return isAddJob;
	}

	/**
	 * 是否添加JOB设定
	 * @param isAddJob 是否添加JOB
	 */
	public void setIsAddJob(String isAddJob) {
		this.isAddJob = isAddJob;
	}

	/**
	 * 任务发起人ID取得
	 * @return puserid 任务发起人ID
	 */
	public String getPuserid() {
		return puserid;
	}

	/**
	 * 任务发起人ID设定
	 * @param puserid 任务发起人ID
	 */
	public void setPuserid(String puserid) {
		this.puserid = puserid;
	}

}
