package com.deliverik.infogovernor.asset.form;

import com.deliverik.framework.base.BaseForm;

/**
 * ���յ������Ϣ�ɹ���¼��ȷ�ϻ���FORM
 * 
 */
public class IGASM2703Form extends BaseForm{

	private static final long serialVersionUID = 1L;
	
	/** ���յ�ID */
	protected Integer eiid;

	/**
	 * ���յ�IDȡ��
	 * @return ���յ�ID
	 */
	public Integer getEiid() {
		return eiid;
	}

	/**
	 * ���յ�ID�趨
	 *
	 * @param eiid ���յ�ID
	 */
	public void setEiid(Integer eiid) {
		this.eiid = eiid;
	}

}
