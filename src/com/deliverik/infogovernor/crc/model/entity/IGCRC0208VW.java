/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.crc.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.deliverik.infogovernor.crc.model.IGCRC0208VWInfo;


@SuppressWarnings("serial")
@Entity
public class IGCRC0208VW implements Serializable,Cloneable,IGCRC0208VWInfo{
	
	@Id
	protected Integer prid;
	
	/**
	 * 流程记录类型
	 */
	protected String prtype;
	
	/**
	 * 流程记录状态
	 */
	protected String prstatus;
	
	
	/**
	 * 流程记录题目
	 */
	protected String prtitle;
	
	
	/**
	 * 流程记录建立时间
	 */
	protected String propentime;
	
	/**
	 * 流程记录关闭时间
	 */
	protected String prclosetime;
	
	/**
	 * 流程记录工单号
	 */
	protected String prserialnum;
	
	/**
	 * 流程记录发起者用户姓名
	 */
	protected String prusername;
	
	/**
	 * 流程记录状态子状态
	 */
	protected String prsubstatus;
	
	/**
	 * 流程记录流程类型ID
	 */
	protected String prpdid;
	
	
	/** 事件分类  */	
	private String eventType;
	/** 事件来源  */	
	private String eventSource;
	/** 严重程度 */	
	private String eventSeverity;
	/** 紧急程度  */	
	private String eventEmergency;
	/** 流程状态名称 */
	private String orderstatus;
	
	/** 发生时间  */	
	private String happenTime;
	/** 处理方法  */	
	private String handlingMethod;
	/** 原因分析  */	
	private String analysis;
	/** 故障系统名称  */	
	private String stoppageName;
	/** 事件处理人  */	
//	private String ppusername;
	
