package com.deliverik.infogovernor.asset.form;

import com.deliverik.framework.base.BaseForm;

/**
 * ����ƽ��ͼ����FORM
 * 
 */
public class IGASM1114Form extends BaseForm {

	private static final long serialVersionUID = 1L;

	/** ����ID */
	protected String eiid;
	
	protected String jitype;
	
	/** �豸ID */
	protected String device_eiid;
	
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
	 * �豸IDȡ��
	 * @return �豸ID
	 */
	public String getDevice_eiid() {
		return device_eiid;
	}

	/**
	 * �豸ID�趨
	 *
	 * @param device_eiid �豸ID
	 */
	public void setDevice_eiid(String device_eiid) {
		this.device_eiid = device_eiid;
	}

	public String getJitype() {
		return jitype;
	}

	public void setJitype(String jitype) {
		this.jitype = jitype;
	}
}
