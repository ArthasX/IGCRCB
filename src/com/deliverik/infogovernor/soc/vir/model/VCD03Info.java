/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.vir.model;

import com.deliverik.framework.base.BaseModel;

/**
  * ����: ��Դ���������Ϣ�ӿ�
  * ��������: ��Դ���������Ϣ�ӿ�
  * ������¼: 2014/02/25
  * �޸ļ�¼: 
  */
public interface VCD03Info extends BaseModel {

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Integer getId();

	/**
	 * ��Ŀ����ȡ��
	 *
	 * @return ��Ŀ����
	 */
	public Integer getPid();

	/**
	 * vcloud����ȡ��
	 *
	 * @return vcloud����
	 */
	public Integer getVcid();
	
	/**
	 * vcloud����ȡ��
	 * @return vcname vcloud����
	 */
	public String getVcname();

	/**
	 * ģ��IDȡ��
	 *
	 * @return ģ��ID
	 */
	public Integer getTemplateid();
	
	/**
	 * ģ������ȡ��
	 * @return templateName ģ������
	 */
	public String getTemplateName();

	/**
	 * ���������������ȡ��
	 *
	 * @return ���������������
	 */
	public String getHostName();

	/**
	 * ������ȡ��
	 *
	 * @return ������
	 */
	public String getNetworkName();

	/**
	 * �������ȡ��
	 *
	 * @return �������
	 */
	public String getVmName();

	/**
	 * ���CPU����ȡ��
	 *
	 * @return ���CPU����
	 */
	public Integer getVmCpus();

	/**
	 * ����ڴ��Сȡ��
	 *
	 * @return ����ڴ��С
	 */
	public Integer getVmMem();

	/**
	 * ���Ӳ�̴�Сȡ��
	 *
	 * @return ���Ӳ�̴�С
	 */
	public Integer getVmDisk();

	/**
	 * �����ȡ��
	 *
	 * @return �����
	 */
	public String getNetWork();

	/**
	 * �洢����ȡ��
	 *
	 * @return �洢����
	 */
	public String getStorageProfile();

	/**
	 * ���������ȡ��
	 *
	 * @return ���������
	 */
	public String getOrgsyscoding();

	/**
	 * ��������ȡ��
	 *
	 * @return ��������
	 */
	public String getOrgname();

	/**
	 * �Զ��������ȡ��
	 *
	 * @return �Զ��������
	 */
	public String getProgress();

	/**
	 * �û�IDȡ��
	 *
	 * @return �û�ID
	 */
	public String getUserid();

	/**
	 * �û�����ȡ��
	 *
	 * @return �û�����
	 */
	public String getUserName();

	/**
	 * ����ʱ��ȡ��
	 *
	 * @return ����ʱ��
	 */
	public String getApplyTime();

	/**
	 * ����ʱ��ȡ��
	 *
	 * @return ����ʱ��
	 */
	public String getExpiryTime();

}