/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.vir.model;

import com.deliverik.framework.base.BaseModel;

/**
  * ����: vCloud ServiceInstance�ӿ�
  * ��������: vCloud ServiceInstance�ӿ�
  * ������¼: 2014/02/25
  * �޸ļ�¼: 
  */
public interface VCD01Info extends BaseModel {

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