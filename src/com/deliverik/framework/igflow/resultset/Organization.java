/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.igflow.resultset;

/**
 * ������Ϣ
 */
public class Organization implements OrganizationInfo {
	
	/** ʱ��� */
	private String fingerPrint;

	/** ������������ */
	private String orgname;

	/** ������������� */
	private String orgsyscoding;
	
	/**
	 * ʱ���ȡ��
	 * @return fingerPrint ʱ���
	 */
	public String getFingerPrint() {
		return fingerPrint;
	}

	/**
	 * ʱ����趨
	 * @param fingerPrint ʱ���
	 */
	public void setFingerPrint(String fingerPrint) {
		this.fingerPrint = fingerPrint;
	}

	/**
	 * ������������ȡ��
	 *
	 * @return ������������
	 */
	public String getOrgname() {
		return orgname;
	}

	/**
	 * �������������趨
	 *
	 * @param orgname ������������
	 */
	public void setOrgname(String orgname) {
		this.orgname = orgname;
	}

	/**
	 * �������������ȡ��
	 *
	 * @return �������������
	 */
	public String getOrgsyscoding() {
		return orgsyscoding;
	}
	
	/**
	 * �������������ȡ��
	 *
	 * @param orgsyscoding �������������
	 */
	public void setOrgsyscoding(String orgsyscoding) {
		this.orgsyscoding = orgsyscoding;
	}
}