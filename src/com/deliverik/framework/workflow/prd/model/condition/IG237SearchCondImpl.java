/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prd.model.condition;


/**
  * ����: ���̲���֪ͨ�˼�������ʵ��
  * ��������: ���̲���֪ͨ�˼�������ʵ��
  * ������¼: 2012/04/25
  * �޸ļ�¼: 
  */
public class IG237SearchCondImpl implements
		IG237SearchCond {

	/** ״̬ID */
	protected String psdid;

	/** �Ƿ�ȷ�� */
	protected String psdconfirm;

	/** ״̬ID */
	protected String psdid_like;
	
	/** ��ֵ */
	protected String pivalue;
	
	/**
	 * ״̬IDȡ��
	 *
	 * @return ״̬ID
	 */
	public String getPsdid() {
		return psdid;
	}

	/**
	 * ״̬ID�趨
	 *
	 * @param psdid ״̬ID
	 */
	public void setPsdid(String psdid) {
		this.psdid = psdid;
	}

	/**
	 * �Ƿ�ȷ��ȡ��
	 *
	 * @return �Ƿ�ȷ��
	 */
	public String getPsdconfirm() {
		return psdconfirm;
	}

	/**
	 * �Ƿ�ȷ���趨
	 *
	 * @param psdconfirm �Ƿ�ȷ��
	 */
	public void setPsdconfirm(String psdconfirm) {
		this.psdconfirm = psdconfirm;
	}

	/**
	 * ״̬IDȡ��
	 * 
	 * @return ״̬ID
	 */
	public String getPsdid_like() {
		return psdid_like;
	}

	/**
	 * ״̬ID�趨
	 * @param psdid_like ״̬ID
	 */
	public void setPsdid_like(String psdid_like) {
		this.psdid_like = psdid_like;
	}

	/**
	 * ��ֵȡ��
	 * @return pivalue ��ֵ
	 */
	public String getPivalue() {
		return pivalue;
	}

	/**
	 * ��ֵ�趨
	 * @param pivalue ��ֵ
	 */
	public void setPivalue(String pivalue) {
		this.pivalue = pivalue;
	}
	
}