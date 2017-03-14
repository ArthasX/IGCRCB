/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.asset.model.entity;

import java.io.Serializable;

import com.deliverik.framework.base.BasePK;

/**
  * 概述: StorageEvent实体主键
  * 功能描述: StorageEvent实体主键
  * 创建记录: 2011/06/13
  * 修改记录: 
  */
@SuppressWarnings("serial")
public class StorageEventPK extends BasePK implements Serializable {

	/** 日志记录时间 */
	protected String detectiontime;

	/** dir */
	protected String dir;
	
	/** 种类 */
	protected String category;
	
	/** 级别 */
	protected String severity;

	/** 错误号 */
	protected String errornum;

	/** eirootmark */
	protected String eirootmark;
	
	/**
	 * 构造函数
	 */
	public StorageEventPK() {

	}

	/**
	 * 构造函数
	 */
	public StorageEventPK(String detectiontime,String  dir, String errornum, String eirootmark, String category, String severity) {
		super();
		this.detectiontime = detectiontime;
		this.dir = dir;
		this.category=category;
		this.severity=severity;
		this.errornum = errornum;
		this.eirootmark=eirootmark;
		
	}

	/**
	 * 日志记录时间取得
	 *
	 * @return 日志记录时间
	 */
	public String getDetectiontime() {
		return detectiontime;
	}

	/**
	 * 日志记录时间设定
	 *
	 * @param detectiontime日志记录时间
	 */
	public void setDetectiontime(String detectiontime) {
		this.detectiontime = detectiontime;
	}

	/**
	 * dir取得
	 *
	 * @return dir
	 */
	public String getDir() {
		return dir;
	}

	/**
	 * dir设定
	 *
	 * @param dirdir
	 */
	public void setDir(String dir) {
		this.dir = dir;
	}

	/**
	 * 种类取得
	 *
	 * @return 种类
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * 种类设定
	 *
	 * @param category种类
	 */
	public void setCategory(String category) {
		this.category = category;
	}

	/**
	 * 级别取得
	 *
	 * @return 级别
	 */
	public String getSeverity() {
		return severity;
	}

	/**
	 * 级别设定
	 *
	 * @param severity级别
	 */
	public void setSeverity(String severity) {
		this.severity = severity;
	}

	/**
	 * 错误号取得
	 *
	 * @return 错误号
	 */
	public String getErrornum() {
		return errornum;
	}

	/**
	 * 错误号设定
	 *
	 * @param errornum错误号
	 */
	public void setErrornum(String errornum) {
		this.errornum = errornum;
	}

	/**
	 * eirootmark取得
	 * @return eirootmark
	 */
	public String getEirootmark() {
		return eirootmark;
	}

	/**
	 * eirootmark设置
	 * @param eirootmark
	 */
	public void setEirootmark(String eirootmark) {
		this.eirootmark = eirootmark;
	}
}