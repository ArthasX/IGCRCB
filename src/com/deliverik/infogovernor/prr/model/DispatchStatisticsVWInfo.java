/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.prr.model;


/**
  * ����: ��������ͳ�ƽӿ�
  * ��������: ��������ͳ�ƽӿ�
  * ������¼: 2013/02/27
  * �޸ļ�¼: 
  */
public interface DispatchStatisticsVWInfo {

	/**
	 * �����û�IDȡ��
	 *
	 * @return �����û�ID
	 */
	public String getDsuserid();

	/**
	 * �û���ȡ��
	 *
	 * @return �û���
	 */
	public String getDsusername();

	/**
	 * �����������ȡ��
	 *
	 * @return �����������
	 */
	public Integer getSumzc();

	/**
	 * ��ʱ�������ȡ��
	 *
	 * @return ��ʱ�������
	 */
	public Integer getSumys();

	/**
	 * δ�������ȡ��
	 *
	 * @return δ�������
	 */
	public Integer getSumwwc();

	/**
	 * �ϼ�����ȡ��
	 *
	 * @return �ϼ�����
	 */
	public Integer getSumnum();

}