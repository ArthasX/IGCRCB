/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.sym.form;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.framework.user.model.Role;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ϵͳ����_�û�����_�����޸�FormBean
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */

@SuppressWarnings("serial")
public class IGSYM0302Form extends BaseForm implements Role{
	
	/**
	 * ��ɫ����
	 */
	
	protected Integer roleid;
	
	/**
	 * ��ɫ����
	 */
	
	protected String roleidstr;
	
	/**
	 * ��ɫ����
	 */
	
	protected String rolename;
	
	/**
	 * ��ɫ����
	 */
	
	protected String rolenamebak;
	
	/**
	 * ��ɫ˵��
	 */
	
	protected String roledesc;
	
	/**
	 * ��ɫ��Ϣ�������ֶΣ�
	 */
	
	protected String roleinfo;
	
	protected String roletype;
	
	
	
	/**
	 * ҳ�������ʾ��־0-����,1-���
	 */
	
	protected String mode = "0";
	
	

	/**
	 * ��ɫ������syscoding��
	 */
	protected String roledomain;
	
	/**
	 * �ʲ��������ݣ�esyscoding��
	 */
	protected String assetdomain;
	
	
	/**
	 * ��ɫ��������ʾ�ã�orgname��
	 */
	protected String roledomainname;
	
	protected String rodomain;
	
	/**
	 * �ʲ�����������ʾ��
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
	 * ��ȡ��ɫ����
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
	 * ���ý�ɫ����
	 * @param roleid String
	 */
	
	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}
	
	/**
	 * ��ȡ��ɫ����
	 * @return String
	 */
	
	public String getRoleidstr() {
		return roleidstr;
	}

	/**
	 * ���ý�ɫ����
	 * @param roleid String
	 */
	
	public void setRoleidstr(String roleidstr) {
		this.roleidstr = roleidstr;
	}

	/**
	 * ��ȡ��ɫ����
	 * @return String
	 */
	
	public String getRolename() {
		return rolename;
	}
	
	/**
	 * ���ý�ɫ����
	 * @param rolename String
	 */
	
	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	/**
	 * ��ȡ��ɫ˵��
	 * @return String
	 */
	
	public String getRoledesc() {
		return roledesc;
	}
	/**
	 * ���ý�ɫ˵��
	 * @param roledesc String
	 */
	public void setRoledesc(String roledesc) {
		this.roledesc = roledesc;
	}
	
	/**
	 * ��ȡ��ɫ��Ϣ�������ֶΣ�
	 * @return String
	 */
	
	public String getRoleinfo() {
		return roleinfo;
	}
	
	/**
	 * ���ý�ɫ��Ϣ�������ֶΣ�
	 * @param roleinfo String
	 */
	
	public void setRoleinfo(String roleinfo) {
		this.roleinfo = roleinfo;
	}

	/**
	 * ��ȡҳ�������ʾ��־
	 * @return String
	 */
	
	public String getMode() {
		return mode;
	}

	/**
	 * ����ҳ�������ʾ��־
	 * @param mode String
	 */
	
	public void setMode(String mode) {
		this.mode = mode;
	}

	/**
	 * ��ȡ��ɫ����
	 * @return String
	 */
	
	public String getRoletype() {
		return roletype;
	}

	/**
	 * ���ý�ɫ����
	 * @param roletype String
	 */
	
	public void setRoletype(String roletype) {
		this.roletype = roletype;
	}

	/**
	 * ��ȡ��ɫ����
	 * @return String
	 */
	
	public String getRolenamebak() {
		return rolenamebak;
	}

	/**
	 * ���ý�ɫ����
	 * @param rolenamebak String
	 */
	
	public void setRolenamebak(String rolenamebak) {
		this.rolenamebak = rolenamebak;
	}
	
}
