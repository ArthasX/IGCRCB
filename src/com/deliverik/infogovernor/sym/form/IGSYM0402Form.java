/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
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
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ϵͳ����_��Ȩ����_��ɫ��ȨForm
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */

@SuppressWarnings("serial")
public class IGSYM0402Form extends BaseForm implements UserRoleVWSearchCond{
	
	/**
	 * ��������
	 */
	
	protected String orgid;
	
	/**
	 * �û�id
	 */
	
	protected String userid;
	
	/**
	 * ��ɫid
	 */
	
	protected Integer roleid;
	
	/**
	 * ����Ȩ�û���ɫ����
	 */
	
	protected String[] urid;
	
	/**
	 * δ��Ȩ��ɫ����
	 */
	
	protected String[] roleids;
	
	/**
	 * ����ʽ1-ɾ����0-���
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
	 * ��ȡ��������
	 * @return Integer
	 */
	
	public String getOrgid() {
		return orgid;
	}
	
	/**
	 * ���û�������
	 * @param orgid Integer
	 */
	
	public void setOrgid(String orgid) {
		this.orgid = orgid;
	}
	
	/**
	 * ��ȡ�û�id
	 * @return String
	 */
	
	public String getUserid() {
		return userid;
	}
	/**
	 * �����û�id
	 * @param userid String
	 */
	public void setUserid(String userid) {
		this.userid = userid;
	}

	/**
	 * ��ȡ����Ȩ�û���ɫ����
	 * @return String[]
	 */
	
	public String[] getUrid() {
		return urid;
	}

	/**
	 * ��������Ȩ�û���ɫ����
	 * @param urid String[]
	 */
	
	public void setUrid(String[] urid) {
		this.urid = urid;
	}
	
	/**
	 * ����Form
	 * @param mapping ActionMapping
	 * @param request HttpServletRequest
	 */
	
	public void reset(ActionMapping mapping,HttpServletRequest request){
		super.reset(mapping, request);
		this.urid = null;
		this.roleids = null;
	}

	/**
	 * ��ȡδ��Ȩ��ɫ����
	 * @return String[]
	 */
	
	public void setRoleids(String[] roleids) {
		this.roleids = roleids;
	}

	/**
	 * ����δ��Ȩ��ɫ����
	 * @param roleids String[]
	 */
	
	public String[] getRoleids() {
		return roleids;
	}
	
	/**
	 * ��ȡ����ʽ1-ɾ����0-���
	 * @return String[]
	 */
	
	public String getMode() {
		return mode;
	}

	/**
	 * ���ô���ʽ1-ɾ����0-���
	 * @param mode String
	 */
	
	public void setMode(String mode) {
		this.mode = mode;
	}

	/**
	 * ��ȡ��ɫid
	 * @return Integer
	 */
	
	public Integer getRoleid() {
		return roleid;
	}

	/**
	 * ���ý�ɫid
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
