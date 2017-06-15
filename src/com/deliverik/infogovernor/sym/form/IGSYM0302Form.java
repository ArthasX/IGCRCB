/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.sym.form;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.framework.user.model.Role;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 系统管理_用户管理_新增修改FormBean
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */

@SuppressWarnings("serial")
public class IGSYM0302Form extends BaseForm implements Role{
	
	/**
	 * 角色主键
	 */
	
	protected Integer roleid;
	
	/**
	 * 角色主键
	 */
	
	protected String roleidstr;
	
	/**
	 * 角色名称
	 */
	
	protected String rolename;
	
	/**
	 * 角色名称
	 */
	
	protected String rolenamebak;
	
	/**
	 * 角色说明
	 */
	
	protected String roledesc;
	
	/**
	 * 角色信息（保留字段）
	 */
	
	protected String roleinfo;
	
	protected String roletype;
	
	
	
	/**
	 * 页面标题显示标志0-新增,1-变更
	 */
	
	protected String mode = "0";
	
	

	/**
	 * 角色管理域（syscoding）
	 */
	protected String roledomain;
	
	/**
	 * 资产管理内容（esyscoding）
	 */
	protected String assetdomain;
	
	
	/**
	 * 角色管理域显示用（orgname）
	 */
	protected String roledomainname;
	
	protected String rodomain;
	
	/**
	 * 资产管理内容显示用
	 */
	protected String assetdomainname;
	
	protected String asdomain;
	
	protected String fingerPrint;

	public String getFingerPrint() {
		return fingerPrint;
	}

	public void setFingerPrint(String fingerPrint) {
		this.fingerPrint = fingerPrint;
	}
	
	
	public String getAssetdomainname() {
		return assetdomainname;
	}

	public void setAssetdomainname(String assetdomainname) {
		this.assetdomainname = assetdomainname;
	}

	public String getAsdomain() {
		return asdomain;
	}

	public void setAsdomain(String asdomain) {
		this.asdomain = asdomain;
	}

	public String getAssetdomain() {
		return assetdomain;
	}

	public void setAssetdomain(String assetdomain) {
		this.assetdomain = assetdomain;
	}

	public String getRodomain() {
		return rodomain;
	}

	public void setRodomain(String rodomain) {
		this.rodomain = rodomain;
	}

	public String getRoledomain() {
		return roledomain;
	}

	public void setRoledomain(String roledomain) {
		this.roledomain = roledomain;
	}

	public String getRoledomainname() {
		return roledomainname;
	}

	public void setRoledomainname(String roledomainname) {
		this.roledomainname = roledomainname;
	}

	/**
	 * 获取角色主键
	 * @return String
	 */
	
	public Integer getRoleid() {
		if( (this.roleidstr == null) || ("".equals(this.roleidstr))){
			return null;
		} else {
			return Integer.valueOf(this.roleidstr);
		}
	}
	
	/**
	 * 设置角色主键
	 * @param roleid String
	 */
	
	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}
	
	/**
	 * 获取角色主键
	 * @return String
	 */
	
	public String getRoleidstr() {
		return roleidstr;
	}

	/**
	 * 设置角色主键
	 * @param roleid String
	 */
	
	public void setRoleidstr(String roleidstr) {
		this.roleidstr = roleidstr;
	}

	/**
	 * 获取角色名称
	 * @return String
	 */
	
	public String getRolename() {
		return rolename;
	}
	
	/**
	 * 设置角色名称
	 * @param rolename String
	 */
	
	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	/**
	 * 获取角色说明
	 * @return String
	 */
	
	public String getRoledesc() {
		return roledesc;
	}
	/**
	 * 设置角色说明
	 * @param roledesc String
	 */
	public void setRoledesc(String roledesc) {
		this.roledesc = roledesc;
	}
	
	/**
	 * 获取角色信息（保留字段）
	 * @return String
	 */
	
	public String getRoleinfo() {
		return roleinfo;
	}
	
	/**
	 * 设置角色信息（保留字段）
	 * @param roleinfo String
	 */
	
	public void setRoleinfo(String roleinfo) {
		this.roleinfo = roleinfo;
	}

	/**
	 * 获取页面标题显示标志
	 * @return String
	 */
	
	public String getMode() {
		return mode;
	}

	/**
	 * 设置页面标题显示标志
	 * @param mode String
	 */
	
	public void setMode(String mode) {
		this.mode = mode;
	}

	/**
	 * 获取角色类型
	 * @return String
	 */
	
	public String getRoletype() {
		return roletype;
	}

	/**
	 * 设置角色类型
	 * @param roletype String
	 */
	
	public void setRoletype(String roletype) {
		this.roletype = roletype;
	}

	/**
	 * 获取角色名称
	 * @return String
	 */
	
	public String getRolenamebak() {
		return rolenamebak;
	}

	/**
	 * 设置角色名称
	 * @param rolenamebak String
	 */
	
	public void setRolenamebak(String rolenamebak) {
		this.rolenamebak = rolenamebak;
	}
	
}
