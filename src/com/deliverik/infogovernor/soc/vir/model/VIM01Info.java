/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.vir.model;

import com.deliverik.framework.base.BaseModel;

/**
  * ����: vCenter ServiceInstance�ӿ�
  * ��������: vCenter ServiceInstance�ӿ�
  * ������¼: 2014/02/12
  * �޸ļ�¼: 
  */
public interface VIM01Info extends BaseModel {

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Integer getVcid();

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public String getVcname();

	/**
	 * URLȡ��
	 *
	 * @return URL
	 */
	public String getVcurl();

	/**
	 * �û���ȡ��
	 *
	 * @return �û���
	 */
	public String getVcusername();

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public String getVcpassword();

	/**
	 * ״̬ȡ��
	 *
	 * @return ״̬
	 */
	public String getVcstatus();

}