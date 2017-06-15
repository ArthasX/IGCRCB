/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.prd.form;

import com.deliverik.framework.base.BaseForm;


/**
 * 流程定义_参与者_权限Form
 * 
 */
@SuppressWarnings("serial")
public class IGPRD0108Form extends BaseForm {
	
	/** 参与者_权限主键ID */
	protected Integer pipdid;
	
	/** 流程变量的ID */
	protected Integer pidid;
	
	/** 流程变量的ID集合 */
	protected String[] pidids;
	
	/** 参与者_权限主键ID集合 */
	protected String[] pipdids;
	
	/** 流程状态的ID */
	protected String psdid;
	
	/** 流程参与者的ID */
	protected String ppdid;
	
	/** 流程变量的名称 */
	protected String pidname;
	
	/** 流程变量的显示名称 */
	protected String pidlabel;
	
	/** 流程变量的描述 */
	protected String piddesc;
	
	/** 流程变量的类型 */
	protected String pidtype;
	
	/** 参与人员对变量的权限 */
	protected String pidaccess;
	
	/** 参与人员对变量的权限集合 */
	protected String[] pidaccesses;
	
	protected String[] pidrequired;
	
	/** 参与者_权限记录的时间戳 */
	protected String fingerPrint;

	/** 流程ID */
	protected String pdid;
	
	/** 参与人员勾选的动作集合 */
	protected String pikey;
	
	protected String[] pikeys;
	protected String[] pikeynames;
	
	/**动作按钮提示信息集合 */
	protected String[] pikeydecs;
	
	/** 类型集合 */
	protected String[] types;
	
	protected String[] pbdid;
	
	protected String[] ppbdname;
	
	protected String[] ppbddesc;
	
	protected String[] ppbdauth;
	
	protected String[] ppbdid;
	
	protected String[] relevantPdid;
	
	protected String[] psprpid;
	
    /** 是否校验必填项 */
    protected String[] checkrequired;
    
    /** 是否校验处理记录 */
	protected String[] checkrecord;
	
	/** 弹出页js名称 */
	protected String[] acturl;

	/** 父流程状态ID */
	protected String ppsdid;
	
	public String[] getPikeydecs() {
		return pikeydecs;
	}

	public void setPikeydecs(String[] pikeydecs) {
		this.pikeydecs = pikeydecs;
	}

	public String[] getPikeynames() {
		return pikeynames;
	}

	public void setPikeynames(String[] pikeynames) {
		this.pikeynames = pikeynames;
	}

	public String[] getPidids() {
		return pidids;
	}

	public void setPidids(String[] pidids) {
		this.pidids = pidids;
	}

	public String[] getPipdids() {
		return pipdids;
	}

	public void setPipdids(String[] pipdids) {
		this.pipdids = pipdids;
	}

	public String[] getPidaccesses() {
		return pidaccesses;
	}

	public void setPidaccesses(String[] pidaccesses) {
		this.pidaccesses = pidaccesses;
	}

	public String getPikey() {
		return pikey;
	}

	public void setPikey(String pikey) {
		this.pikey = pikey;
	}

	public String[] getPikeys() {
		return pikeys;
	}

	public void setPikeys(String[] pikeys) {
		this.pikeys = pikeys;
	}

	public String getPdid() {
		return pdid;
	}

	public void setPdid(String pdid) {
		this.pdid = pdid;
	}

	public Integer getPipdid() {
		return pipdid;
	}

	public void setPipdid(Integer pipdid) {
		this.pipdid = pipdid;
	}

	public Integer getPidid() {
		return pidid;
	}

	public void setPidid(Integer pidid) {
		this.pidid = pidid;
	}

	public String getPsdid() {
		return psdid;
	}

	public void setPsdid(String psdid) {
		this.psdid = psdid;
	}

	public String getPpdid() {
		return ppdid;
	}

	public void setPpdid(String ppdid) {
		this.ppdid = ppdid;
	}

	public String getPidname() {
		return pidname;
	}

