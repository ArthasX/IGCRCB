/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.prd.form;

import java.util.List;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.framework.workflow.prd.model.IG202Info;
import com.deliverik.framework.workflow.prd.model.entity.IG286TB;

/**
 * 流程定义基本信息编辑画面Form
 * 
 */
@SuppressWarnings("serial")
public class IGPRD0118Form extends BaseForm implements IG202Info {
	
	
	/** 表单信息的默认值 */
	protected String piddefault;

	/** 表单信息的描述 */
	protected String piddesc;

	/** 表单信息的ID */
	protected Integer pidid;

	/** 表单信息的显示名称 */
	protected String pidlabel;

	/** 表单信息的显示名称 */
	protected String pidlabel_bak;
	
	/** 表单信息的后台名称 */
	protected String pidname;

	/** 表单信息的取值范围 */
	protected String pidoption;

	/** 表单信息是否必填项 */
	protected String pidrequired;

	/** 表单信息的类型 */
	protected String pidtype;
	
	/** 流程定义记录的时间戳 */
	protected String fingerPrint;
	
	/** 模式 0登记，1编辑 */
	protected String mode = "0";
	
	/** 表单信息的模式 */
	protected String pidmode;
	
	/** 表单信息的行显示模式 */
	protected String rowwidth;
	
	/** 表单信息的行显示模式 */
	protected String privatescope;

	/** 排序ID */
	protected String pidsortid;
	
	protected String ccid;
	
	protected String pidgid[];
	
	protected String pdid;
	
	/** 从基本流程类型添加共通变量 */
	protected String basic;
	
	public String getPdid() {
		return pdid;
	}

	public void setPdid(String pdid) {
		this.pdid = pdid;
	}

	public String[] getPidgid() {
		return pidgid;
	}

	public void setPidgid(String[] pidgid) {
		this.pidgid = pidgid;
	}

	public String getCcid() {
		return ccid;
	}

	public void setCcid(String ccid) {
		this.ccid = ccid;
	}

	public String getPidsortid() {
		return pidsortid;
	}

	public void setPidsortid(String pidsortid) {
		this.pidsortid = pidsortid;
	}

	/**
	 * 模式取得
	 * 
	 * @return 模式
	 */
	public String getMode() {
		return mode;
	}

	/**
	 * 模式设定
	 *
	 * @param mode 模式
	 */
	public void setMode(String mode) {
		this.mode = mode;
	}


	/**
	 * 表单信息的默认值取得
	 * 
	 * @return 表单信息的默认值
	 */
	public String getPiddefault() {
		return piddefault;
	}

	/**
	 * 表单信息的默认值设定
	 *
	 * @param piddefault 表单信息的默认值
	 */
	public void setPiddefault(String piddefault) {
		this.piddefault = piddefault;
	}

	/**
	 * 表单信息的描述取得
	 * 
	 * @return 表单信息的描述
	 */
	public String getPiddesc() {
		return piddesc;
	}

	/**
	 * 表单信息的描述设定
	 *
	 * @param piddesc 表单信息的描述
	 */
	public void setPiddesc(String piddesc) {
		this.piddesc = piddesc;
	}

	/**
	 * 表单信息的ID取得
	 * 
	 * @return 表单信息的ID
	 */
	public Integer getPidid() {
		return pidid;
	}

	/**
	 * 表单信息的ID设定
	 *
	 * @param pidid 表单信息的ID
	 */
	public void setPidid(Integer pidid) {
		this.pidid = pidid;
	}

	/**
	 * 表单信息的显示名称取得
	 * 
	 * @return 表单信息的显示名称
	 */
	public String getPidlabel() {
		return pidlabel;
	}

	/**
	 * 表单信息的显示名称设定
	 *
	 * @param pidlabel 表单信息的显示名称
	 */
	public void setPidlabel(String pidlabel) {
		this.pidlabel = pidlabel;
	}

	/**
	 * 表单信息的显示名称取得
	 * 
	 * @return 表单信息的显示名称
	 */
	public String getPidlabel_bak() {
		return pidlabel_bak;
	}

	/**
	 * 表单信息的显示名称设定
	 *
	 * @param pidlabel_bak 表单信息的显示名称
	 */
	public void setPidlabel_bak(String pidlabel_bak) {
		this.pidlabel_bak = pidlabel_bak;
	}

	/**
	 * 表单信息的后台名称取得
	 * 
	 * @return 表单信息的后台名称
	 */
	public String getPidname() {
		return pidname;
	}

	/**
	 * 表单信息的后台名称设定
	 *
	 * @param pidname 表单信息的后台名称
	 */
	public void setPidname(String pidname) {
		this.pidname = pidname;
	}

	/**
	 * 表单信息的取值范围取得
	 * 
	 * @return 表单信息的取值范围
	 */
	public String getPidoption() {
		return pidoption;
	}

	/**
	 * 表单信息的取值范围设定
	 *
	 * @param pidoption 表单信息的取值范围
	 */
	public void setPidoption(String pidoption) {
		this.pidoption = pidoption;
	}

	/**
	 * 表单信息的是否必填项取得
	 * 
	 * @return 表单信息的是否必填项
	 */
	public String getPidrequired() {
		return pidrequired;
	}

	/**
	 * 表单信息的是否必填项设定
	 *
	 * @param pidrequired 表单信息的是否必填项
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
	 * 表单信息记录的时间戳取得
	 * 
	 * @return 表单信息记录的时间戳
	 */
	public String getFingerPrint() {
		return fingerPrint;
	}

	/**
	 * 表单信息记录的时间戳设定
	 *
	 * @param fingerPrint 表单信息记录的时间戳
	 */
	public void setFingerPrint(String fingerPrint) {
		this.fingerPrint = fingerPrint;
	}

	public List<IG286TB> getProcessLinkageDefList() {
		return null;
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

	public String getPrivateaccess() {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * 从基本流程类型添加共通变量取得
	 * @return 从基本流程类型添加共通变量
	 */
	public String getBasic() {
		return basic;
	}

	/**
	 * 从基本流程类型添加共通变量设定
	 * @param basic从基本流程类型添加共通变量
	 */
	public void setBasic(String basic) {
		this.basic = basic;
	}
}
