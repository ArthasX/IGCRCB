/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prd.model.condition;

/**
  * ����: ���̱���ʼ���¼�������������ʵ��
  * ��������: ���̱���ʼ���¼�������������ʵ��
  * ������¼: 2012/07/03
  * �޸ļ�¼: 
  */
public class IG373SearchCondImpl implements
		IG373SearchCond {
	
	/**
	 * ����״̬ID
	 */
	protected String psdid;

	/** ���̶���ID */
	protected String pdid;

	/**
	 * ����״̬IDȡ��
	 * @return ����״̬ID
	 */
	public String getPsdid() {
		return psdid;
	}

	/**
	 * ����״̬ID�趨
	 * @param psdid ����״̬ID
	 */
	public void setPsdid(String psdid) {
		this.psdid = psdid;
	}

	/**
	 * ���̶���IDȡ��
	 * 
	 * @return ���̶���ID
	 */
	public String getPdid() {
		return pdid;
	}

	/**
	 * ���̶���ID�趨
	 * 
	 * @param pdid ���̶���ID
	 */
	public void setPdid(String pdid) {
		this.pdid = pdid;
	}
	
}