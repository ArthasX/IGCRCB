package com.deliverik.infogovernor.asset.form;

import com.deliverik.framework.base.BaseForm;

/**
 * ���������Ϣ�ɹ���¼��ȷ�ϻ���FORM
 * 
 */
public class IGASM1203Form extends BaseForm{

	private static final long serialVersionUID = 1L;
	
	/** ����ID */
	protected Integer eiid;

	/**
	 * ����IDȡ��
	 * @return ����ID
	 */
	public Integer getEiid() {
		return eiid;
	}

	/**
	 * ����ID�趨
	 *
	 * @param eiid ����ID
	 */
	public void setEiid(Integer eiid) {
		this.eiid = eiid;
	}

}
