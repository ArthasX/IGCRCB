/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.ven.model;

import com.deliverik.framework.base.BaseModel;

/**
  * ����: ���ռ���ӿ�
  * ��������: ���ռ���ӿ�
  * ������¼: 2014/12/01
  * �޸ļ�¼: 
  */
public interface RiskMonitoringInfo extends BaseModel {

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Integer getRmid();

	/**
	 * ���ղ�������idȡ��
	 *
	 * @return ���ղ�������id
	 */
	public Integer getRsid();

	/**
	 * �����������ȡ��
	 *
	 * @return �����������
	 */
	public String getRmname();

	/**
	 * �ƻ���ʼʱ��ȡ��
	 *
	 * @return �ƻ���ʼʱ��
	 */
	public String getRmstartdate();

	/**
	 * ʵ�����ʱ��ȡ��
	 *
	 * @return ʵ�����ʱ��
	 */
	public String getRmenddate();

}