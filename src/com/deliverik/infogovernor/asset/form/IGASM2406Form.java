package com.deliverik.infogovernor.asset.form;

import com.deliverik.framework.base.BaseForm;

/**
 * �ĵ���ϵ������FORM
 * 
 */
public class IGASM2406Form extends BaseForm {

	private static final long serialVersionUID = 1L;

	/** �ĵ�ID */
	protected String eiid;
	
	/** ɾ���ĵ���ϵ���� */
	protected String[] deleteEirid;
	
	/**
	 * �ĵ�IDȡ��
	 * @return �ĵ�ID
	 */
	public String getEiid() {
		return eiid;
	}

	/**
	 * �ĵ�ID�趨
	 *
	 * @param eiid �ĵ�ID
	 */
	public void setEiid(String eiid) {
		this.eiid = eiid;
	}

	/**
	 * ɾ���ĵ���ϵ����ȡ��
	 * @return ɾ���ĵ���ϵ����
	 */
	public String[] getDeleteEirid() {
		return deleteEirid;
	}

	/**
	 * ɾ���ĵ���ϵ�����趨
	 *
	 * @param deleteEirid ɾ���ĵ���ϵ����
	 */
	public void setDeleteEirid(String[] deleteEirid) {
		this.deleteEirid = deleteEirid;
	}
}
