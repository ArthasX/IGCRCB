/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.dbm.model;

import com.deliverik.framework.base.BaseModel;

/**
  * ����: ȫ��IP���˽ӿ�
  * ��������: ȫ��IP���˽ӿ�
  * ������¼: 2012/11/07
  * �޸ļ�¼: 
  */
public interface Ip_FilterInfo extends BaseModel {

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Integer getId();

	/**
	 * IP��ַȡ��
	 *
	 * @return IP��ַ
	 */
	public String getIp();

	/**
	 * ���ʱ��ȡ��
	 *
	 * @return ���ʱ��
	 */
	public String getAddtime();

}