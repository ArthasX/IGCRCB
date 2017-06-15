/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.deliverik.framework.workflow.prd.model.condition;


/**
 * 流程状态变量前处理检索条件实现
 *
 */
public class IG211SearchCondImpl implements IG211SearchCond{
	
	/** 
	 * 主键 
	 */
	protected String psidid;
	
	/**
	 * 流程状态ID
	 */
	protected String psdid;
	
	/**
	 * 流程变量ID
	 */
	protected String pidid;

	/**
	 * 流程变量名称
	 */
	protected String pidname;
	
	/**
	 * 流程变量类型
	 */
	protected String pidtype;	

	/**
	 * 流程变量值
	 */
	protected String pidvalue;
	
	/**
	 * 流程状态ID 
	 */
	protected String psidid_like;

	/**
	 * 流程状态变量前处理ID取得
	 * @return 流程状态变量前处理ID
	 */
	public String getPsidid() {
		return psidid;
	}

	/**
	 * 流程状态变量前处理ID设定
	 * @param psidid 流程状态变量前处理ID
	 */
	public void setPsidid(String psidid) {
		this.psidid = psidid;
	}

	/**
	 * 流程状态ID取得
	 * @return 流程状态ID
	 */
	public String getPsdid() {
		return psdid;
	}

	/**
	 * 流程状态ID设定
	 * @param psdid 流程状态ID
	 */
	public void setPsdid(String psdid) {
		this.psdid = psdid;
	}

	/**
	 * 流程变量ID取得
	 * @return 流程变量ID
	 */
	public String getPidid() {
		return pidid;
	}

	/**
	 * 流程变量ID设定
	 * @param pidid 流程变量ID
	 */
	public void setPidid(String pidid) {
		this.pidid = pidid;
	}

	/**
	 * 流程变量名称取得
	 * @return 流程变量名称
	 */
	public String getPidname() {
		return pidname;
	}

	/**
	 * 流程变量名称设定
	 * @param pidname 流程变量名称
	 */
	public void setPidname(String pidname) {
		this.pidname = pidname;
	}

	/**
	 * 流程变量类型取得
	 * @return 流程变量类型
	 */
	public String getPidtype() {
		return pidtype;
	}

	/**
	 * 流程变量类型设定
	 * @param pidtype 流程变量类型
	 */
	public void setPidtype(String pidtype) {
		this.pidtype = pidtype;
	}

	/**
	 * 流程变量值取得
	 * @return 流程变量值
	 */
	public String getPidvalue() {
		return pidvalue;
	}

	/**
	 * 流程变量值设定
	 * @param pidvalue 流程变量值
	 */
	public void setPidvalue(String pidvalue) {
		this.pidvalue = pidvalue;
	}

	/**
	 * 主键取得
	 * 
	 * @return 主键 
	 */
	public String getPsidid_like() {
		return psidid_like;
	}

	/**
	 * 主键 设定
	 * 
	 * @param psidid_like 主键 
	 */
	public void setPsidid_like(String psidid_like) {
		this.psidid_like = psidid_like;
	}
	
}
