/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.kgm.model.condition;

/**
  * ����: knowLog��������ʵ��
  * ��������: knowLog��������ʵ��
  * ������¼: 2011/05/30
  * �޸ļ�¼: 
  */
public class KnowLogSearchCondImpl implements
		KnowLogSearchCond {

	/** ֪ʶID */
	protected Integer klkid;

	/**
	 * ֪ʶID�趨
	 * @param klkid ֪ʶID
	 */
	public void setKlkid(Integer klkid) {
		this.klkid = klkid;
	}

	/**
	 * ֪ʶIDȡ��
	 * @return klkid ֪ʶID
	 */
	public Integer getKlkid() {
		return klkid;
	}
}