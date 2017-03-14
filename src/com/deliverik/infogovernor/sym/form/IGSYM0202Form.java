/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.sym.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.Globals;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.base.BaseForm;
import com.deliverik.framework.platform.WebApplicationSupport;
import com.deliverik.framework.user.model.Organization;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.utility.CodeListUtils;
import com.deliverik.infogovernor.adapter.CodeDefinition;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 系统管理_机构管理_新增修改FormBean
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */

@SuppressWarnings("serial")
public class IGSYM0202Form extends BaseForm implements User{
	
	
	/**
	 * 用户ID（登录系统时用）
	 */
	
	private String loginType;//登录方式  NORMAL/LDAP
	
	
	/**
	 * 用户ID（登录系统时用）
	 */
	
	protected String userid;
	
	
	/**
	 * 用户所属机构ID
	 */
	
	protected String orgid;
	
	/**
	 * 机构id
	 */
	
	protected String orgidstr;
	
	/**
	 * 用户名（真实姓名）
	 */
	
	protected String username;
	
	/**
	 * 所属机构名称
	 */
	
	protected String orgname;
	
	/**
	 * 用户说明
	 */
	
	protected String userdesc;

	/**
	 * 用户信息（保留字段）
	 */
	
	protected String userinfo;

	/**
	 * 用户口令
	 */
	
	protected String password;
	
	/**
	 * 用户口令确认
	 */
	
	protected String repassword;

	/**
	 * 用户状态
	 */
	
	protected String userstatus;

	/**
	 * 用户类型（保留字段）
	 */
	
	protected String usertype;

	/**
	 * 用户电话
	 */
	
	protected String userphone;

	/**
	 * 用户手机
	 */
	
	protected String usermobile;
	
	/**
	 * 用户邮箱
	 */
	
	protected String useremail;
	
	/**
	 * 页面标题显示标志0-新增,1-变更
	 */
	
	protected String mode = "0";
	
	/**
	 * 页面标题显示标志0-新增,1-变更
	 */
	
	protected String userrolename;	
	
	/**
	 * 负责人
	 */
	
	protected String[] rolemanager;
	/**
	 * 负责人
	 */
	
	protected String[] rolemobile;
	/**
	 * 负责人
	 */
	
	protected String[] mobile;
	/**
	 * 负责人
	 */
	
	protected String[] roleid;
	
	/** 逻辑删除标志位 */
	protected String deleteflag;


	public String getLoginType() {
		return loginType;
	}

	public void setLoginType(String loginType) {
		this.loginType = loginType;
	}

	public String getUserrolename() {
		return userrolename;
	}

	public void setUserrolename(String userrolename) {
		this.userrolename = userrolename;
	}

	/**
	 * 获取用户ID（登录系统时用）
	 * @return String
	 */
	
	public String getUserid() {
		return userid;
	}

	/**
	 * 设置用户ID（登录系统时用）
	 * @param userid String
	 */
	
	public void setUserid(String userid) {
		this.userid = userid;
	}

	/**
	 * 获取用户名（真实姓名）
	 * @return String
	 */
	
	public String getUsername() {
		return username;
	}
	
	/**
	 * 设置用户名（真实姓名）
	 * @param username String
	 */
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	/**
	 * 获取用户说明
	 * @return String
	 */
	
	public String getUserdesc() {
		return userdesc;
	}

	/**
	 * 设置用户说明
	 * @param userdesc String
	 */
	
	public void setUserdesc(String userdesc) {
		this.userdesc = userdesc;
	}


	/**
	 * 获取用户信息（保留字段）
	 * @return String
	 */
	
	public String getUserinfo() {
		return userinfo;
	}

	/**
	 * 设置用户信息（保留字段）
	 * @param userinfo String
	 */
	
	public void setUserinfo(String userinfo) {
		this.userinfo = userinfo;
	}

	/**
	 * 获取用户口令
	 * @return String
	 */
	
	public String getPassword() {
		return password;
	}
	
	/**
	 * 设置用户口令
	 * @param password String
	 */
	
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * 获取用户状态
	 * @return String
	 */
	
	public String getUserstatus() {
		return userstatus;
	}

	/**
	 * 设置用户状态
	 * @param userstatus String
	 */
	
	public void setUserstatus(String userstatus) {
		this.userstatus = userstatus;
	}

	/**
	 * 获取用户类型（保留字段）
	 * @return String
	 */
	
	public String getUsertype() {
		return usertype;
	}

