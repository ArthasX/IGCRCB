/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.smr.form;

import com.deliverik.framework.base.BaseForm;

/**
 * ���������ѯForm
 *
 */
@SuppressWarnings("serial")
public class IGSMR0202Form extends BaseForm {
	
	/** ���̱��������� */
	protected String pidid;
	
	/** �������� */
	protected Integer prid;
	
	/** ���ʽ���к� */
	protected String rownumber;

	/**
	 * ���̱���������ȡ��
	 *
	 * @return pidid ���̱���������
	 */
	public String getPidid() {
		return pidid;
	}

	/**
	 * ���̱����������趨
	 *
	 * @param pidid ���̱���������
	 */
	public void setPidid(String pidid) {
		this.pidid = pidid;
	}

	/**
	 * ��������ȡ��
	 *
	 * @return prid ��������
	 */
	public Integer getPrid() {
		return prid;
	}

	/**
	 * ���������趨
	 *
	 * @param prid ��������
	 */
	public void setPrid(Integer prid) {
		this.prid = prid;
	}

	/**
	 * ���ʽ���к�ȡ��
	 * @return rownumber ���ʽ���к�
	 */
	public String getRownumber() {
		return rownumber;
	}

	/**
	 * ���ʽ���к��趨
	 * @param rownumber ���ʽ���к�
	 */
	public void setRownumber(String rownumber) {
		this.rownumber = rownumber;
	}
}