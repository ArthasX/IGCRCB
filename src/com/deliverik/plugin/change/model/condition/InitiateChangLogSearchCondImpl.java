/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.plugin.change.model.condition;

/**
  * ����: ������������־��������ʵ��
  * ��������: ������������־��������ʵ��
  * ������¼: 2015/07/02
  * �޸ļ�¼: 
  */
public class InitiateChangLogSearchCondImpl implements
		InitiateChangLogSearchCond {

	/**����ID*/
	protected int prid;

	/**
	 * ����IDȡ��
	 * @return prid ����ID
	 */
	
	public int getPrid() {
		return prid;
	}

	/**
	 * ����ID�趨
	 * @param prid ����ID
	 */
	public void setPrid(int prid) {
		this.prid = prid;
	}
	
	
}