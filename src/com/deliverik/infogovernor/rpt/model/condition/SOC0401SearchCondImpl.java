/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.rpt.model.condition;

/**
  * ����: ���ݿ�����ʵʱ���������ʵ��
  * ��������: ���ݿ�����ʵʱ���������ʵ��
  * ������¼: 2012/07/03
  * �޸ļ�¼: 2012/08/09 ��DBCapacityRealTimeSearchCondImpl������ΪSOC0401SearchCondImpl
  */
public class SOC0401SearchCondImpl implements
		SOC0401SearchCond {
	/**��������*/
	protected String hostName_eq;

	/**
	 * ��������ȡ��
	 *
	 * @return hostName_eq ��������
	 */
	public String getHostName_eq() {
		return hostName_eq;
	}

	/**
	 * ���������趨
	 *
	 * @param hostName_eq ��������
	 */
	public void setHostName_eq(String hostName_eq) {
		this.hostName_eq = hostName_eq;
	}
}