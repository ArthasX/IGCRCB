/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.ven.model.condition;


/**
  * ����: ���ռ�����������ӿ�
  * ��������: ���ռ�����������ӿ�
  * ������¼: 2014/12/01
  * �޸ļ�¼: 
  */
public interface RiskMonitoringSearchCond {
	/**
	 * rmidȡ��
	 * @return rmid  rmid
	 */
	public Integer getRmid();

	

	/**
	 * ���ղ�������idȡ��
	 * @return rsid  ���ղ�������id
	 */
	public Integer getRsid();

	/**
	 * �����������ȡ��
	 * @return rmname  �����������
	 */
	public String getRmname();

	/**
	 * �ƻ���ʼʱ��ȡ��
	 * @return rmstartdate  �ƻ���ʼʱ��
	 */
	public String getRmstartdate();


	/**
	 * ��ѯ�����ƻ���ʼʱ��ȡ��
	 * @return rmstartdate_from  ��ѯ�����ƻ���ʼʱ��
	 */
	public String getRmstartdate_from();

	/**
	 * ��ѯ�����ƻ���ʼʱ��ȡ��
	 * @return rmstartdate_to  ��ѯ�����ƻ���ʼʱ��
	 */
	public String getRmstartdate_to();


	/**
	 * ʵ�����ʱ��ȡ��
	 * @return rmenddate  ʵ�����ʱ��
	 */
	public String getRmenddate();

	/**
	 * ��ѯ����ʵ�����ʱ��ȡ��
	 * @return rmenddate_from  ��ѯ����ʵ�����ʱ��
	 */
	public String getRmenddate_from();

	
	/**
	 * ��ѯ����ʵ�����ʱ��ȡ��
	 * @return rmenddate_to  ��ѯ����ʵ�����ʱ��
	 */
	public String getRmenddate_to();
	
}