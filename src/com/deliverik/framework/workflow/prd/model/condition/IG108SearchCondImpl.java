/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prd.model.condition;

/**
  * ����: �Զ������̱���ѯ����������������ʵ��
  * ��������: �Զ������̱���ѯ����������������ʵ��
  * ������¼: 2013/03/13
  * �޸ļ�¼: 
  */
public class IG108SearchCondImpl implements IG108SearchCond {

	/** ������������ */
	protected String pdid;

	/**
	 * ������������ȡ��
	 * @return ������������
	 */
	public String getPdid() {
		return pdid;
	}

	/**
	 * �������������趨
	 * @param pdid ������������
	 */
	public void setPdid(String pdid) {
		this.pdid = pdid;
	}
}