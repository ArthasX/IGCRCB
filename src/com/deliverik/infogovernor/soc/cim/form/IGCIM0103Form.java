package com.deliverik.infogovernor.soc.cim.form;

import com.deliverik.framework.base.BaseForm;

/**
 * �豸������Ϣ�ɹ���¼��ȷ�ϻ���FORM
 * 
 */
public class IGCIM0103Form extends BaseForm{

	private static final long serialVersionUID = 1L;
	
	/** �豸ID */
	protected Integer eiid;

	/**
	 * �豸IDȡ��
	 * @return �豸ID
	 */
	public Integer getEiid() {
		return eiid;
	}

	/**
	 * �豸ID�趨
	 *
	 * @param eiid �豸ID
	 */
	public void setEiid(Integer eiid) {
		this.eiid = eiid;
	}

}
