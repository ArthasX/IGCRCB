/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.prd.form;

import com.deliverik.framework.base.BaseForm;

/**
 * ����: �Զ������̱���ѯ��������Form
 * ��������: �Զ������̱���ѯ��������Form
 * ������¼: 2013/03/15
 * �޸ļ�¼: 
 */
@SuppressWarnings("serial")
public class IGPRD0145Form extends BaseForm{
	
	/** ������������ */
	protected String pdid;
	
	/** Ҫɾ������Ϣ���� */
	protected String[] pidid_del;
	
	/** Ҫ��ӵ���Ϣ���� */
	protected String[] pidid_add;
	
	/**����ʽ��0-ɾ����1-����*/
	protected String mode;
	
	/** ���̲�ѯ��ʾ�� */
	protected String[] processQueryShowColumns;
	
	/** ���̲�ѯ���� */
	protected String[] processQuerys;
	
	/** �鿴ģʽ 0���£��ɱ༭��1����ʷ��ֻ�鿴 */
	protected String viewhistory;

	
	/**
	 * @return the processQueryShowColumns
	 */
	public String[] getProcessQueryShowColumns() {
		return processQueryShowColumns;
	}

	/**
	 * @param processQueryShowColumns the processQueryShowColumns to set
	 */
	public void setProcessQueryShowColumns(String[] processQueryShowColumns) {
		this.processQueryShowColumns = processQueryShowColumns;
	}

	/**
	 * @return the processQuerys
	 */
	public String[] getProcessQuerys() {
		return processQuerys;
	}

	/**
	 * @param processQuerys the processQuerys to set
	 */
	public void setProcessQuerys(String[] processQuerys) {
		this.processQuerys = processQuerys;
	}

	/**
	 * ������������ȡ��
	 * @return ������������
	 */
	public String getPdid() {
		return pdid;
	}

	/**
	 * �������������趨
	 * @param pdid ������������
	 */
	public void setPdid(String pdid) {
		this.pdid = pdid;
	}

	/**
	 * Ҫɾ������Ϣ����ȡ��
	 * @return Ҫɾ������Ϣ����
	 */
	public String[] getPidid_del() {
		return pidid_del;
	}

	/**
	 * Ҫ��ӵ���Ϣ����ȡ��
	 * @return Ҫ��ӵ���Ϣ����
	 */
	public String[] getPidid_add() {
		return pidid_add;
	}

	/**
	 * Ҫɾ������Ϣ�����趨
	 * @param pidid_del Ҫɾ������Ϣ����
	 */
	public void setPidid_del(String[] pidid_del) {
		this.pidid_del = pidid_del;
	}

	/**
	 * Ҫ��ӵ���Ϣ�����趨
	 * @param pidid_add Ҫ��ӵ���Ϣ����
	 */
	public void setPidid_add(String[] pidid_add) {
		this.pidid_add = pidid_add;
	}

	/**
	 * ����ʽȡ��
	 * @return ����ʽ
	 */
	public String getMode() {
		return mode;
	}

	/**
	 * ����ʽ�趨
	 * @param mode ����ʽ
	 */
	public void setMode(String mode) {
		this.mode = mode;
	}

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
}
