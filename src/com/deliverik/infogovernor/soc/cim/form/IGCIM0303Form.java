/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.cim.form;

import com.deliverik.framework.base.BaseForm;

/**
 * ����: ��ƿ���̨����鿴FORM
 * ��������: ��ƿ���̨����鿴FORM
 * ������¼: 2011/04/29
 * �޸ļ�¼: 
 */
@SuppressWarnings("serial")
public class IGCIM0303Form extends BaseForm {
	
	/** ����ID */
	protected Integer auwtid;

	/**
	 * ����IDȡ��
	 * 
	 * @return ����ID
	 */
	public Integer getAuwtid() {
		return auwtid;
	}

	/**
	 * ����ID�趨
	 * 
	 * @param auwtid ����ID
	 */
	public void setAuwtid(Integer auwtid) {
		this.auwtid = auwtid;
	}

}
