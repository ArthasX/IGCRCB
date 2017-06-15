/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.soc.asset.model.entity;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.framework.soc.asset.model.SOC0153Info;

/**
 * 概述: 日志信息表
 */
@Entity
@Table(name = "SOC0153", schema = "ig")
public class SOC0153TB extends BaseEntity implements SOC0153Info, Serializable,
		Cloneable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7301133326035958817L;
	@Id
	@SequenceGenerator(
			name="SOC0153_GENERATOR", sequenceName="SOC0153_SEQ", 
			initialValue=1, allocationSize=1
		)
	/**ID（主键）*/
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="SOC0153_GENERATOR")
	private Integer lid;
	/**日志名称*/
	private String logName;
	/**预警类型*/
	private String warnType;
	/**CI类型*/
	private Integer ciType; 
	/**日志状态*/
	private String logStatus;
	/**日志信息*/
	private String logContent;
	/**日志时间*/
	private String logDate;
	/**总大小*/
	private String totalSize;
	/**已使用*/
	private String userSize;
	/**剩余大小*/
	private String surplusSize;
	/**使用率*/
	private String userRatio;
	/**服务器IP*/
	private String serverIP;
	
	/**映射实体 */
	@OneToOne
	@JoinColumn(name="ciType", referencedColumnName="impTypeid", updatable=false, insertable= false)
	@Basic(fetch = FetchType.EAGER)
	@NotFound(action = NotFoundAction.IGNORE)
	protected SOC0113TB soc0113TB;
	
	public void setLid(Integer lid) {
		this.lid = lid;
	}
	public void setLogName(String logName) {
		this.logName = logName;
	}
	public void setWarnType(String warnType) {
		this.warnType = warnType;
	}
	public void setCiType(Integer ciType) {
		this.ciType = ciType;
	}
	public void setLogStatus(String logStatus) {
		this.logStatus = logStatus;
	}
	public void setLogContent(String logContent) {
		this.logContent = logContent;
	}
	public void setLogDate(String logDate) {
		this.logDate = logDate;
	}
	public void setTotalSize(String totalSize) {
		this.totalSize = totalSize;
	}
	public void setUserSize(String userSize) {
		this.userSize = userSize;
	}
	public void setSurplusSize(String surplusSize) {
		this.surplusSize = surplusSize;
	}
	public void setUserRatio(String userRatio) {
		this.userRatio = userRatio;
	}
	public void setServerIP(String serverIP) {
		this.serverIP = serverIP;
	}
	public Integer getLid() {
		return lid;
	}
	public String getLogName() {
		return logName;
	}
	public String getWarnType() {
		return warnType;
	}
	public Integer getCiType() {
		return ciType;
	}
	public String getLogStatus() {
		return logStatus;
	}
	public String getLogContent() {
		return logContent;
	}
	public String getLogDate() {
		return logDate;
	}
	public String getTotalSize() {
		return totalSize;
	}
	public String getUserSize() {
		return userSize;
	}
	public String getSurplusSize() {
		return surplusSize;
	}
	public String getUserRatio() {
		return userRatio;
	}
	public String getServerIP() {
		return serverIP;
	}
	@Override
	public Serializable getPK() {
		return lid;
	}
	public SOC0113TB getSoc0113TB() {
		return soc0113TB;
	}
	public void setSoc0113TB(SOC0113TB soc0113tb) {
		soc0113TB = soc0113tb;
	}
	
	
	
	
	
	
}