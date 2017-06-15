/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.drm.model.condition;

import java.io.Serializable;

/**
  * 概述: 项目周报人员工作量检索条件实现
  * 功能描述: 项目周报人员工作量检索条件实现
  * 创建记录: 2016/08/11
  * 修改记录: 
  */
public class EvaluationContentSearchCondImpl implements
		EvaluationContentSearchCond {
	protected Integer evid;

	/** 流程ID */
	protected Integer prid;

	/** 序号 */
	protected Integer sortId;

	/** 节点名称 */
	protected String stepName;

	/** 参与人 */
	protected String peoples;

	/** 开始时间 */
	protected String startTime;

	/** 结束时间 */
	protected String stopTime;


	/** 意见 */
	protected String suggestion;

	/** 评估人 */
	protected String evpeople;

	
	/**节点ID*/
	
	protected String psdid;
	
	/**评估时间*/
	
	protected String doTime;
	/**流程类型*/
	protected String flowType;
	
	
	
	/**
	 * 评估ID取得
	 *
	 * @return 评估ID
	 */
	public Integer getEvid() {
		return evid;
	}

	/**
	 * 评估ID设定
	 *
	 * @param evid 评估ID
	 */
	public void setEvid(Integer evid) {
		this.evid = evid;
	}

	/**
	 * 流程ID取得
	 *
	 * @return 流程ID
	 */
	public Integer getPrid() {
		return prid;
	}

	/**
	 * 流程ID设定
	 *
	 * @param prid 流程ID
	 */
	public void setPrid(Integer prid) {
		this.prid = prid;
	}

	/**
	 * 序号取得
	 *
	 * @return 序号
	 */
	public Integer getSortId() {
		return sortId;
	}

	/**
	 * 序号设定
	 *
	 * @param sortId 序号
	 */
	public void setSortId(Integer sortId) {
		this.sortId = sortId;
	}

	/**
	 * 节点名称取得
	 *
	 * @return 节点名称
	 */
	public String getStepName() {
		return stepName;
	}

	/**
	 * 节点名称设定
	 *
	 * @param stepName 节点名称
	 */
	public void setStepName(String stepName) {
		this.stepName = stepName;
	}

	/**
	 * 参与人取得
	 *
	 * @return 参与人
	 */
	public String getPeoples() {
		return peoples;
	}

	/**
	 * 参与人设定
	 *
	 * @param peoples 参与人
	 */
	public void setPeoples(String peoples) {
		this.peoples = peoples;
	}

	/**
	 * 开始时间取得
	 *
	 * @return 开始时间
	 */
	public String getStartTime() {
		return startTime;
	}

	/**
	 * 开始时间设定
	 *
	 * @param startTime 开始时间
	 */
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	/**
	 * 结束时间取得
	 *
	 * @return 结束时间
	 */
	public String getStopTime() {
		return stopTime;
	}

	/**
	 * 结束时间设定
	 *
	 * @param stopTime 结束时间
	 */
	public void setStopTime(String stopTime) {
		this.stopTime = stopTime;
	}


	/**
	 * 意见取得
	 *
	 * @return 意见
	 */
	public String getSuggestion() {
		return suggestion;
	}

	/**
	 * 意见设定
	 *
	 * @param suggestion 意见
	 */
	public void setSuggestion(String suggestion) {
		this.suggestion = suggestion;
	}

	/**
	 * 评估人取得
	 *
	 * @return 评估人
	 */
	public String getEvpeople() {
		return evpeople;
	}

	/**
	 * 评估人设定
	 *
	 * @param evpeople 评估人
	 */
	public void setEvpeople(String evpeople) {
		this.evpeople = evpeople;
	}

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Serializable getPK() {
		return evid;
	}

	/**  
	 * 获取psdid  
	 * @return psdid 
	 */
	public String getPsdid() {
		return psdid;
	}

	/**  
	 * 设置psdid  
	 * @param psdid
	 */
	
	public void setPsdid(String psdid) {
		this.psdid = psdid;
	}

	/**  
	 * 获取doTime  
	 * @return doTime 
	 */
	public String getDoTime() {
		return doTime;
	}

	/**  
	 * 设置doTime  
	 * @param doTime
	 */
	
	public void setDoTime(String doTime) {
		this.doTime = doTime;
	}

	/**  
	 * 获取flowType  
	 * @return flowType 
	 */
	public String getFlowType() {
		return flowType;
	}

	/**  
	 * 设置flowType  
	 * @param flowType
	 */
	
	public void setFlowType(String flowType) {
		this.flowType = flowType;
	}
	
}