/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prr.model.condition;

/**
  * ����: ���̱�ֵ���������ʵ��
  * ��������: ���̱�ֵ���������ʵ��
  * ������¼: 2013/08/28
  * �޸ļ�¼: 
  */
public class IG505SearchCondImpl implements IG505SearchCond {

	/** �������� */
	protected Integer prid;

	/**
	 * ��������ȡ��
	 * @return prid ��������
	 */
	public Integer getPrid() {
		return prid;
	}

	/**
	 * ���������趨
	 * @param prid ��������
	 */
	public void setPrid(Integer prid) {
		this.prid = prid;
	}
}