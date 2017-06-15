/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.form;

import com.csebank.lom.model.condition.DealOrgVWSearchCond;
import com.deliverik.framework.base.BaseForm;

/**
 * ģ�飺���ڹ���-�Ӵ�����
 * ˵��������ͲͲ��Ź���ͳ��Form
 * ���ߣ�������
 */
public class IGLOM0120Form extends BaseForm implements DealOrgVWSearchCond {
	

	private static final long serialVersionUID = 1L;

	/** ��ѯ��� */
	protected String year;
	
	/** ��ѯ��ʼ�� */
	protected String month_from;
	
	/** ��ѯ������ */
	protected String month_to;
	
	/** ���Ų���� */
	protected String rapporgid_org;
	
	/** ���Ų���� */
	protected String rapporgid;
	
	/** �������� */
	protected String deptName;

	
	/**
	 * ��ѯ���ȡ��
	 * @return ��ѯ���
	 */
	public String getYear() {
		return year;
	}

	/**
	 * ��ѯ����趨
	 * @param year ��ѯ���
	 */
	public void setYear(String year) {
		this.year = year;
	}

	/**
	 * ��ѯ��ʼ��ȡ��
	 * @return ��ѯ��ʼ��
	 */
	public String getMonth_from() {
		return month_from;
	}

	/**
	 * ��ѯ��ʼ���趨
	 * @param month_from ��ѯ��ʼ��
	 */
	public void setMonth_from(String month_from) {
		this.month_from = month_from;
	}

	/**
	 * ��ѯ������ȡ��
	 * @return ��ѯ������
	 */
	public String getMonth_to() {
		return month_to;
	}

	/**
	 * ��ѯ�������趨
	 * @param month_to ��ѯ������
	 */
	public void setMonth_to(String month_to) {
		this.month_to = month_to;
	}

	/**
	 * ���Ų����ȡ��
	 * @return ���Ų����
	 */
	public String getRapporgid() {
		return rapporgid;
	}

	/**
	 * ���Ų�����趨
	 * @param rapporgid ���Ų����
	 */
	public void setRapporgid(String rapporgid) {
		this.rapporgid = rapporgid;
	}

	
	/**
	 * ���Ų����ȡ��
	 * @return ���Ų����
	 */
	public String getRapporgid_org() {
		return rapporgid_org;
	}

	/**
	 * ���Ų�����趨
	 * @param rapporgid ���Ų����
	 */
	public void setRapporgid_org(String rapporgid_org) {
		this.rapporgid_org = rapporgid_org;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

}
