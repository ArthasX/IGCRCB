/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.mnt.model;

import com.deliverik.framework.base.BaseModel;

/**
  * ����: ������ͷ�ֵ��Ϣ�ӿ�
  * ��������: ������ͷ�ֵ��Ϣ�ӿ�
  * ������¼: 2012/02/07
  * �޸ļ�¼: 
  */
public interface MonitorTypeDefInfo extends BaseModel {

	/**
	 * ����idȡ��
	 *
	 * @return ����id
	 */
	public Integer getMtdId();

	/**
	 * �������idȡ��
	 *
	 * @return �������id
	 */
	public Integer getMtId();

	/**
	 * ��ֵ����ȡ��
	 *
	 * @return ��ֵ����
	 */
	public String getMtdName();

	/**
	 * ��ֵȡ��
	 *
	 * @return ��ֵ
	 */
	public String getMtdValue();

	/**
	 * ����ʱ��ȡ��
	 *
	 * @return ����ʱ��
	 */
	public String getMtdCreateTime();

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
	public String getMtdDes();
	
	/**
	 * �ȽϷ�ȡ��
	 * @return
	 */
	public String getCompare();
}