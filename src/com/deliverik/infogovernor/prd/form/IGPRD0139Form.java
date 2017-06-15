/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.prd.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.base.BaseForm;

/**
 * ����: ����״̬�ɷ��ɽ�ɫ����Form
 * ��������: ����״̬�ɷ��ɽ�ɫ����Form
 * ������¼: 2012/04/11
 * �޸ļ�¼: 
 */
@SuppressWarnings("serial")
public class IGPRD0139Form extends BaseForm {
	
	/** ���̶���ID */
	protected String pdid;
	
	/** ����״̬ID */
	protected String psdid;
	
	/** ����״̬�ɷ��ɽ�ɫ����ID */
	protected String[] psrdids;
	
	/** ��ɫID */
	protected String[] roleids;
	
	/** ����ʽ��0-ɾ����1-���� */
	protected String mode;

	/** �ϼ�״̬ID */
	protected String ppsdid;
	
	/**
	 * ��ʼ��
	 * 
	 * @param mapping ActionMapping
	 * @param request HttpServletRequest
	 */
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		super.reset(mapping, request);
		this.roleids = null;
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
	 * @return ����״̬�ɷ��ɽ�ɫ����ID
	 */
	public String[] getPsrdids() {
		return psrdids;
	}

	/**
	 * ����״̬�ɷ��ɽ�ɫ����ID�趨
	 * 
	 * @param psrdids ����״̬�ɷ��ɽ�ɫ����ID
	 */
	public void setPsrdids(String[] psrdids) {
		this.psrdids = psrdids;
	}

	/**
	 * ��ɫIDȡ��
	 * 
	 * @return ��ɫID
	 */
	public String[] getRoleids() {
		return roleids;
	}

	/**
	 * ��ɫID�趨
	 * 
	 * @param roleids ��ɫID
	 */
	public void setRoleids(String[] roleids) {
		this.roleids = roleids;
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
