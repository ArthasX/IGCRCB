/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prd.model;

import com.deliverik.framework.base.BaseModel;

/**
  * ����: ֪ͨ���Ի�����Ϣ�ӿ�
  * ��������: ֪ͨ���Ի�����Ϣ�ӿ�
  * ������¼: 2013/09/03
  * �޸ļ�¼: 
  */
public interface IG334Info extends BaseModel {

	/**
	 * ���̶���IDȡ��
	 *
	 * @return ���̶���ID
	 */
	public String getPdid();

	/**
	 * ����֪ͨȡ��
	 *
	 * @return ����֪ͨ
	 */
	public String getSms();

	/**
	 * ֪ͨ�ʼ�ȡ��
	 *
	 * @return ֪ͨ�ʼ�
	 */
	public String getEmail();
	
	/**
	 * ������IDȡ��
	 * @return pidid ������ID
	 */
	public String getPidid();
	
	/**
	 * ����������ȡ��
	 * @return pidname ����������
	 */
	public String getPidname();
	

	/**
	 * ��ȡ��
	 * @return notifyd ��
	 */
	public Integer getNotifyd();

	/**
	 * Сʱȡ��
	 * @return notifyh Сʱ
	 */
	public Integer getNotifyh();
	/**
	 * ��ȡ��
	 * @return notifym ��
	 */
	public Integer getNotifym();
	/**
	 * ��ɫIDȡ��
	 * @return roleid ��ɫID
	 */
	public Integer getRoleid() ;

	/**
	 * ����BLȡ��
	 * @return processbl ����BL
	 */
	public String getProcessbl();

}