/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.sym.form;

import com.deliverik.framework.base.BaseForm;

/**
 * ����: ��ҳ�趨Form
 * ������������ҳ�趨Form
 * ������¼����ѧ־    2012/11/14
 * �޸ļ�¼��
 */
@SuppressWarnings("serial")
public class IGSYM1802Form extends BaseForm {
	
	/** ��ҳID  */
	protected String hpid;
	
	/** ��ҳ����  */
	protected String hplabel;
	
	/**  ��ҳ��ʾ����  */
	protected String hptitle;
	
	/** ��ҳURL   */
	protected String hpurl;

	/** �ɹ����ر�־ ���������޸ı�ʶ��0���� 1�޸�*/
	protected String mode = "0";
	
	/**
	 * ��ҳID���
	 * @return the hpid
	 */
	public String getHpid() {
		return hpid;
	}
	/**
	 *��ҳID�趨
	 *	
	 * @param hpid the hpid to set
	 */
	public void setHpid(String hpid) {
		this.hpid = hpid;
	}

	/**
	 * ��ҳ�������
	 * @return the hplabel
	 */
	public String getHplabel() {
		return hplabel;
	}

	/**
	 *��ҳ�����趨
	 *	
	 * @param hplabel the hplabel to set
	 */
	public void setHplabel(String hplabel) {
		this.hplabel = hplabel;
	}

	/**
	 * ��ҳ��ʾ���ƻ��
	 * @return the hptitle
	 */
	public String getHptitle() {
		return hptitle;
	}

	/**
	 *��ҳ��ʾ�����趨
	 *	
	 * @param hptitle the hptitle to set
	 */
	public void setHptitle(String hptitle) {
		this.hptitle = hptitle;
	}

	/**
	 * ��ҳURL ���
	 * @return the hpurl
	 */
	public String getHpurl() {
		return hpurl;
	}

	/**
	 *��ҳURL �趨
	 *	
	 * @param hpurl the hpurl to set
	 */
	public void setHpurl(String hpurl) {
		this.hpurl = hpurl;
	}
	/**
	 * �ɹ����ر�־ ���������޸ı�ʶ ���
	 * @return the mode
	 */
	public String getMode() {
		return mode;
	}
	/**
	 *�ɹ����ر�־ ���������޸ı�ʶ �趨
	 *	
	 * @param mode the mode to set
	 */
	public void setMode(String mode) {
		this.mode = mode;
	}
	
	
	
}
