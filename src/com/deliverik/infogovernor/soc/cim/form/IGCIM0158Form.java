package com.deliverik.infogovernor.soc.cim.form;



import com.deliverik.framework.base.BaseForm;

/**
 * �������FORM
 * 
 */
public class IGCIM0158Form extends BaseForm{

	private static final long serialVersionUID = 1L;

	protected String eiid;

	/** ��ѯ����		0���������	1�����ά�޼�¼*/
	protected String type;
	/**
	 * eiidȡ��
	 * @return eiid eiid
	 */
	public String getEiid() {
		return eiid;
	}

	/**
	 * eiid�趨
	 * @param eiid eiid
	 */
	public void setEiid(String eiid) {
		this.eiid = eiid;
	}

	/**
	 * ��ѯ����0���������1�����ά�޼�¼ȡ��
	 * @return type ��ѯ����0���������1�����ά�޼�¼
	 */
	public String getType() {
		return type;
	}

	/**
	 * ��ѯ����0���������1�����ά�޼�¼�趨
	 * @param type ��ѯ����0���������1�����ά�޼�¼
	 */
	public void setType(String type) {
		this.type = type;
	}
	
}
