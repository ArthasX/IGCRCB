/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.rpt.model.condition;

/**
  * ����: ����������ͼ���������ӿ�
  * ��������: ����������ͼ���������ӿ�
  * ������¼: 2012/07/03
  * �޸ļ�¼: 2012/08/09 ��HostCapacityRealTimeVWSearchCond�޸�ΪSOC0429SearchCond
  */
public interface SOC0429SearchCond {
	/**
	 * bcId_eqȡ��
	 *
	 * @return bcId_eq bcId_eq
	 */
	public Integer getBcId_eq();
	/**
	 * sName_eqȡ��
	 *
	 * @return sName_eq sName_eq
	 */
	public String getSName_eq();
	/**
	 * bcName_eqȡ��
	 *
	 * @return bcName_eq bcName_eq
	 */
	public String getBcName_eq();
}