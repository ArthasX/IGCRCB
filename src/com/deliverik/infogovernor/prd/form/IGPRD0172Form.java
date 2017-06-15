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
public class IGPRD0172Form extends BaseForm{
	
	/** 流程定义ID */
	private String pdid;
	
	/** 角色ID */
	private String roleid;
	
	/** 现有表单集合 */
	protected String[] pidida;
	
	/** 可选表单集合 */
	protected String[] pididb;
	
	/**处理方式：0-删除，1-增加*/
	protected String mode;

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

	public String getRoleid() {
		return roleid;
	}

	public void setRoleid(String roleid) {
		this.roleid = roleid;
	}

	public String[] getPidida() {
		return pidida;
	}

	public void setPidida(String[] pidida) {
		this.pidida = pidida;
	}

	public String[] getPididb() {
		return pididb;
	}

	public void setPididb(String[] pididb) {
		this.pididb = pididb;
	}

	
}
