package com.deliverik.infogovernor.asset.form;

import com.deliverik.framework.base.BaseForm;

/**
 * ��Ա������Ϣ�ɹ���¼��ȷ�ϻ���FORM
 * 
 */
public class IGASM1903Form extends BaseForm{

	private static final long serialVersionUID = 1L;
	
	/** ��ԱID */
	protected Integer eiid;

	/**
	 * ��ԱIDȡ��
	 * @return ��ԱID
	 */
	public Integer getEiid() {
		return eiid;
	}

	/**
	 * ��ԱID�趨
	 *
	 * @param eiid ��ԱID
	 */
	public void setEiid(Integer eiid) {
		this.eiid = eiid;
	}

}
