/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.rpt.model.condition;

/**
  * ����: ����pvʵʱ����������ӿ�
  * ��������: ����pvʵʱ����������ӿ�
  * ������¼: 2012/07/03
  * �޸ļ�¼: 2012/08/09 ��PVHostRealTimeSearchCond������ΪSOC0409SearchCond
  */
public interface SOC0409SearchCond {
	/**
	 * hostName_eqȡ��
	 *
	 * @return hostName_eq hostName_eq
	 */
	public String getHostName_eq();
	/**
	 * sName_eqȡ��
	 *
	 * @return sName_eq sName_eq
	 */
	public String getSName_eq();
	/**
	 * sName_notinȡ��
	 *
	 * @return sName_notin sName_notin
	 */
	public String[] getSName_notin();
	/**
	 * hostName_notinȡ��
	 *
	 * @return hostName_notin hostName_notin
	 */
	public String[] getHostName_notin();
}