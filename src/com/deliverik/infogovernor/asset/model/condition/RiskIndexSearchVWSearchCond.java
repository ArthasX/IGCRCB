/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.asset.model.condition;

/**
  * ����: ����ָ���ѯ���������ӿ�
  * ��������: ����ָ���ѯ���������ӿ�
  * ������¼: 2014/07/25
  * �޸ļ�¼: 
  */
public interface RiskIndexSearchVWSearchCond {
	
	/**
	 * ָ������ ȡ��
	 */
	public String getEiname();
	
	/**
	 * ָ���� ȡ��
	 */
	public String getEilabel() ;
	
	/**
	 * ָ�����ȡ��
	 */
	public String getSyscoding();
	
	/**
	 * ָ����;ȡ��
	 */
	public String getIndexused();
	
	/**
	 * ��ֵȡ��
	 */
	public String getZbfz();
	
	/**
	 * ָ��������ȡ��
	 */
	public String getDutyuser();
	
	/**
	 * ָ�����β��� ȡ��
	 */
	public String getDutydepartment();
	
	/**
	 * �Ƿ�ؼ�ָ�� ȡ��
	 */
	public String getKeyindex();
	
	/**
	 * ָ������� ȡ��
	 */
	public String getMguserid();
	
	/**
	 * �Ǽ����� ��ʱ��ȡ��
	 */
	public String getEiStartDate();

	/**
	 * �Ǽ����� ��ʱ��ȡ��
	 */
	public String getEiEndDate();

	/**
	 * ����ʱ�� ��ʱ��ȡ��
	 */
	public String getEuStartDate();

	/**
	 * ����ʱ�� ��ʱ��ȡ��
	 */
	public String getEuEndDate();

	
	/**
	 * ָ������EIID ȡ��
	 */
	public String getEiid();

	/**
	 *  eiid�ų����ϻ�ȡ
	 * @return the eiid_NotIn
	 */
	public String getEiid_NotIn();
	
	/**
	 * eiid���ϻ�ȡ
	 * @return eiid_In
	 */
	public String getEiid_In();
}