/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.sym.form;


import com.deliverik.framework.base.BaseForm;
import com.deliverik.infogovernor.sym.model.condition.RoleReportSearchCond;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 系统管理_授权管理_角色授权Form
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */

@SuppressWarnings("serial")
public class IGSYM0410Form extends BaseForm implements RoleReportSearchCond{
	
	/**
	 * 角色ID
	 */
	
	protected Integer roleid;
	
	/**
	 * 报表ID
	 */
	
	protected Integer rfdid;
	
	protected String rrperm;
	
	protected String rrdesc;
	
	protected String fingerprint;
	
	protected String rfdtitle;
	
	/**
	 * 未授权角色主键
	 */
	
	protected String[] roleids;
	
	/**
	 * 已授权角色主键
	 */
	
	protected String[] roleidy;
	
	/**
	 * 处理方式1-删除，0-添加
	 */
	
	protected String mode;
	
	protected String urid;
	
	protected String rfdpictype;
	
	protected String rfdtype;
	
	protected String rfdtypename;
	
	
	
	
	public String getRfdtypename() {
		return rfdtypename;
	}


	public void setRfdtypename(String rfdtypename) {
		this.rfdtypename = rfdtypename;
	}


	public String getRfdtype() {
		return rfdtype;
	}


	public void setRfdtype(String rfdtype) {
		this.rfdtype = rfdtype;
	}


	public String getRfdpictype() {
		return rfdpictype;
	}


	public void setRfdpictype(String rfdpictype) {
		this.rfdpictype = rfdpictype;
	}


	public String getUrid() {
		return urid;
	}


	public void setUrid(String urid) {
		this.urid = urid;
	}


	public String getMode() {
		return mode;
	}


	public void setMode(String mode) {
		this.mode = mode;
	}



	public String getRfdtitle() {
		return rfdtitle;
	}


	public void setRfdtitle(String rfdtitle) {
		this.rfdtitle = rfdtitle;
	}


	public String getCvalue() {
		return cvalue;
	}


	public void setCvalue(String cvalue) {
		this.cvalue = cvalue;
	}


	protected String cvalue;
	

	
	public Integer getRoleid() {
		return roleid;
	}


	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}


	public Integer getRfdid() {
		return rfdid;
	}


	public void setRfdid(Integer rfdid) {
		this.rfdid = rfdid;
	}


	public String getRrperm() {
		return rrperm;
	}


	public void setRrperm(String rrperm) {
		this.rrperm = rrperm;
	}


	public String getRrdesc() {
		return rrdesc;
	}


	public void setRrdesc(String rrdesc) {
		this.rrdesc = rrdesc;
	}


	public String getFingerprint() {
		return fingerprint;
	}


	public void setFingerprint(String fingerprint) {
		this.fingerprint = fingerprint;
	}


	public String[] getRoleids() {
		return roleids;
	}


	public void setRoleids(String[] roleids) {
		this.roleids = roleids;
	}


	public String[] getRoleidy() {
		return roleidy;
	}


	public void setRoleidy(String[] roleidy) {
		this.roleidy = roleidy;
	}

	
	
}
