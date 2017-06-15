package com.deliverik.infogovernor.cic.form;

import com.deliverik.framework.base.BaseForm;

/**
 * 配置一致性比对
 *	对比规则查询画面FORM
 * 
 */
public class IGCIC0101Form extends BaseForm {

	private static final long serialVersionUID = 1L;

	/**对比规则id*/
	private Integer crid;
	/**对比域*/
	private Integer csid;
	/**对比规则名称*/
	private String crname;

	/** 对比类型 */
	protected String crtype;
	
	/** 业务系统id */
	protected Integer crsystemid;
	protected String crsystemname;

	public String getCrtype() {
		return crtype;
	}

	public void setCrtype(String crtype) {
		this.crtype = crtype;
	}

	public Integer getCrsystemid() {
		return crsystemid;
	}

	public void setCrsystemid(Integer crsystemid) {
		this.crsystemid = crsystemid;
	}
	
	
	/**
	 * 规则id 获取
	 * @return
	 */
	public Integer getCrid() {
		return crid;
	}
	/**
	 * 规则id  设定
	 * @param crid
	 */
	public void setCrid(Integer crid) {
		this.crid = crid;
	}
	/**
	 * 域id 获取
	 * @return
	 */
	public Integer getCsid() {
		return csid;
	}
	/**
	 * 域id设定
	 * @param csid
	 */
	public void setCsid(Integer csid) {
		this.csid = csid;
	}
	/**
	 * 规则名称 获取
	 * @return
	 */
	public String getCrname() {
		return crname;
	}
	/**
	 * 规则名称设定
	 * @param crname
	 */
	public void setCrname(String crname) {
		this.crname = crname;
	}

	public String getCrsystemname() {
		return crsystemname;
	}

	public void setCrsystemname(String crsystemname) {
		this.crsystemname = crsystemname;
	}
	
	
	
}
