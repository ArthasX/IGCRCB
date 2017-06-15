/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prd.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.framework.workflow.prd.model.IG335Info;

/**
  * 概述: 表单策略表实体
  * 功能描述: 表单策略表实体
  * 创建记录: 2013/09/03
  * 修改记录: 
  */
@SuppressWarnings("serial")
@Entity
@IdClass(IG335PK.class)
@Table(name="IG335")
public class IG335TB extends BaseEntity implements Serializable,
		Cloneable, IG335Info {

	/** 状态定义ID */
	@Id
	protected String psdid;

	/** 表单定义ID */
	@Id
	protected String pidid;

	/** 表单值 */
	@Id
	protected String pivalue;

	/** 确认节点是否  */
	@Id
	protected String psdconfirm;

	/** 流程定义ID */
	@Id
	protected String pdid;
	
	/** 天 */
	protected Integer notifyd;

	/** 小时 */
	protected Integer notifyh;

	/** 分 */
	protected Integer notifym;
	
	/** 上报_天 */
	protected Integer reportd;
	
	/** 上报_小时 */
	protected Integer reporth;
	
	/** 上报_分 */
	protected Integer reportm;

	/** 角色ID */
	protected Integer roleid;
	
	/** 角色名称 */
	protected String rolename;
	
	/** 上报角色负责人 */
	protected String rolemanager;

	/** 处理BL */
	protected String processbl;

	/** 通知人ID */
	@Transient
	protected String notifierids;
	
	/** 通知人名称 */
	@Transient
	protected String notifiernames;
	
	/**
	 * 状态定义ID取得
	 *
	 * @return 状态定义ID
	 */
	public String getPsdid() {
		return psdid;
	}

	/**
	 * 状态定义ID设定
	 *
	 * @param psdid 状态定义ID
	 */
	public void setPsdid(String psdid) {
		this.psdid = psdid;
	}

	/**
	 * 表单定义ID取得
	 *
	 * @return 表单定义ID
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
	 * 表单值取得
	 * @return pivalue 表单值
	 */
	public String getPivalue() {
		return pivalue;
	}

	/**
	 * 表单值设定
	 * @param pivalue 表单值
	 */
	public void setPivalue(String pivalue) {
		this.pivalue = pivalue;
	}

	/**
	 * 确认节点是否取得
	 * @return psdconfirm 确认节点是否
	 */
	public String getPsdconfirm() {
		return psdconfirm;
	}

	/**
	 * 确认节点是否设定
	 * @param psdconfirm 确认节点是否
	 */
	public void setPsdconfirm(String psdconfirm) {
		this.psdconfirm = psdconfirm;
	}

	/**
	 * 流程定义ID取得
	 * @return pdid
	 */
	public String getPdid() {
		return pdid;
	}
	/**
	 * 流程定义ID设定
	 * @param pdid
	 */
	public void setPdid(String pdid) {
		this.pdid = pdid;
	}

	/**
	 * 天取得
	 *
	 * @return 天
	 */
	public Integer getNotifyd() {
		return notifyd;
	}

	/**
	 * 天设定
	 *
	 * @param notifyd 天
	 */
	public void setNotifyd(Integer notifyd) {
		this.notifyd = notifyd;
	}

	/**
	 * 小时取得
	 *
	 * @return 小时
	 */
	public Integer getNotifyh() {
		return notifyh;
	}

	/**
	 * 小时设定
	 *
	 * @param notifyh 小时
	 */
	public void setNotifyh(Integer notifyh) {
		this.notifyh = notifyh;
	}

	/**
	 * 分取得
	 *
	 * @return 分
	 */
	public Integer getNotifym() {
		return notifym;
	}

	/**
	 * 分设定
	 *
	 * @param notifym 分
	 */
	public void setNotifym(Integer notifym) {
		this.notifym = notifym;
	}

	/**
	 * 上报_天取得
	 * @return reportd 上报_天
	 */
	public Integer getReportd() {
		return reportd;
	}

	/**
	 * 上报_天设定
	 * @param reportd 上报_天
	 */
	public void setReportd(Integer reportd) {
		this.reportd = reportd;
	}

	/**
	 * 上报_小时取得
	 * @return reporth 上报_小时
	 */
	public Integer getReporth() {
		return reporth;
	}

	/**
	 * 上报_小时设定
	 * @param reporth 上报_小时
	 */
	public void setReporth(Integer reporth) {
		this.reporth = reporth;
	}

	/**
	 * 上报_分取得
	 * @return reportm 上报_分
	 */
	public Integer getReportm() {
		return reportm;
	}

	/**
	 * 上报_分设定
	 * @param reportm 上报_分
	 */
	public void setReportm(Integer reportm) {
		this.reportm = reportm;
	}

	/**
	 * 角色ID取得
	 *
	 * @return 角色ID
	 */
	public Integer getRoleid() {
		return roleid;
	}

	/**
	 * 角色ID设定
	 *
	 * @param roleid 角色ID
	 */
	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}

	/**
	 * 角色名称取得
	 * @return rolename 角色名称
	 */
	public String getRolename() {
		return rolename;
	}

	/**
	 * 角色名称设定
	 * @param rolename 角色名称
	 */
	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	/**
	 * 上报角色负责人取得
	 * @return rolemanager 上报角色负责人
	 */
	public String getRolemanager() {
		return rolemanager;
	}

	/**
	 * 上报角色负责人设定
	 * @param rolemanager 上报角色负责人
	 */
	public void setRolemanager(String rolemanager) {
		this.rolemanager = rolemanager;
	}

	/**
	 * 处理BL取得
	 *
	 * @return 处理BL
	 */
	public String getProcessbl() {
		return processbl;
	}

	/**
	 * 处理BL设定
	 *
	 * @param processbl 处理BL
	 */
	public void setProcessbl(String processbl) {
		this.processbl = processbl;
	}

	/**
	 * 通知人ID取得
	 * @return notifierids 通知人ID
	 */
	public String getNotifierids() {
		return notifierids;
	}

	/**
	 * 通知人ID设定
	 * @param notifierids 通知人ID
	 */
	public void setNotifierids(String notifierids) {
		this.notifierids = notifierids;
	}

	/**
	 * 通知人名称取得
	 * @return notifiernames 通知人名称
	 */
	public String getNotifiernames() {
		return notifiernames;
	}

	/**
	 * 通知人名称设定
	 * @param notifiernames 通知人名称
	 */
	public void setNotifiernames(String notifiernames) {
		this.notifiernames = notifiernames;
	}

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Serializable getPK() {
		return new IG335PK(psdid, pdid, pidid, pivalue, psdconfirm);
	}

}