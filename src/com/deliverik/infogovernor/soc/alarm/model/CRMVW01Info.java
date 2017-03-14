/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.alarm.model;

import com.deliverik.framework.base.BaseModel;

/**
  * ����: CRM01�ӿ�
  * ��������: CRM01�ӿ�
  * ������¼: 2013/07/30
  * �޸ļ�¼: 
  */
public interface CRMVW01Info extends BaseModel {

	/**
	 * hostȡ��
	 *
	 * @return host
	 */
	public String getHost();

	/**
	 * ipȡ��
	 *
	 * @return ip
	 */
	public String getIp();

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
	 * collecttimeȡ��
	 *
	 * @return collecttime
	 */
	public String getCollecttime();

	/**
	 * commandȡ��
	 *
	 * @return command
	 */
	public String getCommand();

	/**
	 * cdataorderȡ��
	 *
	 * @return cdataorder
	 */
	public Integer getCdataorder();

	/**
	 * cdataȡ��
	 *
	 * @return cdata
	 */
	public String getCdata();

	/**
	 * inserttimeȡ��
	 *
	 * @return inserttime
	 */
	public String getInserttime();

	/**
	 * categoryȡ��
	 *
	 * @return category
	 */
	public String getCategory();

	/**
	 * keysȡ��
	 *
	 * @return keys
	 */
	public String getKeys();
	
	
	public String getObjectname();

}