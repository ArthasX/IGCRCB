/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prr.model.condition;

/**
  * ����: ��Ա���ֵ���������ʵ��
  * ��������: ��Ա���ֵ���������ʵ��
  * ������¼: 2013/09/03
  * �޸ļ�¼: 
  */
public class IG506SearchCondImpl implements IG506SearchCond {
	
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