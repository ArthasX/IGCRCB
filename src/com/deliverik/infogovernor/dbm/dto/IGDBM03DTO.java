/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.deliverik.infogovernor.dbm.dto;

import com.deliverik.framework.base.BaseDTO;

public class IGDBM03DTO extends BaseDTO {

	private static final long serialVersionUID = 1L;
	
	/*返回一切需要xml流的字符串*/
	protected String resultXML;
	
	/*事件、问题、变更数量*/
	protected String processCount;
	
	/*变更计划用日历*/
	protected String valueOfDate;
	
	/*变更计划日历xml*/
	protected String changePlanCalender;
	
	/*本月事件数量*/
	protected int currentMouthEventCount;
	
	/*处长首页本月问题数量*/
	protected int currentMouthProblemCount;
	
	/*流程主题各种类型工作数量*/
	protected String allTypeWorkCount;
	
	/**
	 * 处长首页变更计划用日历取得
	 * @return valueOfDate
	 */
	public String getValueOfDate() {
		return valueOfDate;
	}
	/**
	 * 处长首页变更计划用日历设置
	 * @param  valueOfDate 处长首页变更计划用日历
	 */
	public void setValueOfDate(String valueOfDate) {
		this.valueOfDate = valueOfDate;
	}
	
	
	
	/**
	 * 处长首页事件、问题、变更数量取得
	 * @return processCount
	 */
	public String getProcessCount() {
		return processCount;
	}
	/**
	 * 处长首页事件、问题、变更数量设置
	 * @param  processCount 处长首页事件、问题、变更数量
	 */
	public void setProcessCount(String processCount) {
		this.processCount = processCount;
	}

	public String getResultXML() {
		return resultXML;
	}
	public void setResultXML(String resultXML) {
		this.resultXML = resultXML;
	}
	public String getChangePlanCalender() {
		return changePlanCalender;
	}
	public void setChangePlanCalender(String changePlanCalender) {
		this.changePlanCalender = changePlanCalender;
	}
	public int getCurrentMouthEventCount() {
		return currentMouthEventCount;
	}
	public void setCurrentMouthEventCount(int currentMouthEventCount) {
		this.currentMouthEventCount = currentMouthEventCount;
	}
	public int getCurrentMouthProblemCount() {
		return currentMouthProblemCount;
	}
	public void setCurrentMouthProblemCount(int currentMouthProblemCount) {
		this.currentMouthProblemCount = currentMouthProblemCount;
	}
	public String getAllTypeWorkCount() {
		return allTypeWorkCount;
	}
	public void setAllTypeWorkCount(String allTypeWorkCount) {
		this.allTypeWorkCount = allTypeWorkCount;
	}
	
	
}