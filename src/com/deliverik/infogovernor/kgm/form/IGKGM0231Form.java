/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.kgm.form;

import com.deliverik.framework.base.BaseForm;


/**
 * ֪ʶ��������ͳ��FORM
 * 
 */

@SuppressWarnings("serial")
public class IGKGM0231Form extends BaseForm {
	
	/**
	 * ��������xml
	 */
	private String svcxml;

	/**
	 * ��������xmlȡ��
	 * @return svcxml ��������xml
	 */
	public String getSvcxml() {
		return svcxml;
	}

	/**
	 * ��������xml�趨
	 * @param svcxml ��������xml
	 */
	public void setSvcxml(String svcxml) {
		this.svcxml = svcxml;
	}

}