	/**
	 * prid取得
	 * @return prid  prid
	 */
	public Integer getPrid() {
		return prid;
	}
	/**
	 * prid设定
	 * @param prid  prid
	 */
	public void setPrid(Integer prid) {
		this.prid = prid;
	}
	/**
	 * 流程记录类型取得
	 * @return prtype  流程记录类型
	 */
	public String getPrtype() {
		return prtype;
	}
	/**
	 * 流程记录类型设定
	 * @param prtype  流程记录类型
	 */
	public void setPrtype(String prtype) {
		this.prtype = prtype;
	}
	/**
	 * 流程记录状态取得
	 * @return prstatus  流程记录状态
	 */
	public String getPrstatus() {
		return prstatus;
	}
	/**
	 * 流程记录状态设定
	 * @param prstatus  流程记录状态
	 */
	public void setPrstatus(String prstatus) {
		this.prstatus = prstatus;
	}
	/**
	 * 流程记录题目取得
	 * @return prtitle  流程记录题目
	 */
	public String getPrtitle() {
		return prtitle;
	}
	/**
	 * 流程记录题目设定
	 * @param prtitle  流程记录题目
	 */
	public void setPrtitle(String prtitle) {
		this.prtitle = prtitle;
	}
	/**
	 * 流程记录建立时间取得
	 * @return propentime  流程记录建立时间
	 */
	public String getPropentime() {
		return propentime;
	}
	/**
	 * 流程记录建立时间设定
	 * @param propentime  流程记录建立时间
	 */
	public void setPropentime(String propentime) {
		this.propentime = propentime;
	}
	/**
	 * 流程记录关闭时间取得
	 * @return prclosetime  流程记录关闭时间
	 */
	public String getPrclosetime() {
		return prclosetime;
	}
	/**
	 * 流程记录关闭时间设定
	 * @param prclosetime  流程记录关闭时间
	 */
	public void setPrclosetime(String prclosetime) {
		this.prclosetime = prclosetime;
	}
	/**
	 * 流程记取得
	 * @return eventType  流程记
	 */
	public String getEventType() {
		return eventType;
	}
	/**
	 * 流程记设定
	 * @param eventType  流程记
	 */
	public void setEventType(String eventType) {
		this.eventType = eventType;
	}
	/**
	 * 事件来源取得
	 * @return eventSource  事件来源
	 */
	public String getEventSource() {
		return eventSource;
	}
	/**
	 * 事件来源设定
	 * @param eventSource  事件来源
	 */
	public void setEventSource(String eventSource) {
		this.eventSource = eventSource;
	}
	/**
	 * 严重程度取得
	 * @return eventSeverity  严重程度
	 */
	public String getEventSeverity() {
		return eventSeverity;
	}
	/**
	 * 严重程度设定
	 * @param eventSeverity  严重程度
	 */
	public void setEventSeverity(String eventSeverity) {
		this.eventSeverity = eventSeverity;
	}
	/**
	 * 紧急程度取得
	 * @return eventEmergency  紧急程度
	 */
	public String getEventEmergency() {
		return eventEmergency;
	}
	/**
	 * 紧急程度设定
	 * @param eventEmergency  紧急程度
	 */
	public void setEventEmergency(String eventEmergency) {
		this.eventEmergency = eventEmergency;
	}
	/**
	 * 流程记录工单号取得
	 * @return prserialnum  流程记录工单号
	 */
	public String getPrserialnum() {
		return prserialnum;
	}
	/**
	 * 流程记录工单号设定
	 * @param prserialnum  流程记录工单号
	 */
	public void setPrserialnum(String prserialnum) {
		this.prserialnum = prserialnum;
	}
	/**
	 * 流程记录发起者用户姓名取得
	 * @return prusername  流程记录发起者用户姓名
	 */
	public String getPrusername() {
		return prusername;
	}
	/**
	 * 流程记录发起者用户姓名设定
	 * @param prusername  流程记录发起者用户姓名
	 */
	public void setPrusername(String prusername) {
		this.prusername = prusername;
	}
	/**
	 * 流程记录状态子状态取得
	 * @return prsubstatus  流程记录状态子状态
	 */
	public String getPrsubstatus() {
		return prsubstatus;
	}
	/**
	 * 流程记录状态子状态设定
	 * @param prsubstatus  流程记录状态子状态
	 */
	public void setPrsubstatus(String prsubstatus) {
		this.prsubstatus = prsubstatus;
	}
	/**
	 * 流程状态名称取得
	 * @return orderstatus  流程状态名称
	 */
	public String getOrderstatus() {
		return orderstatus;
	}
	/**
	 * 流程状态名称设定
	 * @param orderstatus  流程状态名称
	 */
	public void setOrderstatus(String orderstatus) {
		this.orderstatus = orderstatus;
	}
	/**
	 * 发生时间取得
	 * @return happenTime  发生时间
	 */
	public String getHappenTime() {
		return happenTime;
	}
	/**
	 * 发生时间设定
	 * @param happenTime  发生时间
	 */
	public void setHappenTime(String happenTime) {
		this.happenTime = happenTime;
	}
	/**
	 * 处理方法取得
	 * @return handlingMethod  处理方法
	 */
	public String getHandlingMethod() {
		return handlingMethod;
	}
	/**
	 * 处理方法设定
	 * @param handlingMethod  处理方法
	 */
	public void setHandlingMethod(String handlingMethod) {
		this.handlingMethod = handlingMethod;
	}
	/**
	 * 原因分析取得
	 * @return analysis  原因分析
	 */
	public String getAnalysis() {
		return analysis;
	}
	/**
	 * 原因分析设定
	 * @param analysis  原因分析
	 */
	public void setAnalysis(String analysis) {
		this.analysis = analysis;
	}
	/**
	 * 故障系统名称取得
	 * @return stoppageName  故障系统名称
	 */
	public String getStoppageName() {
		return stoppageName;
	}
	/**
	 * 故障系统名称设定
	 * @param stoppageName  故障系统名称
	 */
	public void setStoppageName(String stoppageName) {
		this.stoppageName = stoppageName;
	}
	/**
	 * 流程记录流程类型ID取得
	 * @return prpdid  流程记录流程类型ID
	 */
	public String getPrpdid() {
		return prpdid;
	}
	/**
	 * 流程记录流程类型ID设定
	 * @param prpdid  流程记录流程类型ID
	 */
	public void setPrpdid(String prpdid) {
		this.prpdid = prpdid;
	}
	
	
	
}
