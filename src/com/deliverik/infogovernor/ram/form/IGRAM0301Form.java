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
public class IGRAM0301Form extends BaseForm {
	
	/**����������ѯ��ʼʱ��*/
	protected String propentime_from;
	
	/**����������ѯ����ʱ��*/
	protected String propentime_to;

	/**
	 * propentime_fromȡ��
	 */
	public String getPropentime_from() {
		return propentime_from;
	}

	/**
	 * propentime_from�趨
	 */
	public void setPropentime_from(String propentime_from) {
		this.propentime_from = propentime_from;
	}

	/**
	 * propentime_toȡ��
	 */
	public String getPropentime_to() {
		return propentime_to;
	}

	/**
	 * propentime_to�趨
	 */
	public void setPropentime_to(String propentime_to) {
		this.propentime_to = propentime_to;
	}


}
