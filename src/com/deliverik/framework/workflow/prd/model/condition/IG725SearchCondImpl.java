/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prd.model.condition;

/**
  * ����: ȱʡ�����߰�ť������������ʵ��
  * ��������: ȱʡ�����߰�ť������������ʵ��
  * ������¼: 2012/04/18
  * �޸ļ�¼: 
  */
public class IG725SearchCondImpl implements
		IG725SearchCond {
	
	/** ״̬ID */
	public String psdid;
	
	/** ��ťID */
	public String pbdid;
	
	/** ���� */
	protected String pdbdid_like;

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
	 *@param psdid ״̬ID
	 * @return ״̬ID
	 */
	public void setPsdid(String psdid) {
		this.psdid = psdid;
	}

	/**
	 * ��ťIDȡ��
	 *
	 * @return ��ťID
	 */
	public String getPbdid() {
		return pbdid;
	}

	/**
	 * ��ťID�趨
	 *
	 *@param pbdid ��ťID
	 * @return ��ťID
	 */
	public void setPbdid(String pbdid) {
		this.pbdid = pbdid;
	}

	/**
	 * ����ȡ��
	 * 
	 * @return ����
	 */
	public String getPdbdid_like() {
		return pdbdid_like;
	}

	/**
	 * �����趨
	 * 
	 * @param pdbdid_like ����
	 */
	public void setPdbdid_like(String pdbdid_like) {
		this.pdbdid_like = pdbdid_like;
	}
	
}