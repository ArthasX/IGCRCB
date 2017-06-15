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
public interface CRM06Info extends BaseModel {

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
	
	public String getAlarmstatus();
	
	public String getCreatemessage();
	public Integer getHqserverid();
	public String getHqservername();
	
	/**
	 * ������ת������Ӧ��ʽʱ��ķ���
	 */
	public String getTranToTime();

}