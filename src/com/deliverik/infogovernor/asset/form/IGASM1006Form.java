package com.deliverik.infogovernor.asset.form;

import com.deliverik.framework.base.BaseForm;

/**
 * �ʲ����ϵ������FORM
 * 
 */
public class IGASM1006Form extends BaseForm {

	private static final long serialVersionUID = 1L;

	/** �ʲ���ID */
	protected String eiid;
	
	/**
	 * �ʲ���IDȡ��
	 * @return �ʲ���ID
	 */
	public String getEiid() {
		return eiid;
	}

	/**
	 * �ʲ���ID�趨
	 *
	 * @param eiid �ʲ���ID
	 */
	public void setEiid(String eiid) {
		this.eiid = eiid;
	}

}
