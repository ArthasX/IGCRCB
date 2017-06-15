/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.prd.form;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.framework.workflow.prd.model.condition.IG202SearchCond;

/**
 * 表单信息查询画面Form
 * 
 * @author liupeng@deliverik.com
 */
@SuppressWarnings("serial")
public class IGPRD0117Form extends BaseForm implements IG202SearchCond {
	
	/** 表单信息是否是系统默认 */
	protected String isDefault;
	

	/** 表单信息的显示名称 */
	protected String pidlabel;

	/** 表单信息的后台显示名称 */
	protected String pidname;

	/** 表单信息的后台显示名称like查询条件 */
	protected String pidname_like;
	
	/** 表单信息是否必填项 */
	protected String pidrequired;

	/** 表单信息的类型 */
	protected String pidtype;
	
	/** 流程定义的ID */
	protected String pdid;
	
	/** 表单信息的模式 */
	protected String pidmode;
	
	/** 表单信息的行显示模式 */
	protected String rowwidth;
	
	/** 表单信息的行显示模式 */
	protected String privatescope;
	
	/** 是否显示确认按钮 */
	protected String disp;
	
	/**
	 * 表单信息是否是系统默认取得
	 * 
	 * @return 表单信息是否是系统默认
	 */
	public String getIsDefault() {
		return isDefault;
	}

	/**
	 * 表单信息是否是系统默认设定
	 *
	 * @param isDefault 表单信息是否是系统默认
	 */
	public void setIsDefault(String isDefault) {
		this.isDefault = isDefault;
	}

	

	/**
	 * 表单信息的显示名称取得
	 * 
	 * @return 表单信息德显示名称
	 */
	public String getPidlabel() {
		return pidlabel;
	}

	/**
	 * 表单信息德显示名称设定
	 *
	 * @param pidlabel 表单信息德显示名称
	 */
	public void setPidlabel(String pidlabel) {
		this.pidlabel = pidlabel;
	}

	/**
	 * 表单信息的后台显示名称取得
	 * 
	 * @return 表单信息的后台显示名称
	 */
	public String getPidname() {
		return pidname;
	}

	/**
	 * 表单信息的后台显示名称设定
	 *
	 * @param pidname 表单信息的后台显示名称
	 */
	public void setPidname(String pidname) {
		this.pidname = pidname;
	}

	/**
	 * 表单信息的后台显示名称like查询条件取得
	 * 
	 * @return 表单信息的后台显示名称like查询条件
	 */
	public String getPidname_like() {
		return pidname_like;
	}

	/**
	 * 表单信息的后台显示名称like查询条件设定
	 *
	 * @param pidname_like 表单信息的后台显示名称like查询条件
	 */
	public void setPidname_like(String pidname_like) {
		this.pidname_like = pidname_like;
	}

	/**
	 * 表单信息是否必填项取得
	 * 
	 * @return 表单信息是否必填项
	 */
	public String getPidrequired() {
		return pidrequired;
	}

	/**
	 * 表单信息是否必填项设定
	 *
	 * @param pidname_like 表单信息是否必填项
	 */
	public void setPidrequired(String pidrequired) {
		this.pidrequired = pidrequired;
	}

	/**
	 * 表单信息的类型取得
	 * 
	 * @return 表单信息的类型
	 */
	public String getPidtype() {
		return pidtype;
	}

	/**
	 * 表单信息的类型设定
	 *
	 * @param pidtype 表单信息的类型
	 */
	public void setPidtype(String pidtype) {
		this.pidtype = pidtype;
	}

	/**
	 * 流程定义的ID取得
	 * 
	 * @return 流程定义的ID
	 */
	public String getPdid() {
		return pdid;
	}

	/**
	 * 流程定义的ID设定
	 *
	 * @param pdid 流程定义的ID
	 */
	public void setPdid(String pdid) {
		this.pdid = pdid;
	}

	public String getPidmode() {
		return pidmode;
	}

	public void setPidmode(String pidmode) {
		this.pidmode = pidmode;
	}

	public String getRowwidth() {
		return rowwidth;
	}

	public void setRowwidth(String rowwidth) {
		this.rowwidth = rowwidth;
	}

	public String getPrivatescope() {
		return privatescope;
	}

	public void setPrivatescope(String privatescope) {
		this.privatescope = privatescope;
	}

	public Integer getPidid_notlike() {
		return null;
	}

	public String getDisp() {
		return disp;
	}

	public void setDisp(String disp) {
		this.disp = disp;
	}

}
