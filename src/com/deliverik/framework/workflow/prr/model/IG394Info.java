/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prr.model;

import com.deliverik.framework.base.BaseModel;

/**
  * ����: ���Ѽ�¼��ӿ�
  * ��������: ���Ѽ�¼��ӿ�
  * ������¼: 2012/04/25
  * �޸ļ�¼: 
  */
public interface IG394Info extends BaseModel {
	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Integer getPnssid();

	/**
	 * ����idȡ��
	 *
	 * @return ����id
	 */
	public Integer getPrid();

	/**
	 * ״̬IDȡ��
	 *
	 * @return ״̬ID
	 */
	public String getPsdid();

	/**
	 * �ӵ�״̬ȡ��
	 *
	 * @return �ӵ�״̬
	 */
	public String getPsdconfirm();

	/**
	 * ��ɫIDȡ��
	 *
	 * @return ��ɫID
	 */
	public Integer getRoleid();

	/**
	 * �������û�IDȡ��
	 *
	 * @return �������û�ID
	 */
	public String getUserid();

	public String getNotifysmstime();

	public String getNotifyemailtime();

	public String getReportsmstime();

	public String getReportemailtime();
	
}