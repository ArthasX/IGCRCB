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
public class IGPRD0107Form extends BaseForm {
	
	/** 参与者ID */
	protected Integer ppdid;
	
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
	
	
	/**参与者ID集合*/
	protected String[] ppdids;
	
	/**参与者角色ID集合*/
	protected String[] roleids;

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
	
	/** 参与者权限主键集合 */
	protected String[] change_ppdid;
	
	/** 用户id集合 */
	protected String[] userid;

	/** 父流程状态ID */
	protected String ppsdid;
	
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		super.reset(mapping, request);
		this.roleids = null;
		this.rolenames = null;
		this.ppuserids = null;
		this.ppusernames = null;
		this.pporgids = null;
		this.pporgnames = null;
		
		this.ppdids = null;
		this.roleinfos = null;
		this.roledescs = null;
		this.change_ppdid = null;
		this.userid = null;
	}
	
	
	
	public String getPdid() {
		return pdid;
	}



	public void setPdid(String pdid) {
		this.pdid = pdid;
	}



	public String[] getPpdids() {
		return ppdids;
	}



	public void setPpdids(String[] ppdids) {
		this.ppdids = ppdids;
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

	public String[] getRoleids() {
		return roleids;
	}

	public void setRoleids(String[] roleids) {
		this.roleids = roleids;
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

	public Integer getPpdid() {
		return ppdid;
	}

	public void setPpdid(Integer ppdid) {
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



	/**
	 * 参与者权限主键集合取得
	 * @return change_ppdid 参与者权限主键集合
	 */
	public String[] getChange_ppdid() {
		return change_ppdid;
	}



	/**
	 * 参与者权限主键集合设定
	 * @param change_ppdid 参与者权限主键集合
	 */
	public void setChange_ppdid(String[] change_ppdid) {
		this.change_ppdid = change_ppdid;
	}



	/**
	 * 用户id集合取得
	 * @return userid 用户id集合
	 */
	public String[] getUserid() {
		return userid;
	}



	/**
	 * 用户id集合设定
	 * @param userid 用户id集合
	 */
	public void setUserid(String[] userid) {
		this.userid = userid;
	}

	/**
	 * 父流程状态ID取得
	 * @return 父流程状态ID
	 */
	public String getPpsdid() {
		return ppsdid;
	}

	/**
	 * 父流程状态ID设定
	 * @param ppsdid 父流程状态ID
	 */
	public void setPpsdid(String ppsdid) {
		this.ppsdid = ppsdid;
	}
	
}
