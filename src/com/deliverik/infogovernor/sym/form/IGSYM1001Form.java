package com.deliverik.infogovernor.sym.form;

import com.deliverik.framework.base.BaseForm;

/**
 * ���ݷ����б���FORM
 *  
 */
public class IGSYM1001Form extends BaseForm{

	private static final long serialVersionUID = 1L;

	/** ���ݷ���CD */
	protected String ccid ;
	
	/**
	 * ���ݷ���CDȡ��
	 * @return ���ݷ���CD
	 */
	public String getCcid() {
		return ccid;
	}

	/**
	 * ���ݷ���CD�趨
	 *
	 * @param ccid ���ݷ���CD
	 */
	public void setCcid(String ccid) {
		this.ccid = ccid;
	}

}
