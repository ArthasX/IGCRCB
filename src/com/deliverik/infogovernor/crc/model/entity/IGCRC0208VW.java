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
//	private String eventSeverity;
	/** 紧急程度  */	
//	private String eventEmergency;
	/** 流程状态名称 */
	private String orderstatus;
	
	/** 发生时间  */	
	private String happenTime;
	/** 处理方法  */	
//	private String handlingMethod;
	/** 原因分析  */	
//	private String analysis;
	/** 故障系统名称  */	
//	private String stoppageName;
	/** 事件处理人  */	
//	private String ppusername;
	
	/**
	 * 涉及系统
	 */
	protected String involveSystem;
	
	/**
	 * 影响范围
	 */
	protected String influenceRange;
	
	/**
	 * 影响范围备注
	 */
	protected String influenceRangeRemarks;
	
	/**
	 * 事件等级
	 */
	protected String eventLevel;
	
	/**
	 * 事件原因
	 */
	protected String eventCause;
	
	/**
	 * 应急解决方案
	 */
	protected String emergencySolution;
	
	/**
	 * 是否已关闭
	 */
	protected String isClosed;
	
	
	
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
	public String getInvolveSystem() {
		return involveSystem;
	}
	public void setInvolveSystem(String involveSystem) {
		this.involveSystem = involveSystem;
	}
	public String getInfluenceRange() {
		return influenceRange;
	}
	public void setInfluenceRange(String influenceRange) {
		this.influenceRange = influenceRange;
	}
	public String getInfluenceRangeRemarks() {
		return influenceRangeRemarks;
	}
	public void setInfluenceRangeRemarks(String influenceRangeRemarks) {
		this.influenceRangeRemarks = influenceRangeRemarks;
	}
	public String getEventLevel() {
		return eventLevel;
	}
	public void setEventLevel(String eventLevel) {
		this.eventLevel = eventLevel;
	}
	public String getEventCause() {
		return eventCause;
	}
	public void setEventCause(String eventCause) {
		this.eventCause = eventCause;
	}
	public String getEmergencySolution() {
		return emergencySolution;
	}
	public void setEmergencySolution(String emergencySolution) {
		this.emergencySolution = emergencySolution;
	}
	public String getIsClosed() {
		return isClosed;
	}
	public void setIsClosed(String isClosed) {
		this.isClosed = isClosed;
	}
	
	
	
}
