/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.rpt.model.condition;

/**
  * ����: ��������ʵʱ���������ʵ��
  * ��������: ��������ʵʱ���������ʵ��
  * ������¼: 2012/07/03
  * �޸ļ�¼: 2012/08/10 ��VGCapacityRealTimeSearchCondImpl�����޸�ΪSOC0419SearchCondImpl
  */
public class SOC0419SearchCondImpl implements
		SOC0419SearchCond {
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