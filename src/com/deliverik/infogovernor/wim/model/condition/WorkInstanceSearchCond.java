/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.wim.model.condition;

/**
  * ����: ����ʵ�����������ӿ�
  * ��������: ����ʵ�����������ӿ�
  * ������¼: 2017/06/09
  * �޸ļ�¼: 
  */
public interface WorkInstanceSearchCond {

	/**
	 * ����ʵ������ȡ��
	 *
	 * @return ����ʵ������
	 */
	public String getWiname();

	/**
	 * ����״̬��0��δִ�У�1��ִ���У�2����ִ�У�3��������4����ֹ����ȡ��
	 *
	 * @return ����״̬��0��δִ�У�1��ִ���У�2����ִ�У�3��������4����ֹ����
	 */
	public Integer getWistatus();

	/**
	 * ���ţ�id��ȡ��
	 *
	 * @return ���ţ�id��
	 */
	public String getWiDepartmentid();
	
	/**
	 * ��Ա��userid��ȡ��
	 *
	 * @return ��Ա��userid��
	 */
	public String getWiuserid();

	/**
	 * �������ͣ�1���Զ�����2���ֶ�����ȡ��
	 *
	 * @return �������ͣ�1���Զ�����2���ֶ�����
	 */
	public String getWiLunchType();

	/**
	 * ִ������ʱ�䣨Сʱ��ȡ��
	 *
	 * @return ִ������ʱ�䣨Сʱ��
	 */
	public String getExcuteTime();

	/**
	 * ʵ�ʴ�������ȡ��
	 *
	 * @return ʵ�ʴ�������
	 */
	public String getActualDealwithDate();

	/**
	 * ����ȷ������ȡ��
	 *
	 * @return ����ȷ������
	 */
	public String getConfirmDate();

	/**
	 * ����������ȡ��
	 *
	 * @return ����������
	 */
	public String getTitleDate();

	/**
	 * ���¼��������ȡ��
	 *
	 * @return ���¼��������
	 */
	public String getCrtDate();
}