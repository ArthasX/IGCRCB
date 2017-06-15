package com.deliverik.infogovernor.soc.cim.form;

import com.deliverik.framework.base.BaseForm;

/**
 * 日志查看画面FORM
 * 
 */
public class IGCIM1701Form extends BaseForm {

	private static final long serialVersionUID = 1L;

	private Integer lid;
	private String logName;
	private String warnType;
	private Integer ciType; 
	private String logStatus;
	private String logContent;
	private String logDate;
	private String totalSize;
	private String userSize;
	private String surplusSize;
	private String userRaio;
	private String serverIP;
	private String sDate;
	private String eDate;
	
	public Integer getLid() {
		return lid;
	}
	public void setLid(Integer lid) {
		this.lid = lid;
	}
	public String getLogName() {
		return logName;
	}
	public void setLogName(String logName) {
		this.logName = logName;
	}
	public String getWarnType() {
		return warnType;
	}
	public void setWarnType(String warnType) {
		this.warnType = warnType;
	}
	public Integer getCiType() {
		return ciType;
	}
	public void setCiType(Integer ciType) {
		this.ciType = ciType;
	}
	public String getLogStatus() {
		return logStatus;
	}
	public void setLogStatus(String logStatus) {
		this.logStatus = logStatus;
	}
	public String getLogContent() {
		return logContent;
	}
	public void setLogContent(String logContent) {
		this.logContent = logContent;
	}
	public String getLogDate() {
		return logDate;
	}
	public void setLogDate(String logDate) {
		this.logDate = logDate;
	}
	public String getTotalSize() {
		return totalSize;
	}
	public void setTotalSize(String totalSize) {
		this.totalSize = totalSize;
	}
	public String getUserSize() {
		return userSize;
	}
	public void setUserSize(String userSize) {
		this.userSize = userSize;
	}
	public String getSurplusSize() {
		return surplusSize;
	}
	public void setSurplusSize(String surplusSize) {
		this.surplusSize = surplusSize;
	}
	public String getUserRaio() {
		return userRaio;
	}
	public void setUserRaio(String userRaio) {
		this.userRaio = userRaio;
	}
	public String getServerIP() {
		return serverIP;
	}
	public void setServerIP(String serverIP) {
		this.serverIP = serverIP;
	}
	public String getsDate() {
		return sDate;
	}
	public void setsDate(String sDate) {
		this.sDate = sDate;
	}
	public String geteDate() {
		return eDate;
	}
	public void seteDate(String eDate) {
		this.eDate = eDate;
	}
	
	
	

}
