/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.prd.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.base.BaseForm;

/**
 * ����: ����״̬�ɷ��ɻ�������Form
 * ��������: ����״̬�ɷ��ɻ�������Form
 * ������¼: 2012/04/11
 * �޸ļ�¼: 2013/02/25		130225	���̻�������޸�(״̬�ɷ��ɻ�������)
 */
@SuppressWarnings("serial")
public class IGPRD0143Form extends BaseForm {
	
	/** ���̶���ID */
	protected String pdid;
	
	/** ����״̬ID */
	protected String psdid;
	
	/** ����״̬�ɷ��ɽ�ɫ����ID */
	protected String[] psodids;
	
	/** ��ɫID */
	protected String[] orgsyscodings;
	
	/** ����ʽ��0-ɾ����1-���� */
	protected String mode;
	
	/**
	 * ��ʼ��
	 * 
	 * @param mapping ActionMapping
	 * @param request HttpServletRequest
	 */
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		super.reset(mapping, request);
		this.orgsyscodings = null;
	}
	
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
	 * ����״̬�ɷ��ɽ�ɫ����IDȡ��
	 *
	 * @return psodids ����״̬�ɷ��ɽ�ɫ����ID
	 */
	public String[] getPsodids() {
		return psodids;
	}

	/**
	 * ����״̬�ɷ��ɽ�ɫ����ID�趨
	 *
	 * @param psodids ����״̬�ɷ��ɽ�ɫ����ID
	 */
	public void setPsodids(String[] psodids) {
		this.psodids = psodids;
	}

	/**
	 * ��ɫIDȡ��
	 *
	 * @return orgsyscodings ��ɫID
	 */
	public String[] getOrgsyscodings() {
		return orgsyscodings;
	}

	/**
	 * ��ɫID�趨
	 *
	 * @param orgsyscodings ��ɫID
	 */
	public void setOrgsyscodings(String[] orgsyscodings) {
		this.orgsyscodings = orgsyscodings;
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

	/** �ϼ�״̬ID */
	protected String ppsdid;

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
