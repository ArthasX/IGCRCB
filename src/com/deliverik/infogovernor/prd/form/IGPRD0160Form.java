/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.prd.form;

import com.deliverik.framework.base.BaseForm;

/**
 * ����: ���̲���֪ͨ�˲�ѯForm
 * ��������: ���̲���֪ͨ�˲�ѯForm
 * ������¼: 2012/04/11
 * �޸ļ�¼: 
 */
@SuppressWarnings("serial")
public class IGPRD0160Form extends BaseForm {
	
	/** ������ */
	protected String rowIndex;
	
	/**
	 * ������ȡ��
	 * 
	 * @return ������
	 */
	public String getRowIndex() {
		return rowIndex;
	}

	/**
	 * �������趨
	 * 
	 * @param rowIndex ������
	 */
	public void setRowIndex(String rowIndex) {
		this.rowIndex = rowIndex;
	}

}
