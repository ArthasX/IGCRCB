/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prd.model.condition;


/**
 * 流程参与者检索条件实现
 *
 */
public class IG222SearchCondImpl implements IG222SearchCond{
	
	/** 
	 * 流程参与者ID
	 */
	protected String ppdid;
	
	/**
	 * 流程状态ID
	 */
	protected String psdid;
	
	/**
	 * 流程参与者角色ID
	 */
	protected Integer roleid;

	/**
	 * 流程参与者批准
	 */
	protected String ppapprove;
	
	/**
	 * 流程参与者驳回
	 */
	protected String ppdeny;
	
	/**
	 * 流程参与者提交
	 */
	protected String ppsubmit;
	
	/**
	 * 流程参与者中止
	 */
	protected String ppterm;
	
	/**
	 * 流程参与者更新
	 */
	protected String ppupdate;
	
	protected String pdid;
	
	protected Integer prid;
	
	/** 
	 * 流程参与者ID
	 */
	protected String ppdid_like;
	
	/** 是否按机构 */
	protected String isOrg;
	
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
	 * 流程参与者角色ID取得
	 * @return 流程参与者角色ID
	 */
	public Integer getRoleid() {
		return roleid;
	}

	/**
	 * 流程参与者角色ID设定
	 * @param roleid 流程参与者角色ID
	 */
	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}

	/**
	 * 流程参与者批准取得
	 * @return 流程参与者批准
	 */
	public String getPpapprove() {
		return ppapprove;
	}

	/**
	 * 流程参与者批准设定
	 * @param ppapprove 流程参与者批准
	 */
	public void setPpapprove(String ppapprove) {
		this.ppapprove = ppapprove;
	}

	/**
	 * 流程参与者驳回取得
	 * @return 流程参与者驳回
	 */
	public String getPpdeny() {
		return ppdeny;
	}

	/**
	 * 流程参与者驳回设定
	 * @param ppdeny 流程参与者驳回
	 */
	public void setPpdeny(String ppdeny) {
		this.ppdeny = ppdeny;
	}

	/**
	 * 流程参与者提交取得
	 * @return 流程参与者提交
	 */
	public String getPpsubmit() {
		return ppsubmit;
	}

	/**
	 * 流程参与者提交设定
	 * @param ppsubmit 流程参与者提交
	 */
	public void setPpsubmit(String ppsubmit) {
		this.ppsubmit = ppsubmit;
	}

	/**
	 * 流程参与者中止取得
	 * @return 流程参与者中止
	 */
	public String getPpterm() {
		return ppterm;
	}

	/**
	 * 流程参与者中止设定
	 * @param ppterm 流程参与者中止
	 */
	public void setPpterm(String ppterm) {
		this.ppterm = ppterm;
	}

	/**
	 * 流程参与者更新取得
	 * @return 流程参与者更新
	 */
	public String getPpupdate() {
		return ppupdate;
	}

	/**
	 * 流程参与者更新设定
	 * @param ppupdate 流程参与者更新
	 */
	public void setPpupdate(String ppupdate) {
		this.ppupdate = ppupdate;
	}

	public String getPdid() {
		return pdid;
	}

	public void setPdid(String pdid) {
		this.pdid = pdid;
	}

	public Integer getPrid() {
		return prid;
	}

	public void setPrid(Integer prid) {
		this.prid = prid;
	}

	/**
	 * 流程参与者ID取得
	 * 
	 * @return 流程参与者ID
	 */
	public String getPpdid_like() {
		return ppdid_like;
	}

	/**
	 * 流程参与者ID设定
	 * 
	 * @param ppdid_like 流程参与者ID
	 */
	public void setPpdid_like(String ppdid_like) {
		this.ppdid_like = ppdid_like;
	}

	/**
	 * 是否按机构取得 
	 * @return 是否按机构
	 */
	public String getIsOrg() {
		return isOrg;
	}

	/**
	 * 是否按机构设定
	 * @param isOrg 是否按机构
	 */
	public void setIsOrg(String isOrg) {
		this.isOrg = isOrg;
	}
}
