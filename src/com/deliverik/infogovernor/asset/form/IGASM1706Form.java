package com.deliverik.infogovernor.asset.form;

import com.deliverik.framework.base.BaseForm;

/**
 * �����ϵ������FORM
 * 
 */
public class IGASM1706Form extends BaseForm {

	private static final long serialVersionUID = 1L;

	/** ���ID */
	protected String eiid;
	
	/** ɾ�������ϵ���� */
	protected String[] deleteEirid;
	
	/**
	 * ���IDȡ��
	 * @return ���ID
	 */
	public String getEiid() {
		return eiid;
	}

	/**
	 * ���ID�趨
	 *
	 * @param eiid ���ID
	 */
	public void setEiid(String eiid) {
		this.eiid = eiid;
	}

	/**
	 * ɾ�������ϵ����ȡ��
	 * @return ɾ�������ϵ����
	 */
	public String[] getDeleteEirid() {
		return deleteEirid;
	}

	/**
	 * ɾ�������ϵ�����趨
	 *
	 * @param deleteEirid ɾ�������ϵ����
	 */
	public void setDeleteEirid(String[] deleteEirid) {
		this.deleteEirid = deleteEirid;
	}
}
