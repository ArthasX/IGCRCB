/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.sym.model;

import com.deliverik.framework.base.BaseModel;

/**
  * ����: ���Ŷ��б�ӿ�
  * ��������: ���Ŷ��б�ӿ�
  * ������¼: 2012/11/13
  * �޸ļ�¼: 
  */
public interface QueueInfo extends BaseModel {

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Integer getQid();

	/**
	 * �澯IDȡ��
	 *
	 * @return �澯ID
	 */
	public String getAlertid();

	/**
	 * �澯����ȡ��
	 *
	 * @return �澯����
	 */
	public String getSmscontext();

	/**
	 * �澯ʱ��ȡ��
	 *
	 * @return �澯ʱ��
	 */
	public String getAlerttime();

	/**
	 * �ֻ���ȡ��
	 *
	 * @return �ֻ���
	 */
	public String getTel();

	/**
	 * �û�����ȡ��
	 *
	 * @return �û�����
	 */
	public String getUserName();

	/**
	 * �û�IDȡ��
	 *
	 * @return �û�ID
	 */
	public String getUserid();

}