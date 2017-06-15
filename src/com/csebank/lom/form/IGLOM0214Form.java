/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.csebank.lom.form;

import com.deliverik.framework.base.BaseForm;

public class IGLOM0214Form extends BaseForm {

	private static final long serialVersionUID = 1L;

	/** GStock主键 */
	protected Integer gsid;
	/** 物品种类 */
	protected String gscategory;
	protected String gcategoryname;
	
	/** 物品名称 */
	protected String gsname;
	/** 物品编号 */
	protected String gscode;
	/** 总数量 */
	protected Integer gsnum;
	/** 所属机构层次码 */
	protected String gsorg;
	/** 采购平均价 */
	protected Double gsavgprice;
	/** 冻结数量 */
	protected Integer gsfreezenum;
	/** 最后一次更新人ID */
	protected String gsuserid;
	/** 最后一次更新人姓名 */
	protected String gsusername;
	/** 最后一次更新时间 */
	protected String gsdate;
	/**
	 * @return the gsid
	 */
	public Integer getGsid() {
		return gsid;
	}
	/**
	 * @param gsid the gsid to set
	 */
	public void setGsid(Integer gsid) {
		this.gsid = gsid;
	}
	/**
	 * @return the gscategory
	 */
	public String getGscategory() {
		return gscategory;
	}
	/**
	 * @param gscategory the gscategory to set
	 */
	public void setGscategory(String gscategory) {
		this.gscategory = gscategory;
	}
	/**
	 * @return the gsname
	 */
	public String getGsname() {
		return gsname;
	}
	/**
	 * @param gsname the gsname to set
	 */
	public void setGsname(String gsname) {
		this.gsname = gsname;
	}
	/**
	 * @return the gscode
	 */
	public String getGscode() {
		return gscode;
	}
	/**
	 * @param gscode the gscode to set
	 */
	public void setGscode(String gscode) {
		this.gscode = gscode;
	}
	/**
	 * @return the gsnum
	 */
	public Integer getGsnum() {
		return gsnum;
	}
	/**
	 * @param gsnum the gsnum to set
	 */
	public void setGsnum(Integer gsnum) {
		this.gsnum = gsnum;
	}
	/**
	 * @return the gsorg
	 */
	public String getGsorg() {
		return gsorg;
	}
	/**
	 * @param gsorg the gsorg to set
	 */
	public void setGsorg(String gsorg) {
		this.gsorg = gsorg;
	}
	/**
	 * @return the gsavgprice
	 */
	public Double getGsavgprice() {
		return gsavgprice;
	}
	/**
	 * @param gsavgprice the gsavgprice to set
	 */
	public void setGsavgprice(Double gsavgprice) {
		this.gsavgprice = gsavgprice;
	}
	/**
	 * @return the gsfreezenum
	 */
	public Integer getGsfreezenum() {
		return gsfreezenum;
	}
	/**
	 * @param gsfreezenum the gsfreezenum to set
	 */
	public void setGsfreezenum(Integer gsfreezenum) {
		this.gsfreezenum = gsfreezenum;
	}
	/**
	 * @return the gsuserid
	 */
	public String getGsuserid() {
		return gsuserid;
	}
	/**
	 * @param gsuserid the gsuserid to set
	 */
	public void setGsuserid(String gsuserid) {
		this.gsuserid = gsuserid;
	}
	/**
	 * @return the gsusername
	 */
	public String getGsusername() {
		return gsusername;
	}
	/**
	 * @param gsusername the gsusername to set
	 */
	public void setGsusername(String gsusername) {
		this.gsusername = gsusername;
	}
	/**
	 * @return the gsdate
	 */
	public String getGsdate() {
		return gsdate;
	}
	/**
	 * @param gsdate the gsdate to set
	 */
	public void setGsdate(String gsdate) {
		this.gsdate = gsdate;
	}
	public String getGcategoryname() {
		return gcategoryname;
	}
	public void setGcategoryname(String gcategoryname) {
		this.gcategoryname = gcategoryname;
	}
	
	
	
}
