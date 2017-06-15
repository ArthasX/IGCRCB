/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.deliverik.infogovernor.dbm.dto;

import com.deliverik.framework.base.BaseDTO;

public class IGDBM02DTO extends BaseDTO {

	private static final long serialVersionUID = 1L;
	
	/*返回一切需要xml流的字符串*/
	protected String resultXML;
	
	/*处长首页事件、问题、变更数量*/
	protected String processCount;
	
	/*处长首页本月问题数量*/
	protected int currentMouthProblemCount;
	
	/*处长首页本月事件数量*/
	protected int currentMouthEventCount;
	
	/*处长首页变更计划用日历*/
	protected String valueOfDate;
	
	/*处长首页各中心工作数量*/
	protected String workCount;
	
	/*监视器控件*/
	protected String monitor;
	
	/*变更计划日历xml*/
	protected String changePlanCalender;
	
	/*银联成功率仪表*/
	protected int meter;
	
	/**
	 * 处长首页各中心工作数量取得
	 * @return workCount
	 */
	public String getWorkCount() {
		return workCount;
	}
	/**
	 * 处长首页各中心工作数量设置
	 * @param  workCount 处长首页各中心工作数量
	 */
	public void setWorkCount(String workCount) {
		this.workCount = workCount;
	}
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
	 * 处长首页本月问题数量取得
	 * @return currentMouthProblemCount
	 */
	public int getCurrentMouthProblemCount() {
		return currentMouthProblemCount;
	}
	/**
	 * 处长首页本月问题数量设置
	 * @param  processCount 处长首页事件、问题、变更数量
	 */
	public void setCurrentMouthProblemCount(int currentMouthProblemCount) {
		this.currentMouthProblemCount = currentMouthProblemCount;
	}
	/**
	 * 处长首页本月事件数量取得
	 * @return currentMouthEventCount
	 */
	public int getCurrentMouthEventCount() {
		return currentMouthEventCount;
	}
	/**
	 * 处长首页本月事件数量设置
	 * @param  processCount 处长首页本月事件数量
	 */
	public void setCurrentMouthEventCount(int currentMouthEventCount) {
		this.currentMouthEventCount = currentMouthEventCount;
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
	public String getMonitor() {
		return monitor;
	}
	public void setMonitor(String monitor) {
		this.monitor = monitor;
	}
	public String getChangePlanCalender() {
		return changePlanCalender;
	}
	public void setChangePlanCalender(String changePlanCalender) {
		this.changePlanCalender = changePlanCalender;
	}
	public int getMeter() {
		return meter;
	}
	public void setMeter(int meter) {
		this.meter = meter;
	}
	
}