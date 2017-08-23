/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.crc.model;

import java.io.Serializable;


public interface IGCRC0208VWInfo extends Serializable{
	
	/**
	 * prid取得
	 * @return prid  prid
	 */
	public Integer getPrid();
	/**
	 * 流程记录类型取得
	 * @return prtype  流程记录类型
	 */
	public String getPrtype();
	/**
	 * 流程记录状态取得
	 * @return prstatus  流程记录状态
	 */
	public String getPrstatus();
	/**
	 * 流程记录题目取得
	 * @return prtitle  流程记录题目
	 */
	public String getPrtitle();
	/**
	 * 流程记录建立时间取得
	 * @return propentime  流程记录建立时间
	 */
	public String getPropentime();
	/**
	 * 流程记录关闭时间取得
	 * @return prclosetime  流程记录关闭时间
	 */
	public String getPrclosetime();
	/**
	 * 流程记取得
	 * @return eventType  流程记
	 */
	public String getEventType();
	/**
	 * 事件来源取得
	 * @return eventSource  事件来源
	 */
	public String getEventSource();
	/**
	 * 严重程度取得
	 * @return eventSeverity  严重程度
	 */
//	public String getEventSeverity();
	/**
	 * 紧急程度取得
	 * @return eventEmergency  紧急程度
	 */
//	public String getEventEmergency();
	
	/**
	 * 流程记录工单号取得
	 * @return prserialnum  流程记录工单号
	 */
	public String getPrserialnum();
	
	/**
	 * 流程记录发起者用户姓名取得
	 * @return prusername  流程记录发起者用户姓名
	 */
	public String getPrusername();
	
	/**
	 * 流程记录状态子状态取得
	 * @return prsubstatus  流程记录状态子状态
	 */
	public String getPrsubstatus();
	
	/**
	 * 流程状态名称取得
	 * @return orderstatus  流程状态名称
	 */
	public String getOrderstatus();
	
	/**
	 * 发生时间取得
	 * @return happenTime  发生时间
	 */
	public String getHappenTime();
	/**
	 * 处理方法取得
	 * @return handlingMethod  处理方法
	 */
//	public String getHandlingMethod();
	/**
	 * 原因分析取得
	 * @return analysis  原因分析
	 */
//	public String getAnalysis();
	/**
	 * 故障系统名称取得
	 * @return stoppageName  故障系统名称
	 */
//	public String getStoppageName();
	
	/**
	 * 流程记录流程类型ID取得
	 * @return prpdid  流程记录流程类型ID
	 */
	public String getPrpdid();
	
	public String getInvolveSystem();
	
	public String getInfluenceRange();
	
	public String getInfluenceRangeRemarks();
	
	public String getEventLevel();
	
	public String getEventCause();
	
	public String getEmergencySolution();
	
	public String getIsClosed();
}
