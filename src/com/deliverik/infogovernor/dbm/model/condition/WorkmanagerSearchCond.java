/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.dbm.model.condition;

/**
  * ����: ����������������ӿ�
  * ��������: ����������������ӿ�
  * ������¼: 2016/04/19
  * �޸ļ�¼: 
  */
public interface WorkmanagerSearchCond {

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Integer getWmid();

	/**
	 * ��������ȡ��
	 *
	 * @return ��������
	 */
	public String getWmname();

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public String getWmdesc();
	
	/**
	 * ���״̬(0-δ���1-�����)ȡ��
	 *
	 * @return ���״̬(0-δ���1-�����)
	 */
	public String getWmstatus();

	/**
	 * @return the ��������
	 */
	public String getWmstartdate_from();
	
	/**
	 * @return the wmstartdate_to
	 */
	public String getWmstartdate_to();
	
	/**
	 * @return the Ƶ��
	 */
	public String getWmfrequency();
	
	/**
	 * @return the wmusername
	 */
	public String getWmusername();
	
	/**
	 * @return the ����Դwmid
	 */
	public String getRewmid();
	
	/**
	 * @return the ��������
	 */
	public String getWmstartdate();
	
	/**
	 * @return the �Ƿ�����0-����1-��������
	 */
	public String getWmremind();
}