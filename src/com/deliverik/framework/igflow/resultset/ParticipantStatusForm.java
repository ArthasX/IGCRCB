/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.igflow.resultset;

/**
 * 参与者状态表单信息
 */
public class ParticipantStatusForm implements ParticipantStatusFormInfo {
	
	/** 流程表单ID */
	protected String pidid;
	
	/** 流程变量显示名称 */
	protected String pidlabel;
	
	/** 流程变量权限 */
	protected String pidaccess;
	
	/**
	 * 流程变量ID取得
	 * @return 流程变量ID
	 */
	public String getPidid() {
		return pidid;
	}

	/**
	 * 流程变量ID设定
	 * @param pidid 流程变量ID
	 */
	public void setPidid(String pidid) {
		this.pidid = pidid;
	}

	/**
	 * 流程变量显示名称取得
	 * @return 流程变量显示名称
	 */
	public String getPidlabel() {
		return pidlabel;
	}

	/**
	 * 流程变量显示名称设定
	 * @param pidlabel 流程变量显示名称
	 */
	public void setPidlabel(String pidlabel) {
		this.pidlabel = pidlabel;
	}

	/**
	 * 流程参与者变量权限取得
	 * @return 流程参与者变量权限
	 */
	public String getPidaccess() {
		return pidaccess;
	}

	/**
	 * 流程参与者变量权限设定
	 * @param pidaccess 流程参与者变量权限
	 */
	public void setPidaccess(String pidaccess) {
		this.pidaccess = pidaccess;
	}

}
