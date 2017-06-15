/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.deliverik.framework.workflow.prd.model.condition;


/**
 * 流程状态检索条件实现
 *
 */
public class IG333SearchCondImpl implements IG333SearchCond {
	
	/**
	 *  流程状态ID
	 */
	protected String psdid;
	
	/**
	 * 流程名称ID
	 */
	protected String pdid;
	/**
	 * 流程名称ID(应急管理专用)
	 */
	protected String pdid_like;

	/**
	 * 流程状态名称
	 */
	protected String psdname;
	
	/**
	 * 流程状态标识
	 */
	protected String psdcode;
	
	/**
	 * 流程节点是否动态取参与者标识（0正常取参与者，1动态取参与者 ）
	 */
	protected String psdflag;
	
	/**
	 * 分派节点ID
	 */
	protected String assignpsdid;
	
	/**
	 * 分派按钮ID
	 */
	protected String assignpbdid;
	
	/**
	 * 不包含关闭状态
	 */
	protected String notContainEndStatus;
	
	/**
	 * 不包含开始状态
	 */
	protected String notContainStartStatus;
	
	/**
	 * 不包含本身状态
	 */
	protected String notContainSelf;
	
	protected String psdtype;
	protected String psdmode;
	
	/** 流程状态ID */
	protected String psdid_like;
	
	/** 表单全集控制标识 */
	protected String formGlobalControl;

	/** 上级状态ID */
	protected String ppsdid;
	
	/** 一级状态 */
	protected String fatherflag;
	
	protected String bysequence;

	protected String orderField;
	/** 获取前节点 */
	protected String fingerprint;
	/**应急流程标识*/
	protected String drmSign;


protected String subpsdtype;
	/**
	 * 流程节点动态参与者标识取得
	 * @return 流程节点动态参与者标识
	 */
	public String getPsdflag() {
		return psdflag;
	}

