/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.ven.model.condition;

/**
  * 概述: 监测工作填报表检索条件实现
  * 功能描述: 监测工作填报表检索条件实现
  * 创建记录: 2014/12/01
  * 修改记录: 
  */
public class MonitoringWorkSearchCondImpl implements MonitoringWorkSearchCond {

	/** 风险策略主键id */
	protected Integer rmid;

	/** 监测结果 null */
	protected String result_isNotNull;
	
	/** 指标名称  */	
	protected String einame;
	
	/** 指标编号  */	
	protected String eilabel;
	
	/**
	 * 风险策略主键id取得
	 * @return rmid  风险策略主键id
	 */
	public Integer getRmid() {
		return rmid;
	}

	/**
	 * 风险策略主键id设定
	 * @param rmid  风险策略主键id
	 */
	public void setRmid(Integer rmid) {
		this.rmid = rmid;
	}

	/**
	 * 监测结果null取得
	 * @return result_isNotNull  监测结果null
	 */
	public String getResult_isNotNull() {
		return result_isNotNull;
	}

	/**
	 * 监测结果null设定
	 * @param result_isNotNull  监测结果null
	 */
	public void setResult_isNotNull(String result_isNotNull) {
		this.result_isNotNull = result_isNotNull;
	}

	/**
	 * 指标名称取得
	 * @return einame  指标名称
	 */
	public String getEiname() {
		return einame;
	}

	/**
	 * 指标名称设定
	 * @param einame  指标名称
	 */
	public void setEiname(String einame) {
		this.einame = einame;
	}

	/**
	 * 指标编号取得
	 * @return eilabel  指标编号
	 */
	public String getEilabel() {
		return eilabel;
	}

	/**
	 * 指标编号设定
	 * @param eilabel  指标编号
	 */
	public void setEilabel(String eilabel) {
		this.eilabel = eilabel;
	}


}