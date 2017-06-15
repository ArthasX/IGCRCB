/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.sym.form;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.framework.model.entity.CodeDetailTB;
import com.deliverik.infogovernor.sym.model.ReportFileDefinition;


/**
 * 报表新增Form
 *
 */
@SuppressWarnings("serial")
public class IGSYM1402Form extends BaseForm implements ReportFileDefinition {
	
	/** 主键 */
	protected Integer rfdid;

	/** 报表显示名称 */
	protected String rfdtitle;
	
	/** 报表分类 */
	protected String rfdtype;

	/** 报表说明 */
	protected String rfddesc;

	/** 报表文件名  */
	protected String rfdfilename;

	/** 报表登记人ID */
	protected String rfduserid;

	/** 报表登记人姓名 */
	protected String rfdusername;

	/** 报表登记时间 */
	protected String rfdinstime;
	
	/** 记录时间戳 */
	protected String fingerPrint;
	
	/** 报表分类显示名称 */
	protected String rfdtypename;
	
	/** 报表版本号 */
	protected Integer rfdversion;
	
	/** 报表最新版本号 */
	protected Integer rfdnewversion;
	
	/** 报表类型 */
	protected String rfdpictype;
	
	/** 报表参数 */
	protected String rfdparameters;
	
	/** 是否订制 */
	protected String isFlag;
	
	/** 流程类型 */
	protected String prtype;
	/** 流程类型复选 */
	protected String[] prtypes;
	
	/** 流程状态 */
	protected String[] prstatus;
	
	/** 表单ID */
	protected String pidid;
	/** 表单ID 复选*/
	protected String[] pidids;
	
	/** 表单值 */
	protected String pidvalue;
	
	/** 树形级别 */
	protected String rank;
	
	/** 报表模版 */
	protected String rfdfilemodel;
	
	protected CodeDetailTB codeDetailTB;
	
	protected String prstatuss;
	
	public String getPrstatuss() {
		return prstatuss;
	}

	public void setPrstatuss(String prstatuss) {
		this.prstatuss = prstatuss;
	}

	/**
	 * 主键取得
	 * @return 主键
	 */
	public Integer getRfdid() {
		return rfdid;
	}

	/**
	 * 主键设定
	 * @param rfdid 主键
	 */
	public void setRfdid(Integer rfdid) {
		this.rfdid = rfdid;
	}

	/**
	 * 报表名称取得
	 * @return 报表名称
	 */
	public String getRfdtitle() {
		return rfdtitle;
	}

	/**
	 * 报表名称设定
	 * @param rfdtitle 报表名称
	 */
	public void setRfdtitle(String rfdtitle) {
		this.rfdtitle = rfdtitle;
	}

	/**
	 * 报表分类取得
	 * @return 报表分类
	 */
	public String getRfdtype() {
		return rfdtype;
	}

	/**
	 * 报表分类设定
	 * @param rfdtype 报表分类
	 */
	public void setRfdtype(String rfdtype) {
		this.rfdtype = rfdtype;
	}

	/**
	 * 报表说明取得
	 * @return 报表说明
	 */
	public String getRfddesc() {
		return rfddesc;
	}

	/**
	 * 报表说明设定
	 * @param rfddesc 报表说明
	 */
	public void setRfddesc(String rfddesc) {
		this.rfddesc = rfddesc;
	}

	/**
	 * 报表文件名取得
	 * @return 报表文件名
	 */
	public String getRfdfilename() {
		return rfdfilename;
	}

	/**
	 * 报表文件名设定
	 * @param rfdfilename 报表文件名
	 */
	public void setRfdfilename(String rfdfilename) {
		this.rfdfilename = rfdfilename;
	}

	/**
	 * 报表登记人ID取得
	 * @return 报表登记人ID
	 */
	public String getRfduserid() {
		return rfduserid;
	}

	/**
	 * 报表登记人ID设定
	 * @param rfduserid 报表登记人ID
	 */
	public void setRfduserid(String rfduserid) {
		this.rfduserid = rfduserid;
	}

	/**
	 * 报表登记人姓名取得
	 * @return 报表登记人姓名
	 */
	public String getRfdusername() {
		return rfdusername;
	}

