/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.mnt.model;

import com.deliverik.framework.base.BaseModel;

/**
  * ����: �����������ӿ�
  * ��������: �����������ӿ�
  * ������¼: 2012/05/10
  * �޸ļ�¼: 
  */
public interface MonitorTaskObjectInfo extends BaseModel {

	/**
	 * ��ˮIDȡ��
	 *
	 * @return ��ˮID
	 */
	public Integer getMtoId();

	/**
	 * ����IDȡ��
	 *
	 * @return ����ID
	 */
	public Integer getMtId();

	/**
	 * ��������ȡ��
	 *
	 * @return ��������
	 */
	public String getMtoName();

	/**
	 * ������¼����ȡ��
	 *
	 * @return ������¼����
	 */
	public Integer getMtoRow();

}