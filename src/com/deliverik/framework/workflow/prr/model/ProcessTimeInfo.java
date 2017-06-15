/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prr.model;

import com.deliverik.framework.base.BaseModel;

/**
  * ����: ���̼�ʱ��ӿ�
  * ��������: ���̼�ʱ��ӿ�
  * ������¼: 2011/10/08
  * �޸ļ�¼: 
  */
public interface ProcessTimeInfo extends BaseModel {

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Integer getPrtid();

	/**
	 * ����IDȡ��
	 *
	 * @return ����ID
	 */
	public Integer getPrid();

	/**
	 * ��ʱ�û�IDȡ��
	 *
	 * @return ��ʱ�û�ID
	 */
	public String getUserid();

	/**
	 * ��ʱ��ʼʱ��ȡ��
	 *
	 * @return ��ʱ��ʼʱ��
	 */
	public String getPrtstartTime();

	/**
	 * ��ʼ��ʱ״̬ȡ��
	 *
	 * @return ��ʼ��ʱ״̬
	 */
	public String getPrtstartStatus();

	/**
	 * ��ʱ����ʱ��ȡ��
	 *
	 * @return ��ʱ����ʱ��
	 */
	public String getPrtEndTime();

	/**
	 * ��ʱ����״̬ȡ��
	 *
	 * @return ��ʱ����״̬
	 */
	public String getPrtEndStatus();

	/**
	 * ��Ч������ȡ��
	 *
	 * @return ��Ч������
	 */
	public Integer getFactTime();

}