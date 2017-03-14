/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.crc.model;

import com.deliverik.framework.base.BaseModel;

/**
  * ����: ���ɸ澯��ӿ�
  * ��������: ���ɸ澯��ӿ�
  * ������¼: 2014/06/21
  * �޸ļ�¼: 
  */
public interface IgalarmInfo extends BaseModel {

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Integer getPk();

	/**
	 * ���ȡ��
	 *
	 * @return ���
	 */
	public String getSerial();

	/**
	 * ��������ȡ��
	 *
	 * @return ��������
	 */
	public String getAppname();

	/**
	 * IP��ַȡ��
	 *
	 * @return IP��ַ
	 */
	public String getIpaddr();

	/**
	 * �¼��ȼ�ȡ��
	 *
	 * @return �¼��ȼ�
	 */
	public String getSeverity();

	/**
	 * �¼�����ȡ��
	 *
	 * @return �¼�����
	 */
	public String getSummary();

	/**
	 * ����/�ָ�ʱ��ȡ��
	 *
	 * @return ����/�ָ�ʱ��
	 */
	public String getLasttime();

	/**
	 * ״̬(0:δ����;1:�Ѵ���)ȡ��
	 *
	 * @return ״̬(0:δ����;1:�Ѵ���)
	 */
	public String getStatus();

	/**
	 * �¼������ȡ��
	 *
	 * @return �¼������
	 */
	public String getPedeventid();
	
	/**
	 * �ָ�ʱ��ȡ��
	 * @return recoveryTime  �ָ�ʱ��
	 */
	public String getRecoveryTime();
	
	/**
	 * ����ȡ��
	 * @return description  ����
	 */
	public String getDescription();

	/**
	 * �Ƿ����ɹ���ȡ�� (1:��  0:��) 
	 * @return isCreateOrder  �Ƿ����ɹ���
	 */
	public String getIsCreateOrder();
	
	/**
	 * ������ϵ��ȡ��
	 * @return faultContact  ������ϵ��
	 */
	public String getFaultContact();
	
	/**
	 * �Ƿ���ʾ��ʶȡ��
	 * @return isShow  �Ƿ���ʾ��ʶ
	 */
	public String getIsShow();
	
	
	/**
	 * ���һ�θ澯ʱ��ȡ��
	 * @return prealarmtime ���һ�θ澯ʱ��
	 */
	public String getPrealarmtime();
	
	/**
	 * �ø澯�����Ĵ���ȡ��
	 * @return alarmcount �ø澯�����Ĵ���
	 */
	public Integer getAlarmcount();
	
	/**
	 * Ӧ����������״̬�ı�ʶȡ��
	 * @return
	 */
	public String getShieldflag();
	
	/**
	 * Ӧ��������������ȡ��
	 * @return
	 */
	public String getShielddesc();
	
	
}