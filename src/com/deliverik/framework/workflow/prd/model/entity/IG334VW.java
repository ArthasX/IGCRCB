/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prd.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

import com.deliverik.framework.workflow.prd.model.IG334VWInfo;

/**
 * 概述: 流程策略设定信息
 * 功能描述: 流程策略设定信息
 * 创建记录: 2013/09/04
 * 修改记录: 
 */
@SuppressWarnings("serial")
@Entity
@IdClass(IG334VWPK.class)
public class IG334VW implements Serializable,Cloneable, IG334VWInfo {
	
	/** 流程策略对应状态主键 */
	@Id
	protected String psdid;
	
	/** 表单定义ID */
	@Id
	protected String pidid;
	
	/** 流程策略相关表单值 */
	@Id
	protected String pivalue;
	
	/** 流程类型ID */
	protected String pdid;
	
	/** 流程策略发送短信标识 */
	protected String sms;
	
	/** 流程策略发送邮件标识 */
	protected String email;
	
	/** 流程策略对应状态标识 */
	protected String psdcode;
	
	/** 流程策略对应状态名称 */
	protected String psdname;
	
	/** 流程策略相关表单名称 */
	protected String pidname;
	
	/** 流程策略超时提醒天数 */
	protected Integer notifyd;
	
	/** 流程策略超时提醒小时 */
	protected Integer notifyh;
	
	/** 流程策略超时提醒分钟 */
	protected Integer notifym;
	
	/** 流程策略报告上级天数 */
	protected Integer reportd;
	
	/** 流程策略报告上级小时 */
	protected Integer reporth;
	
	/** 流程策略报告上级分钟 */
	protected Integer reportm;
	
	/** 流程策略提醒角色ID */
	protected Integer roleid;
	
	/** 流程策略提醒调用BL */
	protected String processbl;
	
	/** 流程策略提醒是否上报角色负责人 */
	protected String rolemanager;
	
	/** 是否确认 */
	protected String psdconfirm;

	/**
	 * 表单定义ID取得
	 *
	 * @return pidid 表单定义ID
	 */
	public String getPidid() {
		return pidid;
	}

	/**
	 * 表单定义ID设定
	 *
	 * @param pidid 表单定义ID
	 */
	public void setPidid(String pidid) {
		this.pidid = pidid;
	}

	/**
	 * 流程类型ID取得
	 *
	 * @return pdid 流程类型ID
	 */
	public String getPdid() {
		return pdid;
	}

	/**
	 * 流程类型ID设定
	 *
	 * @param pdid 流程类型ID
	 */
	public void setPdid(String pdid) {
		this.pdid = pdid;
	}

	/**
	 * 流程策略发送短信标识取得
	 *
	 * @return sms 流程策略发送短信标识
	 */
	public String getSms() {
		return sms;
	}

	/**
	 * 流程策略发送短信标识设定
	 *
	 * @param sms 流程策略发送短信标识
	 */
	public void setSms(String sms) {
		this.sms = sms;
	}

	/**
	 * 流程策略发送邮件标识取得
	 *
	 * @return email 流程策略发送邮件标识
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * 流程策略发送邮件标识设定
	 *
	 * @param email 流程策略发送邮件标识
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * 流程策略对应状态主键取得
	 *
	 * @return psdid 流程策略对应状态主键
	 */
	public String getPsdid() {
		return psdid;
	}

	/**
	 * 流程策略对应状态主键设定
	 *
	 * @param psdid 流程策略对应状态主键
	 */
	public void setPsdid(String psdid) {
		this.psdid = psdid;
	}

	/**
	 * 流程策略对应状态标识取得
	 *
	 * @return psdcode 流程策略对应状态标识
	 */
	public String getPsdcode() {
		return psdcode;
	}

	/**
	 * 流程策略对应状态标识设定
	 *
	 * @param psdcode 流程策略对应状态标识
	 */
	public void setPsdcode(String psdcode) {
		this.psdcode = psdcode;
	}

	/**
	 * 流程策略对应状态名称取得
	 *
	 * @return psdname 流程策略对应状态名称
	 */
	public String getPsdname() {
		return psdname;
	}

	/**
	 * 流程策略对应状态名称设定
	 *
	 * @param psdname 流程策略对应状态名称
	 */
	public void setPsdname(String psdname) {
		this.psdname = psdname;
	}

	/**
	 * 流程策略相关表单名称取得
	 *
	 * @return pidname 流程策略相关表单名称
	 */
	public String getPidname() {
		return pidname;
	}

