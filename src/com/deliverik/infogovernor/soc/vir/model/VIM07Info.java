/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.vir.model;

import com.deliverik.framework.base.BaseModel;

/**
  * ����: ���������Ϣ��ӿ�
  * ��������: ���������Ϣ��ӿ�
  * ������¼: 2014/03/24
  * �޸ļ�¼: 
  */
public interface VIM07Info extends BaseModel {

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Integer getId();

	/**
	 * �������ȡ��
	 *
	 * @return �������
	 */
	public Integer getVmid();
	
	/**
	 * ��ĿIDȡ��
	 * @return pid ��ĿID
	 */
	public Integer getPid();

	/**
	 * ��������ȡ��
	 *
	 * @return ��������
	 */
	public String getCtype();

	/**
	 * ��������ȡ��
	 *
	 * @return ��������
	 */
	public Integer getPrid();

	/**
	 * ��������ʱ��ȡ��
	 *
	 * @return ��������ʱ��
	 */
	public String getCtime();

	/**
	 * �������ʱ��ȡ��
	 *
	 * @return �������ʱ��
	 */
	public String getAtime();
	
	/**
	 * �����û�IDȡ��
	 * @return userid �����û�ID
	 */
	public String getUserid();

}