/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prd.model;

import com.deliverik.framework.base.BaseModel;

/**
  * ����: �����Ա�ӿ�
  * ��������: �����Ա�ӿ�
  * ������¼: 2013/09/03
  * �޸ļ�¼: 
  */
public interface IG335Info extends BaseModel {

	/**
	 * ״̬����IDȡ��
	 *
	 * @return ״̬����ID
	 */
	public String getPsdid();

	/**
	 * ������IDȡ��
	 *
	 * @return ������ID
	 */
	public String getPidid();

	/**
	 * ��ֵȡ��
	 * @return pivalue ��ֵ
	 */
	public String getPivalue();
	
	/**
	 * ȷ�Ͻڵ��Ƿ���ȡ��
	 * @return psdconfirm ȷ�Ͻڵ��Ƿ���
	 */
	public String getPsdconfirm();

	/**
	 * ��ȡ��
	 *
	 * @return ��
	 */
	public Integer getNotifyd();

	/**
	 * Сʱȡ��
	 *
	 * @return Сʱ
	 */
	public Integer getNotifyh();

	/**
	 * ��ȡ��
	 *
	 * @return ��
	 */
	public Integer getNotifym();
	
	/**
	 * �ϱ�_��ȡ��
	 * @return reportd �ϱ�_��
	 */
	public Integer getReportd();

	/**
	 * �ϱ�_Сʱȡ��
	 * @return reporth �ϱ�_Сʱ
	 */
	public Integer getReporth();

	/**
	 * �ϱ�_��ȡ��
	 * @return reportm �ϱ�_��
	 */
	public Integer getReportm();

	/**
	 * ��ɫIDȡ��
	 *
	 * @return ��ɫID
	 */
	public Integer getRoleid();
	
	/**
	 * �û�IDȡ��
	 *
	 * @return �û�ID
	 */
	public String getRolename();

	/**
	 * ����BLȡ��
	 *
	 * @return ����BL
	 */
	public String getProcessbl();
	
	/**
	 * �ϱ���ɫ������ȡ��
	 * @return rolemanager �ϱ���ɫ������
	 */
	public String getRolemanager();
	
	/**
	 * ֪ͨ��IDȡ��
	 * @return notifierids ֪ͨ��ID
	 */
	public String getNotifierids();
	
	/**
	 * ֪ͨ������ȡ��
	 * @return notifiernames ֪ͨ������
	 */
	public String getNotifiernames();

	/**
	 * ���̶���IDȡ��
	 * @return pdid
	 */
	public String getPdid();

}