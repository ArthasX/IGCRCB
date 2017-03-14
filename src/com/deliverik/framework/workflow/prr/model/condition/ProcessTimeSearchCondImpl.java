/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prr.model.condition;

/**
  * 概述: 流程计时表检索条件实现
  * 功能描述: 流程计时表检索条件实现
  * 创建记录: 2011/10/08
  * 修改记录: 
  */
public class ProcessTimeSearchCondImpl implements
		ProcessTimeSearchCond {
	
	protected String year;
	
	protected Integer prid;
	
	//查询用户id
	protected String userId;
	
	//查询计时开始时间
	protected String prtstartTime_le;
	
	//查询计时结束时间
	protected String prtEndTime_ge;

	/**
	 * 用户id获取
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * 用户id设定
	 * @param userId
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * 计时开始时间获取
	 */
	public String getPrtstartTime_le() {
		return prtstartTime_le;
	}

	/**
	 * 计时开始时间设定
	 * @param prtstartTime_like
	 */
	public void setPrtstartTime_le(String prtstartTime_le) {
		this.prtstartTime_le = prtstartTime_le;
	}
	
	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public Integer getPrid() {
		return prid;
	}

	public void setPrid(Integer prid) {
		this.prid = prid;
	}

	/**
	 * 计时结束时间获取
	 */
	public String getPrtEndTime_ge() {
		return prtEndTime_ge;
	}

	/**
	 * 计时结束时间设定
	 */
	public void setPrtEndTime_ge(String prtEndTime_ge) {
		this.prtEndTime_ge = prtEndTime_ge;
	}

}