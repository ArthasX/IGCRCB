/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.dwp.form;

import com.deliverik.framework.base.BaseForm;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 任务查询Form
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGDWP0101Form extends BaseForm{

	/** 开始时间：从 */
	protected String startdate_from;
	
	/** 开始时间：到 */
	protected String startdate_to;
	
	/** 计划ID */
	protected Integer planid;
	
	/** 个人任务标识 */
	protected String single;
	
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
	 * 计划ID取得
	 * @return planid 计划ID
	 */
	public Integer getPlanid() {
		return planid;
	}

	/**
	 * 计划ID设定
	 * @param planid 计划ID
	 */
	public void setPlanid(Integer planid) {
		this.planid = planid;
	}

	/**
	 * 个人任务标识取得
	 * @return single 个人任务标识
	 */
	public String getSingle() {
		return single;
	}

	/**
	 * 个人任务标识设定
	 * @param single 个人任务标识
	 */
	public void setSingle(String single) {
		this.single = single;
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