/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prd.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.framework.workflow.prd.model.IG334Info;

/**
  * 概述: 通知策略基本信息实体
  * 功能描述: 通知策略基本信息实体
  * 创建记录: 2013/09/03
  * 修改记录: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="IG334")
public class IG334TB extends BaseEntity implements Serializable,
		Cloneable, IG334Info {

	/** 流程定义ID */
	@Id
	protected String pdid;

	/** 短信通知 */
	protected String sms;

	/** 通知邮件 */
	protected String email;

	/** 表单定义ID */
	protected String pidid;
	
	/** 表单定义名称 */
	protected String pidname;

	/** 天 */
	protected Integer notifyd;

	/** 小时 */
	protected Integer notifyh;

	/** 分 */
	protected Integer notifym;

	/** 角色ID */
	protected Integer roleid;

	/** 处理BL */
	protected String processbl;
	
	/**
	 * 流程定义ID取得
	 *
	 * @return 流程定义ID
	 */
	public String getPdid() {
		return pdid;
	}

	/**
	 * 流程定义ID设定
	 *
	 * @param pdid 流程定义ID
	 */
	public void setPdid(String pdid) {
		this.pdid = pdid;
	}

	/**
	 * 短信通知取得
	 *
	 * @return 短信通知
	 */
	public String getSms() {
		return sms;
	}

	/**
	 * 短信通知设定
	 *
	 * @param sms 短信通知
	 */
	public void setSms(String sms) {
		this.sms = sms;
	}

	/**
	 * 通知邮件取得
	 *
	 * @return 通知邮件
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * 通知邮件设定
	 *
	 * @param email 通知邮件
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * 表单定义ID取得
	 * @return pidid 表单定义ID
	 */
	public String getPidid() {
		return pidid;
	}

	/**
	 * 表单定义ID设定
	 * @param pidid 表单定义ID
	 */
	public void setPidid(String pidid) {
		this.pidid = pidid;
	}

	/**
	 * 表单定义名称取得
	 * @return pidname 表单定义名称
	 */
	public String getPidname() {
		return pidname;
	}

	/**
	 * 表单定义名称设定
	 * @param pidname 表单定义名称
	 */
	public void setPidname(String pidname) {
		this.pidname = pidname;
	}

	/**
	 * 天取得
	 * @return notifyd 天
	 */
	public Integer getNotifyd() {
		return notifyd;
	}

	/**
	 * 天设定
	 * @param notifyd 天
	 */
	public void setNotifyd(Integer notifyd) {
		this.notifyd = notifyd;
	}

	/**
	 * 小时取得
	 * @return notifyh 小时
	 */
	public Integer getNotifyh() {
		return notifyh;
	}

	/**
	 * 小时设定
	 * @param notifyh 小时
	 */
	public void setNotifyh(Integer notifyh) {
		this.notifyh = notifyh;
	}

	/**
	 * 分取得
	 * @return notifym 分
	 */
	public Integer getNotifym() {
		return notifym;
	}

	/**
	 * 分设定
	 * @param notifym 分
	 */
	public void setNotifym(Integer notifym) {
		this.notifym = notifym;
	}

	/**
	 * 角色ID取得
	 * @return roleid 角色ID
	 */
	public Integer getRoleid() {
		return roleid;
	}

	/**
	 * 角色ID设定
	 * @param roleid 角色ID
	 */
	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}

	/**
	 * 处理BL取得
	 * @return processbl 处理BL
	 */
	public String getProcessbl() {
		return processbl;
	}

	/**
	 * 处理BL设定
	 * @param processbl 处理BL
	 */
	public void setProcessbl(String processbl) {
		this.processbl = processbl;
	}

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Serializable getPK() {
		return pdid;
	}

}