/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.soc.asset.model;

import com.deliverik.framework.base.BaseModel;

/**
  * ����: timer02�ӿ�
  * ��������: timer02�ӿ�
  * ������¼: 2013/07/04
  * �޸ļ�¼: 
  */
public interface Timer02Info extends BaseModel {

	/**
	 * uuidȡ��
	 *
	 * @return uuid
	 */
	public String getUuid();

	/**
	 * nameȡ��
	 *
	 * @return name
	 */
	public String getName();

	/**
	 * typeȡ��
	 *
	 * @return type
	 */
	public String getTypename();

	/**
	 * collectdateȡ��
	 *
	 * @return collectdate
	 */
	public String getCollectdate();

	/**
	 * executruleȡ��
	 *
	 * @return executrule
	 */
	public String getExecutrule();

	/**
	 * periodtypeȡ��
	 *
	 * @return periodtype
	 */
	public String getPeriodtype();

	/**
	 * executstatusȡ��
	 *
	 * @return executstatus
	 */
	public String getExecutstatus();
	
	public String getExecutmessage();

}