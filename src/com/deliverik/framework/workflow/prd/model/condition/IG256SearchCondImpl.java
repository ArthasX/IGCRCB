/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prd.model.condition;

/**
  * 概述: 流程策略提醒检索条件实现
  * 功能描述: 流程策略提醒检索条件实现
  * 创建记录: 2013/09/03
  * 修改记录: 
  */
public class IG256SearchCondImpl implements
		IG256SearchCond {

	/** 流程ID */
	private Integer prid;
	
	/** 流程当前状态 */
	private String prstatus;

	private String flag;

	private String[] flag_in;

	/**
	 * 设置流程ID等值查询
	 * @param prid
	 */
	public void setPrid(Integer prid) {
		this.prid = prid;
	}

	/**
	 * 获取流程ID
	 * @return
	 */
	public Integer getPrid() {
		return prid;
	}

	/**
	 * 设置流程状态等值查询
	 * @param prstatus
	 */
	public void setPrstatus(String prstatus) {
		this.prstatus = prstatus;
	}

	/**
	 * 获取流程状态
	 * @return
	 */
	public String getPrstatus() {
		return prstatus;
	}

	/**
	 * 通知标识设置 值域 0:通知 1:超时
	 * @param flag
	 */
	public void setFlag(String flag) {
		this.flag = flag;
	}

	/**
	 * 通知标识获取 
	 * @return
	 */
	public String getFlag() {
		return flag;
	}

	/**
	 * 通知标识 in 查询
	 * @param flag_in
	 */
	public void setFlag_in(String[] flag_in) {
		this.flag_in = flag_in;
	}

	/**
	 * 获取通知标识 in
	 * @return
	 */
	public String[] getFlag_in() {
		return flag_in;
	}

}