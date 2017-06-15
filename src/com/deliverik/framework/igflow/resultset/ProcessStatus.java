/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.igflow.resultset;

/**
 * 流程状态定义信息
 */
public class ProcessStatus implements ProcessStatusInfo {
	
	/** 流程状态ID */
	protected String psdid;
	
	/** 流程定义ID */
	protected String pdid;

	/** 流程状态名称 */
	protected String psdname;
	
	/** 流程状态标识 */
	protected String psdcode;
	
	/** 排序 */
	protected String bysequence;

	/** 上级状态ID */
	protected String ppsdid;

	/** 状态开始时间 */
	protected String opentime;
	
	/** 状态结束时间 */
	protected String closetime;

	/** 状态分支编号 */
	protected String statusnum;
	
	/** 时间戳 */
	protected String fingerPrint;
	
	/**
	 * 流程状态ID取得
	 * @return 流程状态ID
	 */
	public String getPsdid() {
		return psdid;
	}

	/**
	 * 流程状态ID设定
	 * @param psdid 流程状态ID
	 */
	public void setPsdid(String psdid) {
		this.psdid = psdid;
	}

	/**
	 * 流程定义ID取得
	 * @return 流程定义ID
	 */
	public String getPdid() {
		return pdid;
	}

	/**
	 * 流程定义ID设定
	 * @param pdid 流程定义ID
	 */
	public void setPdid(String pdid) {
		this.pdid = pdid;
	}

	/**
	 * 流程状态名称取得
	 * @return 流程状态名称
	 */
	public String getPsdname() {
		return psdname;
	}

	/**
	 * 流程状态名称设定
	 * @param psdname 流程状态名称
	 */
	public void setPsdname(String psdname) {
		this.psdname = psdname;
	}
	
	/**
	 * 流程状态标识取得
	 * @return 流程状态标识
	 */
	public String getPsdcode() {
		return psdcode;
	}

	/**
	 * 流程状态标识设定
	 * @param psdcode 流程状态标识
	 */
	public void setPsdcode(String psdcode) {
		this.psdcode = psdcode;
	}

	/**
	 * 排序取得
	 * 
	 * @return 排序
	 */
	public String getBysequence() {
		return bysequence;
	}

	/**
	 * 排序设定
	 * 
	 * @param bysequence 排序
	 */
	public void setBysequence(String bysequence) {
		this.bysequence = bysequence;
	}

	/**
	 * 上级状态ID取得
	 * @return 上级状态ID
	 */
	public String getPpsdid() {
		return ppsdid;
	}

	/**
	 * 上级状态ID设定
	 * @param ppsdid 上级状态ID
	 */
	public void setPpsdid(String ppsdid) {
		this.ppsdid = ppsdid;
	}

	/**
	 * 状态开始时间取得
	 * @return 状态开始时间
	 */
	public String getOpentime() {
		return opentime;
	}

	/**
	 * 状态开始时间设定
	 * @param opentime 状态开始时间
	 */
	public void setOpentime(String opentime) {
		this.opentime = opentime;
	}

	/**
	 * 状态分支编号取得
	 * @return 状态分支编号
	 */
	public String getStatusnum() {
		return statusnum;
	}

	/**
	 * 状态分支编号设定
	 * @param statusnum 状态分支编号
	 */
	public void setStatusnum(String statusnum) {
		this.statusnum = statusnum;
	}

	/**
	 * 状态结束时间取得
	 * @return 状态结束时间
	 */
	public String getClosetime() {
		return closetime;
	}

	/**
	 * 状态结束时间设定
	 * @param closetime 状态结束时间
	 */
	public void setClosetime(String closetime) {
		this.closetime = closetime;
	}

	/**
	 * 时间戳取得
	 * @return fingerPrint 时间戳
	 */
	public String getFingerPrint() {
		return fingerPrint;
	}

	/**
	 * 时间戳设定
	 * @param fingerPrint 时间戳
	 */
	public void setFingerPrint(String fingerPrint) {
		this.fingerPrint = fingerPrint;
	}
	
}
