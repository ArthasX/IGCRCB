package com.deliverik.infogovernor.asset.form;



import com.deliverik.framework.base.BaseForm;

/**
 * ������ѯ����FORM
 * 
 */
public class IGASM1101Form extends BaseForm{

	private static final long serialVersionUID = 1L;

	/** ɾ���������� */
	protected String[] deleteEiid;
	
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

}
