/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.smr.form;

import com.deliverik.framework.base.BaseForm;

/**
 * ����:�����߰� 
 * ���������������߰�
 * �����ˣ�����͢
 * ������¼�� 2013-08-08
 * �޸ļ�¼��
 */
@SuppressWarnings("serial")
public class IGSMR0602Form extends BaseForm {
	
	/** ��� */
	protected String year;

	/** ���� */
	protected String quarter;
	
	/** ʵ������ */
	protected Integer instanceID;
	
	/** ѡ�еı��� */
	protected String prid;
	
	/** �߰���Ϣ */
	protected String view;
	
	/**
	 *  ����ȡ��
	 *
	 * @return  ����
	 */	
	public String getQuarter() {
		return quarter;
	}
	/**
	 *  �����趨
	 *
	 * @param quarter  ����
	 */
	public void setQuarter(String quarter) {
		this.quarter = quarter;
	}
	/**
	 * ����IDȡ��
	 *
	 * @return ����ID
	 */
	public Integer getInstanceID() {
		return instanceID;
	}

	/**
	 * ����ID�趨
	 *
	 * @param instanceID ����ID
	 */
	public void setInstanceID(Integer instanceID) {
		this.instanceID = instanceID;
	}
	/**
	 * ѡ�еı���ȡ��
	 *
	 * @return ѡ�еı���
	 */
	public String getPrid() {
		return prid;
	}
	/**
	 * ѡ�еı����趨
	 *
	 * @param prid ѡ�еı���
	 */
	public void setPrid(String prid) {
		this.prid = prid;
	}
	/**
	 * �߰���Ϣȡ��
	 *
	 * @return �߰���Ϣ
	 */
	public String getView() {
		return view;
	}
	/**
	 * �߰���Ϣ�趨
	 *
	 * @param view �߰���Ϣ
	 */
	public void setView(String view) {
		this.view = view;
	}
	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}
	
}
