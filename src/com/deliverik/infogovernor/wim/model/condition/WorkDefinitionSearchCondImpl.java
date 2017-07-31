/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.wim.model.condition;

import java.util.List;

/**
  * 概述: 工作定义检索条件实现
  * 功能描述: 工作定义检索条件实现
  * 创建记录: 2017/06/09
  * 修改记录: 
  */
public class WorkDefinitionSearchCondImpl implements
		WorkDefinitionSearchCond {
	
	/**
	 * 工作项名称
	 */
	protected String wdname;
	
	/**
	 * 发起人（userid）
	 */
	protected String initiatorId;
	
	/**
	 * 发起人名称
	 */
	protected String leaderName;
	
	/**
	 * 发起人（userid匹配多个）
	 */
	protected List<String> initiatorId_in;
	
	/**
	 * 执行人名称
	 */
	protected String excutorName;
	
	/**
	 * 启用状态（0，未启用；1，已启用）
	 */
	protected String wdstatus;
	
	/** 
	 * 负责人（userid）
	 */
	protected String leaderId;
	
	/**
	 * 开始日期从
	 */
	protected String beginDateStart;
	
	/**
	 * 开始日期到
	 */
	protected String beginDateOver;

	/**
	 * 工作项名称取得
	 * @return 工作项名称
	 */
	public String getWdname() {
		return wdname;
	}

	/**
	 * 工作项名称设定
	 * @param 工作项名称
	 */
	public void setWdname(String wdname) {
		this.wdname = wdname;
	}

	/**
	 * 发起人（userid）取得
	 * @return 发起人（userid）
	 */
	public String getInitiatorId() {
		return initiatorId;
	}

	/**
	 * 发起人（userid）设定
	 * @param 发起人（userid）
	 */
	public void setInitiatorId(String initiatorId) {
		this.initiatorId = initiatorId;
	}
	
	/**
	 * 发起人名称取得
	 * @return 发起人名称
	 */
	public String getLeaderName() {
		return leaderName;
	}

	/**
	 * 发起人名称设定
	 * @param 发起人名称
	 */
	public void setLeaderName(String leaderName) {
		this.leaderName = leaderName;
	}

	/**
	 * 发起人（userid匹配多个）取得
	 * @return 发起人（userid匹配多个）
	 */
	public List<String> getInitiatorId_in() {
		return initiatorId_in;
	}

	/**
	 * 发起人（userid匹配多个）设定
	 * @param 发起人（userid匹配多个）
	 */
	public void setInitiatorId_in(List<String> initiatorId_in) {
		this.initiatorId_in = initiatorId_in;
	}

	/**
	 * 执行人名称取得
	 * @return 执行人名称
	 */
	public String getExcutorName() {
		return excutorName;
	}

	/**
	 * 执行人名称设定
	 * @param 执行人名称
	 */
	public void setExcutorName(String excutorName) {
		this.excutorName = excutorName;
	}

	/**
	 * 启用状态（0，未启用；1，已启用）取得
	 * @return 启用状态（0，未启用；1，已启用）
	 */
	public String getWdstatus() {
		return wdstatus;
	}

	/**
	 * 启用状态（0，未启用；1，已启用）设定
	 * @param 启用状态（0，未启用；1，已启用） 
	 */
	public void setWdstatus(String wdstatus) {
		this.wdstatus = wdstatus;
	}

	/**
	 * 负责人（userid）取得
	 * @return 负责人（userid）
	 */
	public String getLeaderId() {
		return leaderId;
	}

	/**
	 * 负责人（userid）设定
	 * @param 负责人（userid）
	 */
	public void setLeaderId(String leaderId) {
		this.leaderId = leaderId;
	}

	/**
	 * 开始日期从取得
	 * @return 开始日期从
	 */
	public String getBeginDateStart() {
		return beginDateStart;
	}

	/**
	 * 开始日期从设定
	 * @param 开始日期从
	 */
	public void setBeginDateStart(String beginDateStart) {
		this.beginDateStart = beginDateStart;
	}

	/**
	 * 开始日期到取得
	 * @return 开始日期到
	 */
	public String getBeginDateOver() {
		return beginDateOver;
	}

	/**
	 * 开始日期到设定
	 * @param 开始日期到
	 */
	public void setBeginDateOver(String beginDateOver) {
		this.beginDateOver = beginDateOver;
	}
	
}