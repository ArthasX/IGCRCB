/*
 * 沈阳递蓝科信息技术有限公司版权所有，保留所有权利。
 * Copyright 2009 Deliverik Co. Ltd.， All rights reserved.
 */
package com.deliverik.infogovernor.prj.form;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.infogovernor.prj.model.ProjectLog;

public class IGPRJ0102Form extends BaseForm implements ProjectLog {
	
	private static final long serialVersionUID = 1L;

	/** 项目ID*/
	protected Integer pid;

	/** 项目类型 */
	protected String ptype;
	protected String ptype_name;
	
	/** 项目编号 */
	protected String pcode;
	
	/** 项目名称 */
	protected String pname;

	/** 项目描述 */
	protected String pdesc;
	
	/** 项目开启时间 */
	protected String popentime;
	
	/** 项目关闭时间 */
	protected String pclosetime;
	
	/** 项目状态 */
	protected String pstatus;
	
	/** 项目用途*/
	protected String ppurpose;
	
	/** 项目预算用途*/
	protected String puse;
	
	/** 项目预算额度*/
	protected Double plimit;
	
	/** 需求部门*/
	protected String pbranch;
	
	/** 预算主表ID*/
	protected Integer pbid;
	
	/** 预算主表预算名称*/
	protected String pbname;

	/** 预算金额*/
	protected String pamount;
	
	/** 使用预算*/
	protected String isUseBudget;
	
	/** 项目目的*/
	protected String paim;
	protected String pinfo;
	protected String prole;
	protected String porg;
	protected String puser;
	
	protected Integer plroleid;
	protected String plrolename;
	protected String pluserid;
	protected String plusername;
	protected String plinfo;
	protected String pltype;
	protected String plattkey;
	protected String pltime;
	
	/** 预算主键 */
	protected Integer[] bid;
	
	/** 预算 资本金 开发*/
	protected Double[] bzdevelop;
	
	/** 预算 资本金 硬件*/
	protected Double[] bzhardware;
	
	/** 预算 资本金 软件*/
	protected Double[] bzsoftware;
	
	/** 预算 资本金 工程*/
	protected Double[] bzproject;
	
	/** 预算 资本金 其他*/
	protected Double[] bzelse;
	
	/** 预算 成本金 实施*/
	protected Double[] bcimplement;
	
	/** 预算 成本金 其他*/
	protected Double[] bcelse;
	
	/** 计划结束时间 */
	protected String pplanclosetime;
	
	/** 项目 资本金 开发*/
	protected Double pbzdevelop;
	
	/** 项目 资本金 硬件*/
	protected Double pbzhardware;
	
	/** 项目 资本金 软件*/
	protected Double pbzsoftware;
	
	/** 项目 资本金 工程*/
	protected Double pbzproject;
	
	/** 项目 资本金 其他*/
	protected Double pbzelse;
	
	/** 项目 成本金 实施*/
	protected Double pbcimplement;
	
	/** 项目 成本金 其他*/
	protected Double pbcelse;
	
	/** 合同编号 */
	protected Integer plcid;
	
	/** 项目性质 */
	protected String ppquality ;
	
	public void setPinfo(String pinfo) {
		this.pinfo = pinfo;
	}

	/**
	 * 计划结束时间取得
	 * @return pplanclosetime 计划结束时间
	 */
	public String getPplanclosetime() {
		return pplanclosetime;
	}

	/**
	 * 计划结束时间设定
	 * @param pplanclosetime 计划结束时间
	 */
	public void setPplanclosetime(String pplanclosetime) {
		this.pplanclosetime = pplanclosetime;
	}

	public String getPtype_name() {
		return ptype_name;
	}

	public void setPtype_name(String ptype_name) {
		this.ptype_name = ptype_name;
	}

	public void setPopentime(String popentime) {
		this.popentime = popentime;
	}

	public void setPclosetime(String pclosetime) {
		this.pclosetime = pclosetime;
	}

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public String getPtype() {
		return ptype;
	}

	public void setPtype(String ptype) {
		this.ptype = ptype;
	}

	public String getPcode() {
		return pcode;
	}

