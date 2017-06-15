/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.asset.form;

import com.deliverik.framework.asset.model.AuditTaskInfo;
import com.deliverik.framework.base.BaseForm;

/**
 * ����: �������Form
 * ��������: �������Form
 * ������¼: 2011/05/19
 * �޸ļ�¼: 
 */
public class IGASM2105Form extends BaseForm implements AuditTaskInfo{
	
	private static final long serialVersionUID = 1L;
	
	/** �߼����� */
	protected Integer autid;

	/** ����������� */
	protected String autdesc;

	/** ���ʱ��� */
	protected String auttime;
	
	/** ״̬ */
	protected String autstatus;
	
	/** �༭ģʽ���Ǽ�/����� */
	protected String mode = "0";
	
	/** ������ʱ�� */
	protected String autupdtime;
	
	/** ���Ա�ʱ�� */
	protected String autcomptime;

	/**
	 * �߼�����ȡ��
	 *
	 * @return �߼�����
	 */
	public Integer getAutid() {
		return autid;
	}

	/**
	 * �߼������趨
	 *
	 * @param autid �߼�����
	 */
	public void setAutid(Integer autid) {
		this.autid = autid;
	}

	/**
	 * �����������ȡ��
	 *
	 * @return �����������
	 */
	public String getAutdesc() {
		return autdesc;
	}

	/**
	 * ������������趨
	 *
	 * @param autdesc �����������
	 */
	public void setAutdesc(String autdesc) {
		this.autdesc = autdesc;
	}

	/**
	 * ���ʱ���ȡ��
	 *
	 * @return ���ʱ���
	 */
	public String getAuttime() {
		return auttime;
	}

	/**
	 * ���ʱ����趨
	 *
	 * @param auttime ���ʱ���
	 */
	public void setAuttime(String auttime) {
		this.auttime = auttime;
	}
	/**
	 * �༭ģʽ���Ǽ�/�����
	 * @return �༭ģʽ���Ǽ�/�����
	 */
	public String getMode() {
		return mode;
	}

	/**
	 * �༭ģʽ���Ǽ�/�����
	 * @param mode�༭ģʽ���Ǽ�/�����
	 */
	public void setMode(String mode) {
		this.mode = mode;
	}

	/**
	 * ״̬ȡ��
	 * 
	 * @return ״̬
	 */
	public String getAutstatus() {
		return autstatus;
	}

	/**
	 * ״̬�趨
	 * 
	 * @param autstatus ״̬
	 */
	public void setAutstatus(String autstatus) {
		this.autstatus = autstatus;
	}
	
	/**
	 * ��¼ʱ���
	 */
	public String getFingerPrint() {
		return null;
	}

	/**
	 * ������ʱ��ȡ��
	 * @return ������ʱ��
	 */
	public String getAutupdtime() {
		return autupdtime;
	}

	/**
	 * ������ʱ���趨
	 * @param autupdtime ������ʱ��
	 */ 
	public void setAutupdtime(String autupdtime) {
		this.autupdtime = autupdtime;
	}

	/**
	 * ���Ա�ʱ��ȡ��
	 * @return ���Ա�ʱ��
	 */
	public String getAutcomptime() {
		return autcomptime;
	}

	/**
	 * ���Ա�ʱ���趨
	 * @param autcomptime ���Ա�ʱ��
	 */
	public void setAutcomptime(String autcomptime) {
		this.autcomptime = autcomptime;
	}
}