	/**
	 * 报表登记人姓名设定
	 * @param rfdusername 报表登记人姓名
	 */
	public void setRfdusername(String rfdusername) {
		this.rfdusername = rfdusername;
	}

	/**
	 * 报表登记时间取得
	 * @return 报表登记时间
	 */
	public String getRfdinstime() {
		return rfdinstime;
	}

	/**
	 * 报表登记时间设定
	 * @param rfdinstime 报表登记时间
	 */
	public void setRfdinstime(String rfdinstime) {
		this.rfdinstime = rfdinstime;
	}

	/**
	 * 记录时间戳取得
	 * 
	 * @return 记录时间戳
	 */
	public String getFingerPrint() {
		return fingerPrint;
	}

	/**
	 * 记录时间戳设定
	 *
	 * @param fingerPrint 记录时间戳
	 */
	public void setFingerPrint(String fingerPrint) {
		this.fingerPrint = fingerPrint;
	}

	public void setCodeDetailTB(CodeDetailTB codeDetailTB) {
		this.codeDetailTB = codeDetailTB;
	}

	/**
	 * 报表分类显示名称取得
	 * 
	 * @return 报表分类显示名称
	 */
	public String getRfdtypename() {
		return rfdtypename;
	}

	/**
	 * 报表分类显示名称设定
	 *
	 * @param rfdtypename 报表分类显示名称
	 */
	public void setRfdtypename(String rfdtypename) {
		this.rfdtypename = rfdtypename;
	}
	
	/**
	 * 报表登记时间取得
	 * @return 报表登记时间
	 */
	public Integer getRfdversion() {
		return rfdversion;
	}

	/**
	 * 报表登记时间设定
	 * @param rfdversion 报表登记时间
	 */
	public void setRfdversion(Integer rfdversion) {
		this.rfdversion = rfdversion;
	}
	
	/**
	 * 报表最新版本号取得
	 * @return 报表最新版本号
	 */
	public Integer getRfdnewversion() {
		return rfdnewversion;
	}

	/**
	 * 报表最新版本号设定
	 * @param rfdnewversion 报表最新版本号
	 */
	public void setRfdnewversion(Integer rfdnewversion) {
		this.rfdnewversion = rfdnewversion;
	}
	
	public String getRfdpictype() {
		return rfdpictype;
	}

	public void setRfdpictype(String rfdpictype) {
		this.rfdpictype = rfdpictype;
	}
	
	public String getIsFlag() {
		return isFlag;
	}

	public void setIsFlag(String isFlag) {
		this.isFlag = isFlag;
	}

	public String getRfdparameters() {
		return rfdparameters;
	}

	public void setRfdparameters(String rfdparameters) {
		this.rfdparameters = rfdparameters;
	}

	public String getPrtype() {
		return prtype;
	}

	public void setPrtype(String prtype) {
		this.prtype = prtype;
	}

	public String[] getPrstatus() {
		return prstatus;
	}

	public CodeDetailTB getCodeDetailTB() {
		return codeDetailTB;
	}

	public void setPrstatus(String[] prstatus) {
		this.prstatus = prstatus;
	}

	public String getPidid() {
		return pidid;
	}

	public void setPidid(String pidid) {
		this.pidid = pidid;
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	public String getPidvalue() {
		return pidvalue;
	}

	public void setPidvalue(String pidvalue) {
		this.pidvalue = pidvalue;
	}

	public String getRfdfilemodel() {
		return rfdfilemodel;
	}

	public void setRfdfilemodel(String rfdfilemodel) {
		this.rfdfilemodel = rfdfilemodel;
	}

	/**
	 * 表单复选 获取
	 * @return the pidids
	 */
	public String[] getPidids() {
		return pidids;
	}

	/**
	 *
	 *	 表单复选设置
	 * @param pidids the pidids to set
	 */
	public void setPidids(String[] pidids) {
		this.pidids = pidids;
	}

	/**
	 * 流程复选取得
	 * @return the prtypes
	 */
	public String[] getPrtypes() {
		return prtypes;
	}

	/**
	 *
	 *	流程复选设置
	 * @param prtypes the prtypes to set
	 */
	public void setPrtypes(String[] prtypes) {
		this.prtypes = prtypes;
	}

	
}
