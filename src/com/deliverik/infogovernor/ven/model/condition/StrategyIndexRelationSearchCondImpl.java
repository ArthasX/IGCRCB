/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.ven.model.condition;

/**
  * ����: ���ղ���ָ���ϵ���������ʵ��
  * ��������: ���ղ���ָ���ϵ���������ʵ��
  * ������¼: 2014/12/01
  * �޸ļ�¼: 
  */
public class StrategyIndexRelationSearchCondImpl implements
		StrategyIndexRelationSearchCond {

	/** ���ղ�������*/
	protected Integer rsid;

	/**
	 * ���ղ���������ȡ
	 * @return rsid
	 */
	public Integer getRsid() {
		return rsid;
	}

	/**
	 * ���ղ��������趨
	 * @param rsid
	 */
	public void setRsid(Integer rsid) {
		this.rsid = rsid;
	}
}