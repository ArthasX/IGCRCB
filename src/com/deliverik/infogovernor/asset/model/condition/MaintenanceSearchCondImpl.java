/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.asset.model.condition;

/**
  * ����: ����ָ��ά����������ʵ��
  * ��������: ����ָ��ά����������ʵ��
  * ������¼: 2014/07/25
  * �޸ļ�¼: 
  */
public class MaintenanceSearchCondImpl implements
		MaintenanceSearchCond {
	
	/** ��ѯSQL */
	protected String searchSQL;
	
	/**��ѯʱ��*/
	protected String searchTime;
	
	/** ����ָ��ID */
	protected Integer RIID;

	/**
	 * ��ȡ��ѯSQL
	 * @return searchSQL
	 */
	public String getSearchSQL() {
		return searchSQL;
	}

	/**
	 * ���ò�ѯSQL
	 * @param searchSQL
	 */
	public void setSearchSQL(String searchSQL) {
		this.searchSQL = searchSQL;
	}
	
	/**
	 * ��ȡ��ѯʱ��
	 * @return searchTime
	 */
	public String getSearchTime() {
		return searchTime;
	}

	/**
	 * ���ò�ѯʱ��
	 * @param searchTime
	 */
	public void setSearchTime(String searchTime) {
		this.searchTime = searchTime;
	}
	
	/**
	 * ����ָ��IDȡ��
	 *
	 * @return ����ָ��ID
	 */
	public Integer getRIID() {
		return RIID;
	}

	/**
	 * ����ָ��ID�趨
	 *
	 * @param RIID ����ָ��ID
	 */
	public void setRIID(Integer RIID) {
		this.RIID = RIID;
	}
}