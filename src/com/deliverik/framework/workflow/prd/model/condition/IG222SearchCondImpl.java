/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prd.model.condition;


/**
 * ���̲����߼�������ʵ��
 *
 */
public class IG222SearchCondImpl implements IG222SearchCond{
	
	/** 
	 * ���̲�����ID
	 */
	protected String ppdid;
	
	/**
	 * ����״̬ID
	 */
	protected String psdid;
	
	/**
	 * ���̲����߽�ɫID
	 */
	protected Integer roleid;

	/**
	 * ���̲�������׼
	 */
	protected String ppapprove;
	
	/**
	 * ���̲����߲���
	 */
	protected String ppdeny;
	
	/**
	 * ���̲������ύ
	 */
	protected String ppsubmit;
	
	/**
	 * ���̲�������ֹ
	 */
	protected String ppterm;
	
	/**
	 * ���̲����߸���
	 */
	protected String ppupdate;
	
	protected String pdid;
	
	protected Integer prid;
	
	/** 
	 * ���̲�����ID
	 */
	protected String ppdid_like;
	
	/** �Ƿ񰴻��� */
	protected String isOrg;
	
	/**
	 * ���̲�����IDȡ��
	 * @return ���̲�����ID
	 */
	public String getPpdid() {
		return ppdid;
	}

	/**
	 * ���̲�����ID�趨
	 * @param ppdid ���̲�����ID
	 */
	public void setPpdid(String ppdid) {
		this.ppdid = ppdid;
	}

	/**
	 * ����״̬IDȡ��
	 * @return ����״̬ID
	 */
	public String getPsdid() {
		return psdid;
	}

	/**
	 * ����״̬ID�趨
	 * @param psdid ����״̬ID
	 */
	public void setPsdid(String psdid) {
		this.psdid = psdid;
	}

	/**
	 * ���̲����߽�ɫIDȡ��
	 * @return ���̲����߽�ɫID
	 */
	public Integer getRoleid() {
		return roleid;
	}

	/**
	 * ���̲����߽�ɫID�趨
	 * @param roleid ���̲����߽�ɫID
	 */
	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}

	/**
	 * ���̲�������׼ȡ��
	 * @return ���̲�������׼
	 */
	public String getPpapprove() {
		return ppapprove;
	}

	/**
	 * ���̲�������׼�趨
	 * @param ppapprove ���̲�������׼
	 */
	public void setPpapprove(String ppapprove) {
		this.ppapprove = ppapprove;
	}

	/**
	 * ���̲����߲���ȡ��
	 * @return ���̲����߲���
	 */
	public String getPpdeny() {
		return ppdeny;
	}

	/**
	 * ���̲����߲����趨
	 * @param ppdeny ���̲����߲���
	 */
	public void setPpdeny(String ppdeny) {
		this.ppdeny = ppdeny;
	}

	/**
	 * ���̲������ύȡ��
	 * @return ���̲������ύ
	 */
	public String getPpsubmit() {
		return ppsubmit;
	}

	/**
	 * ���̲������ύ�趨
	 * @param ppsubmit ���̲������ύ
	 */
	public void setPpsubmit(String ppsubmit) {
		this.ppsubmit = ppsubmit;
	}

	/**
	 * ���̲�������ֹȡ��
	 * @return ���̲�������ֹ
	 */
	public String getPpterm() {
		return ppterm;
	}

	/**
	 * ���̲�������ֹ�趨
	 * @param ppterm ���̲�������ֹ
	 */
	public void setPpterm(String ppterm) {
		this.ppterm = ppterm;
	}

	/**
	 * ���̲����߸���ȡ��
	 * @return ���̲����߸���
	 */
	public String getPpupdate() {
		return ppupdate;
	}

	/**
	 * ���̲����߸����趨
	 * @param ppupdate ���̲����߸���
	 */
	public void setPpupdate(String ppupdate) {
		this.ppupdate = ppupdate;
	}

	public String getPdid() {
		return pdid;
	}

	public void setPdid(String pdid) {
		this.pdid = pdid;
	}

	public Integer getPrid() {
		return prid;
	}

	public void setPrid(Integer prid) {
		this.prid = prid;
	}

	/**
	 * ���̲�����IDȡ��
	 * 
	 * @return ���̲�����ID
	 */
	public String getPpdid_like() {
		return ppdid_like;
	}

	/**
	 * ���̲�����ID�趨
	 * 
	 * @param ppdid_like ���̲�����ID
	 */
	public void setPpdid_like(String ppdid_like) {
		this.ppdid_like = ppdid_like;
	}

	/**
	 * �Ƿ񰴻���ȡ�� 
	 * @return �Ƿ񰴻���
	 */
	public String getIsOrg() {
		return isOrg;
	}

	/**
	 * �Ƿ񰴻����趨
	 * @param isOrg �Ƿ񰴻���
	 */
	public void setIsOrg(String isOrg) {
		this.isOrg = isOrg;
	}
}
