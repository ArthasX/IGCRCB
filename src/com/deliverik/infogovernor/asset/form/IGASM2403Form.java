package com.deliverik.infogovernor.asset.form;

import com.deliverik.framework.base.BaseForm;

/**
 * ��Ʊ������Ϣ�ɹ���¼��ȷ�ϻ���FORM
 * 
 */
public class IGASM2403Form extends BaseForm{

	private static final long serialVersionUID = 1L;
	
	/** ��ƱID */
	protected Integer eiid;

	/**
	 * ��ƱIDȡ��
	 * @return ��ƱID
	 */
	public Integer getEiid() {
		return eiid;
	}

	/**
	 * ��ƱID�趨
	 *
	 * @param eiid ��ƱID
	 */
	public void setEiid(Integer eiid) {
		this.eiid = eiid;
	}

}
