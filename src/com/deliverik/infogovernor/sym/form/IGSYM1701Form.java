/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.sym.form;

import com.deliverik.framework.base.BaseForm;

/**
 * ����: ���̶����ѯForm
 * �������������̶����ѯForm
 * ������¼������    2010/11/26
 * �޸ļ�¼��
 */
@SuppressWarnings("serial")
public class IGSYM1701Form extends BaseForm {
	
	/** �������� */
	protected String pttype;

	/**
	 * ��������ȡ��
	 * @return ��������
	 */
	public String getPttype() {
		return pttype;
	}

	/**
	 * ���������趨
	 * @param pttype��������
	 */
	public void setPttype(String pttype) {
		this.pttype = pttype;
	}
	
}
