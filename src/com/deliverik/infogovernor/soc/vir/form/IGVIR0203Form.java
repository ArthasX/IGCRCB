/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.soc.vir.form;

import com.deliverik.framework.base.BaseForm;

/**
 * ������Ȼ���FORM
 * 
 */
public class IGVIR0203Form extends BaseForm{

	private static final long serialVersionUID = 1L;
	
    /** �������� */
    protected String prid;

	/**
	 * ��������ȡ��
	 * @return prid ��������
	 */
	public String getPrid() {
		return prid;
	}

	/**
	 * ���������趨
	 * @param prid ��������
	 */
	public void setPrid(String prid) {
		this.prid = prid;
	}
    
}
