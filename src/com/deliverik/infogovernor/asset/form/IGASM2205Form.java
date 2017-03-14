/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.asset.form;

import com.deliverik.framework.asset.model.CITaskInfo;
import com.deliverik.framework.base.BaseForm;

/**
 * 概述: CI变更任务Form
 * 功能描述: CI变更任务Form
 * 创建记录: 2011/05/19
 * 修改记录: 
 */
public class IGASM2205Form extends BaseForm implements CITaskInfo{
	
	private static final long serialVersionUID = 1L;
	
	/** 逻辑主键 */
	protected Integer citid;

	/** CI变更任务描述 */
	protected String citdesc;

	/** CI变更时间戳 */
	protected String cittime;
	
	/** 状态 */
	protected String citstatus;
	
	/** 编辑模式（登记/变更） */
	protected String mode = "0";
	
	/** 最后更新时间 */
	protected String citupdtime;
	
	/** 最后对比时间 */
	protected String citcomptime;

	/**
	 * 逻辑主键取得
	 *
	 * @return 逻辑主键
	 */
	public Integer getCitid() {
		return citid;
	}

	/**
	 * 逻辑主键设定
	 *
	 * @param citid 逻辑主键
	 */
	public void setCitid(Integer citid) {
		this.citid = citid;
	}

	/**
	 * CI变更任务描述取得
	 *
	 * @return CI变更任务描述
	 */
	public String getCitdesc() {
		return citdesc;
	}

	/**
	 * CI变更任务描述设定
	 *
	 * @param citdesc CI变更任务描述
	 */
	public void setCitdesc(String citdesc) {
		this.citdesc = citdesc;
	}

	/**
	 * CI变更时间戳取得
	 *
	 * @return CI变更时间戳
	 */
	public String getCittime() {
		return cittime;
	}

	/**
	 * CI变更时间戳设定
	 *
	 * @param cittime CI变更时间戳
	 */
	public void setCittime(String cittime) {
		this.cittime = cittime;
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
	public String getCitstatus() {
		return citstatus;
	}

	/**
	 * 状态设定
	 * 
	 * @param citstatus 状态
	 */
	public void setCitstatus(String citstatus) {
		this.citstatus = citstatus;
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
	public String getCitupdtime() {
		return citupdtime;
	}

	/**
	 * 最后更新时间设定
	 * @param citupdtime 最后更新时间
	 */ 
	public void setCitupdtime(String citupdtime) {
		this.citupdtime = citupdtime;
	}

	/**
	 * 最后对比时间取得
	 * @return 最后对比时间
	 */
	public String getCitcomptime() {
		return citcomptime;
	}

	/**
	 * 最后对比时间设定
	 * @param citcomptime 最后对比时间
	 */
	public void setCitcomptime(String citcomptime) {
		this.citcomptime = citcomptime;
	}

}
