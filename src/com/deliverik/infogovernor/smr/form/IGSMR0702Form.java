/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.smr.form;

import com.deliverik.framework.base.BaseForm;

/**
 * ����:�걨��鿴Action 
 * �����������걨��鿴Action 
 * �����ˣ�����͢
 * ������¼�� 2013-07-29
 * �޸ļ�¼��
 */
@SuppressWarnings("serial")
public class IGSMR0702Form extends BaseForm {

	/** ��� */
	protected String year_q;
	
	/** ʵ������ */
	protected Integer instanceID;
	
	/** ѡ�еı��� */
	protected String prid;
	
	/** �߰���Ϣ */
	protected String view;
	
	/**
	 * ���ȡ��
	 * @return ���
	 */
	public String getYear_q() {
		return year_q;
	}

	/**
	 * ����趨
	 * @param year ���
	 */
	public void setYear_q(String year_q) {
		this.year_q = year_q;
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


	
	
	
}
