/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.alarm.model;

import com.deliverik.framework.base.BaseModel;

/**
  * ����: CRM06�ӿ�
  * ��������: CRM06�ӿ�
  * ������¼: 2013/07/30
  * �޸ļ�¼: 
  */
public interface CRM06VWInfo extends BaseModel {

	/**
	 * serveridȡ��
	 *
	 * @return serverid
	 */
	public Integer getServerid();

	/**
	 * fileidȡ��
	 *
	 * @return fileid
	 */
	public Integer getFileid();

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
	public String getServertype();

	/**
	 * ipȡ��
	 *
	 * @return ip
	 */
	public String getIp();

	/**
	 * statusȡ��
	 *
	 * @return status
	 */
	public String getStatus();
	
	public String getIp2();
	
	public String getHost();
	
	/**
	 * �������ȡ��
	 * @return
	 */
	public Integer getTempcounts();
	
	public String getAlarmstatus();
	
	public Integer getHqserverid();
	public String getHqservername();

}