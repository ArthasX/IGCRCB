/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.alarm.model;

import com.deliverik.framework.base.BaseModel;

/**
  * ����: CRM09�ӿ�
  * ��������: CRM09�ӿ�
  * ������¼: 2013/07/30
  * �޸ļ�¼: 
  */
public interface CRM09Info extends BaseModel {

	/**
	 * RELATIONIDȡ��
	 *
	 * @return RELATIONID
	 */
	public Integer getRelationid();

	/**
	 * SERVERIDȡ��
	 *
	 * @return SERVERID
	 */
	public Integer getServerid();

	/**
	 * RULETEMPIDȡ��
	 *
	 * @return RULETEMPID
	 */
	public Integer getRuletempid();

	/**
	 * MAXALARMNUMȡ��
	 *
	 * @return MAXALARMNUM
	 */
	public Integer getMaxalarmnum();

	/**
	 * MAXALARMTIMEȡ��
	 *
	 * @return MAXALARMTIME
	 */
	public Integer getMaxalarmtime();
	
	public String getCreatetime();

}