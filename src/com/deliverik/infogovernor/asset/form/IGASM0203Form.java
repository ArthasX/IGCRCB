package com.deliverik.infogovernor.asset.form;

import com.deliverik.framework.base.BaseForm;

/**
 * �ʲ��������Ϣ�ɹ���¼��ȷ�ϻ���FORM
 * 
 */
public class IGASM0203Form extends BaseForm{

	private static final long serialVersionUID = 1L;
	
	/** �ʲ���ID */
	protected Integer eiid;

	/**
	 * �ʲ���IDȡ��
	 * @return �ʲ���ID
	 */
	public Integer getEiid() {
		return eiid;
	}

	/**
	 * �ʲ���ID�趨
	 *
	 * @param eiid �ʲ���ID
	 */
	public void setEiid(Integer eiid) {
		this.eiid = eiid;
	}

}
