/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.smr.model.condition;


/**
  * 概述: 报表填报明细表检索条件实现
  * 功能描述: 报表填报明细表检索条件实现
  * 创建记录: 2013/07/18
  * 修改记录: 
  */
public class RegulatoryReportDetailSearchCondImpl implements
		RegulatoryReportDetailSearchCond {
	
	/** 实例ID */
	private	Integer instanceID;
	
	/** 流程ID */
	private	Integer prid;

	/**
	 * 实例ID取得
	 * 
	 * @return 实例ID
	 */
	public Integer getInstanceID() {
		return instanceID;
	}

	/**
	 * 实例ID设定
	 * 
	 * @param instanceID 实例ID
	 */
	public void setInstanceID(Integer instanceID) {
		this.instanceID = instanceID;
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

	
}