package com.deliverik.infogovernor.asset.form;

import com.deliverik.framework.base.BaseForm;

/**
 * ϵͳ��ϵ������FORM
 * 
 */
public class IGASM1806Form extends BaseForm {

	private static final long serialVersionUID = 1L;

	/** ϵͳID */
	protected String eiid;
	
	/** ɾ��ϵͳ��ϵ���� */
	protected String[] deleteEirid;
	
	/**
	 * ϵͳIDȡ��
	 * @return ϵͳID
	 */
	public String getEiid() {
		return eiid;
	}

	/**
	 * ϵͳID�趨
	 *
	 * @param eiid ϵͳID
	 */
	public void setEiid(String eiid) {
		this.eiid = eiid;
	}

	/**
	 * ɾ��ϵͳ��ϵ����ȡ��
	 * @return ɾ��ϵͳ��ϵ����
	 */
	public String[] getDeleteEirid() {
		return deleteEirid;
	}

	/**
	 * ɾ��ϵͳ��ϵ�����趨
	 *
	 * @param deleteEirid ɾ��ϵͳ��ϵ����
	 */
	public void setDeleteEirid(String[] deleteEirid) {
		this.deleteEirid = deleteEirid;
	}
}