	/**
	 * 设置用户类型（保留字段）
	 * @param usertype String
	 */
	
	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}

	/**
	 * 获取用户电话
	 * @return String
	 */
	
	public String getUserphone() {
		return userphone;
	}

	/**
	 * 设置用户电话
	 * @param userphone String
	 */
	
	public void setUserphone(String userphone) {
		this.userphone = userphone;
	}
	
	/**
	 * 获取用户手机
	 * @return String
	 */
	
	public String getUsermobile() {
		return usermobile;
	}

	/**
	 * 设置用户手机
	 * @param usermobile String
	 */
	
	public void setUsermobile(String usermobile) {
		this.usermobile = usermobile;
	}

	/**
	 * 获取用户邮箱
	 * @return String
	 */
	
	public String getUseremail() {
		return useremail;
	}

	/**
	 * 设置用户邮箱
	 * @param useremail String
	 */
	
	public void setUseremail(String useremail) {
		this.useremail = useremail;
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
	 * 获取机构id
	 * @return String
	 */
	
	public String getOrgid() {
		if( (this.orgidstr == null) || ("".equals(this.orgidstr))){
			return null;
		} else {
			return this.orgidstr;
		}
	}
	
	/**
	 * 设置用户所属机构ID
	 * @param orgid Integer
	 */
	
	public void setOrgid(String orgid) {
		this.orgid = orgid;
	}

	/**
	 * 获取机构id
	 * @return String
	 */
	
	public String getOrgidstr() {
		return orgidstr;
	}
	
	/**
	 * 设置机构id
	 * @param orgid String
	 */
	
	public void setOrgidstr(String orgidstr) {
		this.orgidstr = orgidstr;
	}

	/**
	 * 设置所属机构名称
	 * @param orgid String
	 */
	
	public String getOrgname() {
		return orgname;
	}

	/**
	 * 获取所属机构名称
	 * @return String
	 */
	
	public void setOrgname(String orgname) {
		this.orgname = orgname;
	}
	
	

	public String getRepassword() {
		return repassword;
	}

	public void setRepassword(String repassword) {
		this.repassword = repassword;
	}

	@Override
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
			ActionErrors errors = new ActionErrors();
		errors = super.validate(mapping, request);
		
		boolean flag = true;
		CodeListUtils codeListUtils = (CodeListUtils) WebApplicationSupport.getBean("codeListUtils");
		loginType = codeListUtils.getCodeValue(CodeDefinition.LDAP, "", "", CodeDefinition.LDAP_AUTHORIZATIONTYPE);
		String localuser = "";//本地登陆用户组
		User nowUser = (User)request.getSession().getAttribute(BaseAction.SESSION_KEY_LOGIN_USER);
		String userid = nowUser.getUserid();

		localuser = codeListUtils.getCodeValue(CodeDefinition.LDAP, "", "", CodeDefinition.LDAP_LOCALORIZATIONTYPE);
		for(int i=0,j=localuser.split(",").length;i<j;i++){//判断当前用户是否为本地登陆用户组里的用户,是的话就不使用LDAP验证
			String localUserId =  localuser.split(",")[i];
			if(null!=localUserId && userid.equals(localUserId)){
				flag = false;
			}
		}
		
		if("1".equals(loginType) && flag){
			
		}else{//普通登录方式需要校验密码
			if ( password != null ) {
				if (password.length()>16) {
					errors.add(Globals.ERROR_KEY, new ActionMessage("errors.invalid","用户密码长度不能超过16位！"));
				}
			}
		}
		
		
		return errors;
	}
	
	protected String fingerPrint;

	public String getFingerPrint() {
		return fingerPrint;
	}

	public void setFingerPrint(String fingerPrint) {
		this.fingerPrint = fingerPrint;
	}

	public String[] getRolemanager() {
		return rolemanager;
	}

	public void setRolemanager(String[] rolemanager) {
		this.rolemanager = rolemanager;
	}

	public String[] getRolemobile() {
		return rolemobile;
	}

	public void setRolemobile(String[] rolemobile) {
		this.rolemobile = rolemobile;
	}

	public String[] getMobile() {
		return mobile;
	}

	public void setMobile(String[] mobile) {
		this.mobile = mobile;
	}

	public String[] getRoleid() {
		return roleid;
	}

	public void setRoleid(String[] roleid) {
		this.roleid = roleid;
	}

	public String getDeleteflag() {
		return deleteflag;
	}

	public void setDeleteflag(String deleteflag) {
		this.deleteflag = deleteflag;
	}

	public Organization getOrganizationTB() {
		// TODO Auto-generated method stub
		return null;
	}

}
