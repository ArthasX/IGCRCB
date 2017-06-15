/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.mnt.model;

import com.deliverik.framework.base.BaseModel;

/**
  * ����: ��ض���ֵ��Ϣ��ӿ�
  * ��������: ��ض���ֵ��Ϣ��ӿ�
  * ������¼: 2012/02/07
  * �޸ļ�¼: 
  */
public interface MonitorObjectDefInfo extends BaseModel {

	/**
	 * ����idȡ��
	 *
	 * @return ����id
	 */
	public Integer getModId();

	/**
	 * ��ض���idȡ��
	 *
	 * @return ��ض���id
	 */
	public Integer getMoId();

	/**
	 * ����ʱ��ȡ��
	 *
	 * @return ����ʱ��
	 */
	public String getModCreateTime();

	/**
	 * ��ض���ֵ����ȡ��
	 *
	 * @return ��ض���ֵ����
	 */
	public String getModName();

	/**
	 * ��ض���ֵȡ��
	 *
	 * @return ��ض���ֵ
	 */
	public String getModValue();

	/**
	 * �����ȡ��
	 *
	 * @return �����
	 */
	public Integer getOrderNumber();

	/**
	 * ״̬ȡ��
	 *
	 * @return ״̬
	 */
	public String getDeleteFlag();
	
	/**
	 * ����ȡ��
	 * @return
	 */
	public String getModDes();
	
	/**
	 * �ȽϷ�ȡ��
	 * @return
	 */
	public String getCompare();

}