/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.prr.model.condition;

/**
  * ����: �����˱���������ӿ�
  * ��������: �����˱���������ӿ�
  * ������¼: 2013/02/25
  * �޸ļ�¼: 
  */
public interface CopyReadUserSearchCond {

	/**
	 * ��������ȡ��
	 *
	 * @return ��������
	 */
	public String getPrtitle() ;
	
	/**
	 * �Ƿ�鿴��ʶȡ��
	 *
	 * @return �Ƿ�鿴��ʶ
	 */
	public String getIslook();
	
	
	/**
	 * ������idȡ��
	 *
	 * @return ������id
	 */
	public String getPruserid ();
	
	/**
	 * ��������ȡ��
	 *
	 * @return ��������
	 */
	public Integer getPrid();
}