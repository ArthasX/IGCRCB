/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.svc.form;

import com.deliverik.framework.base.BaseForm;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ��ȹ�������ͳ��Form
 * </p>
 * 
 * @author wanglei@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGSVC0640Form extends BaseForm{

	/** ��� */
	protected String year;
	
	/** ����id */
	protected String orgid;
	
	/** �������� */
	protected String orgname;

	/**
	 * ���ȡ��
	 * @return year ���
	 */
	public String getYear() {
		return year;
	}

	/**
	 * ����趨
	 * @param year ���
	 */
	public void setYear(String year) {
		this.year = year;
	}

	/**
	 * ����idȡ��
	 * @return orgid ����id
	 */
	public String getOrgid() {
		return orgid;
	}

	/**
	 * ����id�趨
	 * @param orgid ����id
	 */
	public void setOrgid(String orgid) {
		this.orgid = orgid;
	}

	/**
	 * ��������ȡ��
	 * @return orgid ��������
	 */
	public String getOrgname() {
		return orgname;
	}

	/**
	 * ���������趨
	 * @param orgid ��������
	 */
	public void setOrgname(String orgname) {
		this.orgname = orgname;
	}
	
	
}
