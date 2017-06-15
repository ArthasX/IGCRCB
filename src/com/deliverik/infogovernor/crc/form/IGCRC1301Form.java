/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.crc.form;

import com.deliverik.framework.base.BaseForm;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: �ĵ���ѯForm
 * </p>
 * 
 * @author shenbing@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGCRC1301Form extends BaseForm{
	/** �ĵ���� */
	protected String eiNumber;
	
	/** �ĵ����� */
	protected String eiName;
	
	/** �ĵ����� */
	protected String eiType;
	
	/** �ĵ����� */
	protected String eiSort;
	
	/** �ĵ��ܼ� */
	protected String eiDense;
	
	/** ���� */
	protected String department;
	
	/** ������ */
	protected String managermentPerson;
	
	/** ���� */
	protected String content;

	/** ������ */
	protected String userName;
	
	/** �Ƿ������ */
	protected String isDownload;
	
	/**
	 * ������ȡ��
	 * @return userName ������
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * �������趨
	 * @param userName ������
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * �ĵ����ȡ��
	 * @return eiNumber �ĵ����
	 */
	public String getEiNumber() {
		return eiNumber;
	}

	/**
	 * �ĵ�����趨
	 * @param eiNumber �ĵ����
	 */
	public void setEiNumber(String eiNumber) {
		this.eiNumber = eiNumber;
	}

	/**
	 * �ĵ�����ȡ��
	 * @return eiName �ĵ�����
	 */
	public String getEiName() {
		return eiName;
	}

	/**
	 * �ĵ������趨
	 * @param eiName �ĵ�����
	 */
	public void setEiName(String eiName) {
		this.eiName = eiName;
	}

	/**
	 * �ĵ�����ȡ��
	 * @return eiType �ĵ�����
	 */
	public String getEiType() {
		return eiType;
	}

	/**
	 * �ĵ������趨
	 * @param eiType �ĵ�����
	 */
	public void setEiType(String eiType) {
		this.eiType = eiType;
	}

	/**
	 * �ĵ�����ȡ��
	 * @return eiSort �ĵ�����
	 */
	public String getEiSort() {
		return eiSort;
	}

	/**
	 * �ĵ������趨
	 * @param eiSort �ĵ�����
	 */
	public void setEiSort(String eiSort) {
		this.eiSort = eiSort;
	}

	/**
	 * �ĵ��ܼ�ȡ��
	 * @return eiDense �ĵ��ܼ�
	 */
	public String getEiDense() {
		return eiDense;
	}

	/**
	 * �ĵ��ܼ��趨
	 * @param eiDense �ĵ��ܼ�
	 */
	public void setEiDense(String eiDense) {
		this.eiDense = eiDense;
	}

	/**
	 * ����ȡ��
	 * @return department ����
	 */
	public String getDepartment() {
		return department;
	}

	/**
	 * �����趨
	 * @param department ����
	 */
	public void setDepartment(String department) {
		this.department = department;
	}

	/**
	 * ������ȡ��
	 * @return managermentPerson ������
	 */
	public String getManagermentPerson() {
		return managermentPerson;
	}

	/**
	 * �������趨
	 * @param managermentPerson ������
	 */
	public void setManagermentPerson(String managermentPerson) {
		this.managermentPerson = managermentPerson;
	}

	/**
	 * ����ȡ��
	 * @return content ����
	 */
	public String getContent() {
		return content;
	}

	/**
	 * �����趨
	 * @param content ����
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * �Ƿ������ȡ��
	 * @return isDownload �Ƿ������
	 */
	public String getIsDownload() {
		return isDownload;
	}

	/**
	 * �Ƿ�������趨
	 * @param isDownload �Ƿ������
	 */
	public void setIsDownload(String isDownload) {
		this.isDownload = isDownload;
	}
	
	
}
