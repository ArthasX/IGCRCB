/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.ram.form;

import com.deliverik.framework.base.BaseForm;


/**
 * ��ư汾��ѯForm
 *
 * @author tangzhen@deliverik.com
 */
@SuppressWarnings("serial")
public class IGRAM0401Form extends BaseForm {
	

	/**�������������*/
	protected String currentyear;

	/**
	 * currentyearȡ��
	 */
	public String getCurrentyear() {
		return currentyear;
	}

	/**
	 * currentyear�趨
	 */
	public void setCurrentyear(String currentyear) {
		this.currentyear = currentyear;
	}

}
