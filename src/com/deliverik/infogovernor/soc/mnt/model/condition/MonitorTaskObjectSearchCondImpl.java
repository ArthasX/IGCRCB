/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.mnt.model.condition;

/**
  * ����: ������������������ʵ��
  * ��������: ������������������ʵ��
  * ������¼: 2012/05/10
  * �޸ļ�¼: 
  */
public class MonitorTaskObjectSearchCondImpl implements
		MonitorTaskObjectSearchCond {
	/**����ID*/
	protected Integer mtid;

	/**
	 * ����IDȡ��
	 *
	 * @return mtid ����ID
	 */
	public Integer getMtid() {
		return mtid;
	}

	/**
	 * ����ID�趨
	 *
	 * @param mtid ����ID
	 */
	public void setMtid(Integer mtid) {
		this.mtid = mtid;
	}
	
}