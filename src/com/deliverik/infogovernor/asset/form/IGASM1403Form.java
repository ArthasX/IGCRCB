package com.deliverik.infogovernor.asset.form;

import com.deliverik.framework.base.BaseForm;

/**
 * �����¼������Ϣ�ɹ���¼��ȷ�ϻ���FORM
 * 
 */
public class IGASM1403Form extends BaseForm{

	private static final long serialVersionUID = 1L;
	
	/** �����¼ID */
	protected Integer eiid;

	/**
	 * �����¼IDȡ��
	 * @return �����¼ID
	 */
	public Integer getEiid() {
		return eiid;
	}

	/**
	 * �����¼ID�趨
	 *
	 * @param eiid �����¼ID
	 */
	public void setEiid(Integer eiid) {
		this.eiid = eiid;
	}

}