	public void setPidname(String pidname) {
		this.pidname = pidname;
	}

	public String getPidlabel() {
		return pidlabel;
	}

	public void setPidlabel(String pidlabel) {
		this.pidlabel = pidlabel;
	}

	public String getPiddesc() {
		return piddesc;
	}

	public void setPiddesc(String piddesc) {
		this.piddesc = piddesc;
	}

	public String getPidtype() {
		return pidtype;
	}

	public void setPidtype(String pidtype) {
		this.pidtype = pidtype;
	}

	public String getPidaccess() {
		return pidaccess;
	}

	public void setPidaccess(String pidaccess) {
		this.pidaccess = pidaccess;
	}

	public String getFingerPrint() {
		return fingerPrint;
	}

	public void setFingerPrint(String fingerPrint) {
		this.fingerPrint = fingerPrint;
	}

	/**
	 * 类型集合取得
	 * 
	 * @return 类型集合
	 */
	public String[] getTypes() {
		return types;
	}

	/**
	 * 类型集合设定
	 * 
	 * @param type 类型集合
	 */
	public void setTypes(String[] types) {
		this.types = types;
	}
	/** 查看模式 0最新：可编辑，1：历史：只查看 */
	protected String viewhistory;

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

	public String[] getPbdid() {
		return pbdid;
	}

	public void setPbdid(String[] pbdid) {
		this.pbdid = pbdid;
	}

	public String[] getPpbdname() {
		return ppbdname;
	}

	public void setPpbdname(String[] ppbdname) {
		this.ppbdname = ppbdname;
	}

	public String[] getPpbddesc() {
		return ppbddesc;
	}

	public void setPpbddesc(String[] ppbddesc) {
		this.ppbddesc = ppbddesc;
	}

	public String[] getPpbdauth() {
		return ppbdauth;
	}

	public void setPpbdauth(String[] ppbdauth) {
		this.ppbdauth = ppbdauth;
	}

	public String[] getPpbdid() {
		return ppbdid;
	}

	public void setPpbdid(String[] ppbdid) {
		this.ppbdid = ppbdid;
	}

	public String[] getPidrequired() {
		return pidrequired;
	}

	public void setPidrequired(String[] pidrequired) {
		this.pidrequired = pidrequired;
	}

    /**
     * @return the relevantPdid
     */
    public String[] getRelevantPdid() {
        return relevantPdid;
    }

    /**
     * @param relevantPdid the relevantPdid to set
     */
    public void setRelevantPdid(String[] relevantPdid) {
        this.relevantPdid = relevantPdid;
    }

    /**
     * @return the psprpid
     */
    public String[] getPsprpid() {
        return psprpid;
    }

    /**
     * @param psprpid the psprpid to set
     */
    public void setPsprpid(String[] psprpid) {
        this.psprpid = psprpid;
    }

	/**
	 *是否校验必填项取得
	 */
	public String[] getCheckrequired() {
		return checkrequired;
	}

	/**
	 *是否校验必填项设定
	 */
	public void setCheckrequired(String[] checkrequired) {
		this.checkrequired = checkrequired;
	}

	/**
	 *是否校验处理记录取得
	 */
	public String[] getCheckrecord() {
		return checkrecord;
	}

	/**
	 *是否校验处理记录设定
	 */
	public void setCheckrecord(String[] checkrecord) {
		this.checkrecord = checkrecord;
	}

	/**
	 *弹出页js名称取得
	 */
	public String[] getActurl() {
		return acturl;
	}

	/**
	 *弹出页js名称设定
	 */
	public void setActurl(String[] acturl) {
		this.acturl = acturl;
	}

	/**
	 * 父流程状态ID取得
	 * @return 父流程状态ID
	 */
	public String getPpsdid() {
		return ppsdid;
	}

	/**
	 * 父流程状态ID设定
	 * @param ppsdid 父流程状态ID
	 */
	public void setPpsdid(String ppsdid) {
		this.ppsdid = ppsdid;
	}
	
}
