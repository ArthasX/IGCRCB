/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.soc.vir.form;

import com.deliverik.framework.base.BaseForm;

/**
 * 
 * 
 */

@SuppressWarnings("serial")
public class IGVIR1103Form extends BaseForm{
	
	/**��Ŀ��  */
	protected String pname_like;

	/**
	 * ��Ŀ��ȡ��
	 * @return pname_like ��Ŀ��
	 */
	public String getPname_like() {
		return pname_like;
	}

	/**
	 * ��Ŀ���趨
	 * @param pname_like ��Ŀ��
	 */
	public void setPname_like(String pname_like) {
		this.pname_like = pname_like;
	}
}
