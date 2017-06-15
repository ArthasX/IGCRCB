/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.prd.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.base.BaseForm;

/**
 * 流程定义_参与者Form
 * 
 */
@SuppressWarnings("serial")
public class IGPRD0124Form extends BaseForm {
	
	/** 参与者ID */
	protected String ppdid;
	
	/** 流程ID */
	protected String pdid;

	/** 流程状态ID */
	protected String psdid;
	
	/** 角色ID */
	protected Integer roleid;	
	
	/** 角色名称 */
	protected String rolename;
	
	/** 角色描述 */
	protected String roledesc;
	
	/** 角色信息 */
	protected String roleinfo;
	
	/** 参与者批准 */
	protected String ppapprove;
	
	/** 参与者驳回 */
	protected String ppdeny;
	
	/** 参与者提交 */
	protected String ppsubmit;
	
	/** 参与者中止 */
	protected String ppterm;
	
	/** 参与者更新 */
	protected String ppupdate;
	
	/** 参与者记录的时间戳 */
	protected String fingerPrint;
	
	
	/**角色类型主键集合*/
	protected String[] prtdids;
	
	/**角色类型ID集合*/
	protected String[] roletypes;

	/**参与者角色名称集合*/
	protected String[] rolenames;
	
	/**参与者角色信息集合*/
	protected String[] roleinfos;
	
	/**参与者角色描述集合*/
	protected String[] roledescs;

	/**参与者用户ID集合*/
	protected String[] ppuserids;
	
	/**参与者用户名称集合*/
	protected String[] ppusernames;

	/**参与者机构ID集合*/
	protected String[] pporgids;
	
	/**参与者机构名称集合*/
	protected String[] pporgnames;
	
	/**处理方式：0-删除，1-增加*/
	protected String mode;
	
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		super.reset(mapping, request);
		this.roletypes = null;
		this.rolenames = null;
		this.ppuserids = null;
		this.ppusernames = null;
		this.pporgids = null;
		this.pporgnames = null;
		
		this.prtdids = null;
		this.roleinfos = null;
		this.roledescs = null;
	}
	
	
	
	public String getPdid() {
		return pdid;
	}



	public void setPdid(String pdid) {
		this.pdid = pdid;
	}

	public String[] getRoleinfos() {
		return roleinfos;
	}

	public void setRoleinfos(String[] roleinfos) {
		this.roleinfos = roleinfos;
	}

	public String[] getRoledescs() {
		return roledescs;
	}

	public void setRoledescs(String[] roledescs) {
		this.roledescs = roledescs;
	}

	public String[] getRolenames() {
		return rolenames;
	}

	public void setRolenames(String[] rolenames) {
		this.rolenames = rolenames;
	}

	public String[] getPpuserids() {
		return ppuserids;
	}

	public void setPpuserids(String[] ppuserids) {
		this.ppuserids = ppuserids;
	}

	public String[] getPpusernames() {
		return ppusernames;
	}

	public void setPpusernames(String[] ppusernames) {
		this.ppusernames = ppusernames;
	}

	public String[] getPporgids() {
		return pporgids;
	}

	public void setPporgids(String[] pporgids) {
		this.pporgids = pporgids;
	}

	public String[] getPporgnames() {
		return pporgnames;
	}

	public void setPporgnames(String[] pporgnames) {
		this.pporgnames = pporgnames;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public String getPpdid() {
		return ppdid;
	}

	public void setPpdid(String ppdid) {
		this.ppdid = ppdid;
	}

	public String getPsdid() {
		return psdid;
	}

	public void setPsdid(String psdid) {
		this.psdid = psdid;
	}

	public Integer getRoleid() {
		return roleid;
	}

	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}

	public String getRolename() {
		return rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	public String getRoledesc() {
		return roledesc;
	}

	public void setRoledesc(String roledesc) {
		this.roledesc = roledesc;
	}

	public String getRoleinfo() {
		return roleinfo;
	}

	public void setRoleinfo(String roleinfo) {
		this.roleinfo = roleinfo;
	}

	public String getPpapprove() {
		return ppapprove;
	}

	public void setPpapprove(String ppapprove) {
		this.ppapprove = ppapprove;
	}

	public String getPpdeny() {
		return ppdeny;
	}

	public void setPpdeny(String ppdeny) {
		this.ppdeny = ppdeny;
	}

	public String getPpsubmit() {
		return ppsubmit;
	}

	public void setPpsubmit(String ppsubmit) {
		this.ppsubmit = ppsubmit;
	}

	public String getPpterm() {
		return ppterm;
	}

	public void setPpterm(String ppterm) {
		this.ppterm = ppterm;
	}

	public String getPpupdate() {
		return ppupdate;
	}

	public void setPpupdate(String ppupdate) {
		this.ppupdate = ppupdate;
	}

	public String getFingerPrint() {
		return fingerPrint;
	}

	public void setFingerPrint(String fingerPrint) {
		this.fingerPrint = fingerPrint;
	}
	
	public String[] getRoletypes() {
		return roletypes;
	}



	public void setRoletypes(String[] roletypes) {
		this.roletypes = roletypes;
	}



	public void setPrtdids(String[] prtdids) {
		this.prtdids = prtdids;
	}



	public String[] getPrtdids() {
		return prtdids;
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
}
