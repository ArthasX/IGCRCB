/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.asset.model.condition;

/**
  * ����: ��ƶԱȽ����Ϣ����������ӿ�
  * ��������: ��ƶԱȽ����Ϣ����������ӿ�
  * ������¼: 2011/05/18
  * �޸ļ�¼: 
  */
public interface AuditResultSearchCond {

	/**
	 * ���ʱ��� ��ʼȡ��
	 * @return ���ʱ��� ��ʼ
	 */
	public String getAutupdtime();

	/**
	 * ���ʱ��� ����ȡ��
	 * @return ���ʱ��� ����
	 */
	public String getAutcomptime();
	
	/**
	 * �����������ȡ��
	 * @return �����������
	 */
	public Integer getAutid();
	
	/**
	 * �ʲ������ȡ��
	 * @return �ʲ������
	 */
	public String getEsyscoding();

}