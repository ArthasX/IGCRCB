/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.prd.form;

import com.deliverik.framework.base.BaseForm;


/**
 * 流程定义_缺省参与者_权限Form
 * 
 */
@SuppressWarnings("serial")
public class IGPRD0116Form extends BaseForm {
	
	/** 参与者_权限主键ID */
	protected String[] pdvids;
	
	/** 流程变量的ID */
	protected Integer pidid;
	
	/** 流程变量的ID集合 */
	protected String[] pidids;
	
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
	
	/** 类型集合 */
	protected String[] types;
	
	protected String[] pdbdid;
	protected String[] pdbdname;
	protected String[] pdbddesc;
	protected String[] pdbdauth;
	protected String[] pbdid;
	
    protected String[] relevantPdid;
        
    protected String[] dpsprpid;
    
    /** 是否校验必填项 */
    protected String[] checkrequired;
    
    /** 是否校验处理记录 */
	protected String[] checkrecord;
	
	/** 弹出页js名称 */
	protected String[] acturl;

	/** 上级状态ID */
	protected String ppsdid;
    
	public String[] getPidids() {
		return pidids;
	}

	public void setPidids(String[] pidids) {
		this.pidids = pidids;
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

	public String[] getPdvids() {
		return pdvids;
	}

	public void setPdvids(String[] pdvids) {
		this.pdvids = pdvids;
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

	public String getPpdid() {
		return ppdid;
	}
	public void setPpdid(String ppdid) {
		this.ppdid = ppdid;
	}
	public String[] getPdbdid() {
		return pdbdid;
	}
	public void setPdbdid(String[] pdbdid) {
		this.pdbdid = pdbdid;
	}
	public String[] getPdbdname() {
		return pdbdname;
	}
	public void setPdbdname(String[] pdbdname) {
		this.pdbdname = pdbdname;
	}
	public String[] getPdbddesc() {
		return pdbddesc;
	}
	public void setPdbddesc(String[] pdbddesc) {
		this.pdbddesc = pdbddesc;
	}
	public String[] getPdbdauth() {
		return pdbdauth;
	}
	public void setPdbdauth(String[] pdbdauth) {
		this.pdbdauth = pdbdauth;
	}
	public String[] getPbdid() {
		return pbdid;
	}
	public void setPbdid(String[] pbdid) {
		this.pbdid = pbdid;
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
     * @return the dpsprpid
     */
    public String[] getDpsprpid() {
        return dpsprpid;
    }

    /**
     * @param dpsprpid the dpsprpid to set
     */
    public void setDpsprpid(String[] dpsprpid) {
        this.dpsprpid = dpsprpid;
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
	 * 上级状态ID取得
	 * @return 上级状态ID
	 */
	public String getPpsdid() {
		return ppsdid;
	}

	/**
	 * 上级状态ID设定
	 * @param ppsdid 上级状态ID
	 */
	public void setPpsdid(String ppsdid) {
		this.ppsdid = ppsdid;
	}


}
