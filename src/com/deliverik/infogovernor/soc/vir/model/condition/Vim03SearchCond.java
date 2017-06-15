/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.vir.model.condition;

import java.util.List;

/**
  * ����: ��Դ���������Ϣ����������ӿ�
  * ��������: ��Դ���������Ϣ����������ӿ�
  * ������¼: 2014/02/13
  * �޸ļ�¼: 
  */
public interface Vim03SearchCond {

    /**
     * ��ȡ��Ŀ����
     * @return ��Ŀ���� 
     */
    public Integer getPid_eq();
    
	/**
	 * �û�idȡ��
	 * @return userid_eq �û�id
	 */
	public String getUserid_eq();

	/**
	 * �Զ��������ȡ��
	 * @return progress_eq �Զ��������
	 */
	public String getProgress_eq();

	/**
	 * ���������ȡ��
	 * @return orgsyscoding_eq ���������
	 */
	public String getOrgsyscoding_eq();
	
	/**
     * ��ȡδ����
     * @return δ���� 
     */
    public boolean isProgressIsNull();
    
    /**
     * ��ȡ��������
     * @return �������� 
     */
    public Integer getPrid();
    
    /**
	 * ״̬ȡ��
	 * @return status ״̬
	 */
	public String getStatus();
	


	/**
	 * ����IDȡ��
	 * @return vcid ����ID
	 */
	public Integer getVcid();

	/**
	 * ��������ȡ��
	 * @return hostname ��������
	 */
	public String getHostname();
	
	/**
	 * ״̬ȡ��
	 * @return status_nq ״̬
	 */
	public String getStatus_nq();
	
	/**
	 * ����ID����ȡ��
	 * @return prid_in ����ID����
	 */
	public List<Integer> getPrid_in();
	
	/**
	 * �������ȡ��
	 * @return vmName �������
	 */
	public String getVmName();
}