package com.deliverik.infogovernor.asset.form;

import com.deliverik.framework.base.BaseForm;

/**
 * ϵͳ������Ϣ�ɹ���¼��ȷ�ϻ���FORM
 * 
 */
public class IGASM1803Form extends BaseForm{

	private static final long serialVersionUID = 1L;
	
	/** ϵͳID */
	protected Integer eiid;

	/**
	 * ϵͳIDȡ��
	 * @return ϵͳID
	 */
	public Integer getEiid() {
		return eiid;
	}

	/**
	 * ϵͳID�趨
	 *
	 * @param eiid ϵͳID
	 */
	public void setEiid(Integer eiid) {
		this.eiid = eiid;
	}

}
