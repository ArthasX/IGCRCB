/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prd.model.condition;


/**
  * ����: ����֪ͨ���Լ�������ʵ��
  * ��������: ����֪ͨ���Լ�������ʵ��
  * ������¼: 2012/04/24
  * �޸ļ�¼: 
  */
public class IG212SearchCondImpl implements
		IG212SearchCond {

	/** ״̬ID */
	protected String psdid_like;
	
	/** ���̶���ID */
	private String pdid;

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
	 * 
	 * @param psdid_like ״̬ID
	 */
	public void setPsdid_like(String psdid_like) {
		this.psdid_like = psdid_like;
	}

	/**
	 * ���̶���ID�趨
	 * @param pdid
	 */
	public void setPdid(String pdid) {
		this.pdid = pdid;
	}

	/**
	 * ���̶���ID��ȡ
	 * @return
	 */
	public String getPdid() {
		return pdid;
	}
	
}