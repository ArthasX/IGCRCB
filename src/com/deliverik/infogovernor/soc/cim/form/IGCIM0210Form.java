/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.cim.form;

import com.deliverik.framework.base.BaseForm;

/**
 * ����: ����̨����鿴FORM
 * ��������: ����̨����鿴FORM
 * ������¼: 2011/04/29
 * �޸ļ�¼: 
 */
@SuppressWarnings("serial")
public class IGCIM0210Form extends BaseForm {
	
	/** ����ID */
	protected Integer eitid;

	/**
	 * ����IDȡ��
	 * 
	 * @return ����ID
	 */
	public Integer getEitid() {
		return eitid;
	}

	/**
	 * ����ID�趨
	 * 
	 * @param eitid ����ID
	 */
	public void setEitid(Integer eitid) {
		this.eitid = eitid;
	}

}
