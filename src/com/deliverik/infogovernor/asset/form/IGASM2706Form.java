package com.deliverik.infogovernor.asset.form;

import com.deliverik.framework.base.BaseForm;

/**
 * ���յ��ϵ������FORM
 * 
 */
public class IGASM2706Form extends BaseForm {

	private static final long serialVersionUID = 1L;

	/** ���յ�ID */
	protected String eiid;
	
	/** ɾ�����յ��ϵ���� */
	protected String[] deleteEirid;
	
	/**
	 * ���յ�IDȡ��
	 * @return ���յ�ID
	 */
	public String getEiid() {
		return eiid;
	}

	/**
	 * ���յ�ID�趨
	 *
	 * @param eiid ���յ�ID
	 */
	public void setEiid(String eiid) {
		this.eiid = eiid;
	}

	/**
	 * ɾ�����յ��ϵ����ȡ��
	 * @return ɾ�����յ��ϵ����
	 */
	public String[] getDeleteEirid() {
		return deleteEirid;
	}

	/**
	 * ɾ�����յ��ϵ�����趨
	 *
	 * @param deleteEirid ɾ�����յ��ϵ����
	 */
	public void setDeleteEirid(String[] deleteEirid) {
		this.deleteEirid = deleteEirid;
	}
}
