/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.mnt.model;


/**
  * ����: ��ض���KPI��Ϣ��ͼ�ӿ�
  * ��������: ��ض���KPI��Ϣ��ͼ�ӿ�
  * ������¼: 2012/02/13
  * �޸ļ�¼: 
  */
public interface MonitorObjectDefVWInfo {

	/**
	 * ����idȡ��
	 *
	 * @return ����id
	 */
	public Integer getModid();

	/**
	 * ��ض�������ȡ��
	 *
	 * @return ��ض�������
	 */
	public String getMoName();

	/**
	 * �����������ȡ��
	 *
	 * @return �����������
	 */
	public String getMtName();

	/**
	 * ������Ͳ����ȡ��
	 *
	 * @return ������Ͳ����
	 */
	public String getMtSyscoding();

	/**
	 * ����ʱ��ȡ��
	 *
	 * @return ����ʱ��
	 */
	public String getModCreateTime();

	/**
	 * ��ض���ֵ����ȡ��
	 *
	 * @return ��ض���ֵ����
	 */
	public String getModName();

	/**
	 * ��ض���ֵȡ��
	 *
	 * @return ��ض���ֵ
	 */
	public String getModValue();

	/**
	 * �����ȡ��
	 *
	 * @return �����
	 */
	public Integer getOrderNumber();

	/**
	 * ״̬ȡ��
	 *
	 * @return ״̬
	 */
	public String getDeleteFlag();
	
	/**
	 * �ȽϷ���ȡ��
	 * @return �ȽϷ���
	 */
	public String getCompare();
	
	/**
	 * ����ȡ��
	 * @return
	 */
	public String getModDes();

}