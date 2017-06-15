/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.vir.model;

import com.deliverik.framework.base.BaseModel;

/**
  * ����: ��Դ���������Ϣ��ӿ�
  * ��������: ��Դ���������Ϣ��ӿ�
  * ������¼: 2014/02/13
  * �޸ļ�¼: 
  */
public interface VIM03Info extends BaseModel {

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
     * ��ȡ��Ŀ����
     * @return ��Ŀ���� 
     */
    public String getPname();
    
	/**
     * ��ȡvcenter����
     * @return vcenter���� 
     */
    public Integer getVcid();

    /**
     * ��ȡvCenter����
     * @return vCenter���� 
     */
    public String getVcName();

	/**
	 * ģ������ȡ��
	 *
	 * @return ģ������
	 */
	public String getTemplateName();

	/**
	 * ���������������ȡ��
	 *
	 * @return ���������������
	 */
	public String getHostName();
	
	/**
	 * IP��ַȡ��
	 * @return ip IP��ַ
	 */
	public String getIp();

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
     * ��ȡ�Զ��������
     * @return �Զ�������� 
     */

	public String getProgress();
	
	/**
     * ��ȡ������������
     * @return ������������ 
     */
    public String getDatacenterName();

    /**
     * ��ȡ��Դ������
     * @return ��Դ������ 
     */
    public String getResourcePoolName();
    
    /**
     * ��ȡ���������
     * @return ��������� 
     */
    public String getOrgsyscoding();

    /**
     * ��ȡ��������
     * @return �������� 
     */
    public String getOrgname();
    /**
     * ��ȡ�û�id
     * @return �û�id 
     */
    public String getUserid();
    
    /**
     * ��ȡ�û�����
     * @return �û����� 
     */
    public String getUserName();
    
    /**
     * ��ȡ����ʱ��
     * @return ����ʱ�� 
     */
    public String getApplyTime();
    
    /**
     * ��ȡ����ʱ��
     * @return ����ʱ�� 
     */
    public String getExpiryTime();
 
    /**
     * ��ȡ������������id
     * @return ������������id 
     */
    public Integer getPrid();
    
    /**
	 * ״̬ȡ��
	 * @return status ״̬
	 */
	public String getStatus();
    
	public String getCpucost();

	public String getMemcost();

	public String getDiskcost();
}