	public void setPcode(String pcode) {
		this.pcode = pcode;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getPdesc() {
		return pdesc;
	}

	public void setPdesc(String pdesc) {
		this.pdesc = pdesc;
	}

	public String getPstatus() {
		return pstatus;
	}

	public void setPstatus(String pstatus) {
		this.pstatus = pstatus;
	}

	public String getProle() {
		return prole;
	}

	public void setProle(String prole) {
		this.prole = prole;
	}

	public String getPorg() {
		return porg;
	}

	public void setPorg(String porg) {
		this.porg = porg;
	}

	public String getPuser() {
		return puser;
	}

	public void setPuser(String puser) {
		this.puser = puser;
	}
	
	protected String fingerPrint;

	public String getFingerPrint() {
		return fingerPrint;
	}

	public void setFingerPrint(String fingerPrint) {
		this.fingerPrint = fingerPrint;
	}

	public Integer getPlroleid() {
		return plroleid;
	}

	/**
	 * 合同编号取得
	 * @return plcid 合同编号
	 */
	public Integer getPlcid() {
		return plcid;
	}

	/**
	 * 合同编号设定
	 * @param plcid 合同编号
	 */
	public void setPlcid(Integer plcid) {
		this.plcid = plcid;
	}

	/**
	 * 项目性质取得
	 * @return ppquality 项目性质
	 */
	public String getPpquality() {
		return ppquality;
	}

	/**
	 * 项目性质设定
	 * @param ppquality 项目性质
	 */
	public void setPpquality(String ppquality) {
		this.ppquality = ppquality;
	}

	public void setPlroleid(Integer plroleid) {
		this.plroleid = plroleid;
	}

	public String getPlrolename() {
		return plrolename;
	}

	public void setPlrolename(String plrolename) {
		this.plrolename = plrolename;
	}

	public String getPluserid() {
		return pluserid;
	}

	public void setPluserid(String pluserid) {
		this.pluserid = pluserid;
	}

	public String getPlusername() {
		return plusername;
	}

	public void setPlusername(String plusername) {
		this.plusername = plusername;
	}

	public String getPlinfo() {
		return plinfo;
	}

	public void setPlinfo(String plinfo) {
		this.plinfo = plinfo;
	}

	public String getPltype() {
		return pltype;
	}

	public void setPltype(String pltype) {
		this.pltype = pltype;
	}

	public String getPlattkey() {
		return plattkey;
	}

	public void setPlattkey(String plattkey) {
		this.plattkey = plattkey;
	}

	public String getPopentime() {
		return popentime;
	}

	public String getPclosetime() {
		return pclosetime;
	}

	public String getPinfo() {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer getPlid() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getPltime() {
		return pltime;
	}

	public void setPltime(String pltime) {
		this.pltime = pltime;
	}

	public String getPamount() {
		return pamount;
	}

	public void setPamount(String pamount) {
		this.pamount = pamount;
	}

	public String getPuse() {
		return puse;
	}

	public void setPuse(String puse) {
		this.puse = puse;
	}

	public Double getPlimit() {
		return plimit;
	}

	public void setPlimit(Double plimit) {
		this.plimit = plimit;
	}

	public String getPbranch() {
		return pbranch;
	}

	public void setPbranch(String pbranch) {
		this.pbranch = pbranch;
	}

	public Integer getPbid() {
		return pbid;
	}

	public void setPbid(Integer pbid) {
		this.pbid = pbid;
	}

	public String getPaim() {
		return paim;
	}

	public void setPaim(String paim) {
		this.paim = paim;
	}

	/**
	 * 获取预算主表预算名称
	 * @return fpbname 预算主表预算名称
	 */
	public String getPbname() {
		return pbname;
	}

	/**
	 * 设置预算主表预算名称
	 * @param pbname  预算主表预算名称
	 */
	public void setPbname(String pbname) {
		this.pbname = pbname;
	}

	/**
	 * 获取项目用途
	 * @return fppurpose 项目用途
	 */
	public String getPpurpose() {
		return ppurpose;
	}

	/**
	 * 设置项目用途
	 * @param ppurpose  项目用途
	 */
	public void setPpurpose(String ppurpose) {
		this.ppurpose = ppurpose;
	}

	/**
	 * 获取使用预算
	 * @return fisUseBudget 使用预算
	 */
	public String getIsUseBudget() {
		return isUseBudget;
	}

	/**
	 * 设置使用预算
	 * @param isUseBudget  使用预算
	 */
	public void setIsUseBudget(String isUseBudget) {
		this.isUseBudget = isUseBudget;
	}

	/**
	 * 预算主键取得
	 * @return bid 预算主键
	 */
	public Integer[] getBid() {
		return bid;
	}

	/**
	 * 预算主键设定
	 * @param bid 预算主键
	 */
	public void setBid(Integer[] bid) {
		this.bid = bid;
	}

	/**
	 * 预算资本金开发取得
	 * @return bzdevelop 预算资本金开发
	 */
	public Double[] getBzdevelop() {
		return bzdevelop;
	}

	/**
	 * 预算资本金开发设定
	 * @param bzdevelop 预算资本金开发
	 */
	public void setBzdevelop(Double[] bzdevelop) {
		this.bzdevelop = bzdevelop;
	}

	/**
	 * 预算资本金硬件取得
	 * @return bzhardware 预算资本金硬件
	 */
	public Double[] getBzhardware() {
		return bzhardware;
	}

	/**
	 * 预算资本金硬件设定
	 * @param bzhardware 预算资本金硬件
	 */
	public void setBzhardware(Double[] bzhardware) {
		this.bzhardware = bzhardware;
	}

	/**
	 * 预算资本金软件取得
	 * @return bzsoftware 预算资本金软件
	 */
	public Double[] getBzsoftware() {
		return bzsoftware;
	}

	/**
	 * 预算资本金软件设定
	 * @param bzsoftware 预算资本金软件
	 */
	public void setBzsoftware(Double[] bzsoftware) {
		this.bzsoftware = bzsoftware;
	}

	/**
	 * 预算资本金工程取得
	 * @return bzproject 预算资本金工程
	 */
	public Double[] getBzproject() {
		return bzproject;
	}

	/**
	 * 预算资本金工程设定
	 * @param bzproject 预算资本金工程
	 */
	public void setBzproject(Double[] bzproject) {
		this.bzproject = bzproject;
	}

	/**
	 * 预算资本金其他取得
	 * @return bzelse 预算资本金其他
	 */
	public Double[] getBzelse() {
		return bzelse;
	}

	/**
	 * 预算资本金其他设定
	 * @param bzelse 预算资本金其他
	 */
	public void setBzelse(Double[] bzelse) {
		this.bzelse = bzelse;
	}

	/**
	 * 预算成本金实施取得
	 * @return bcimplement 预算成本金实施
	 */
	public Double[] getBcimplement() {
		return bcimplement;
	}

	/**
	 * 预算成本金实施设定
	 * @param bcimplement 预算成本金实施
	 */
	public void setBcimplement(Double[] bcimplement) {
		this.bcimplement = bcimplement;
	}

	/**
	 * 预算成本金其他取得
	 * @return bcelse 预算成本金其他
	 */
	public Double[] getBcelse() {
		return bcelse;
	}

	/**
	 * 预算成本金其他设定
	 * @param bcelse 预算成本金其他
	 */
	public void setBcelse(Double[] bcelse) {
		this.bcelse = bcelse;
	}

	/**
	 * 项目资本金开发取得
	 * @return pbzdevelop 项目资本金开发
	 */
	public Double getPbzdevelop() {
		return pbzdevelop;
	}

	/**
	 * 项目资本金开发设定
	 * @param pbzdevelop 项目资本金开发
	 */
	public void setPbzdevelop(Double pbzdevelop) {
		this.pbzdevelop = pbzdevelop;
	}

	/**
	 * 项目资本金硬件取得
	 * @return pbzhardware 项目资本金硬件
	 */
	public Double getPbzhardware() {
		return pbzhardware;
	}

	/**
	 * 项目资本金硬件设定
	 * @param pbzhardware 项目资本金硬件
	 */
	public void setPbzhardware(Double pbzhardware) {
		this.pbzhardware = pbzhardware;
	}

	/**
	 * 项目资本金软件取得
	 * @return pbzsoftware 项目资本金软件
	 */
	public Double getPbzsoftware() {
		return pbzsoftware;
	}

	/**
	 * 项目资本金软件设定
	 * @param pbzsoftware 项目资本金软件
	 */
	public void setPbzsoftware(Double pbzsoftware) {
		this.pbzsoftware = pbzsoftware;
	}

	/**
	 * 项目资本金工程取得
	 * @return pbzproject 项目资本金工程
	 */
	public Double getPbzproject() {
		return pbzproject;
	}

	/**
	 * 项目资本金工程设定
	 * @param pbzproject 项目资本金工程
	 */
	public void setPbzproject(Double pbzproject) {
		this.pbzproject = pbzproject;
	}

	/**
	 * 项目资本金其他取得
	 * @return pbzelse 项目资本金其他
	 */
	public Double getPbzelse() {
		return pbzelse;
	}

	/**
	 * 项目资本金其他设定
	 * @param pbzelse 项目资本金其他
	 */
	public void setPbzelse(Double pbzelse) {
		this.pbzelse = pbzelse;
	}

	/**
	 * 项目成本金实施取得
	 * @return pbcimplement 项目成本金实施
	 */
	public Double getPbcimplement() {
		return pbcimplement;
	}

	/**
	 * 项目成本金实施设定
	 * @param pbcimplement 项目成本金实施
	 */
	public void setPbcimplement(Double pbcimplement) {
		this.pbcimplement = pbcimplement;
	}

	/**
	 * 项目成本金其他取得
	 * @return pbcelse 项目成本金其他
	 */
	public Double getPbcelse() {
		return pbcelse;
	}

	/**
	 * 项目成本金其他设定
	 * @param pbcelse 项目成本金其他
	 */
	public void setPbcelse(Double pbcelse) {
		this.pbcelse = pbcelse;
	}
}
