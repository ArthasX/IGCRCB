package com.deliverik.infogovernor.soc.cim.form;

import com.deliverik.framework.base.BaseForm;

/**
 * �豸��ϵ������FORM
 * 
 */
public class IGCIM1406Form extends BaseForm{

	private static final long serialVersionUID = 1L;

	/** ��ԱID */
	protected Integer eiid;
	
	/** ɾ����Ա��ϵ���� */
	protected String[] deleteEirid;
	
	/**
	 * ��ԱIDȡ��
	 * @return ��ԱID
	 */
	public Integer getEiid() {
		return eiid;
	}

	/**
	 * ��ԱID�趨
	 *
	 * @param eiid ��ԱID
	 */
	public void setEiid(Integer eiid) {
		this.eiid = eiid;
	}

	/**
	 * ɾ����Ա��ϵ����ȡ��
	 * @return ɾ����Ա��ϵ����
	 */
	public String[] getDeleteEirid() {
		return deleteEirid;
	}

	/**
	 * ɾ����Ա��ϵ�����趨
	 *
	 * @param deleteEirid ɾ����Ա��ϵ����
	 */
	public void setDeleteEirid(String[] deleteEirid) {
		this.deleteEirid = deleteEirid;
	}
}