	/**
	 * 流程节点动态参与者标识设定
	 * @param psdflag 流程节点动态参与者标识
	 */
	public void setPsdflag(String psdflag) {
		this.psdflag = psdflag;
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
	 * 流程名称ID取得
	 * @return 流程名称ID
	 */
	public String getPdid() {
		return pdid;
	}

	/**
	 * 流程名称ID设定
	 * @param pdid 流程名称ID
	 */
	public void setPdid(String pdid) {
		this.pdid = pdid;
	}

	/**
	 * 流程状态名称取得
	 * @return 流程状态名称
	 */
	public String getPsdname() {
		return psdname;
	}

	/**
	 * 流程状态名称设定
	 * @param psdname 流程状态名称
	 */
	public void setPsdname(String psdname) {
		this.psdname = psdname;
	}

	/**
	 * 流程状态标识取得
	 * @return 流程状态标识
	 */
	public String getPsdcode() {
		return psdcode;
	}

	/**
	 * 流程状态标识设定
	 * @param psdcode 流程状态标识
	 */
	public void setPsdcode(String psdcode) {
		this.psdcode = psdcode;
	}

	/**
	 * 分派节点ID取得
	 * 
	 * @return 分派节点ID
	 */
	public String getAssignpsdid() {
		return assignpsdid;
	}

	/**
	 * 分派节点ID设定
	 * 
	 * @param assignpsdid 分派节点ID
	 */
	public void setAssignpsdid(String assignpsdid) {
		this.assignpsdid = assignpsdid;
	}

	/**
	 * 分派按钮ID取得
	 * 
	 * @return 分派按钮ID
	 */
	public String getAssignpbdid() {
		return assignpbdid;
	}

	/**
	 * 分派按钮ID设定
	 * 
	 * @param assignpbdid 分派按钮ID
	 */
	public void setAssignpbdid(String assignpbdid) {
		this.assignpbdid = assignpbdid;
	}

	public String getNotContainEndStatus() {
		return notContainEndStatus;
	}

	public void setNotContainEndStatus(String notContainEndStatus) {
		this.notContainEndStatus = notContainEndStatus;
	}

	public String getNotContainSelf() {
		return notContainSelf;
	}

	public void setNotContainSelf(String notContainSelf) {
		this.notContainSelf = notContainSelf;
	}

	public String getNotContainStartStatus() {
		return notContainStartStatus;
	}

	public void setNotContainStartStatus(String notContainStartStatus) {
		this.notContainStartStatus = notContainStartStatus;
	}

	public String getPsdtype() {
		return psdtype;
	}

	public void setPsdtype(String psdtype) {
		this.psdtype = psdtype;
	}

	public String getPsdmode() {
		return psdmode;
	}

	public void setPsdmode(String psdmode) {
		this.psdmode = psdmode;
	}

	/**
	 * 流程状态ID取得
	 * 
	 * @return 流程状态ID
	 */
	public String getPsdid_like() {
		return psdid_like;
	}

	/**
	 * 流程状态ID设定
	 * 
	 * @param psdid_like 流程状态ID
	 */
	public void setPsdid_like(String psdid_like) {
		this.psdid_like = psdid_like;
	}
	
	/**
     * 表单全局控制标识取得
     * @return 表单全局控制标识
     */
	public String getFormGlobalControl() {
		return formGlobalControl;
	}

	/**
	 * 表单全集控制标识设定
	 * @param formGlobalControl 表单全局控制标识
	 */
	public void setFormGlobalControl(String formGlobalControl) {
		this.formGlobalControl = formGlobalControl;
	}

	/**
	 * 上级状态ID取得
	 * @return 上级状态ID
	 */
	public String getPpsdid() {
		return ppsdid;
	}

	/**
	 * 上级状态ID设定
	 * @param ppsdid 上级状态ID
	 */
	public void setPpsdid(String ppsdid) {
		this.ppsdid = ppsdid;
	}

	/**
	 * @return the fatherflag
	 */
	public String getFatherflag() {
		return fatherflag;
	}

	/**
	 * @param fatherflag the fatherflag to set
	 */
	public void setFatherflag(String fatherflag) {
		this.fatherflag = fatherflag;
	}

	/**
	 * bysequence   取得
	 * @return bysequence bysequence
	 */
	public String getBysequence() {
		return bysequence;
	}

	/**
	 * bysequence   设定
	 * @param bysequence bysequence
	 */
	public void setBysequence(String bysequence) {
		this.bysequence = bysequence;
	}

	/**
	 * orderField   取得
	 * @return orderField orderField
	 */
	public String getOrderField() {
		return orderField;
	}

	/**
	 * orderField   设定
	 * @param orderField orderField
	 */
	public void setOrderField(String orderField) {
		this.orderField = orderField;
	}

	/**
	 * subpsdtype   取得
	 * @return subpsdtype subpsdtype
	 */
	public String getSubpsdtype() {
		return subpsdtype;
	}

	/**
	 * subpsdtype   设定
	 * @param subpsdtype subpsdtype
	 */
	public void setSubpsdtype(String subpsdtype) {
		this.subpsdtype = subpsdtype;
	}

	/**
	 * @return the 流程名称ID(应急管理专用)
	 */
	public String getPdid_like() {
		return pdid_like;
	}

	/**
	 * @param 流程名称ID(应急管理专用) the pdid_like to set
	 */
	public void setPdid_like(String pdid_like) {
		this.pdid_like = pdid_like;
	}
	/**  
	 * ??è???è??°?úμ?  
	 * @return fingerprint ??è??°?úμ?  
	 */
	
	public String getFingerprint() {
		return fingerprint;
	}

	/**  
	 * éè????è??°?úμ?  
	 * @param fingerprint ??è??°?úμ?  
	 */
	
	public void setFingerprint(String fingerprint) {
		this.fingerprint = fingerprint;
	}

	/**  
	 * 获取drmSign  
	 * @return drmSign 
	 */
	public String getDrmSign() {
		return drmSign;
	}

	/**  
	 * 设置drmSign  
	 * @param drmSign
	 */
	
	public void setDrmSign(String drmSign) {
		this.drmSign = drmSign;
	}
	
	
}
