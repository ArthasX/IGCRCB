/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prr.model.condition;

/**
  * 概述: 用户作息时间定义表检索条件实现
  * 功能描述: 用户作息时间定义表检索条件实现
  * 创建记录: 2011/10/08
  * 修改记录: 
  */
public class ProcessWorkTimeSearchCondImpl implements ProcessWorkTimeSearchCond {
	/**查询开始日期*/
	private String startDate;
	
	/**查询结束日期*/
	private String endDate;
	
	/**查询工作日期*/
	protected String pwDate;
	
	/**查询用户修改标识位*/
	protected String pwFlg;
	
	/**
	 * 查询年份
	 */
	protected String pwDate_like;
	
	/**查询用户ID*/
	private String userId;
	
	/**
	 * 工作日期获取
	 */
	public String getPwDate() {
		return pwDate;
	}

	/**
	 * 工作日期设定
	 * @param pwDate
	 */
	public void setPwDate(String pwDate) {
		this.pwDate = pwDate;
	}
	
	/**
	 * @return 查询用户ID
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param 查询用户ID
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * 用户修改标识位获取
	 */
	public String getPwFlg() {
		return pwFlg;
	}

	/**
	 * 用户修改标识位设定
	 * @param pwFlg
	 */
	public void setPwFlg(String pwFlg) {
		this.pwFlg = pwFlg;
	}

	/**
	 * @return 查询开始日期
	 */
	public String getStartDate() {
		return startDate;
	}

	/**
	 * @param 查询开始日期
	 */
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	/**
	 * @return 查询结束日期
	 */
	public String getEndDate() {
		return endDate;
	}

	/**
	 * @param 查询结束日期
	 */
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	/**
	 * 查询年份获取
	 */
	public String getPwDate_like() {
		return pwDate_like;
	}
	/**
	 * 查询年份设定
	 */
	public void setPwDate_like(String pwDate_like) {
		this.pwDate_like = pwDate_like;
	}

}