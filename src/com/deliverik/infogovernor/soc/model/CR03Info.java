/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.model;

import com.deliverik.framework.base.BaseModel;

/**
  * ����: ����ԭ������������ϵ��ӿ�
  * ��������: ����ԭ������������ϵ��ӿ�
  * ������¼: 2013/04/08
  * �޸ļ�¼: 
  */
public interface CR03Info extends BaseModel {


	/**
	 * ��������ȡ��
	 *
	 * @return ��������
	 */
	public String getTablename();

	/**
	 * ������ʶȡ��
	 *
	 * @return ������ʶ
	 */
	public String getHost();
	
	/**
	 * ״̬ȡ��
	 * @return ״̬
	 */
	public String getStatus();

	/**
	 * ����ȡ��
	 * @return ����
	 */
	public Integer getType();
	
	
	/**
	 * IPȡ��
	 * @return
	 */
	public String getIp();
	
	
	public String getCollecttime();
	
	/**
	 * servernameȡ��
	 * @return
	 */
	public String getServername();

}