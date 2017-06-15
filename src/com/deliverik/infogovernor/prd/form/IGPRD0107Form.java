/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.prd.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.base.BaseForm;

/**
 * ���̶���_������Form
 * 
 */
@SuppressWarnings("serial")
public class IGPRD0107Form extends BaseForm {
	
	/** ������ID */
	protected Integer ppdid;
	
	/** ����ID */
	protected String pdid;

	/** ����״̬ID */
	protected String psdid;
	
	/** ��ɫID */
	protected Integer roleid;	
	
	/** ��ɫ���� */
	protected String rolename;
	
	/** ��ɫ���� */
	protected String roledesc;
	
	/** ��ɫ��Ϣ */
	protected String roleinfo;
	
	/** ��������׼ */
	protected String ppapprove;
	
	/** �����߲��� */
	protected String ppdeny;
	
	/** �������ύ */
	protected String ppsubmit;
	
	/** ��������ֹ */
	protected String ppterm;
	
	/** �����߸��� */
	protected String ppupdate;
	
	/** �����߼�¼��ʱ��� */
	protected String fingerPrint;
	
	
	/**������ID����*/
	protected String[] ppdids;
	
	/**�����߽�ɫID����*/
	protected String[] roleids;

	/**�����߽�ɫ���Ƽ���*/
	protected String[] rolenames;
	
	/**�����߽�ɫ��Ϣ����*/
	protected String[] roleinfos;
	
	/**�����߽�ɫ��������*/
	protected String[] roledescs;

	/**�������û�ID����*/
	protected String[] ppuserids;
	
	/**�������û����Ƽ���*/
	protected String[] ppusernames;

	/**�����߻���ID����*/
	protected String[] pporgids;
	
	/**�����߻������Ƽ���*/
	protected String[] pporgnames;
	
	/**����ʽ��0-ɾ����1-����*/
	protected String mode;
	
	/** ������Ȩ���������� */
	protected String[] change_ppdid;
	
	/** �û�id���� */
	protected String[] userid;

	/** ������״̬ID */
	protected String ppsdid;
	
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		super.reset(mapping, request);
		this.roleids = null;
		this.rolenames = null;
		this.ppuserids = null;
		this.ppusernames = null;
		this.pporgids = null;
		this.pporgnames = null;
		
		this.ppdids = null;
		this.roleinfos = null;
		this.roledescs = null;
		this.change_ppdid = null;
		this.userid = null;
	}
	
	
	
	public String getPdid() {
		return pdid;
	}



	public void setPdid(String pdid) {
		this.pdid = pdid;
	}



	public String[] getPpdids() {
		return ppdids;
	}



	public void setPpdids(String[] ppdids) {
		this.ppdids = ppdids;
	}



	public String[] getRoleinfos() {
		return roleinfos;
	}

	public void setRoleinfos(String[] roleinfos) {
		this.roleinfos = roleinfos;
	}

	public String[] getRoledescs() {
		return roledescs;
	}

	public void setRoledescs(String[] roledescs) {
		this.roledescs = roledescs;
	}

	public String[] getRoleids() {
		return roleids;
	}

	public void setRoleids(String[] roleids) {
		this.roleids = roleids;
	}

	public String[] getRolenames() {
		return rolenames;
	}

	public void setRolenames(String[] rolenames) {
		this.rolenames = rolenames;
	}

	public String[] getPpuserids() {
		return ppuserids;
	}

	public void setPpuserids(String[] ppuserids) {
		this.ppuserids = ppuserids;
	}

	public String[] getPpusernames() {
		return ppusernames;
	}

	public void setPpusernames(String[] ppusernames) {
		this.ppusernames = ppusernames;
	}

	public String[] getPporgids() {
		return pporgids;
	}

	public void setPporgids(String[] pporgids) {
		this.pporgids = pporgids;
	}

	public String[] getPporgnames() {
		return pporgnames;
	}

	public void setPporgnames(String[] pporgnames) {
		this.pporgnames = pporgnames;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public Integer getPpdid() {
		return ppdid;
	}

	public void setPpdid(Integer ppdid) {
		this.ppdid = ppdid;
	}

	public String getPsdid() {
		return psdid;
	}

	public void setPsdid(String psdid) {
		this.psdid = psdid;
	}

	public Integer getRoleid() {
		return roleid;
	}

	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}

	public String getRolename() {
		return rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	public String getRoledesc() {
		return roledesc;
	}

	public void setRoledesc(String roledesc) {
		this.roledesc = roledesc;
	}

	public String getRoleinfo() {
		return roleinfo;
	}

	public void setRoleinfo(String roleinfo) {
		this.roleinfo = roleinfo;
	}

	public String getPpapprove() {
		return ppapprove;
	}

	public void setPpapprove(String ppapprove) {
		this.ppapprove = ppapprove;
	}

	public String getPpdeny() {
		return ppdeny;
	}

	public void setPpdeny(String ppdeny) {
		this.ppdeny = ppdeny;
	}

	public String getPpsubmit() {
		return ppsubmit;
	}

	public void setPpsubmit(String ppsubmit) {
		this.ppsubmit = ppsubmit;
	}

	public String getPpterm() {
		return ppterm;
	}

	public void setPpterm(String ppterm) {
		this.ppterm = ppterm;
	}

	public String getPpupdate() {
		return ppupdate;
	}

	public void setPpupdate(String ppupdate) {
		this.ppupdate = ppupdate;
	}

	public String getFingerPrint() {
		return fingerPrint;
	}

	public void setFingerPrint(String fingerPrint) {
		this.fingerPrint = fingerPrint;
	}
	/** �鿴ģʽ 0���£��ɱ༭��1����ʷ��ֻ�鿴 */
	protected String viewhistory;

	/**
	 * �鿴ģʽ
	 *
	 * @return �鿴ģʽ
	 */
	public String getViewhistory() {
		return viewhistory;
	}

	/**
	 * �鿴ģʽ
	 *
	 * @param viewHistory  0�����£�1��ʷ
	 */
	public void setViewhistory(String viewhistory) {
		this.viewhistory = viewhistory;
	}



	/**
	 * ������Ȩ����������ȡ��
	 * @return change_ppdid ������Ȩ����������
	 */
	public String[] getChange_ppdid() {
		return change_ppdid;
	}



	/**
	 * ������Ȩ�����������趨
	 * @param change_ppdid ������Ȩ����������
	 */
	public void setChange_ppdid(String[] change_ppdid) {
		this.change_ppdid = change_ppdid;
	}



	/**
	 * �û�id����ȡ��
	 * @return userid �û�id����
	 */
	public String[] getUserid() {
		return userid;
	}



	/**
	 * �û�id�����趨
	 * @param userid �û�id����
	 */
	public void setUserid(String[] userid) {
		this.userid = userid;
	}

	/**
	 * ������״̬IDȡ��
	 * @return ������״̬ID
	 */
	public String getPpsdid() {
		return ppsdid;
	}

	/**
	 * ������״̬ID�趨
	 * @param ppsdid ������״̬ID
	 */
	public void setPpsdid(String ppsdid) {
		this.ppsdid = ppsdid;
	}
	
}
