/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.prd.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.base.BaseForm;

/**
 * ���̶���_���ɽ�ɫForm
 * 
 */
@SuppressWarnings("serial")
public class IGPRD0114Form extends BaseForm {
	
	/** ������ID */
	protected String ppdid;
	
	/** ����ID */
	protected String pdid;
	
	/** ״̬ID */
	protected String psdid;
	
	/** ģʽ��1-��� */
	protected String mode;
	
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		super.reset(mapping, request);
		this.ppdid = null;
	}

	/**
	 * ������IDȡ��
	 * @return
	 */
	public String getPpdid() {
		return ppdid;
	}

	/**
	 * ������ID�趨
	 * @param ppdid������ID
	 */
	public void setPpdid(String ppdid) {
		this.ppdid = ppdid;
	}

	/**
	 * ����IDȡ��
	 * @return ����ID
	 */
	public String getPdid() {
		return pdid;
	}

	/**
	 * ����ID�趨
	 * @param pdid����ID
	 */
	public void setPdid(String pdid) {
		this.pdid = pdid;
	}

	/**
	 * ״̬IDȡ��
	 * @return ״̬ID
	 */
	public String getPsdid() {
		return psdid;
	}

	/**
	 * ״̬ID�趨
	 * @param psdid״̬ID
	 */
	public void setPsdid(String psdid) {
		this.psdid = psdid;
	}

	/**
	 * ģʽȡ��
	 * @return ģʽ
	 */
	public String getMode() {
		return mode;
	}

	/**
	 * ģʽ�趨
	 * @param mode ģʽ
	 */
	public void setMode(String mode) {
		this.mode = mode;
	}
	
}
