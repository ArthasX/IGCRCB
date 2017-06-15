package com.deliverik.infogovernor.sya.form;

import com.deliverik.framework.base.BaseForm;

@SuppressWarnings("serial")
public class IGSYA0101Form extends BaseForm{

	/** 制度名称  */	
	protected String inname;

	/** 制度描述  */	
	protected String indesc;
	
	/** 时间 */
	protected String createtime_from;
	
	protected String createtime_to;
	
	/** 登记人机构名称 */
	protected String paorgname;

	/** 制度分类  */	
	public String intype;
	
	/**
	 * 登记人机构名称取得
	 * @return paorgname  登记人机构名称
	 */
	public String getPaorgname() {
		return paorgname;
	}

	/**
	 * 登记人机构名称设定
	 * @param paorgname  登记人机构名称
	 */
	public void setPaorgname(String paorgname) {
		this.paorgname = paorgname;
	}

	/**
	 * 制度名称取得
	 * @return inname  制度名称
	 */
	public String getInname() {
		return inname;
	}

	/**
	 * 制度名称设定
	 * @param inname  制度名称
	 */
	public void setInname(String inname) {
		this.inname = inname;
	}

	/**
	 * 制度描述取得
	 * @return indesc  制度描述
	 */
	public String getIndesc() {
		return indesc;
	}

	/**
	 * 制度描述设定
	 * @param indesc  制度描述
	 */
	public void setIndesc(String indesc) {
		this.indesc = indesc;
	}

	/**
	 * 时间取得
	 * @return createtime_from  时间
	 */
	public String getCreatetime_from() {
		return createtime_from;
	}

	/**
	 * 时间设定
	 * @param createtime_from  时间
	 */
	public void setCreatetime_from(String createtime_from) {
		this.createtime_from = createtime_from;
	}

	/**
	 * createtime_to取得
	 * @return createtime_to  createtime_to
	 */
	public String getCreatetime_to() {
		return createtime_to;
	}

	/**
	 * createtime_to设定
	 * @param createtime_to  createtime_to
	 */
	public void setCreatetime_to(String createtime_to) {
		this.createtime_to = createtime_to;
	}

	/**
	 * 制度分类取得
	 * @return intype  制度分类
	 */
	public String getIntype() {
		return intype;
	}

	/**
	 * 制度分类设定
	 * @param intype  制度分类
	 */
	public void setIntype(String intype) {
		this.intype = intype;
	}

	
	
}
