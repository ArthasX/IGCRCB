/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.wim.model;

import com.deliverik.framework.base.BaseModel;

/**
  * ����: ������־�ӿ�
  * ��������: ������־�ӿ�
  * ������¼: 2017/06/09
  * �޸ļ�¼: 
  */
public interface WorkLogInfo extends BaseModel {

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Integer getWlid();

	/**
	 * ����ʵ��������ȡ��
	 *
	 * @return ����ʵ��������
	 */
	public Integer getWiid();

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
	 * ���� ȡ��
	 *
	 * @return ���� 
	 */
	public String getOperation();

	/**
	 * ����������ȡ��
	 *
	 * @return ����������
	 */
	public String getTitleDate();

	/**
	 * ִ��ʱ��ȡ��
	 *
	 * @return ִ��ʱ��
	 */
	public String getExcuteTime();

	/**
	 * ʵ�ʴ�������ȡ��
	 *
	 * @return ʵ�ʴ�������
	 */
	public String getActualDealwithDate();

	/**
	 * ִ���������ȡ��
	 *
	 * @return ִ���������
	 */
	public String getWlDescription();

	/**
	 * ���¼�������� ȡ��
	 *
	 * @return ���¼�������� 
	 */
	public String getCrtDate();

}