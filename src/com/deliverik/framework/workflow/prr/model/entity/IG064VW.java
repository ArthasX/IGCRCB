/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prr.model.entity;
import java.io.Serializable;

import javax.persistence.Id;

import com.deliverik.framework.workflow.prr.model.IG064Info;

/**
  * 概述: 流程记录节点提醒视图实体
  * 功能描述: 流程记录节点提醒视图实体
  * 创建记录: 2012/04/25
  * 修改记录: 
  */
@SuppressWarnings("serial")
@javax.persistence.Entity
public class IG064VW implements Serializable,
		Cloneable, IG064Info {

	/** 流程ID */
	protected Integer prid;
	
	protected String prtitle;

	protected String prserialnum;
	/** 流程状态ID */
	protected String psdid;

	/** 流程定义ID */
	protected String pdid;
	
	protected String psdname;

	/** 流程状态标示 */
	protected String psdcode;

	/** 是否提交（0：否；1：是） */
	protected String psdconfirm;

	/** 当前参与角色ID */
	protected Integer pproleid;

	/** 参与角色名称 */
	protected String pprolename;

	/** 当前参与人员ID */
	protected String ppuserid;

	/** 人员姓名 */
	protected String ppusername;

	/** 接单动作 */
	protected String ppsubstatus;
	
	protected String ppinittime;

	/** 接单时间 */
	protected String ppbacktime;

	/** 策略定义状态ID */
	protected String pnsdpsdid;

	/** 策略表提交标示 */
	protected String pnsdconfirm;

	/** 是否发送短信 */
	protected String sms;

	/** 是否发送EMAIL */
	protected String email;

	/** 通知时间天 */
	protected Integer notifyd;

	/** 通知小时 */
	protected Integer notifyh;

	/** 通知时间分 */
	protected Integer notifym;

	/** 上报天 */
	protected Integer reportd;

	/** 上报时 */
	protected Integer reporth;

	/** 上报分 */
	protected Integer reportm;

	/** 角色负责人 */
	protected String rolemanager;
	
	//====>130225Begin
	/** 状态模式 */
	protected String psdassign;
	
	/** 机构层次码 */
	protected String pporgid;
	
	/** 机构名称 */
	protected String pporgname;
	
	/**
	 * 状态模式取得
	 *
	 * @return psdassign 状态模式
	 */
	public String getPsdassign() {
		return psdassign;
	}

	/**
	 * 状态模式设定
	 *
	 * @param psdassign 状态模式
	 */
	public void setPsdassign(String psdassign) {
		this.psdassign = psdassign;
	}
	
	/**
	 * 机构层次码取得
	 *
	 * @return pporgid 机构层次码
	 */
	public String getPporgid() {
		return pporgid;
	}

	/**
	 * 机构层次码设定
	 *
	 * @param pporgid 机构层次码
	 */
	public void setPporgid(String pporgid) {
		this.pporgid = pporgid;
	}

	/**
	 * 机构名称取得
	 *
	 * @return pporgname 机构名称
	 */
	public String getPporgname() {
		return pporgname;
	}

	/**
	 * 机构名称设定
	 *
	 * @param pporgname 机构名称
	 */
	public void setPporgname(String pporgname) {
		this.pporgname = pporgname;
	}
	//====>130225End
	
	public Integer getPpid() {
		return ppid;
	}

	public void setPpid(Integer ppid) {
		this.ppid = ppid;
	}

	@Id
	protected Integer ppid;
	
	/**
	 * 流程ID取得
	 *
	 * @return 流程ID
	 */
	public Integer getPrid() {
		return prid;
	}

	/**
	 * 流程ID设定
	 *
	 * @param prid 流程ID
	 */
	public void setPrid(Integer prid) {
		this.prid = prid;
	}

	/**
	 * 流程状态ID取得
	 *
	 * @return 流程状态ID
	 */
	public String getPsdid() {
		return psdid;
	}

	/**
	 * 流程状态ID设定
	 *
	 * @param psdid 流程状态ID
	 */
	public void setPsdid(String psdid) {
		this.psdid = psdid;
	}

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
	 * 流程状态标示取得
	 *
	 * @return 流程状态标示
	 */
	public String getPsdcode() {
		return psdcode;
	}

	/**
	 * 流程状态标示设定
	 *
	 * @param psdcode 流程状态标示
	 */
	public void setPsdcode(String psdcode) {
		this.psdcode = psdcode;
	}

	/**
	 * 是否提交（0：否；1：是）取得
	 *
	 * @return 是否提交（0：否；1：是）
	 */
	public String getPsdconfirm() {
		return psdconfirm;
	}

	/**
	 * 是否提交（0：否；1：是）设定
	 *
	 * @param psdconfirm 是否提交（0：否；1：是）
	 */
	public void setPsdconfirm(String psdconfirm) {
		this.psdconfirm = psdconfirm;
	}

	/**
	 * 当前参与角色ID取得
	 *
	 * @return 当前参与角色ID
	 */
	public Integer getPproleid() {
		return pproleid;
	}

	/**
	 * 当前参与角色ID设定
	 *
	 * @param pproleid 当前参与角色ID
	 */
	public void setPproleid(Integer pproleid) {
		this.pproleid = pproleid;
	}

	/**
	 * 参与角色名称取得
	 *
	 * @return 参与角色名称
	 */
	public String getPprolename() {
		return pprolename;
	}

	/**
	 * 参与角色名称设定
	 *
	 * @param pprolename 参与角色名称
	 */
	public void setPprolename(String pprolename) {
		this.pprolename = pprolename;
	}

	/**
	 * 当前参与人员ID取得
	 *
	 * @return 当前参与人员ID
	 */
	public String getPpuserid() {
		return ppuserid;
	}

	/**
	 * 当前参与人员ID设定
	 *
	 * @param ppuserid 当前参与人员ID
	 */
	public void setPpuserid(String ppuserid) {
		this.ppuserid = ppuserid;
	}

	/**
	 * 人员姓名取得
	 *
	 * @return 人员姓名
	 */
	public String getPpusername() {
		return ppusername;
	}

	/**
	 * 人员姓名设定
	 *
	 * @param ppusername 人员姓名
	 */
	public void setPpusername(String ppusername) {
		this.ppusername = ppusername;
	}

	/**
	 * 接单动作取得
	 *
	 * @return 接单动作
	 */
	public String getPpsubstatus() {
		return ppsubstatus;
	}

	/**
	 * 接单动作设定
	 *
	 * @param ppsubstatus 接单动作
	 */
	public void setPpsubstatus(String ppsubstatus) {
		this.ppsubstatus = ppsubstatus;
	}

	/**
	 * 接单时间取得
	 *
	 * @return 接单时间
	 */
	public String getPpbacktime() {
		return ppbacktime;
	}

	/**
	 * 接单时间设定
	 *
	 * @param ppbacktime 接单时间
	 */
	public void setPpbacktime(String ppbacktime) {
		this.ppbacktime = ppbacktime;
	}

	/**
	 * 策略定义状态ID取得
	 *
	 * @return 策略定义状态ID
	 */
	public String getPnsdpsdid() {
		return pnsdpsdid;
	}

	/**
	 * 策略定义状态ID设定
	 *
	 * @param pnsdpsdid 策略定义状态ID
	 */
	public void setPnsdpsdid(String pnsdpsdid) {
		this.pnsdpsdid = pnsdpsdid;
	}

	/**
	 * 策略表提交标示取得
	 *
	 * @return 策略表提交标示
	 */
	public String getPnsdconfirm() {
		return pnsdconfirm;
	}

	/**
	 * 策略表提交标示设定
	 *
	 * @param pnsdconfirm 策略表提交标示
	 */
	public void setPnsdconfirm(String pnsdconfirm) {
		this.pnsdconfirm = pnsdconfirm;
	}

	/**
	 * 是否发送短信取得
	 *
	 * @return 是否发送短信
	 */
	public String getSms() {
		return sms;
	}

	/**
	 * 是否发送短信设定
	 *
	 * @param sms 是否发送短信
	 */
	public void setSms(String sms) {
		this.sms = sms;
	}

	/**
	 * 是否发送EMAIL取得
	 *
	 * @return 是否发送EMAIL
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * 是否发送EMAIL设定
	 *
	 * @param email 是否发送EMAIL
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * 通知时间天取得
	 *
	 * @return 通知时间天
	 */
	public Integer getNotifyd() {
		return notifyd;
	}

	/**
	 * 通知时间天设定
	 *
	 * @param notifyd 通知时间天
	 */
	public void setNotifyd(Integer notifyd) {
		this.notifyd = notifyd;
	}

	/**
	 * 通知小时取得
	 *
	 * @return 通知小时
	 */
	public Integer getNotifyh() {
		return notifyh;
	}

	/**
	 * 通知小时设定
	 *
	 * @param notify 通知小时
	 */
	public void setNotifyh(Integer notifyh) {
		this.notifyh = notifyh;
	}

	/**
	 * 通知时间分取得
	 *
	 * @return 通知时间分
	 */
	public Integer getNotifym() {
		return notifym;
	}

	/**
	 * 通知时间分设定
	 *
	 * @param notifym 通知时间分
	 */
	public void setNotifym(Integer notifym) {
		this.notifym = notifym;
	}

	/**
	 * 上报天取得
	 *
	 * @return 上报天
	 */
	public Integer getReportd() {
		return reportd;
	}

	/**
	 * 上报天设定
	 *
	 * @param reportd 上报天
	 */
	public void setReportd(Integer reportd) {
		this.reportd = reportd;
	}

	/**
	 * 上报时取得
	 *
	 * @return 上报时
	 */
	public Integer getReporth() {
		return reporth;
	}

	/**
	 * 上报时设定
	 *
	 * @param reporth 上报时
	 */
	public void setReporth(Integer reporth) {
		this.reporth = reporth;
	}

	/**
	 * 上报分取得
	 *
	 * @return 上报分
	 */
	public Integer getReportm() {
		return reportm;
	}

	/**
	 * 上报分设定
	 *
	 * @param reportm 上报分
	 */
	public void setReportm(Integer reportm) {
		this.reportm = reportm;
	}

	/**
	 * 角色负责人取得
	 *
	 * @return 角色负责人
	 */
	public String getRolemanager() {
		return rolemanager;
	}

	/**
	 * 角色负责人设定
	 *
	 * @param rolemanager 角色负责人
	 */
	public void setRolemanager(String rolemanager) {
		this.rolemanager = rolemanager;
	}

	public String getPsdname() {
		return psdname;
	}

	public void setPsdname(String psdname) {
		this.psdname = psdname;
	}

	public String getPpinittime() {
		return ppinittime;
	}

	public void setPpinittime(String ppinittime) {
		this.ppinittime = ppinittime;
	}

	public String getPrtitle() {
		return prtitle;
	}

	public void setPrtitle(String prtitle) {
		this.prtitle = prtitle;
	}

	public String getPrserialnum() {
		return prserialnum;
	}

	public void setPrserialnum(String prserialnum) {
		this.prserialnum = prserialnum;
	}
	
}