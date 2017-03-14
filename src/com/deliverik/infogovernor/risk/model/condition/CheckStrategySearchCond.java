/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.risk.model.condition;

/**
  * ����: �����Լ��������ӿ�
  * ��������: �����Լ��������ӿ�
  * ������¼: 2014/09/02
  * �޸ļ�¼: 
  */
public interface CheckStrategySearchCond {

	
	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Integer getCsid();

	/**
	 * �������ȡ��
	 *
	 * @return �������
	 */
	public String getCsname();

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public String getCsdesc();

	/**
	 * ״̬ȡ��
	 *
	 * @return ״̬
	 */
	public String getCsstatus();

	/**
	 * ��ʼ����ȡ��
	 *
	 * @return ��ʼ����
	 */
	public String getCsstartdate();

	/**
	 * ��������ȡ��
	 *
	 * @return ��������
	 */
	public String getCsenddate();

	/**
	 * Ƶ��ȡ��
	 *
	 * @return Ƶ��
	 */
	public String getCsfrequency();

	/**
	 * ����ִ�б��ʽȡ��
	 *
	 * @return ����ִ�б��ʽ
	 */
	public String getCscron();

	/**
	 * ������IDȡ��
	 *
	 * @return ������ID
	 */
	public String getCsuserid();

	/**
	 * ����������ȡ��
	 *
	 * @return ����������
	 */
	public String getCsusername();

	/**
	 * �������ɫIDȡ��
	 *
	 * @return �������ɫID
	 */
	public String getCsroleid();

	/**
	 * �������ɫ����ȡ��
	 *
	 * @return �������ɫ����
	 */
	public String getCsrolename();

	/**
	 * ����������idȡ��
	 *
	 * @return ����������id
	 */
	public String getCsasset();

	/**
	 * ��������������ȡ��
	 *
	 * @return ��������������
	 */
	public String getCsassetname();

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public String getCsattch ();

	/**
	 * ѡ��ȡ��
	 *
	 * @return ѡ��
	 */
	public String getCsoption ();
	
	public String getCstype();
	
	public String getCsrtestmode();
	
	public String getCsassetorgname();
	
	public String getCsassetorgid();
}