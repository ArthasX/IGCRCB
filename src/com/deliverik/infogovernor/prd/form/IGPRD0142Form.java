/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.prd.form;

import com.deliverik.framework.base.BaseForm;

/**
 * ����: ����״̬�ɵ��������߶���Form
 * ��������: ����״̬�ɵ��������߶���Form
 * ������¼: 2012/05/09
 * �޸ļ�¼: 
 */
@SuppressWarnings("serial")
public class IGPRD0142Form extends BaseForm {
	
	/** ���̶���ID */
	protected String pdid;
	
	/** ����״̬ID */
	protected String psdid;
	
	protected String[] ids;
	
	/** ����ʽ��0-ɾ����1-���� */
	protected String mode;

	/** �ϼ�״̬ID */
	protected String ppsdid;
	
	/**
	 * ���̶���IDȡ��
	 * 
	 * @return ���̶���ID
	 */
	public String getPdid() {
		return pdid;
	}

	/**
	 * ���̶���ID�趨
	 * 
	 * @param pdid ���̶���ID
	 */
	public void setPdid(String pdid) {
		this.pdid = pdid;
	}

	/**
	 * ����״̬IDȡ��
	 * 
	 * @return ����״̬ID
	 */
	public String getPsdid() {
		return psdid;
	}

	/**
	 * ����״̬ID�趨
	 * 
	 * @param psdid ����״̬ID
	 */
	public void setPsdid(String psdid) {
		this.psdid = psdid;
	}
	
	/**
	 * ����ʽȡ��
	 * 
	 * @return ����ʽ
	 */
	public String getMode() {
		return mode;
	}

	/**
	 * ����ʽ�趨
	 * 
	 * @param mode ����ʽ
	 */
	public void setMode(String mode) {
		this.mode = mode;
	}
	/** �鿴ģʽ 0���£��ɱ༭��1����ʷ��ֻ�鿴 */
	protected String viewhistory;

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

	public String[] getIds() {
		return ids;
	}

	public void setIds(String[] ids) {
		this.ids = ids;
	}

	/**
	 * �ϼ�״̬IDȡ��
	 * @return �ϼ�״̬ID
	 */
	public String getPpsdid() {
		return ppsdid;
	}

	/**
	 * �ϼ�״̬ID�趨
	 * @param ppsdid �ϼ�״̬ID
	 */
	public void setPpsdid(String ppsdid) {
		this.ppsdid = ppsdid;
	}
}
