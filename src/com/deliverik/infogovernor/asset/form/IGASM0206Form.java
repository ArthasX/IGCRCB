package com.deliverik.infogovernor.asset.form;

import com.deliverik.framework.base.BaseForm;

/**
 * �ʲ����ϵ������FORM
 * 
 */
public class IGASM0206Form extends BaseForm {

	private static final long serialVersionUID = 1L;

	/** �ʲ���ID */
	protected int eiid;
	
	/** ɾ���ʲ����ϵ���� */
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
	 * �ʲ���IDȡ��
	 * @return �ʲ���ID
	 */
	public int getEiid() {
		return eiid;
	}

	/**
	 * �ʲ���ID�趨
	 *
	 * @param eiid �ʲ���ID
	 */
	public void setEiid(int eiid) {
		this.eiid = eiid;
	}

	/**
	 * ɾ���ʲ����ϵ����ȡ��
	 * @return ɾ���ʲ����ϵ����
	 */
	public String[] getDeleteEirid() {
		return deleteEirid;
	}

	/**
	 * ɾ���ʲ����ϵ�����趨
	 *
	 * @param deleteEirid ɾ���ʲ����ϵ����
	 */
	public void setDeleteEirid(String[] deleteEirid) {
		this.deleteEirid = deleteEirid;
	}
}
