/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prd.model;

import com.deliverik.framework.base.BaseModel;

/**
  * ����: ����֪ͨ���Խӿ�
  * ��������: ����֪ͨ���Խӿ�
  * ������¼: 2012/04/24
  * �޸ļ�¼: 
  */
public interface IG212Info extends BaseModel {

	/**
	 * ״̬IDȡ��
	 *
	 * @return ״̬ID
	 */
	public String getPsdid();
	
	/**
	 * �Ƿ�ȷ��ȡ��
	 *
	 * @return �Ƿ�ȷ��
	 */
	public String getPsdconfirm();
	
	/**
	 * ״̬����ȡ��
	 * 
	 * @return ״̬����
	 */
	public String getPsdname();
	
	/**
	 * �Ƿ��Ͷ���ȡ��
	 *
	 * @return �Ƿ��Ͷ���
	 */
	public String getSms();

	/**
	 * �Ƿ����ʼ�ȡ��
	 *
	 * @return �Ƿ����ʼ�
	 */
	public String getEmail();


	/**
	 * ���̶���Idȡ��
	 * @return pdid ���̶���Id
	 */
	public String getPdid();
}