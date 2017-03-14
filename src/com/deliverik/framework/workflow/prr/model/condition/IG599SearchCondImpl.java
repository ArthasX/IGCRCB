package com.deliverik.framework.workflow.prr.model.condition;

/**
 * 流程变量信息检索条件实现
 */
public class IG599SearchCondImpl implements IG599SearchCond {

	/**
	 * 流程记录ID
	 */
	protected Integer prid;
	
	/**
	 * 流程定义ID
	 */
	protected String pdid;
	
	/**
	 * 流程变量标识
	 */
	protected String pivarname;
	
	/**
	 * 流程变量类型
	 */
	protected String pivartype;
	
	/**
	 * 流程变量标识
	 */
	protected String pivarlabel;
	
	/**
	 * 流程变量值
	 */
	protected String pivarvalue;
	
	/**
	 * 用户ID
	 */
	protected String userid;
	
	/**
	 * 流程记录ID取得
	 * @return 流程记录ID
	 */
	public Integer getPrid() {
		return prid;
	}

	/**
	 * 流程记录ID设定
	 * @param prid 流程记录ID
	 */
	public void setPrid(Integer prid) {
		this.prid = prid;
	}

	/**
	 * 流程变量标识取得
	 * @return 流程变量标识
	 */
	public String getPivarname() {
		return pivarname;
	}

	/**
	 * 流程变量标识设定
	 * @param pivarname 流程变量标识
	 */
	public void setPivarname(String pivarname) {
		this.pivarname = pivarname;
	}

	/**
	 * 流程变量类型取得
	 * @return 流程变量
	 */
	public String getPivartype() {
		return pivartype;
	}

	/**
	 * 流程变量设定
	 * @param pivartype 流程变量
	 */
	public void setPivartype(String pivartype) {
		this.pivartype = pivartype;
	}

	/**
	 * 流程变量标识取得
	 * @return 流程变量
	 */
	public String getPivarlabel() {
		return pivarlabel;
	}

	/**
	 * 流程变量设定
	 * @param pivarlabel 流程变量
	 */
	public void setPivarlabel(String pivarlabel) {
		this.pivarlabel = pivarlabel;
	}

	/**
	 * 流程变量值取得
	 * @return 流程变量值
	 */
	public String getPivarvalue() {
		return pivarvalue;
	}

	/**
	 * 流程变量值设定
	 * @param pivarvalue 流程变量值
	 */
	public void setPivarvalue(String pivarvalue) {
		this.pivarvalue = pivarvalue;
	}

	/**
	 * 用户ID取得
	 * @return 用户ID
	 */
	public String getUserid() {
		return userid;
	}

	/**
	 * 用户ID设定
	 * @param userid 用户ID
	 */
	public void setUserid(String userid) {
		this.userid = userid;
	}

	/**
	 * 流程定义ID取得
	 * @return 流程定义ID
	 */
	public String getPdid() {
		return pdid;
	}

	/**
	 * 流程定义ID设定
	 * @param pdid流程定义ID
	 */
	public void setPdid(String pdid) {
		this.pdid = pdid;
	}
	
}
