/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.risk.model.condition;

/**
  * 概述: 检查策略检索条件实现
  * 功能描述: 检查策略检索条件实现
  * 创建记录: 2014/09/02
  * 修改记录: 
  */
public class CheckStrategySearchCondImpl implements
		CheckStrategySearchCond {

	protected Integer csid;

	/** 检查名称 */
	protected String csname;

	/** 描述 */
	protected String csdesc;

	/** 状态 */
	protected String csstatus;

	/** 开始日期 */
	protected String csstartdate;

	/** 结束日期 */
	protected String csenddate;
	
	/** 重要程度*/
	protected String cstype;

	/** 频率 */
	protected String csfrequency;
	
	/** 检查方式*/
	protected String csrtestmode;

	/** 策略执行表达式 */
	protected String cscron;

	/** 责任人ID */
	protected String csuserid;

	/** 责任人姓名 */
	protected String csusername;

	/** 责任组角色ID */
	protected String csroleid;

	/** 责任组角色名称 */
	protected String csrolename;

	/** 合作责任人id */
	protected String csasset;

	/** 合作责任人姓名 */
	protected String csassetname;
	
	/** 合作责任组角色id*/
	protected String csassetorgid;
	
	/** 合作责任组名称*/
	protected String csassetorgname;

	/** 附件 */
	protected String csattch ;

	/** 选项 */
	protected String csoption ;

	/**
	 * @return the csid
	 */
	public Integer getCsid() {
		return csid;
	}

	/**
	 * @param csid the csid to set
	 */
	public void setCsid(Integer csid) {
		this.csid = csid;
	}

	/**
	 * @return the csname
	 */
	public String getCsname() {
		return csname;
	}

	/**
	 * @param csname the csname to set
	 */
	public void setCsname(String csname) {
		this.csname = csname;
	}

	/**
	 * @return the csdesc
	 */
	public String getCsdesc() {
		return csdesc;
	}

	/**
	 * @param csdesc the csdesc to set
	 */
	public void setCsdesc(String csdesc) {
		this.csdesc = csdesc;
	}

	/**
	 * @return the csstatus
	 */
	public String getCsstatus() {
		return csstatus;
	}

	/**
	 * @param csstatus the csstatus to set
	 */
	public void setCsstatus(String csstatus) {
		this.csstatus = csstatus;
	}

	/**
	 * @return the csstartdate
	 */
	public String getCsstartdate() {
		return csstartdate;
	}

	/**
	 * @param csstartdate the csstartdate to set
	 */
	public void setCsstartdate(String csstartdate) {
		this.csstartdate = csstartdate;
	}

	/**
	 * @return the csenddate
	 */
	public String getCsenddate() {
		return csenddate;
	}

	/**
	 * @param csenddate the csenddate to set
	 */
	public void setCsenddate(String csenddate) {
		this.csenddate = csenddate;
	}

	/**
	 * @return the csfrequency
	 */
	public String getCsfrequency() {
		return csfrequency;
	}

	/**
	 * @param csfrequency the csfrequency to set
	 */
	public void setCsfrequency(String csfrequency) {
		this.csfrequency = csfrequency;
	}

	/**
	 * @return the cscron
	 */
	public String getCscron() {
		return cscron;
	}

	/**
	 * @param cscron the cscron to set
	 */
	public void setCscron(String cscron) {
		this.cscron = cscron;
	}

	/**
	 * @return the csuserid
	 */
	public String getCsuserid() {
		return csuserid;
	}

	/**
	 * @param csuserid the csuserid to set
	 */
	public void setCsuserid(String csuserid) {
		this.csuserid = csuserid;
	}

	/**
	 * @return the csusername
	 */
	public String getCsusername() {
		return csusername;
	}

	/**
	 * @param csusername the csusername to set
	 */
	public void setCsusername(String csusername) {
		this.csusername = csusername;
	}

	/**
	 * @return the csroleid
	 */
	public String getCsroleid() {
		return csroleid;
	}

	/**
	 * @param csroleid the csroleid to set
	 */
	public void setCsroleid(String csroleid) {
		this.csroleid = csroleid;
	}

	/**
	 * @return the csrolename
	 */
	public String getCsrolename() {
		return csrolename;
	}

	/**
	 * @param csrolename the csrolename to set
	 */
	public void setCsrolename(String csrolename) {
		this.csrolename = csrolename;
	}

	/**
	 * @return the csasset
	 */
	public String getCsasset() {
		return csasset;
	}

	/**
	 * @param csasset the csasset to set
	 */
	public void setCsasset(String csasset) {
		this.csasset = csasset;
	}

	/**
	 * @return the csassetname
	 */
	public String getCsassetname() {
		return csassetname;
	}

	/**
	 * @param csassetname the csassetname to set
	 */
	public void setCsassetname(String csassetname) {
		this.csassetname = csassetname;
	}

	/**
	 * @return the csattch
	 */
	public String getCsattch() {
		return csattch;
	}

	/**
	 * @param csattch the csattch to set
	 */
	public void setCsattch(String csattch) {
		this.csattch = csattch;
	}

	/**
	 * @return the csoption
	 */
	public String getCsoption() {
		return csoption;
	}

	/**
	 * @param csoption the csoption to set
	 */
	public void setCsoption(String csoption) {
		this.csoption = csoption;
	}

	/**
	 * @return the cstype
	 */
	public String getCstype() {
		return cstype;
	}

	/**
	 * @param cstype the cstype to set
	 */
	public void setCstype(String cstype) {
		this.cstype = cstype;
	}

	/**
	 * @return the csrtestmode
	 */
	public String getCsrtestmode() {
		return csrtestmode;
	}

	/**
	 * @param csrtestmode the csrtestmode to set
	 */
	public void setCsrtestmode(String csrtestmode) {
		this.csrtestmode = csrtestmode;
	}

	/**
	 * @return the csassetorgid
	 */
	public String getCsassetorgid() {
		return csassetorgid;
	}

	/**
	 * @param csassetorgid the csassetorgid to set
	 */
	public void setCsassetorgid(String csassetorgid) {
		this.csassetorgid = csassetorgid;
	}

	/**
	 * @return the csassetorgname
	 */
	public String getCsassetorgname() {
		return csassetorgname;
	}

	/**
	 * @param csassetorgname the csassetorgname to set
	 */
	public void setCsassetorgname(String csassetorgname) {
		this.csassetorgname = csassetorgname;
	}
	
	
	
}