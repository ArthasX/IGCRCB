package com.deliverik.infogovernor.asset.form;

import com.deliverik.framework.base.BaseForm;

/**
 * �豸��ϵ������FORM
 * 
 */
public class IGASM1406Form extends BaseForm{

	private static final long serialVersionUID = 1L;

	/** �����¼ID */
	protected String eiid;
	
	/** ɾ�������¼��ϵ���� */
	protected String[] deleteEirid;
	
	/**
	 * �����¼IDȡ��
	 * @return �����¼ID
	 */
	public String getEiid() {
		return eiid;
	}

	/**
	 * �����¼ID�趨
	 *
	 * @param eiid �����¼ID
	 */
	public void setEiid(String eiid) {
		this.eiid = eiid;
	}

	/**
	 * ɾ�������¼��ϵ����ȡ��
	 * @return ɾ�������¼��ϵ����
	 */
	public String[] getDeleteEirid() {
		return deleteEirid;
	}

	/**
	 * ɾ�������¼��ϵ�����趨
	 *
	 * @param deleteEirid ɾ�������¼��ϵ����
	 */
	public void setDeleteEirid(String[] deleteEirid) {
		this.deleteEirid = deleteEirid;
	}
}
