/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.mnt.model.condition;

/**
  * ����: ��ض���ֵ��Ϣ���������ʵ��
  * ��������: ��ض���ֵ��Ϣ���������ʵ��
  * ������¼: 2012/02/08
  * �޸ļ�¼: 
  */
public class MonitorObjectDefSearchCondImpl implements
		MonitorObjectDefSearchCond {
	
	/**
	 * ��ض���id
	 */
	protected String moId;

	/**
	 * ��ض���idȡ��
	 * @return
	 */
	public String getMoId() {
		return moId;
	}

	/**
	 * ��ض���id�趨
	 * @param moId
	 */
	public void setMoId(String moId) {
		this.moId = moId;
	}
}