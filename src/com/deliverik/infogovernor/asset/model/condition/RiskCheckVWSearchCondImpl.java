/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.asset.model.condition;

/**
  * ����: ��鹤��ͳ�Ʊ����������ʵ��
  * ��������: ��鹤��ͳ�Ʊ����������ʵ��
  * ������¼: 2014/07/22
  * �޸ļ�¼: 
  */
public class RiskCheckVWSearchCondImpl implements
		RiskCheckVWSearchCond {
	/**���յ�ID*/
	protected String eiid;

	/**
	 * ���յ�IDȡ��
	 * @return eiid ���յ�ID
	 */
	public String getEiid() {
		return eiid;
	}

	/**
	 * ���յ�ID�趨
	 * @param eiid ���յ�ID
	 */
	public void setEiid(String eiid) {
		this.eiid = eiid;
	}
}