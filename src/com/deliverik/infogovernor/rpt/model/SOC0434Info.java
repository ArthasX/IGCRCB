/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.rpt.model;

import com.deliverik.framework.base.BaseModel;

/**
  * ����: PVVIO�ӿ�
  * ��������: PVVIO�ӿ�
  * ������¼: 2012/08/20
  * �޸ļ�¼: 
  */
public interface SOC0434Info extends BaseModel {

	/**
	 * PVVIDȡ��
	 *
	 * @return PVVID
	 */
	public Integer getPVVID();

	/**
	 * SNȡ��
	 *
	 * @return SN
	 */
	public String getSN();

	/**
	 * PVIDȡ��
	 *
	 * @return PVID
	 */
	public String getPVID();

	/**
	 * SNAMEȡ��
	 *
	 * @return SNAME
	 */
	public String getSNAME();

	/**
	 * LUNIDȡ��
	 *
	 * @return LUNID
	 */
	public String getLUNID();

	/**
	 * PVSIZEȡ��
	 *
	 * @return PVSIZE
	 */
	public Integer getPVSIZE();

	/**
	 * ISUSEDȡ��
	 *
	 * @return ISUSED
	 */
	public String getISUSED();

	/**
	 * CREATEDATEȡ��
	 *
	 * @return CREATEDATE
	 */
	public String getCREATEDATE();

}