/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prd.model;

import com.deliverik.framework.base.BaseModel;

/**
  * ����: �����������ϵ�����ӿ�
  * ��������: �����������ϵ�����ӿ�
  * ������¼: 2015/02/03
  * �޸ļ�¼: 
  */
public interface IG482Info extends BaseModel {

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public String getPgreid();

	/**
	 * ������idȡ��
	 *
	 * @return ������id
	 */
	public String getPgdid();

	/**
	 * �ο����̶���ȡ��
	 *
	 * @return �ο����̶���
	 */
	public String getRpdid();

	/**
	 * Ӱ�����̶���ȡ��
	 *
	 * @return Ӱ�����̶���
	 */
	public String getIpdid();

	/**
	 * ԾǨ����ȡ��
	 *
	 * @return ԾǨ����
	 */
	public String getPgrerule();

	/**
	 * �ο�����״̬ȡ��
	 *
	 * @return �ο�����״̬
	 */
	public String getRpsdid();
	
	/**
	 * �ο�����Ŀ��״̬ȡ��
	 * @return �ο�����Ŀ��״̬
	 */
	public String getRtpsdid();

	/**
	 * Ӱ������״̬ȡ��
	 *
	 * @return Ӱ������״̬
	 */
	public String getIpsdid();

	/**
	 * �������⴦��ȡ��
	 *
	 * @return �������⴦��
	 */
	public String getTransferHandler();

}