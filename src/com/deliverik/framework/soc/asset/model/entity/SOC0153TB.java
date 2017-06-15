/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
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
 * ����: ��־��Ϣ��
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
	/**ID��������*/
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="SOC0153_GENERATOR")
	private Integer lid;
	/**��־����*/
	private String logName;
	/**Ԥ������*/
	private String warnType;
	/**CI����*/
	private Integer ciType; 
	/**��־״̬*/
	private String logStatus;
	/**��־��Ϣ*/
	private String logContent;
	/**��־ʱ��*/
	private String logDate;
	/**�ܴ�С*/
	private String totalSize;
	/**��ʹ��*/
	private String userSize;
	/**ʣ���С*/
	private String surplusSize;
	/**ʹ����*/
	private String userRatio;
	/**������IP*/
	private String serverIP;
	
	/**ӳ��ʵ�� */
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