/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prd.model;

import java.util.List;

import com.deliverik.framework.workflow.prd.model.entity.IG237TB;


/**
  * ����: ����֪ͨ���Խӿ�
  * ��������: ����֪ͨ���Խӿ�
  * ������¼: 2012/04/24
  * �޸ļ�¼: 
  */
public interface IG238Info {

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
	 * ֪ͨ��ȡ��
	 * 
	 * @return ֪ͨ��
	 */
	public List<IG237TB> getLst_ProcessNoticeStrategyUser();
	
	/**
	 * ֪ͨ��IDȡ��
	 * 
	 * @return ֪ͨ��ID
	 */
	public String getNotifierids();

	/**
	 * ֪ͨ������ȡ��
	 * 
	 * @return ֪ͨ������
	 */
	public String getNotifiernames();

}