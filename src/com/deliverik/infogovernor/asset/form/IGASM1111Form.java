package com.deliverik.infogovernor.asset.form;

import com.deliverik.framework.base.BaseForm;

/**
 * ����ѡ����FORM
 * 
 */
public class IGASM1111Form extends BaseForm {

	private static final long serialVersionUID = 1L;

	/** ɾ���������� */
	protected String[] deleteEiid;
	
	/** ��������Id */
	protected String computerContainerId;
	
	/**
	 * ɾ����������ȡ��
	 * @return ɾ����������
	 */
	public String[] getDeleteEiid() {
		return deleteEiid;
	}


	/**
	 * ɾ�����������趨
	 *
	 * @param deleteEiid ɾ����������
	 */
	public void setDeleteEiid(String[] deleteEiid) {
		this.deleteEiid = deleteEiid;
	}

	/**
	 *��������Idȡ��
	 * @return ��������Id
	 */
	public String getComputerContainerId() {
		return computerContainerId;
	}
	/**
	 * ��������Id�趨
	 *
	 * @param computerContainerId ��������Id
	 */
	public void setComputerContainerId(String computerContainerId) {
		this.computerContainerId = computerContainerId;
	}
	

}
