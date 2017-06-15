/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.sym.form;

import java.util.List;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.framework.user.model.condition.UserInfoSearchCond;
import com.deliverik.framework.user.model.condition.UserRoleVWSearchCond;

/**
 * @Description: 角色管理_添加用户
 * @Author  masai
 * @History 2010-6-22     新建 
 * @Version V2.0
 */
@SuppressWarnings("serial")
public class IGSYM0418Form extends BaseForm implements UserRoleVWSearchCond,UserInfoSearchCond {
	
	/** 用户ID */
	protected String userid;
	
	/** 角色ID */
	protected Integer roleid;
	
	/** 角色类型 */
	protected String roletype;
	
	/** 角色类型like查询条件 */
	protected String roles_Like;
	
	/** 流程角色扩展类型 */
	protected String[] roles_BP_EX;
	
	/** 角色用户关联ID */
	protected String[] urids;
	
	/** 初始化时是否含有负责人 */
	protected String hasManager;
		
	protected String userid_q;
	
	protected String username_q;
	
	protected String orgidstr;
	
	protected String orgname;
	
	protected String username;
	
	protected String password;

	protected String orgid;
	
	protected String usermobile;
	
	protected String deleteflag;
	
	protected String orgida;

	protected Integer roleida;
	
	protected String rolename;
	
	/**用户角色管理范围*/
	protected String assetdomain;
	protected String[] roletypes;
	
	/** 工号 */
	protected String userinfo;
	
	/** 工号 */
	protected String userinfo_like;
	
	/**
	 * 用户角色管理范围取得
	 * @return 用户角色管理范围
	 */
	public String getAssetdomain() {
		return assetdomain;
	}

	/**
	 * 用户角色管理范围设定
	 *
	 * @param assetdomain 用户角色管理范围
	 */
	public void setAssetdomain(String assetdomain) {
		this.assetdomain = assetdomain;
	}
	
	public String getOrgida() {
		return orgida;
	}

	public void setOrgida(String orgida) {
		this.orgida = orgida;
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

	protected String userida;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getOrgid() {
		return orgid;
	}

	public void setOrgid(String orgid) {
		this.orgid = orgid;
	}

	public String getUsermobile() {
		return usermobile;
	}

	public void setUsermobile(String usermobile) {
		this.usermobile = usermobile;
	}

	public String getDeleteflag() {
		return deleteflag;
	}

	public void setDeleteflag(String deleteflag) {
		this.deleteflag = deleteflag;
	}

	public String getUserid_q() {
		return userid_q;
	}

	public void setUserid_q(String userid_q) {
		this.userid_q = userid_q;
	}

	public String getUsername_q() {
		return username_q;
	}

	public void setUsername_q(String username_q) {
		this.username_q = username_q;
	}

	public String getOrgname() {
		return orgname;
	}

	public void setOrgname(String orgname) {
		this.orgname = orgname;
	}

	public String getHasManager() {
		return hasManager;
	}

	public void setHasManager(String hasManager) {
		this.hasManager = hasManager;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public Integer getRoleid() {
		return roleid;
	}

	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}

	public String getRoletype() {
		return roletype;
	}

	public void setRoletype(String roletype) {
		this.roletype = roletype;
	}

	public String getRoles_Like() {
		return roles_Like;
	}

	public void setRoles_Like(String roles_Like) {
		this.roles_Like = roles_Like;
	}

	public String[] getRoles_BP_EX() {
		return roles_BP_EX;
	}

	public void setRoles_BP_EX(String[] roles_BP_EX) {
		this.roles_BP_EX = roles_BP_EX;
	}

	public String[] getUrids() {
		return urids;
	}

	public void setUrids(String[] urids) {
		this.urids = urids;
	}

	public String getOrgidstr() {
		return orgidstr;
	}

	public void setOrgidstr(String orgidstr) {
		this.orgidstr = orgidstr;
	}
	
	public boolean isRolemanager() {
		return false;
	}

	public String[] getRoletypes() {
		return roletypes;
	}

	public void setRoletypes(String[] roletypes) {
		this.roletypes = roletypes;
	}

	public boolean isDutyflag() {
		// TODO Auto-generated method stub
		return false;
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

	public String getUsername_forPms() {
		// TODO Auto-generated method stub
		return null;
	}


}
