/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.plugin.change.model;

import com.deliverik.framework.base.BaseModel;

/**
  * ����: ������������־�ӿ�
  * ��������: ������������־�ӿ�
  * ������¼: 2015/07/02
  * �޸ļ�¼: 
  */
public interface InitiateChangLogInfo extends BaseModel {

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Integer getIcid();

	/**
	 * ����ʱ��ȡ��
	 *
	 * @return ����ʱ��
	 */
	public String getSendTime();

	/**
	 * ����ʱ��ȡ��
	 *
	 * @return ����ʱ��
	 */
	public String getPublishTime();

	/**
	 * ����idȡ��
	 *
	 * @return ����id
	 */
	public Integer getPrid();

	/**
	 * ����״̬ȡ��
	 *
	 * @return ����״̬
	 */
	public String getPublishStatus();

	/**
	 * ��עȡ��
	 *
	 * @return ��ע
	 */
	public String getRemark();

	/**
	 * ������idȡ��
	 *
	 * @return ������id
	 */
	public String getPruserId();

	/**
	 * �����˽�ɫidȡ��
	 *
	 * @return �����˽�ɫid
	 */
	public String getPrroleId();

	/**
	 * �������ȡ��
	 *
	 * @return �������
	 */
	public String getChangeName();

	/**
	 * �������ȡ��
	 *
	 * @return �������
	 */
	public String getChangeDescription();

	/**
	 * �ƻ�ִ�п�ʼʱ��ȡ��
	 *
	 * @return �ƻ�ִ�п�ʼʱ��
	 */
	public String getBeginTime();

	/**
	 * �ƻ�ִ�н���ʱ��ȡ��
	 *
	 * @return �ƻ�ִ�н���ʱ��
	 */
	public String getEndTime();

	/**
	 * �������ȡ��
	 *
	 * @return �������
	 */
	public String getChangeType();

	/**
	 * ������ȡ��
	 *
	 * @return ������
	 */
	public String getChangeCategory();

	/**
	 * ��ѡ�������ȡ��
	 *
	 * @return ��ѡ�������
	 */
	public String getSelectedChangeType();

	/**
	 * �������ȡ��
	 *
	 * @return �������
	 */
	public String getChangeClassify();

	/**
	 * ����ƽ̨ȡ��
	 *
	 * @return ����ƽ̨
	 */
	public String getUpdatePlatform();

	/**
	 * ���ԭ�����ȡ��
	 *
	 * @return ���ԭ�����
	 */
	public String getChangeReasonClassify();

	/**
	 * ���ԭ��ȡ��
	 *
	 * @return ���ԭ��
	 */
	public String getChangeReason();

	/**
	 * �������ȡ��
	 *
	 * @return �������
	 */
	public String getChangeContent();

	/**
	 * �����Ŀ���ȡ��
	 *
	 * @return �����Ŀ���
	 */
	public String getPrjid();

	/**
	 * �����Ŀ����ȡ��
	 *
	 * @return �����Ŀ����
	 */
	public String getPrjtitle();

	/**
	 * �Ƿ�Ӱ��ҵ��ȡ��
	 *
	 * @return �Ƿ�Ӱ��ҵ��
	 */
	public String getIsBusiness();

	/**
	 * ��ҵ��Ӱ�췶Χȡ��
	 *
	 * @return ��ҵ��Ӱ�췶Χ
	 */
	public String getBusinessScope();

	/**
	 * �ƻ�Ӱ��ҵ��ʱ��(����)ȡ��
	 *
	 * @return �ƻ�Ӱ��ҵ��ʱ��(����)
	 */
	public String getBusinessTime();

	/**
	 * ִ�мƻ�ȡ��
	 *
	 * @return ִ�мƻ�
	 */
	public String getDeliveryProgram();

	/**
	 * ���˼ƻ�ȡ��
	 *
	 * @return ���˼ƻ�
	 */
	public String getRollbackProgram();

	/**
	 * ��֤�ƻ�ȡ��
	 *
	 * @return ��֤�ƻ�
	 */
	public String getVerificationProgram();

	/**
	 * ��س��򿪷�����ȡ��
	 *
	 * @return ��س��򿪷�����
	 */
	public String getRelatedPrid();
	
	/**
	 * ����key��ȡ
	 * @return the attkey
	 */
	public String getAttkey();
	/**
	 * PMSϵͳ����IDȡ��
	 * @return ticketid PMSϵͳ����ID
	 */
	
	public String getTicketid();
}