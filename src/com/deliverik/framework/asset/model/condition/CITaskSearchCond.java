/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.asset.model.condition;

/**
  * ����: �������������ӿ�
  * ��������: �������������ӿ�
  * ������¼: 2011/05/18
  * �޸ļ�¼: 
  */
public interface CITaskSearchCond {
	
	/**
	 * ״̬ȡ��
	 * @return ״̬
	 */
	public String getCitstatus_eq();
	
	/**
	 * ��������ȡ��
	 * @return ��������
	 */
	public String getCitdesc_like() ;
	
	/**
	 * ��ʼʱ��ȡ��
	 * @return ��ʼʱ��
	 */
	public String getCittime_from() ;
	
	/**
	 * ����ʱ��ȡ��
	 * @return ����ʱ��
	 */
	public String getCittime_to() ;

}