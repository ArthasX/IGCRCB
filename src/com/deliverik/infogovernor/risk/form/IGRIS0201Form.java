package com.deliverik.infogovernor.risk.form;

import com.deliverik.framework.base.BaseForm;


/**
 * 风险检查FORM
 * 
 */
@SuppressWarnings("serial")
public class IGRIS0201Form extends BaseForm {
	
	/** 风险检查ID */
	protected Integer rcid;

	/** 风险检查名称 */
	protected String rcname;
	
	/** 风险检查描述 */
	protected String rcdesc;
	
	/** 风险检查类型 */
	protected String rctype;
	
	/** 风险检查状态 */
	protected String rcstatus;
	
	/** 风险检查状态查询 */
	protected String rcstatus_q;
	
	/** 风险检查起始日期 */
	protected String rcstartdate;
	
	/** 风险检查结束日期 */
	protected String rcenddate;
	
	/** 风险检查频率 */
	protected String rcfrequency;
	
	/** 风险检查责任人id */
	protected String rcuserid;
	
	/** 风险检查责任人姓名 */
	protected String rcusername;
	
	/** 风险检查责任组角色id */
	protected String rcroleid;
	
	/** 风险检查责任组角色名 */
	protected String rcrolename;
	
	/** 风险检查相关资产 */
	protected Integer rcasset;
	
	/** 风险检查相关资产名称 */
	protected String rcassetname;
	
	/** 风险检查附件 */
	protected String rcattch;
	
	/** 风险检查选项 */
	protected String rcoption;
	
	/** 风险检查策略执行表达式 */
	protected String rccron;
	
	protected String fingerPrint;
	
	/** 0为新增 1为变更 */
	protected String mode;

	protected String rcrtestmode;
	
	/** 风险检查名称查询条件 */
	protected String rcname_q;
	
	/** 风险审计ID */
	protected Integer raid;
	
	/** 风险审计评估人姓名 */
	protected String[] radids;
	
	/** 风险检查项类别 */
	protected String rccategory;
	
	/** 风险检查项类别名称 */
	protected String rccategoryname;
	
	/** 风险检查登记时间 */
	protected String rccreatetime;
	
	/** 风险检查审批时间 */
	protected String rcapprovetime;
	
	/** 风险检查审批人 */
	protected String rcapprover;
	
	/** 风险检查类型 */
	protected String rcclass;
	
	/** 风险检查策略详细ID*/
	protected String csid;
	
	/** 信息安全审批 */
	protected String isSecurityApproval;
	
	/**
	 * @return the radids
	 */
	public String[] getRadids() {
		return radids;
	}

	/**
	 * @param radids the radids to set
	 */
	public void setRadids(String[] radids) {
		this.radids = radids;
	}
	

	/**
	 * @return the csid
	 */
	public String getCsid() {
		return csid;
	}

	/**
	 * @param csid the csid to set
	 */
	public void setCsid(String csid) {
		this.csid = csid;
	}

	/**
	 * @return the raid
	 */
	public Integer getRaid() {
		return raid;
	}

	/**
	 * @param raid the raid to set
	 */
	public void setRaid(Integer raid) {
		this.raid = raid;
	}

	/**
	 * @return the rcname_q
	 */
	public String getRcname_q() {
		return rcname_q;
	}

	/**
	 * @param rcname_q the rcname_q to set
	 */
	public void setRcname_q(String rcname_q) {
		this.rcname_q = rcname_q;
	}

	/**
	 * @return the rcid
	 */
	public Integer getRcid() {
		return rcid;
	}

	/**
	 * @return the rcname
	 */
	public String getRcname() {
		return rcname;
	}

	/**
	 * @return the rcdesc
	 */
	public String getRcdesc() {
		return rcdesc;
	}

	/**
	 * @return the rctype
	 */
	public String getRctype() {
		return rctype;
	}

	/**
	 * @return the rcstatus
	 */
	public String getRcstatus() {
		return rcstatus;
	}

	/**
	 * @return the rcstartdate
	 */
	public String getRcstartdate() {
		return rcstartdate;
	}

	/**
	 * @return the rcenddate
	 */
	public String getRcenddate() {
		return rcenddate;
	}

	/**
	 * @return the rcfrequency
	 */
	public String getRcfrequency() {
		return rcfrequency;
	}

	/**
	 * @return the rcuserid
	 */
	public String getRcuserid() {
		return rcuserid;
	}

	/**
	 * @return the rcusername
	 */
	public String getRcusername() {
		return rcusername;
	}

	/**
	 * @return the rcroleid
	 */
	public String getRcroleid() {
		return rcroleid;
	}

	/**
	 * @return the rcrolename
	 */
	public String getRcrolename() {
		return rcrolename;
	}

	/**
	 * @return the rcasset
	 */
	public Integer getRcasset() {
		return rcasset;
	}

	/**
	 * @return the rcassetname
	 */
	public String getRcassetname() {
		return rcassetname;
	}

	/**
	 * @return the rcattch
	 */
	public String getRcattch() {
		return rcattch;
	}

	/**
	 * @return the rcoption
	 */
	public String getRcoption() {
		return rcoption;
	}

	/**
	 * @return the rccron
	 */
	public String getRccron() {
		return rccron;
	}

	/**
	 * @return the fingerPrint
	 */
	public String getFingerPrint() {
		return fingerPrint;
	}

	/**
	 * @return the mode
	 */
	public String getMode() {
		return mode;
	}

	/**
	 * @param rcid the rcid to set
	 */
	public void setRcid(Integer rcid) {
		this.rcid = rcid;
	}