	/**
	 * 流程策略相关表单名称设定
	 *
	 * @param pidname 流程策略相关表单名称
	 */
	public void setPidname(String pidname) {
		this.pidname = pidname;
	}

	/**
	 * 流程策略相关表单值取得
	 *
	 * @return pivalue 流程策略相关表单值
	 */
	public String getPivalue() {
		return pivalue;
	}

	/**
	 * 流程策略相关表单值设定
	 *
	 * @param pivalue 流程策略相关表单值
	 */
	public void setPivalue(String pivalue) {
		this.pivalue = pivalue;
	}

	/**
	 * 流程策略超时提醒天数取得
	 *
	 * @return notifyd 流程策略超时提醒天数
	 */
	public Integer getNotifyd() {
		return notifyd;
	}

	/**
	 * 流程策略超时提醒天数设定
	 *
	 * @param notifyd 流程策略超时提醒天数
	 */
	public void setNotifyd(Integer notifyd) {
		this.notifyd = notifyd;
	}

	/**
	 * 流程策略超时提醒小时取得
	 *
	 * @return notifyh 流程策略超时提醒小时
	 */
	public Integer getNotifyh() {
		return notifyh;
	}

	/**
	 * 流程策略超时提醒小时设定
	 *
	 * @param notifyh 流程策略超时提醒小时
	 */
	public void setNotifyh(Integer notifyh) {
		this.notifyh = notifyh;
	}

	/**
	 * 流程策略超时提醒分钟取得
	 *
	 * @return notifym 流程策略超时提醒分钟
	 */
	public Integer getNotifym() {
		return notifym;
	}

	/**
	 * 流程策略超时提醒分钟设定
	 *
	 * @param notifym 流程策略超时提醒分钟
	 */
	public void setNotifym(Integer notifym) {
		this.notifym = notifym;
	}

	/**
	 * 流程策略报告上级天数取得
	 *
	 * @return reportd 流程策略报告上级天数
	 */
	public Integer getReportd() {
		return reportd;
	}

	/**
	 * 流程策略报告上级天数设定
	 *
	 * @param reportd 流程策略报告上级天数
	 */
	public void setReportd(Integer reportd) {
		this.reportd = reportd;
	}

	/**
	 * 流程策略报告上级小时取得
	 *
	 * @return reporth 流程策略报告上级小时
	 */
	public Integer getReporth() {
		return reporth;
	}

	/**
	 * 流程策略报告上级小时设定
	 *
	 * @param reporth 流程策略报告上级小时
	 */
	public void setReporth(Integer reporth) {
		this.reporth = reporth;
	}

	/**
	 * 流程策略报告上级分钟取得
	 *
	 * @return reportm 流程策略报告上级分钟
	 */
	public Integer getReportm() {
		return reportm;
	}

	/**
	 * 流程策略报告上级分钟设定
	 *
	 * @param reportm 流程策略报告上级分钟
	 */
	public void setReportm(Integer reportm) {
		this.reportm = reportm;
	}

	/**
	 * 流程策略提醒角色ID取得
	 *
	 * @return roleid 流程策略提醒角色ID
	 */
	public Integer getRoleid() {
		return roleid;
	}

	/**
	 * 流程策略提醒角色ID设定
	 *
	 * @param roleid 流程策略提醒角色ID
	 */
	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}

	/**
	 * 流程策略提醒调用BL取得
	 *
	 * @return processbl 流程策略提醒调用BL
	 */
	public String getProcessbl() {
		return processbl;
	}

	/**
	 * 流程策略提醒调用BL设定
	 *
	 * @param processbl 流程策略提醒调用BL
	 */
	public void setProcessbl(String processbl) {
		this.processbl = processbl;
	}

	/**
	 * 流程策略提醒是否上报角色负责人取得
	 *
	 * @return rolemanager 流程策略提醒是否上报角色负责人
	 */
	public String getRolemanager() {
		return rolemanager;
	}

	/**
	 * 流程策略提醒是否上报角色负责人设定
	 *
	 * @param rolemanager 流程策略提醒是否上报角色负责人
	 */
	public void setRolemanager(String rolemanager) {
		this.rolemanager = rolemanager;
	}

	/**
	 * 是否确认取得
	 *
	 * @return psdconfirm 是否确认
	 */
	public String getPsdconfirm() {
		return psdconfirm;
	}

	/**
	 * 是否确认设定
	 *
	 * @param psdconfirm 是否确认
	 */
	public void setPsdconfirm(String psdconfirm) {
		this.psdconfirm = psdconfirm;
	}
	
	
}
