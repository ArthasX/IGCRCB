/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.prd.form;

import com.deliverik.framework.base.BaseForm;

/**
 * ���̶��������Ϣ�ɹ���¼��ȷ�ϻ���FORM
 * 
 */
@SuppressWarnings("serial")
public class IGPRD0103Form extends BaseForm {

	/** ����ģ������ */
	protected String pttype;
	
	/**
	 * ����ģ������ȡ��
	 *
	 * @return pttype ����ģ������
	 */
	public String getPttype() {
		return pttype;
	}


	/**
	 * ����ģ�������趨
	 *
	 * @param pttype ����ģ������
	 */
	public void setPttype(String pttype) {
		this.pttype = pttype;
	}

}
