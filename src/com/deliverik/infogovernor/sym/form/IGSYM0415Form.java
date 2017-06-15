/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.sym.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.framework.user.model.condition.RoleActionSearchCond;
import com.deliverik.infogovernor.sym.model.condition.RoleReportSearchCond;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 系统管理_授权管理_菜单授权Form
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */

@SuppressWarnings("serial")
public class IGSYM0415Form extends BaseForm implements RoleActionSearchCond,RoleReportSearchCond{
	
	/** 菜单id */
	protected String actname;
	
	/** 授权菜单id  */
	protected String[] actionids;
	
	/** 角色id */
	protected Integer roleid;
	
	/** 角色名称 */
	protected String rolename;
	

	
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
	
	protected String[] rfdids;
	
	/**
	 * 已授权角色主键
	 */
	
	protected String[] rfdidy;
	
	/**
	 * 处理方式1-删除，0-添加
	 */
	
	protected String mode;
	
	protected String urid;
	
	protected String rfdpictype;
	
	protected String rfdtype;
	
	protected String rfdtypename;
	
	/**
	 * 角色名称取得
	 * @return 角色名称
	 */
	public String getRolename() {
		return rolename;
	}

	/**
	 * 角色名称设定
	 * @param rolename 角色名称
	 */
	public void setRolename(String rolename) {
		this.rolename = rolename;
	}
	
	/**
	 * 菜单ID取得
	 * @return 菜单ID
	 */
	public String getActname() {
		return actname;
	}

	/**
	 * 菜单ID设定
	 *
	 * @param actname 菜单ID
	 */
	public void setActname(String actname) {
		this.actname = actname;
	}
	
	/**
	 * 获取用户id
	 * @return Integer
	 */
	
	public Integer getRoleid() {
		return roleid;
	}
	/**
	 * 设置用户id
	 * @param roleid Integer
	 */
	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}

	/**
	 * 获取授权菜单id
	 * @return String[]
	 */
	
	public String[] getActionids() {
		return actionids;
	}
	
	/**
	 * 设置授权菜单id
	 * @param actionids String[]
	 */
	
	public void setActionids(String[] actionids) {
		this.actionids = actionids;
	}
	
	/**
	 * 重置Form
	 * @param mapping ActionMapping
	 * @param request HttpServletRequest
	 */
	
	public void reset(ActionMapping mapping,HttpServletRequest request){
		super.reset(mapping, request);
		this.actionids = null;
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

	public String getRfdtitle() {
		return rfdtitle;
	}

	public void setRfdtitle(String rfdtitle) {
		this.rfdtitle = rfdtitle;
	}


	public String[] getRfdids() {
		return rfdids;
	}

	public void setRfdids(String[] rfdids) {
		this.rfdids = rfdids;
	}

	public String[] getRfdidy() {
		return rfdidy;
	}

	public void setRfdidy(String[] rfdidy) {
		this.rfdidy = rfdidy;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public String getUrid() {
		return urid;
	}

	public void setUrid(String urid) {
		this.urid = urid;
	}

	public String getRfdpictype() {
		return rfdpictype;
	}

	public void setRfdpictype(String rfdpictype) {
		this.rfdpictype = rfdpictype;
	}

	public String getRfdtype() {
		return rfdtype;
	}

	public void setRfdtype(String rfdtype) {
		this.rfdtype = rfdtype;
	}

	public String getRfdtypename() {
		return rfdtypename;
	}

	public void setRfdtypename(String rfdtypename) {
		this.rfdtypename = rfdtypename;
	}

	
}
