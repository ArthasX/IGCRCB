/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.prd.form;

import com.deliverik.framework.base.BaseForm;

/**
 * ����: �Զ�������ҳ������Form
 * ��������:  �Զ�������ҳ������Form
 * ������¼: 2012/11/13
 * �޸ļ�¼: 
 */
@SuppressWarnings("serial")
public class IGPRD0169Form extends BaseForm {
	
	/** ���� */
	protected String pjdid;

	/** ���̶���ID */
	protected String pdid;
	
	/** ҳ������*/
	protected String pjdtype;

	/** BL���� */
	protected String pjdblid;

	/** ���·�� */
	protected String pjdurl;
	
	/** �Ǽǳɹ����ر�־ 0 ���� 1 �޸�*/
	protected String mode = "0";
	/** ��¼ʱ��� */
	protected String fingerPrint;

	/**
	 * ������ȡ
	 * @return the pjdid
	 */
	public String getPjdid() {
		return pjdid;
	}

	/**
	 *
	 *	��������
	 * @param pjdid the pjdid to set
	 */
	public void setPjdid(String pjdid) {
		this.pjdid = pjdid;
	}

	/**
	 * ���̶���ID ��ȡ
	 * @return the pdid
	 */
	public String getPdid() {
		return pdid;
	}

	/**
	 *���̶���ID  ����
	 *	
	 * @param pdid the pdid to set
	 */
	public void setPdid(String pdid) {
		this.pdid = pdid;
	}
	
	/**
	 * ҳ������ ȡ��
	 * @return the pjdtype
	 */
	public String getPjdtype() {
		return pjdtype;
	}

	/**
	 *ҳ������ ����
	 *	
	 * @param pjdtype the pjdtype to set
	 */
	public void setPjdtype(String pjdtype) {
		this.pjdtype = pjdtype;
	}

	/**
	 * BL���ƻ��
	 * @return the pjdblid
	 */
	public String getPjdblid() {
		return pjdblid;
	}

	/**
	 *
	 *	BL��������
	 * @param pjdblid the pjdblid to set
	 */
	public void setPjdblid(String pjdblid) {
		this.pjdblid = pjdblid;
	}

	/**
	 * ���·�����
	 * @return the pjdurl
	 */
	public String getPjdurl() {
		return pjdurl;
	}

	/**
	 *
	 *	���·�� ����
	 * @param pjdurl the pjdurl to set
	 */
	public void setPjdurl(String pjdurl) {
		this.pjdurl = pjdurl;
	}

	/**
	 * ʱ������
	 * @return the fingerPrint
	 */
	public String getFingerPrint() {
		return fingerPrint;
	}

	/**
	 *ʱ�������
	 *	
	 * @param fingerPrint the fingerPrint to set
	 */
	public void setFingerPrint(String fingerPrint) {
		this.fingerPrint = fingerPrint;
	}

	/**
	 *  �Ǽǳɹ����ر�־ ��ȡ
	 * @return the mode
	 */
	public String getMode() {
		return mode;
	}

	/**
	 * �Ǽǳɹ����ر�־ ����
	 *	
	 * @param mode the mode to set
	 */
	public void setMode(String mode) {
		this.mode = mode;
	}

	
}
