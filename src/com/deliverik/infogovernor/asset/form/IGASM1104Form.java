package com.deliverik.infogovernor.asset.form;

import com.deliverik.framework.base.BaseForm;

/**
 * ����ƽ��ͼ����FORM
 * 
 */
public class IGASM1104Form extends BaseForm {

	private static final long serialVersionUID = 1L;

	/** ����ID */
	protected String eiid;
	
	/** ����ID */
	protected String container_eiid;
	
	/**
	 * ����IDȡ��
	 * @return ����ID
	 */
	public String getEiid() {
		return eiid;
	}

	/**
	 * ����ID�趨
	 *
	 * @param eiid ����ID
	 */
	public void setEiid(String eiid) {
		this.eiid = eiid;
	}

	/**
	 * ����IDȡ��
	 * @return ����ID
	 */
	public String getContainer_eiid() {
		return container_eiid;
	}

	/**
	 * ����ID�趨
	 *
	 * @param container_eiid ����ID
	 */
	public void setContainer_eiid(String container_eiid) {
		this.container_eiid = container_eiid;
	}
}
