/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.kgm.form;

import com.deliverik.framework.base.BaseForm;

/**
 * ����: ֪ʶ��������Form
 * ����������֪ʶ��������Form
 * ������¼����ʢ�	2011-3-28
 * �޸ļ�¼��
 */
@SuppressWarnings("serial")
public class IGKGM0228Form extends BaseForm {
	
	/** ID���� */
	protected String[] knids;

	/**
	 * ID����ȡ��
	 * @return ID����
	 */
	public String[] getKnids() {
		return knids;
	}

	/**
	 * ID�����趨
	 * @param knids ID����
	 */
	public void setKnids(String[] knids) {
		this.knids = knids;
	}

}
