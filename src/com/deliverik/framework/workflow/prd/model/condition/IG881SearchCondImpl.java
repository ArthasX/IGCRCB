/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prd.model.condition;


/**
 * 流程参与者变量权限查询条件实现
 *
 */
public class IG881SearchCondImpl implements IG881SearchCond{
	
	/** 
	 * 流程参与者变量权限ID 
	 */
	protected String pipdid;
	
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
	 * 流程变权限
	 */
	protected String pidaccess;
	
	/**
	 * 流程状态ID
	 */
	protected String psdid;
	
	/**
	 * 流程参与者ID
	 */
	protected String ppdid;
	
	/**
	 * 流程ID
	 */
	protected String pdid;
	
	/** 
	 * 流程参与者变量权限ID
	 */
	protected String pipdid_like;
	
	/**
	 * 流程ID取得
	 * @return 流程ID
	 */
	public String getPdid() {
		return pdid;
	}

	/**
	 * 流程ID设定
	 * @param pdid 流程ID
	 */
	public void setPdid(String pdid) {
		this.pdid = pdid;
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
	 * 流程参与者ID取得
	 * @return 流程参与者ID
	 */
	public String getPpdid() {
		return ppdid;
	}

	/**
	 * 流程参与者ID设定
	 * @param ppdid 流程参与者ID
	 */
	public void setPpdid(String ppdid) {
		this.ppdid = ppdid;
	}

	/**
	 * 流程参与者变量权限ID取得
	 * @return 流程参与者变量权限ID
	 */
	public String getPipdid() {
		return pipdid;
	}

	/**
	 * 流程参与者变量权限ID设定
	 * @param pipdid 流程参与者变量权限ID
	 */
	public void setPipdid(String pipdid) {
		this.pipdid = pipdid;
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
	 * 流程参与者变量权限取得
	 * @return 流程参与者变量权限
	 */
	public String getPidaccess() {
		return pidaccess;
	}

	/**
	 * 流程参与者变量权限设定
	 * @param pidaccess 流程参与者变量权限
	 */
	public void setPidaccess(String pidaccess) {
		this.pidaccess = pidaccess;
	}

	/**
	 * 流程参与者变量权限ID取得
	 * 
	 * @return 流程参与者变量权限ID
	 */
	public String getPipdid_like() {
		return pipdid_like;
	}

	/**
	 * 流程参与者变量权限ID设定
	 * 
	 * @param pipdid_like 流程参与者变量权限ID
	 */
	public void setPipdid_like(String pipdid_like) {
		this.pipdid_like = pipdid_like;
	}
	
}
