/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prd.model.condition;

/**
  * ����: �Զ������̻�����Χ���������ʵ��
  * ��������: �Զ������̻�����Χ���������ʵ��
  * ������¼: 2013/03/07
  * �޸ļ�¼: 
  */
public class IG123SearchCondImpl implements IG123SearchCond {
	
	/** ���̶������� */
	protected String pdid;

	/**
	 * ���̶�������ȡ��
	 * @return ���̶�������
	 */
	public String getPdid() {
		return pdid;
	}

	/**
	 * ���̶��������趨
	 * @param pdid ���̶�������
	 */
	public void setPdid(String pdid) {
		this.pdid = pdid;
	}
	
}