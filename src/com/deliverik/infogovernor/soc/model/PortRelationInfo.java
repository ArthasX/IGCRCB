/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.model;

import com.deliverik.framework.base.BaseModel;

/**
  * ����: �˵��˹�ϵ��ӿ�
  * ��������: �˵��˹�ϵ��ӿ�
  * ������¼: 2013/01/17
  * �޸ļ�¼: 
  */
public interface PortRelationInfo extends BaseModel {

	/**
	 * HBAPort_WWNȡ��
	 *
	 * @return HBAPort_WWN
	 */
	public String getHBAPort_WWN();

	/**
	 * DevicesNameȡ��
	 *
	 * @return DevicesName
	 */
	public String getDevicesName();

	/**
	 * SymmetrixIDȡ��
	 *
	 * @return SymmetrixID
	 */
	public String getSymmetrixID();

	/**
	 * FANameȡ��
	 *
	 * @return FAName
	 */
	public String getFAName();

	/**
	 * FAPortNameȡ��
	 *
	 * @return FAPortName
	 */
	public String getFAPortName();

	/**
	 * HyperTypeȡ��
	 *
	 * @return HyperType
	 */
	public String getHyperType();

}