/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.soc.asset.model.condition;

/**
 * ����: ��־��Ϣ���������ӿ�
 * ��������: ��־��Ϣ���������ӿ�
 * ������¼:
 * �޸ļ�¼: 
 */
public class SOC0153SearchCondImpl implements
SOC0153SearchCond {
	
	private String warnType;
	private Integer ciType;
	private String logName;
	private String logStatus;
	private String sDate;
	private String eDate;
	private String serverIP;
	
	public String getSDate() {
		return sDate;
	}
	public void setSDate(String date) {
		sDate = date;
	}
	public String getEDate() {
		return eDate;
	}
	public void setEDate(String date) {
		eDate = date;
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
	public String getLogName() {
		return logName;
	}
	public void setLogName(String logName) {
		this.logName = logName;
	}
	public String getLogStatus() {
		return logStatus;
	}
	public void setLogStatus(String logStatus) {
		this.logStatus = logStatus;
	}
	

	
}