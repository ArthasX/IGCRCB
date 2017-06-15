/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.alarm.model;

import com.deliverik.framework.base.BaseModel;

/**
  * ����: CRM03�ӿ�
  * ��������: CRM03�ӿ�
  * ������¼: 2013/07/30
  * �޸ļ�¼: 
  */
public interface CRM03Info extends BaseModel {

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
	 * hostȡ��
	 *
	 * @return host
	 */
	public String getHost();

	/**
	 * statusȡ��
	 *
	 * @return status
	 */
	public String getStatus();

	/**
	 * typeȡ��
	 *
	 * @return type
	 */
	public String getType();

	/**
	 * servernameȡ��
	 *
	 * @return servername
	 */
	public String getServername();

	/**
	 * servertypeȡ��
	 *
	 * @return servertype
	 */
	public Integer getServertype();

	/**
	 * ipȡ��
	 *
	 * @return ip
	 */
	public String getIp();

}