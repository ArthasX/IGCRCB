/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.mnt.model;

import com.deliverik.framework.base.BaseModel;

/**
  * ����: ������ͱ�ӿ�
  * ��������: ������ͱ�ӿ�
  * ������¼: 2012/02/08
  * �޸ļ�¼: 
  */
public interface MonitorTypeInfo extends BaseModel {

	/**
	 * ����idȡ��
	 *
	 * @return ����id
	 */
	public Integer getMtId();

	/**
	 * �����������ȡ��
	 *
	 * @return �����������
	 */
	public String getMtName();

	/**
	 * ����ʱ��ȡ��
	 *
	 * @return ����ʱ��
	 */
	public String getMtCreateTime();

	/**
	 * ���β����ȡ��
	 *
	 * @return ���β����
	 */
	public String getMtSyscoding();

	/**
	 * ״̬ȡ��
	 *
	 * @return ״̬
	 */
	public String getDeleteFlag();

}