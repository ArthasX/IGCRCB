package com.deliverik.infogovernor.drm.form;

import com.deliverik.framework.base.BaseForm;

/**
 * 资产项查询HELP画面用FORM
 * IGCOM0302Form ActionForm
 */
public class IGDRM0701Form extends BaseForm {

	private static final long serialVersionUID = 1L;

	/** 演练描述 */
	protected String prdesc;
	
	/** 流程定义主键 */
	protected String prpdid;
	
	/**工作编号*/
	protected Integer prid;
	
	/**工作名称*/
	protected String prtitle;
	
	/**工作状态*/
	protected String prstatus;
	
	/**发起者姓名*/
	protected String prusername;
	
	/**开始时间*/
	protected String propentime;
	
	/**结束时间*/
	protected String prclosetime;
	
	/**紧急程度*/
	protected String prurgency;

	/** 流程编号 */
	protected String prserialnum;
	
	/** 流程状态数组 */
	protected String[] prStatusArray;
	/** 演练计划类型 */
	protected String status;
	
	/** 演练计划类型（内外） */
	protected Integer prassetid;	
	
	/**
	 * @return the prassetid
	 */
	public Integer getPrassetid() {
		return prassetid;
	}

	/**
	 * @param prassetid the prassetid to set
	 */
	public void setPrassetid(Integer prassetid) {
		this.prassetid = prassetid;
	}

	/**  
	 * 获取status  
	 * @return status 
	 */
	public String getStatus() {
		return status;
	}

	/**  
	 * 设置status  
	 * @param status
	 */
	
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the 演练描述
	 */
	public String getPrdesc() {
		return prdesc;
	}

	/**
	 * @param 演练描述 the prdesc to set
	 */
	public void setPrdesc(String prdesc) {
		this.prdesc = prdesc;
	}

	/**
	 * @return the 流程定义主键
	 */
	public String getPrpdid() {
		return prpdid;
	}

	/**
	 * @param 流程定义主键 the prpdid to set
	 */
	public void setPrpdid(String prpdid) {
		this.prpdid = prpdid;
	}

	/**
	 * @return the 工作编号
	 */
	public Integer getPrid() {
		return prid;
	}

	/**
	 * @param 工作编号 the prid to set
	 */
	public void setPrid(Integer prid) {
		this.prid = prid;
	}

	/**
	 * @return the 工作名称
	 */
	public String getPrtitle() {
		return prtitle;
	}

	/**
	 * @param 工作名称 the prtitle to set
	 */
	public void setPrtitle(String prtitle) {
		this.prtitle = prtitle;
	}

	/**
	 * @return the 工作状态
	 */
	public String getPrstatus() {
		return prstatus;
	}

	/**
	 * @param 工作状态 the prstatus to set
	 */
	public void setPrstatus(String prstatus) {
		this.prstatus = prstatus;
	}

	/**
	 * @return the 发起者姓名
	 */
	public String getPrusername() {
		return prusername;
	}

	/**
	 * @param 发起者姓名 the prusername to set
	 */
	public void setPrusername(String prusername) {
		this.prusername = prusername;
	}

	/**
	 * @return the 开始时间
	 */
	public String getPropentime() {
		return propentime;
	}

	/**
	 * @param 开始时间 the propentime to set
	 */
	public void setPropentime(String propentime) {
		this.propentime = propentime;
	}

	/**
	 * @return the 结束时间
	 */
	public String getPrclosetime() {
		return prclosetime;
	}

	/**
	 * @param 结束时间 the prclosetime to set
	 */
	public void setPrclosetime(String prclosetime) {
		this.prclosetime = prclosetime;
	}

	/**
	 * @return the 紧急程度
	 */
	public String getPrurgency() {
		return prurgency;
	}

	/**
	 * @param 紧急程度 the prurgency to set
	 */
	public void setPrurgency(String prurgency) {
		this.prurgency = prurgency;
	}

	/**
	 * @return the 流程编号
	 */
	public String getPrserialnum() {
		return prserialnum;
	}

	/**
	 * @param 流程编号 the prserialnum to set
	 */
	public void setPrserialnum(String prserialnum) {
		this.prserialnum = prserialnum;
	}

	/**
	 * @return the 流程状态数组
	 */
	public String[] getPrStatusArray() {
		return prStatusArray;
	}

	/**
	 * @param 流程状态数组 the prStatusArray to set
	 */
	public void setPrStatusArray(String[] prStatusArray) {
		this.prStatusArray = prStatusArray;
	}


}
