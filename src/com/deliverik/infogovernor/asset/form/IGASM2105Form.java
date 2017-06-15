/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.asset.form;

import com.deliverik.framework.asset.model.AuditTaskInfo;
import com.deliverik.framework.base.BaseForm;

/**
 * 概述: 审计任务Form
 * 功能描述: 审计任务Form
 * 创建记录: 2011/05/19
 * 修改记录: 
 */
public class IGASM2105Form extends BaseForm implements AuditTaskInfo{
	
	private static final long serialVersionUID = 1L;
	
	/** 逻辑主键 */
	protected Integer autid;

	/** 审计任务描述 */
	protected String autdesc;

	/** 审计时间戳 */
	protected String auttime;
	
	/** 状态 */
	protected String autstatus;
	
	/** 编辑模式（登记/变更） */
	protected String mode = "0";
	
	/** 最后更新时间 */
	protected String autupdtime;
	
	/** 最后对比时间 */
	protected String autcomptime;

	/**
	 * 逻辑主键取得
	 *
	 * @return 逻辑主键
	 */
	public Integer getAutid() {
		return autid;
	}

	/**
	 * 逻辑主键设定
	 *
	 * @param autid 逻辑主键
	 */
	public void setAutid(Integer autid) {
		this.autid = autid;
	}

	/**
	 * 审计任务描述取得
	 *
	 * @return 审计任务描述
	 */
	public String getAutdesc() {
		return autdesc;
	}

	/**
	 * 审计任务描述设定
	 *
	 * @param autdesc 审计任务描述
	 */
	public void setAutdesc(String autdesc) {
		this.autdesc = autdesc;
	}

	/**
	 * 审计时间戳取得
	 *
	 * @return 审计时间戳
	 */
	public String getAuttime() {
		return auttime;
	}

	/**
	 * 审计时间戳设定
	 *
	 * @param auttime 审计时间戳
	 */
	public void setAuttime(String auttime) {
		this.auttime = auttime;
	}
	/**
	 * 编辑模式（登记/变更）
	 * @return 编辑模式（登记/变更）
	 */
	public String getMode() {
		return mode;
	}

	/**
	 * 编辑模式（登记/变更）
	 * @param mode编辑模式（登记/变更）
	 */
	public void setMode(String mode) {
		this.mode = mode;
	}

	/**
	 * 状态取得
	 * 
	 * @return 状态
	 */
	public String getAutstatus() {
		return autstatus;
	}

	/**
	 * 状态设定
	 * 
	 * @param autstatus 状态
	 */
	public void setAutstatus(String autstatus) {
		this.autstatus = autstatus;
	}
	
	/**
	 * 记录时间戳
	 */
	public String getFingerPrint() {
		return null;
	}

	/**
	 * 最后更新时间取得
	 * @return 最后更新时间
	 */
	public String getAutupdtime() {
		return autupdtime;
	}

	/**
	 * 最后更新时间设定
	 * @param autupdtime 最后更新时间
	 */ 
	public void setAutupdtime(String autupdtime) {
		this.autupdtime = autupdtime;
	}

	/**
	 * 最后对比时间取得
	 * @return 最后对比时间
	 */
	public String getAutcomptime() {
		return autcomptime;
	}

	/**
	 * 最后对比时间设定
	 * @param autcomptime 最后对比时间
	 */
	public void setAutcomptime(String autcomptime) {
		this.autcomptime = autcomptime;
	}
}
