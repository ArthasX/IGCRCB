/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.asset.model.condition;

/**
  * ����: ����ָ��ά�����������ӿ�
  * ��������: ����ָ��ά�����������ӿ�
  * ������¼: 2014/07/25
  * �޸ļ�¼: 
  */
public interface MaintenanceSearchCond {
	
	/**
	 * ��ȡ��ѯSQL
	 * @return searchSQL
	 */
	public String getSearchSQL();
	
	/**
	 * ��ȡ��ѯʱ��
	 * @return searchTime
	 */
	public String getSearchTime();
	
	/**
	 * ����ָ��IDȡ��
	 *
	 * @return ����ָ��ID
	 */
	public Integer getRIID();
}