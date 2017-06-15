/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.asset.form;

import com.deliverik.framework.asset.model.CITaskInfo;
import com.deliverik.framework.base.BaseForm;

/**
 * ����: CI�������Form
 * ��������: CI�������Form
 * ������¼: 2011/05/19
 * �޸ļ�¼: 
 */
public class IGASM2205Form extends BaseForm implements CITaskInfo{
	
	private static final long serialVersionUID = 1L;
	
	/** �߼����� */
	protected Integer citid;

	/** CI����������� */
	protected String citdesc;

	/** CI���ʱ��� */
	protected String cittime;
	
	/** ״̬ */
	protected String citstatus;
	
	/** �༭ģʽ���Ǽ�/����� */
	protected String mode = "0";
	
	/** ������ʱ�� */
	protected String citupdtime;
	
	/** ���Ա�ʱ�� */
	protected String citcomptime;

	/**
	 * �߼�����ȡ��
	 *
	 * @return �߼�����
	 */
	public Integer getCitid() {
		return citid;
	}

	/**
	 * �߼������趨
	 *
	 * @param citid �߼�����
	 */
	public void setCitid(Integer citid) {
		this.citid = citid;
	}

	/**
	 * CI�����������ȡ��
	 *
	 * @return CI�����������
	 */
	public String getCitdesc() {
		return citdesc;
	}

	/**
	 * CI������������趨
	 *
	 * @param citdesc CI�����������
	 */
	public void setCitdesc(String citdesc) {
		this.citdesc = citdesc;
	}

	/**
	 * CI���ʱ���ȡ��
	 *
	 * @return CI���ʱ���
	 */
	public String getCittime() {
		return cittime;
	}

	/**
	 * CI���ʱ����趨
	 *
	 * @param cittime CI���ʱ���
	 */
	public void setCittime(String cittime) {
		this.cittime = cittime;
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
	public String getCitstatus() {
		return citstatus;
	}

	/**
	 * ״̬�趨
	 * 
	 * @param citstatus ״̬
	 */
	public void setCitstatus(String citstatus) {
		this.citstatus = citstatus;
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
	public String getCitupdtime() {
		return citupdtime;
	}

	/**
	 * ������ʱ���趨
	 * @param citupdtime ������ʱ��
	 */ 
	public void setCitupdtime(String citupdtime) {
		this.citupdtime = citupdtime;
	}

	/**
	 * ���Ա�ʱ��ȡ��
	 * @return ���Ա�ʱ��
	 */
	public String getCitcomptime() {
		return citcomptime;
	}

	/**
	 * ���Ա�ʱ���趨
	 * @param citcomptime ���Ա�ʱ��
	 */
	public void setCitcomptime(String citcomptime) {
		this.citcomptime = citcomptime;
	}

}
