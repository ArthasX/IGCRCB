/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.crc.model.condition;

/**
  * ����: ���ɸ澯����������ӿ�
  * ��������: ���ɸ澯����������ӿ�
  * ������¼: 2014/06/21
  * �޸ļ�¼: 
  */
public interface IgalarmSearchCond {
	/**
	 * �ȶԼ��ɸ澯����� ȡ�� 
	 * @return �ȶԼ��ɸ澯�����
	 */
	public String getSerial();
	
	/**
	 * �ȶԼ��ɸ澯��ʼʱ�� ȡ�� 
	 * @return �ȶԼ��ɸ澯��ʼʱ��
	 */
	public String getStartDate();

	/**
	 * �ȶԼ��ɸ澯�����ʱ�� ȡ�� 
	 * @return �ȶԼ��ɸ澯�����ʱ��
	 */
	public String getEndDate();

	/**
	 * �ȶԼ��ɸ澯���������� ȡ�� 
	 * @return �ȶԼ��ɸ澯����������
	 */
	public String getAppname();

	/**
	 * �ȶԼ��ɸ澯���¼����� ȡ�� 
	 * @return �ȶԼ��ɸ澯���¼�����
	 */
	public String getSummary();

	/**
	 * �ȶԼ��ɸ澯��id�� ȡ�� 
	 * @return �ȶԼ��ɸ澯��id��
	 */
	public String[] getAlarmIds();
	
	/**
	 * ״̬(0:�澯;1:�ָ�;2:�ر�)ȡ��
	 * @return status  ״̬(0:�澯;1:�ָ�;2:�ر�)
	 */
	public String getStatus();
	
	/**
	 * ����/�ָ�ʱ��ȡ��
	 *
	 * @return ����/�ָ�ʱ��
	 */
	public String getLasttime();
	
	/**
	 * �Ƿ���ʾ��ʶ(0��ʾ��1����ʾ)ȡ��
	 * @return isShow  �Ƿ���ʾ��ʶ
	 */
	public String getIsShow();
	
	/**
	 * �¼������ȡ��
	 *
	 * @return �¼������
	 */
	public String getPedeventid();
	
	public String getIpaddr();

	public String getShieldflag();
	
	/**
	 * ����ʱ������״̬��(1Ϊ���� 2Ϊ����)ȡ��
	 * 
	 * @return ����ʱ������״̬��(1Ϊ���� 2Ϊ����)
	 */
	public String getLasttimestatus();
	
	/**
	 * ip��ַ����״̬��(1Ϊ���� 2Ϊ����)ȡ��
	 * 
	 * @return ip��ַ����״̬��(1Ϊ���� 2Ϊ����)
	 */
	public String getIpaddrstatus();
	
	/**
	 * ������������״̬��(1Ϊ���� 2Ϊ����)ȡ��
	 * 
	 * @return ������������״̬��
	 */
	public String getAppnamestatus();
	
	/**
	 * �ָ�ʱ������״̬��(1Ϊ���� 2Ϊ����)ȡ��
	 * 
	 * @return �ָ�ʱ������״̬��(1Ϊ���� 2Ϊ����)
	 */
	public String getRecoverytimestatus();
	
	
	
	
	
}