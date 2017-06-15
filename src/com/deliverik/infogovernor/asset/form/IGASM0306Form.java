package com.deliverik.infogovernor.asset.form;

import com.deliverik.framework.base.BaseForm;

/**
 * �豸��ϵ������FORM
 * 
 */
public class IGASM0306Form extends BaseForm{

	private static final long serialVersionUID = 1L;

	/** �豸ID */
	protected String eiid;
	
	/** ɾ���豸��ϵ���� */
	protected String[] deleteEirid;
	
	/** ��ϵ���� */
	protected String relationType;
	/**
	 * ��ϵ����ȡ��
	 * @return ��ϵ����
	 */
	public String getRelationType() {
		return relationType;
	}
	/**
	 * ��ϵ�����趨
	 *
	 * @param relationType ��ϵ����
	 */
	public void setRelationType(String relationType) {
		this.relationType = relationType;
	}

	/**
	 * �豸IDȡ��
	 * @return �豸ID
	 */
	public String getEiid() {
		return eiid;
	}

	/**
	 * �豸ID�趨
	 *
	 * @param eiid �豸ID
	 */
	public void setEiid(String eiid) {
		this.eiid = eiid;
	}

	/**
	 * ɾ���豸��ϵ����ȡ��
	 * @return ɾ���豸��ϵ����
	 */
	public String[] getDeleteEirid() {
		return deleteEirid;
	}

	/**
	 * ɾ���豸��ϵ�����趨
	 *
	 * @param deleteEirid ɾ���豸��ϵ����
	 */
	public void setDeleteEirid(String[] deleteEirid) {
		this.deleteEirid = deleteEirid;
	}
}
