package com.deliverik.infogovernor.soc.cim.form;

import com.deliverik.framework.base.BaseForm;

/**
 * Ӧ�ù�ϵ������FORM
 * 
 */
public class IGCIM2005Form extends BaseForm {

	private static final long serialVersionUID = 1L;

	/** Ӧ��ID */
	protected String eiid;
	
	/** ɾ��Ӧ�ù�ϵ���� */
	protected String[] deleteEirid;
	
	/**
	 * Ӧ��IDȡ��
	 * @return Ӧ��ID
	 */
	public String getEiid() {
		return eiid;
	}

	/**
	 * Ӧ��ID�趨
	 *
	 * @param eiid Ӧ��ID
	 */
	public void setEiid(String eiid) {
		this.eiid = eiid;
	}

	/**
	 * ɾ��Ӧ�ù�ϵ����ȡ��
	 * @return ɾ��Ӧ�ù�ϵ����
	 */
	public String[] getDeleteEirid() {
		return deleteEirid;
	}

	/**
	 * ɾ��Ӧ�ù�ϵ�����趨
	 *
	 * @param deleteEirid ɾ��Ӧ�ù�ϵ����
	 */
	public void setDeleteEirid(String[] deleteEirid) {
		this.deleteEirid = deleteEirid;
	}
}
