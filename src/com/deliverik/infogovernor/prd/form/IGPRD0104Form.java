/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.prd.form;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.framework.workflow.prd.model.condition.IG333SearchCond;

/**
 * 流程定义_流程状态FORM
 * 
 */
@SuppressWarnings("serial")
public class IGPRD0104Form extends BaseForm implements IG333SearchCond{
	/** 流程状态ID */
	protected String psdid;
	
	/** 流程ID */
	protected String pdid;
	
	
	/** 流程状态的名称 */
	protected String psdname;
	
	/** 流程状态的描述 */
	protected String psddesc;
	
	/** 流程状态的标识 */
	protected String psdcode;
	
	protected String pdxml;
	
	protected String psdtype;
	
	protected String psdmode;

	/**
	 * 流程节点是否动态取参与者标识（0正常取参与者，1动态取参与者 ）
	 */
	protected String psdflag;

	/** 上级状态ID */
	protected String ppsdid;
	
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
	
	public String getPdxml() {
		return pdxml;
	}

	public void setPdxml(String pdxml) {
		this.pdxml = pdxml;
	}

	public String getPsdid() {
		return psdid;
	}

	public void setPsdid(String psdid) {
		this.psdid = psdid;
	}

	public String getPdid() {
		return pdid;
	}

	public void setPdid(String pdid) {
		this.pdid = pdid;
	}

	public String getPsdname() {
		return psdname;
	}

	public void setPsdname(String psdname) {
		this.psdname = psdname;
	}

	public String getPsddesc() {
		return psddesc;
	}

	public void setPsddesc(String psddesc) {
		this.psddesc = psddesc;
	}

	public String getPsdcode() {
		return psdcode;
	}

	public void setPsdcode(String psdcode) {
		this.psdcode = psdcode;
	}
	
	/** 查看模式 0最新：可编辑，1：历史：只查看 */
	protected String viewhistory;

	/**
	 * 查看模式
	 *
	 * @return 查看模式
	 */
	public String getViewhistory() {
		return viewhistory;
	}

	/**
	 * 查看模式
	 *
	 * @param viewHistory  0：最新，1历史
	 */
	public void setViewhistory(String viewhistory) {
		this.viewhistory = viewhistory;
	}

	public String assignpbdid;
	public String assignpsdid;
	public String notContainEndStatus;
	public String notContainStartStatus;
	public String notContainSelf;


	public String getAssignpbdid() {
		return assignpbdid;
	}

	public void setAssignpbdid(String assignpbdid) {
		this.assignpbdid = assignpbdid;
	}

	public String getAssignpsdid() {
		return assignpsdid;
	}

	public void setAssignpsdid(String assignpsdid) {
		this.assignpsdid = assignpsdid;
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

	public String getPsdid_like() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getFormGlobalControl() {
		// TODO Auto-generated method stub
		return null;
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

	public String getFatherflag() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.deliverik.framework.workflow.prd.model.condition.IG333SearchCond#getBysequence()
	 */
	public String getBysequence() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.deliverik.framework.workflow.prd.model.condition.IG333SearchCond#getOrderField()
	 */
	public String getOrderField() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.deliverik.framework.workflow.prd.model.condition.IG333SearchCond#getSubpsdtype()
	 */
	public String getSubpsdtype() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getPdid_like() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getFingerprint() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.deliverik.framework.workflow.prd.model.condition.IG333SearchCond#getDrmSign()
	 */
	public String getDrmSign() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
