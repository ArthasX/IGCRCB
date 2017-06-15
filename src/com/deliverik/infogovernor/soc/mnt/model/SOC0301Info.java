/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.mnt.model;

import com.deliverik.framework.base.BaseModel;

/**
  * ����: DMXʵʱ������ܱ�ӿ�D MXRealTimeInfo
  * ��������: DMXʵʱ������ܱ�ӿ� DMXRealTimeInfo
  * ������¼: 2012/05/16
  * �޸ļ�¼: 
  */
public interface SOC0301Info extends BaseModel {

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Integer getId();

	/**
	 * �������idȡ��
	 *
	 * @return �������id
	 */
	public Integer getMtId();

	/**
	 * ��ض�����ȡ��
	 *
	 * @return ��ض�����
	 */
	public String getMtoName();

	/**
	 * ����ָ��ȡ��
	 *
	 * @return ����ָ��
	 */
	public String getMtKpi();

	/**
	 * ����ָ��ֵȡ��
	 *
	 * @return ����ָ��ֵ
	 */
	public Double getKpiValue();

	/**
	 * ����ʱ���ȡ��
	 *
	 * @return ����ʱ���
	 */
	public String getTimeStamp();

}