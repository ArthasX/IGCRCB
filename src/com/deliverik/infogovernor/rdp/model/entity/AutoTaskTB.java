/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.rdp.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Transient;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.rdp.model.AutoTaskInfo;

/**
  * ����: AutoTaskʵ��
  * ��������: AutoTaskʵ��
  * ������¼: 2014/04/16
  * �޸ļ�¼: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="AutoTask")
public class AutoTaskTB extends BaseEntity implements Serializable,
		Cloneable, AutoTaskInfo {

	/** id */
	@Id
	@TableGenerator(
			name="AutoTask_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
			pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
			pkColumnValue="AUTOTASK_SEQUENCE", initialValue=1, allocationSize=1
		)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="AutoTask_TABLE_GENERATOR")
	protected Integer id;

	/** taskName */
	protected String taskName;

	/** businessSystemid */
	protected Integer businessSystemid;

	/** hosts */
	protected String hosts;

	/** excutetime */
	protected String excutetime;

	/** scriptPath */
	protected String scriptPath;

	/** version */
	protected String version;
	
	/** �ű�ִ�и��Ӳ��� */
	protected String scriptParam;
	
	/** ����������·�� */
	protected String rdpFilePath;
	
	/** ��ȡ��־·��  */
	protected String resultLogPath;
	
	/** ��ǰ�����ļ��ͽű���·�� */
	protected String currentFilePath;
	
	/** ����ִ��״̬ */
	protected Integer state;
	
	protected String scriptname;
	
	@Transient
	protected String bsmname;
	
	/**
	 * idȡ��
	 *
	 * @return id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * id�趨
	 *
	 * @param id id
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * taskNameȡ��
	 *
	 * @return taskName
	 */
	public String getTaskName() {
		return taskName;
	}

	/**
	 * taskName�趨
	 *
	 * @param taskName taskName
	 */
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	/**
	 * businessSystemidȡ��
	 *
	 * @return businessSystemid
	 */
	public Integer getBusinessSystemid() {
		return businessSystemid;
	}

	/**
	 * businessSystemid�趨
	 *
	 * @param businessSystemid businessSystemid
	 */
	public void setBusinessSystemid(Integer businessSystemid) {
		this.businessSystemid = businessSystemid;
	}

	/**
	 * hostsȡ��
	 *
	 * @return hosts
	 */
	public String getHosts() {
		return hosts;
	}

	/**
	 * hosts�趨
	 *
	 * @param hosts hosts
	 */
	public void setHosts(String hosts) {
		this.hosts = hosts;
	}

	/**
	 * excutetimeȡ��
	 *
	 * @return excutetime
	 */
	public String getExcutetime() {
		return excutetime;
	}

	/**
	 * excutetime�趨
	 *
	 * @param excutetime excutetime
	 */
	public void setExcutetime(String excutetime) {
		this.excutetime = excutetime;
	}

	/**
	 * scriptPathȡ��
	 *
	 * @return scriptPath
	 */
	public String getScriptPath() {
		return scriptPath;
	}

	/**
	 * scriptPath�趨
	 *
	 * @param scriptPath scriptPath
	 */
	public void setScriptPath(String scriptPath) {
		this.scriptPath = scriptPath;
	}

	/**
	 * versionȡ��
	 *
	 * @return version
	 */
	public String getVersion() {
		return version;
	}

	/**
	 * version�趨
	 *
	 * @param version version
	 */
	public void setVersion(String version) {
		this.version = version;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Serializable getPK() {
		return id;
	}

	public String getScriptParam() {
		return scriptParam;
	}

	public void setScriptParam(String scriptParam) {
		this.scriptParam = scriptParam;
	}

	public String getRdpFilePath() {
		return rdpFilePath;
	}

	public void setRdpFilePath(String rdpFilePath) {
		this.rdpFilePath = rdpFilePath;
	}

	public String getResultLogPath() {
		return resultLogPath;
	}

	public void setResultLogPath(String resultLogPath) {
		this.resultLogPath = resultLogPath;
	}

	public String getCurrentFilePath() {
		return currentFilePath;
	}

	public void setCurrentFilePath(String currentFilePath) {
		this.currentFilePath = currentFilePath;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public String getScriptname() {
		return scriptname;
	}

	public void setScriptname(String scriptname) {
		this.scriptname = scriptname;
	}

	public String getBsmname() {
		return bsmname;
	}

	public void setBsmname(String bsmname) {
		this.bsmname = bsmname;
	}

	
}