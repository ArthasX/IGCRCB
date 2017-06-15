/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.framework.workflow.prd.model.condition;


/**
 * 概述:流程评审Cond实现类
 * 功能描述：
 *           
 * 创建记录：宋海洋    2010/11/26
 */
public class IG433SearchCondImpl implements IG433SearchCond {

	/**
	 * 流程记录题目
	 */
	protected String prtitle;

	/**
	 * 流程记录流程类型ID
	 */
	protected String prpdid;

	/**
	 * 流程记录发起者用户姓名
	 */
	protected String prusername;
	
	/**
	 * 流程记录紧急程度
	 */
	protected String prurgency;
	
	/**
	 * 流程记录建立时间（大等于）
	 */
	protected String propentime;
	
	/**
	 * 流程记录工单号
	 */
	protected String prserialnum;
	
	/**
	 * 流程记录计划执行周期
	 */
	protected String prclosetime;

	/**
	 * 流程是否评审完毕
	 */
	protected String assessmentstatus;
	
	/**排序字段*/
	protected String order;
	
	/**排序标识*/
	protected String sing;
	
	/**
	 * 流程评审表主键
	 */
	protected Integer paid;
	
	/**
	 * 事件类别code
	 */
	protected String paeventtypecode;
	
	/**流程类型*/
	protected String prtype;
	
	/**流程ID*/
	protected Integer paprid;
	
	/**
	 * 获取流程ID
	 * @return 流程ID
	 */
	public Integer getPaprid() {
		return paprid;
	}

	/**
	 * 流程ID设定
	 * @param paprid 流程ID
	 */
	public void setPaprid(Integer paprid) {
		this.paprid = paprid;
	}

	/**
	 * 获取流程类型
	 * @return 流程类型
	 */
	public String getPrtype() {
		return prtype;
	}

	/**
	 * 设置流程类型
	 * @param prtype 流程类型
	 */
	public void setPrtype(String prtype) {
		this.prtype = prtype;
	}
	/**
	 *流程评审表主键取得
	 * 
	 * @return 流程评审表主键
	 */
	public Integer getPaid() {
		return paid;
	}

	/**
	 *流程评审表主键设定
	 * 
	 * @param paid 流程评审表主键
	 */
	public void setPaid(Integer paid) {
		this.paid = paid;
	}
	
	/**
	 * 功能：排序标识取得
	 * @return  排序标识
	 */
	public String getSing() {
		return sing;
	}
	/**
	 * 功能：排序标识设定
	 * @param order 排序标识
	 */
	public void setSing(String sing) {
		this.sing = sing;
	}
	/**
	 * 功能：排序字段取得
	 * @return  排序字段
	 */
	public String getOrder() {
		return order;
	}
	/**
	 * 功能：排序字段设定
	 * @param order 排序字段
	 */
	public void setOrder(String order) {
		this.order = order;
	}
	
	/**
	 * 功能：否评审完毕取得
	 * @return  否评审完毕
	 */
	public String getAssessmentstatus() {
		return assessmentstatus;
	}
	
	/**
	 * 功能：否评审完毕设定
	 * @param assessmentstatus 否评审完毕
	 */
	public void setAssessmentstatus(String assessmentstatus) {
		this.assessmentstatus = assessmentstatus;
	}

	/**
	 * 功能：流程记录题目取得
	 * @return  流程记录题目
	 */
	public String getPrtitle() {
		return prtitle;
	}

	/**
	 * 功能：流程记录题目设定
	 * @param prtitle 流程记录题目
	 */
	public void setPrtitle(String prtitle) {
		this.prtitle = prtitle;
	}
	
	/**
	 * 功能：流程记录发起者用户姓名取得
	 * @return 流程记录发起者用户姓名
	 */
	public String getPrusername() {
		return prusername;
	}

	/**
	 * 功能：流程记录发起者用户姓名设定
	 * @param prusername 流程记录发起者用户姓名
	 */
	public void setPrusername(String prusername) {
		this.prusername = prusername;
	}

	/**
	 * 功能：流程记录紧急程度取得
	 * @return 流程记录紧急程度
	 */
	public String getPrurgency() {
		return prurgency;
	}

	/**
	 * 功能：流程记录紧急程度设定
	 * @param prurgency 流程记录紧急程度
	 */
	public void setPrurgency(String prurgency) {
		this.prurgency = prurgency;
	}

	/**
	 * 功能：流程记录建立时间（大等于）取得
	 * @return 流程记录建立时间（大等于）
	 */
	public String getPropentime() {
		return propentime;
	}

	/**
	 * 功能：流程记录建立时间（大等于）设定
	 * @param propentime 流程记录建立时间（大等于）
	 */
	public void setPropentime(String propentime) {
		this.propentime = propentime;
	}

	/**
	 * 功能：流程记录流程类型ID取得
	 * @return 流程记录流程类型ID
	 */
	public String getPrpdid() {
		return prpdid;
	}

	/**
	 * 功能：流程记录流程类型ID设定
	 * @param prpdid 流程记录流程类型ID
	 */
	public void setPrpdid(String prpdid) {
		this.prpdid = prpdid;
	}

	/**
	 * 功能：流程记录计划执行周期取得
	 * @return 流程记录计划执行周期
	 */
	public String getPrclosetime() {
		return prclosetime;
	}

	/**
	 * 功能：流程记录计划执行周期设定
	 * @param prduration 流程记录计划执行周期
	 */
	public void setPrclosetime(String prclosetime) {
		this.prclosetime = prclosetime;
	}

	/**
	 * 功能：流程记录工单号取得
	 * @return 流程记录工单号
	 */
	public String getPrserialnum() {
		return prserialnum;
	}

	/**
	 * 功能：流程记录工单号设定
	 * @param prserialnum 流程记录工单号
	 */
	public void setPrserialnum(String prserialnum) {
		this.prserialnum = prserialnum;
	}
	
	/**
	 *事件类别code取得
	 * 
	 * @return 事件类别code
	 */
	public String getPaeventtypecode() {
		return paeventtypecode;
	}

	/**
	 *事件类别code设定
	 * 
	 * @param paeventtypecode事件类别code
	 */
	public void setPaeventtypecode(String paeventtypecode) {
		this.paeventtypecode = paeventtypecode;
	}
}
