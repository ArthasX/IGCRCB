/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.sym.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.framework.user.model.condition.UserInfoSearchCond;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ϵͳ����_��Ȩ����_�˵���ȨForm
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */

@SuppressWarnings("serial")
public class IGSYM0405Form extends BaseForm implements UserInfoSearchCond{

	protected String orgida;
	
	protected String orgname;

	protected String orgname_q;

	protected Integer roleida;

	protected String rolename;
	
	protected String roletype;

	protected String userida;

	protected String username;
	protected String from_s;
	/**
	 * ����syscoding
	 */
	
	protected String orgidstr;

	protected String orgidstr_name;//��������
	
	/** ������ϵ�绰��ʶ */
	protected String flag;
	
	/** ���� */
	protected String userinfo;
	
	/** ���� */
	protected String userinfo_like;

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
	 * ����Form
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

	public String getFrom_s() {
		return from_s;
	}

	public void setFrom_s(String from_s) {
		this.from_s = from_s;
	}
	
	/**
	 * ������ϵ�绰��ʶȡ��
	 * @return ������ϵ�绰��ʶ
	 */
	public String getFlag() {
		return flag;
	}

	/**
	 * ������ϵ�绰��ʶ�趨
	 * @param flag ������ϵ�绰��ʶ
	 */
	public void setFlag(String flag) {
		this.flag = flag;
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

	public String getUsername_forPms() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
