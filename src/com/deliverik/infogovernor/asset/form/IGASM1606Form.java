package com.deliverik.infogovernor.asset.form;

import com.deliverik.framework.base.BaseForm;

/**
 * ���ݹ�ϵ������FORM
 * 
 */
public class IGASM1606Form extends BaseForm {

	private static final long serialVersionUID = 1L;

	/** ����ID */
	protected String eiid;
	
	/** ɾ�����ݹ�ϵ���� */
	protected String[] deleteEirid;
	
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
	 * ɾ�����ݹ�ϵ����ȡ��
	 * @return ɾ�����ݹ�ϵ����
	 */
	public String[] getDeleteEirid() {
		return deleteEirid;
	}

	/**
	 * ɾ�����ݹ�ϵ�����趨
	 *
	 * @param deleteEirid ɾ�����ݹ�ϵ����
	 */
	public void setDeleteEirid(String[] deleteEirid) {
		this.deleteEirid = deleteEirid;
	}
}
