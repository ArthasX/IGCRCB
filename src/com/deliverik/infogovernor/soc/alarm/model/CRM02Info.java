/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.alarm.model;

import com.deliverik.framework.base.BaseModel;

/**
  * ����: CRM02�ӿ�
  * ��������: CRM02�ӿ�
  * ������¼: 2013/07/30
  * �޸ļ�¼: 
  */
public interface CRM02Info extends BaseModel {

	/**
	 * collecttimeȡ��
	 *
	 * @return collecttime
	 */
	public String getCollecttime();

	/**
	 * tablenameȡ��
	 *
	 * @return tablename
	 */
	public String getTablename();

	/**
	 * statusȡ��
	 *
	 * @return status
	 */
	public String getStatus();

}