/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.asset.form;

import com.deliverik.framework.base.BaseForm;

/**
 * ����: CI�������̨����鿴FORM
 * ��������: CI�������̨����鿴FORM
 * ������¼: 2011/04/29
 * �޸ļ�¼: 
 */
@SuppressWarnings("serial")
public class IGASM2203Form extends BaseForm {
	
	/** ����ID */
	protected Integer ciwtid;

	/**
	 * ����IDȡ��
	 * 
	 * @return ����ID
	 */
	public Integer getCiwtid() {
		return ciwtid;
	}

	/**
	 * ����ID�趨
	 * 
	 * @param ciwtid ����ID
	 */
	public void setCiwtid(Integer ciwtid) {
		this.ciwtid = ciwtid;
	}

}
