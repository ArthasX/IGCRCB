package com.deliverik.infogovernor.asset.form;

import com.deliverik.framework.base.BaseForm;

/**
 * �ĵ�������Ϣ�ɹ���¼��ȷ�ϻ���FORM
 * 
 */
public class IGASM5003Form extends BaseForm{

	private static final long serialVersionUID = 1L;
	
	/** �ĵ�ID */
	protected Integer eiid;

	/**
	 * �ĵ�IDȡ��
	 * @return �ĵ�ID
	 */
	public Integer getEiid() {
		return eiid;
	}

	/**
	 * �ĵ�ID�趨
	 *
	 * @param eiid �ĵ�ID
	 */
	public void setEiid(Integer eiid) {
		this.eiid = eiid;
	}

}
