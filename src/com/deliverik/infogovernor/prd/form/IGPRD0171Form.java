/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.deliverik.infogovernor.prd.form;

import com.deliverik.framework.base.BaseForm;

/**
 * 表单权限FORM
 * @author byf 2012-10-16
 *
 */
@SuppressWarnings("serial")
public class IGPRD0171Form extends BaseForm{
	
	/** 流程定义ID */
	private String pdid;
	
	/**参与者角色ID集合*/
	protected String[] roleids;
	
	protected String[] prdids;
	
	/**处理方式：0-删除，1-增加*/
	protected String mode;
	
	/** 查看模式 0最新：可编辑，1：历史：只查看 */
	protected String viewhistory;

	public String getPdid() {
		return pdid;
	}

	public void setPdid(String pdid) {
		this.pdid = pdid;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public String[] getRoleids() {
		return roleids;
	}

	public void setRoleids(String[] roleids) {
		this.roleids = roleids;
	}

	public String[] getPrdids() {
		return prdids;
	}

	public void setPrdids(String[] prdids) {
		this.prdids = prdids;
	}
	
	/**
	 * 查看模式
	 *
	 * @return 查看模式
	 */
	public String getViewhistory() {
		return viewhistory;
	}

	/**
	 * 查看模式
	 *
	 * @param viewHistory  0：最新，1历史
	 */
	public void setViewhistory(String viewhistory) {
		this.viewhistory = viewhistory;
	}
	
}
