/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.smr.form;

import com.deliverik.framework.base.BaseForm;

/**
 * ����:�����ڱ�����鿴Action 
 * ���������������ڱ�����鿴Action 
 * �����ˣ�����
 * ������¼�� 2013-08-08
 * �޸ļ�¼��
 */
@SuppressWarnings("serial")
public class IGSMR0703Form extends BaseForm {

	/** ��� */
	protected String year_q;
	
	/** ʵ������ */
	protected Integer instanceID;
	
	/** ѡ�еı��� */
	protected String prid;
	
	/** �߰���Ϣ */
	protected String view;
	
	/** ����ʼʱ�� */
	protected String propentime;
	
	/** �������ʱ�� */
	protected String proclosetime;
	
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

	/**
	 *����ʼʱ��ȡ��
	 */
	public String getPropentime() {
		return propentime;
	}

	/**
	 *����ʼʱ���趨
	 */
	public void setPropentime(String propentime) {
		this.propentime = propentime;
	}

	/**
	 *�������ʱ��ȡ��
	 */
	public String getProclosetime() {
		return proclosetime;
	}

	/**
	 *�������ʱ���趨
	 */
	public void setProclosetime(String proclosetime) {
		this.proclosetime = proclosetime;
	}

}
