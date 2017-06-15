/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.sym.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.framework.user.model.condition.UserInfoSearchCond;

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
public class IGSYM0408Form extends BaseForm implements UserInfoSearchCond{

	protected String orgida;
	
	protected String orgname;

	protected String orgname_q;

	protected Integer roleida;

	protected String rolename;
	
	protected String roletype;

	protected String userida;

	protected String username;
	
	/** 工号 */
	protected String userinfo;
	
	/** 工号 */
	protected String userinfo_like;
	
	/**
	 * 机构syscoding
	 */
	
	protected String orgidstr;
	
	protected String orgidstr_name;//机构名称
	

	
	
	/**
	 * @return the orgname
	 */
	public String getOrgname() {
		return orgname;
	}

	/**
	 * @param orgname the orgname to set
	 */
	public void setOrgname(String orgname) {
		this.orgname = orgname;
	}

	public String getOrgidstr_name() {
		return orgidstr_name;
	}

	public void setOrgidstr_name(String orgidstr_name) {
		this.orgidstr_name = orgidstr_name;
	}

	public String getOrgida() {
		return this.orgida;
	}

	public void setOrgida(String orgida) {
		this.orgida = orgida;
	}

	

	/**
	 * @return the orgname_q
	 */
	public String getOrgname_q() {
		return orgname_q;
	}

	/**
	 * @param orgname_q the orgname_q to set
	 */
	public void setOrgname_q(String orgname_q) {
		this.orgname_q = orgname_q;
	}

	public Integer getRoleida() {
		return roleida;
	}

	public void setRoleida(Integer roleida) {
		this.roleida = roleida;
	}

	public String getRolename() {
		return rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	public String getUserida() {
		return userida;
	}

	public void setUserida(String userida) {
		this.userida = userida;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}


	public String getOrgidstr() {
		return orgidstr;
	}

	public void setOrgidstr(String orgidstr) {
		this.orgidstr = orgidstr;
	}
	
	/**
	 * 重置Form
	 * @param mapping ActionMapping
	 * @param request HttpServletRequest
	 */
	
	public void reset(ActionMapping mapping,HttpServletRequest request){
		super.reset(mapping, request);
		this.orgname_q = null;
		this.orgida = null;
		this.username = null;
	}

	public String getRoletype() {
		return roletype;
	}

	public void setRoletype(String roletype) {
		this.roletype = roletype;
	}
	
	/**
	 * 工号取得
	 * @return 工号
	 */
	public String getUserinfo() {
		return userinfo;
	}
	
	/**
	 * 工号设定
	 *
	 * @param userinfo 工号 
	 */
	public void setUserinfo(String userinfo) {
		this.userinfo = userinfo;
	}
	
	/**
	 * 工号取得
	 * @return 工号
	 */
	public String getUserinfo_like() {
		return userinfo_like;
	}
	
	/**
	 * 工号设定
	 *
	 * @param userinfo_like 工号 
	 */
	public void setUserinfo_like(String userinfo_like) {
		this.userinfo_like = userinfo_like;
	}

	public String getUsername_forPms() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
