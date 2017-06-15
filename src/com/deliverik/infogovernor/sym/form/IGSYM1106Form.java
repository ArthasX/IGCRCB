package com.deliverik.infogovernor.sym.form;

import java.util.List;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.framework.model.condition.CodeDetailSearchCond;

/**
 * 数据详细信息画面FORM
 * 
 */
public class IGSYM1106Form extends BaseForm implements CodeDetailSearchCond {

	private static final long serialVersionUID = 1L;
	
	/** 数据分类CD */
	protected String ccid ;
	/** 数据分类CD */
	protected String tempccid ;
	
	/** 数据CD */
	protected String cid ;
	
	/** 数据CD */
	protected String tempcid ;
	
	/** 数据分类CD */
	protected String ccname ;
	
	/** 数据id */
	protected String pcid ;
	
	/** 数据名称 */
	protected String pcvalue ;
	
	/** 状态 0-停用，1-启用 */
	protected String cdstatus;
	
	/** 级次 */
	protected String clevel;
	
	protected String pccid;
	
	protected String psyscoding;
	
	protected String cvalue;
	
	protected String cdinfo_eq;
	
	public String getCvalue() {
		return cvalue;
	}

	public void setCvalue(String cvalue) {
		this.cvalue = cvalue;
	}

	public String getCdinfo_eq() {
		return cdinfo_eq;
	}

	public void setCdinfo_eq(String cdinfo_eq) {
		this.cdinfo_eq = cdinfo_eq;
	}

	/**
	 * 数据分类CD取得
	 * @return 数据分类CD
	 */
	public String getCcid() {
		return ccid;
	}

	/**
	 * 数据分类CD设定
	 *
	 * @param ccid 数据分类CD
	 */
	public void setCcid(String ccid) {
		this.ccid = ccid;
	}

	/**
	 * 数据CD取得
	 * @return 数据CD
	 */
	public String getCid() {
		return cid;
	}

	/**
	 * 数据CD设定
	 *
	 * @param cid 数据CD
	 */
	public void setCid(String cid) {
		this.cid = cid;
	}

	public String getCcname() {
		return ccname;
	}

	public void setCcname(String ccname) {
		this.ccname = ccname;
	}

	public String getPcvalue() {
		return pcvalue;
	}

	public void setPcvalue(String pcvalue) {
		this.pcvalue = pcvalue;
	}

	public void setPcid(String pcid) {
		this.pcid = pcid;
	}
	/**
	 * 状态 0-停用，1-启用
	 * @return 状态
	 */
	public String getCdstatus() {
		return cdstatus;
	}

	/**
	 * 状态 0-停用，1-启用
	 *
	 * @param cdstatus 状态
	 */
	public void setCdstatus(String cdstatus) {
		this.cdstatus = cdstatus;
	}

	public String getTempcid() {
		return tempcid;
	}

	public void setTempcid(String tempcid) {
		this.tempcid = tempcid;
	}

	public String getTempccid() {
		return tempccid;
	}

	public void setTempccid(String tempccid) {
		this.tempccid = tempccid;
	}

	public String getClevel() {
		return clevel;
	}

	public void setClevel(String clevel) {
		this.clevel = clevel;
	}

	public String getPccid() {
		return pccid;
	}

	public void setPccid(String pccid) {
		this.pccid = pccid;
	}

	public String getPcid() {
		return pcid;
	}

	public String getPsyscoding() {
		return psyscoding;
	}

	public void setPsyscoding(String psyscoding) {
		this.psyscoding = psyscoding;
	}

	public String getSyscoding_q() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getBusinesscode_like() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getSyscoding() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getCdinfo() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<String> getCidList() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
