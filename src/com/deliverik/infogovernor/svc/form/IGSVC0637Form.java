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
 * Description: ���ŷ���top5ͳ��Form
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGSVC0637Form extends BaseForm{

	/** ��� */
	protected String year;
	
	/** �·� */
	protected String month;
	
	/** ���� */
	protected String type;

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
	 * �·�ȡ��
	 * @return month �·�
	 */
	public String getMonth() {
		return month;
	}

	/**
	 * �·��趨
	 * @param month �·�
	 */
	public void setMonth(String month) {
		this.month = month;
	}

	/**
	 * ����ȡ��
	 * @return type ����
	 */
	public String getType() {
		return type;
	}

	/**
	 * �����趨
	 * @param type ����
	 */
	public void setType(String type) {
		this.type = type;
	}
}
