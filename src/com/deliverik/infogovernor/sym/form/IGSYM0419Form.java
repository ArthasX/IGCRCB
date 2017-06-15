/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.sym.form;

import java.util.List;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.framework.user.model.condition.UserInfoSearchCond;
import com.deliverik.framework.user.model.condition.UserRoleSearchCond;
import com.deliverik.framework.user.model.condition.UserSearchCond;
import com.deliverik.infogovernor.sym.model.condition.UserNotRoleVWSearchCond;

/**
 * @Description: ��ɫ����_����û�
 * @Author  masai
 * @History 2010-6-22     �½� 
 * @Version V2.0
 */
@SuppressWarnings("serial")
public class IGSYM0419Form extends BaseForm implements UserSearchCond , UserInfoSearchCond , UserRoleSearchCond , UserNotRoleVWSearchCond {
	
	/** �û�ID */
	protected String userid;
	
	/** ��ɫID */
	protected Integer roleid;
	
	/** ��ɫ���� */
	protected String roletype;
	
	/** ��ɫ����like��ѯ���� */
	protected String roles_Like;
	
	/** ���̽�ɫ��չ���� */
	protected String[] roles_BP_EX;
	
	/** ��ɫ�û�����ID */
	protected String[] urids;
	
	/** ��ʼ��ʱ�Ƿ��и����� */
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
	
	/** ֵ����Ա��־λ 1Ϊ����ֵ�࣬0Ϊ����ֵ�� */
	protected String dutyflag;
	
	/** �����������־λ */
	protected String orgflag;
	
	protected String orgida;

	protected Integer roleida;
	
	protected String rolename;
	
	protected String sign;
	
	/**�û���ɫ����Χ*/
	protected String assetdomain;
	
	/** ���� */
	protected String userinfo;
	
	/** ���� */
	protected String userinfo_like;
	
	/**
	 * �û���ɫ����Χȡ��
	 * @return �û���ɫ����Χ
	 */
	public String getAssetdomain() {
		return assetdomain;
	}

	/**
	 * �û���ɫ����Χ�趨
	 *
	 * @param assetdomain �û���ɫ����Χ
	 */
	public void setAssetdomain(String assetdomain) {
		this.assetdomain = assetdomain;
	}
	
	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
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

	public String getDutyflag() {
		return dutyflag;
	}

	public void setDutyflag(String dutyflag) {
		this.dutyflag = dutyflag;
	}

	public String getOrgflag() {
		return orgflag;
	}

	public void setOrgflag(String orgflag) {
		this.orgflag = orgflag;
	}

	/**
	 * ����ȡ��
	 * @return ����
	 */
	public String getUserinfo() {
		return userinfo;
	}
	
	/**
	 * �����趨
	 *
	 * @param userinfo ���� 
	 */
	public void setUserinfo(String userinfo) {
		this.userinfo = userinfo;
	}
	
	/**
	 * ����ȡ��
	 * @return ����
	 */
	public String getUserinfo_like() {
		return userinfo_like;
	}
	
	/**
	 * �����趨
	 *
	 * @param userinfo_like ���� 
	 */
	public void setUserinfo_like(String userinfo_like) {
		this.userinfo_like = userinfo_like;
	}

	public List<String> getUserid_in() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getOrgid_like() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getUsername_forPms() {
		// TODO Auto-generated method stub
		return null;
	}

}