	/**
	 * @param rcname the rcname to set
	 */
	public void setRcname(String rcname) {
		this.rcname = rcname;
	}

	/**
	 * @param rcdesc the rcdesc to set
	 */
	public void setRcdesc(String rcdesc) {
		this.rcdesc = rcdesc;
	}

	/**
	 * @param rctype the rctype to set
	 */
	public void setRctype(String rctype) {
		this.rctype = rctype;
	}

	/**
	 * @param rcstatus the rcstatus to set
	 */
	public void setRcstatus(String rcstatus) {
		this.rcstatus = rcstatus;
	}

	public String getRcstatus_q() {
		return rcstatus_q;
	}

	public void setRcstatus_q(String rcstatus_q) {
		this.rcstatus_q = rcstatus_q;
	}

	/**
	 * @param rcstartdate the rcstartdate to set
	 */
	public void setRcstartdate(String rcstartdate) {
		this.rcstartdate = rcstartdate;
	}

	/**
	 * @param rcenddate the rcenddate to set
	 */
	public void setRcenddate(String rcenddate) {
		this.rcenddate = rcenddate;
	}

	/**
	 * @param rcfrequency the rcfrequency to set
	 */
	public void setRcfrequency(String rcfrequency) {
		this.rcfrequency = rcfrequency;
	}

	/**
	 * @param rcuserid the rcuserid to set
	 */
	public void setRcuserid(String rcuserid) {
		this.rcuserid = rcuserid;
	}

	/**
	 * @param rcusername the rcusername to set
	 */
	public void setRcusername(String rcusername) {
		this.rcusername = rcusername;
	}

	/**
	 * @param rcroleid the rcroleid to set
	 */
	public void setRcroleid(String rcroleid) {
		this.rcroleid = rcroleid;
	}

	/**
	 * @param rcrolename the rcrolename to set
	 */
	public void setRcrolename(String rcrolename) {
		this.rcrolename = rcrolename;
	}

	/**
	 * @param rcasset the rcasset to set
	 */
	public void setRcasset(Integer rcasset) {
		this.rcasset = rcasset;
	}

	/**
	 * @param rcassetname the rcassetname to set
	 */
	public void setRcassetname(String rcassetname) {
		this.rcassetname = rcassetname;
	}

	/**
	 * @param rcattch the rcattch to set
	 */
	public void setRcattch(String rcattch) {
		this.rcattch = rcattch;
	}

	/**
	 * @param rcoption the rcoption to set
	 */
	public void setRcoption(String rcoption) {
		this.rcoption = rcoption;
	}

	/**
	 * @param rccron the rccron to set
	 */
	public void setRccron(String rccron) {
		this.rccron = rccron;
	}

	/**
	 * @param fingerPrint the fingerPrint to set
	 */
	public void setFingerPrint(String fingerPrint) {
		this.fingerPrint = fingerPrint;
	}

	/**
	 * @param mode the mode to set
	 */
	public void setMode(String mode) {
		this.mode = mode;
	}
	
	/**
	 * 风险检查项类别取得
	 * @return 风险检查项类别
	 */
	public String getRccategory() {
		return rccategory;
	}

	/**
	 * 风险检查项类别设定
	 *
	 * @param rccategory 风险检查项类别
	 */
	public void setRccategory(String rccategory) {
		this.rccategory = rccategory;
	}

	/**
	 * 风险检查项类别名称取得
	 * @return 风险检查项类别名称
	 */
	public String getRccategoryname() {
		return rccategoryname;
	}

	/**
	 * 风险检查项类别名称设定
	 *
	 * @param rccategoryname 风险检查项类别名称
	 */
	public void setRccategoryname(String rccategoryname) {
		this.rccategoryname = rccategoryname;
	}
	
	/**
	 * 风险检查登记时间取得
	 * @return 风险检查登记时间
	 */
	public String getRccreatetime() {
		return rccreatetime;
	}

	/**
	 * 风险检查登记时间设定
	 *
	 * @param rccreatetime 风险检查登记时间
	 */
	public void setRccreatetime(String rccreatetime) {
		this.rccreatetime = rccreatetime;
	}
	
	/**
	 * 风险检查审批时间取得
	 * @return 风险检查审批时间
	 */
	public String getRcapprovetime() {
		return rcapprovetime;
	}

	/**
	 * 风险检查审批时间设定
	 *
	 * @param rcapprovetime 风险检查审批时间
	 */
	public void setRcapprovetime(String rcapprovetime) {
		this.rcapprovetime = rcapprovetime;
	}

	/**
	 * 风险检查审批人取得
	 * @return 风险检查审批人
	 */
	public String getRcapprover() {
		return rcapprover;
	}

	/**
	 * 风险检查审批人设定
	 *
	 * @param rcapprover 风险检查审批人
	 */
	public void setRcapprover(String rcapprover) {
		this.rcapprover = rcapprover;
	}

	public String getRcclass() {
		return rcclass;
	}

	public void setRcclass(String rcclass) {
		this.rcclass = rcclass;
	}

	public String getIsSecurityApproval() {
		return isSecurityApproval;
	}

	public void setIsSecurityApproval(String isSecurityApproval) {
		this.isSecurityApproval = isSecurityApproval;
	}

	/**
	 * @return the rcrtestmode
	 */
	public String getRcrtestmode() {
		return rcrtestmode;
	}

	/**
	 * @param rcrtestmode the rcrtestmode to set
	 */
	public void setRcrtestmode(String rcrtestmode) {
		this.rcrtestmode = rcrtestmode;
	}
	
	
}
