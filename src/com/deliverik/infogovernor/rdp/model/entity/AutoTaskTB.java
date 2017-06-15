/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
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
  * 概述: AutoTask实体
  * 功能描述: AutoTask实体
  * 创建记录: 2014/04/16
  * 修改记录: 
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
	
	/** 脚本执行附加参数 */
	protected String scriptParam;
	
	/** 升级包部署路径 */
	protected String rdpFilePath;
	
	/** 获取日志路径  */
	protected String resultLogPath;
	
	/** 当前升级文件和脚本的路径 */
	protected String currentFilePath;
	
	/** 任务执行状态 */
	protected Integer state;
	
	protected String scriptname;
	
	@Transient
	protected String bsmname;
	
	/**
	 * id取得
	 *
	 * @return id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * id设定
	 *
	 * @param id id
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * taskName取得
	 *
	 * @return taskName
	 */
	public String getTaskName() {
		return taskName;
	}

	/**
	 * taskName设定
	 *
	 * @param taskName taskName
	 */
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	/**
	 * businessSystemid取得
	 *
	 * @return businessSystemid
	 */
	public Integer getBusinessSystemid() {
		return businessSystemid;
	}

	/**
	 * businessSystemid设定
	 *
	 * @param businessSystemid businessSystemid
	 */
	public void setBusinessSystemid(Integer businessSystemid) {
		this.businessSystemid = businessSystemid;
	}

	/**
	 * hosts取得
	 *
	 * @return hosts
	 */
	public String getHosts() {
		return hosts;
	}

	/**
	 * hosts设定
	 *
	 * @param hosts hosts
	 */
	public void setHosts(String hosts) {
		this.hosts = hosts;
	}

	/**
	 * excutetime取得
	 *
	 * @return excutetime
	 */
	public String getExcutetime() {
		return excutetime;
	}

	/**
	 * excutetime设定
	 *
	 * @param excutetime excutetime
	 */
	public void setExcutetime(String excutetime) {
		this.excutetime = excutetime;
	}

	/**
	 * scriptPath取得
	 *
	 * @return scriptPath
	 */
	public String getScriptPath() {
		return scriptPath;
	}

	/**
	 * scriptPath设定
	 *
	 * @param scriptPath scriptPath
	 */
	public void setScriptPath(String scriptPath) {
		this.scriptPath = scriptPath;
	}

	/**
	 * version取得
	 *
	 * @return version
	 */
	public String getVersion() {
		return version;
	}

	/**
	 * version设定
	 *
	 * @param version version
	 */
	public void setVersion(String version) {
		this.version = version;
	}

	/**
	 * 主键取得
	 *
	 * @return 主键
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