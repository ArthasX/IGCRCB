/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.asset.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.deliverik.framework.asset.model.StorageEventInfo;
import com.deliverik.framework.base.BaseEntity;

/**
  * 概述: StorageEvent实体
  * 功能描述: StorageEvent实体
  * 创建记录: 2011/06/13
  * 修改记录: 
  */
@SuppressWarnings("serial")
@Entity
@IdClass(StorageEventPK.class)
@Table(name="StorageEvent")
public class StorageEventTB extends BaseEntity implements Serializable,
		Cloneable, StorageEventInfo {

	/** 日志记录时间 */
	@Id
	protected String detectiontime;

	/** dir */
	@Id
	protected String dir;

	/** src */
	protected String src;

	/** 种类 */
	@Id
	protected String category;

	/** 级别 */
	@Id
	protected String severity;

	/** 错误号 */
	@Id
	protected String errornum;
	
	/**eirootmark	 */
	@Id
	protected String eirootmark;
	
	/**状态	 */
	protected String state;
	
	/**一级种类	 */
	protected String sort;

	/** 信息描述 */
	protected String errordesc;

	/** 记录时间戳 */
	protected String fingerprint;

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
	 * src取得
	 *
	 * @return src
	 */
	public String getSrc() {
		return src;
	}

	/**
	 * src设定
	 *
	 * @param srcsrc
	 */
	public void setSrc(String src) {
		this.src = src;
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
	 * 信息描述取得
	 *
	 * @return 信息描述
	 */
	public String getErrordesc() {
		return errordesc;
	}

	/**
	 * 信息描述设定
	 *
	 * @param errordesc信息描述
	 */
	public void setErrordesc(String errordesc) {
		this.errordesc = errordesc;
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

	/**
	 * 状态取得
	 * @return state
	 */
	public String getState() {
		return state;
	}

	/**
	 * 状态设置
	 * @param state
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * 一级种类取得
	 * @return sort
	 */
	public String getSort() {
		return sort;
	}

	/**
	 * 一级种类设置
	 * @param sort
	 */
	public void setSort(String sort) {
		this.sort = sort;
	}

	/**
	 * 记录时间戳取得
	 *
	 * @return 记录时间戳
	 */
	public String getFingerprint() {
		return fingerprint;
	}

	/**
	 * 记录时间戳设定
	 *
	 * @param fingerprint记录时间戳
	 */
	public void setFingerprint(String fingerprint) {
		this.fingerprint = fingerprint;
	}

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Serializable getPK() {
		return new StorageEventPK(detectiontime, dir, category, severity, errornum, eirootmark);
	}

}