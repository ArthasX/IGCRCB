/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.wim.model.condition;

/**
  * ����: ������־�����������ӿ�
  * ��������: ������־���������ӿ�
  * ������¼: 2017/06/09
  * �޸ļ�¼: 
  */
public interface WorkLogSearchCond {

	/**
	 * ������־����ȡ��
	 *
	 * @return ������־����
	 */
	public String getWlname();

	/**
	 * ִ���ˣ�userid��ȡ��
	 *
	 * @return ִ���ˣ�userid��
	 */
	public String getExcutorId();

	/**
	 * ����������ȡ��
	 *
	 * @return ����������
	 */
	public String getTitleDate();
	/**
	 * ִ��ʱ��ȡ��
	 *
	 * @return excuteTime
	 */
	public String getExcuteTime();

	/**
	 * ʵ�ʴ�������ȡ��
	 *
	 * @return ʵ�ʴ�������
	 */
	public String getActualDealwithDate();

	/**
	 * ���¼��������ȡ��
	 *
	 * @return ���¼��������
	 */
	public String getCrtDate();
}