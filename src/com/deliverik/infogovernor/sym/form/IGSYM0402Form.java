/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.sym.form;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.framework.user.model.condition.UserRoleVWSearchCond;

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
public class IGSYM0402Form extends BaseForm implements UserRoleVWSearchCond{
	
	/**
	 * 机构主键
	 */
	
	protected String orgid;
	
	/**
	 * 用户id
	 */
	
	protected String userid;
	
	/**
	 * 角色id
	 */
	
	protected Integer roleid;
	
	/**
	 * 已授权用户角色主键
	 */
	
	protected String[] urid;
	
	/**
	 * 未授权角色主键
	 */
	
	protected String[] roleids;
	
	/**
	 * 处理方式1-删除，0-添加
	 */
	
	protected String mode;
	
	protected String orgname;
	protected String username;
	
	protected String roletype;
	
	


	public String getRoletype() {
		return roletype;
	}

	public void setRoletype(String roletype) {
		this.roletype = roletype;
	}

	public String getOrgname() {
		return orgname;
	}

	public void setOrgname(String orgname) {
		this.orgname = orgname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * 获取机构主键
	 * @return Integer
	 */
	
	public String getOrgid() {
		return orgid;
	}
	
	/**
	 * 设置机构主键
	 * @param orgid Integer
	 */
	
	public void setOrgid(String orgid) {
		this.orgid = orgid;
	}
	
	/**
	 * 获取用户id
	 * @return String
	 */
	
	public String getUserid() {
		return userid;
	}
	/**
	 * 设置用户id
	 * @param userid String
	 */
	public void setUserid(String userid) {
		this.userid = userid;
	}

	/**
	 * 获取已授权用户角色主键
	 * @return String[]
	 */
	
	public String[] getUrid() {
		return urid;
	}

	/**
	 * 设置已授权用户角色主键
	 * @param urid String[]
	 */
	
	public void setUrid(String[] urid) {
		this.urid = urid;
	}
	
	/**
	 * 重置Form
	 * @param mapping ActionMapping
	 * @param request HttpServletRequest
	 */
	
	public void reset(ActionMapping mapping,HttpServletRequest request){
		super.reset(mapping, request);
		this.urid = null;
		this.roleids = null;
	}

	/**
	 * 获取未授权角色主键
	 * @return String[]
	 */
	
	public void setRoleids(String[] roleids) {
		this.roleids = roleids;
	}

	/**
	 * 设置未授权角色主键
	 * @param roleids String[]
	 */
	
	public String[] getRoleids() {
		return roleids;
	}
	
	/**
	 * 获取处理方式1-删除，0-添加
	 * @return String[]
	 */
	
	public String getMode() {
		return mode;
	}

	/**
	 * 设置处理方式1-删除，0-添加
	 * @param mode String
	 */
	
	public void setMode(String mode) {
		this.mode = mode;
	}

	/**
	 * 获取角色id
	 * @return Integer
	 */
	
	public Integer getRoleid() {
		return roleid;
	}

	/**
	 * 设置角色id
	 * @param roleid Integer
	 */
	
	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}

	public String[] getRoles_BP_EX() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getRoles_Like() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean isRolemanager() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isDutyflag() {
		// TODO Auto-generated method stub
		return false;
	}

	public String getAssetdomain() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getOrgid_like() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getRoledomain_like() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getRoledomain() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getRolename_like() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setUrid_eq(Integer urid_eq) {
		// TODO Auto-generated method stub
		
	}

	public String getUsername_like() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Integer> getRoleid_in() {
		// TODO Auto-generated method stub
		return null;
	}



}
