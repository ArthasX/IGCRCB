/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.rdp.model;

import com.deliverik.framework.base.BaseModel;

/**
  * ����: ��־��Ϣ�ӿ�
  * ��������: ��־��Ϣ�ӿ�
  * ������¼: 2014/05/06
  * �޸ļ�¼: 
  */
public interface RealtimedetailInfo extends BaseModel {

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Integer getId();

	/**
	 * ��������ȡ��
	 *
	 * @return ��������
	 */
	public Integer getTaskid();

	/**
	 * ����ipȡ��
	 *
	 * @return ����ip
	 */
	public String getHostip();

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public String getContent();

}