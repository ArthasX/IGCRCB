/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.smr.model.condition;

/**
  * ����: �����ʵ������������ӿ�
  * ��������: �����ʵ������������ӿ�
  * ������¼: 2013/07/18
  * �޸ļ�¼: 
  */
public interface RegulatoryReportInstanceSearchCond {
	
	/**
	 * ���ʶȡ��
	 *
	 * @return ���ʶ
	 */
	public String getKey_eq();

	/**
	 * ״̬ȡ��
	 *
	 * @return ״̬
	 */
	public String getStatus_eq();
	
	/**
	 * ��ǰ��¼��useridȡ��
	 *
	 * @return ��ǰ��¼��userid
	 */
	public String getUserid();
	
	/**
	 * ����״̬��ȡ��
	 *
	 * @return ����״̬��
	 */
	public String getPsdname();
	
	/**
	 * ��������ȡ��
	 *
	 * @return ��������
	 */
	public String getPrtype();
	
	/**
	 * ʵ��idȡ��
	 *
	 * @return ʵ��id
	 */
	public Integer getInstanceid();
	
	public String getInituser();
	
	/**
	 *����ʼʱ��ȡ��
	 */
	public String getPropentime();
	
	/**
	 *�������ʱ��ȡ��
	 */
	public String getProclosetime();
	
	public String getOrderby();
	
	public String getPrtitle();
	
	/**
	 * ��������ID��ƥ��ȡ��
	 *
	 * @return prpdid_like ��������ID��ƥ��
	 */
	public String getPrpdid_like();
	
	/**
	 * ���Ƚ��������ʶȡ��
	 *
	 * @return orderby_quarter ���Ƚ��������ʶ
	 */
	public String getOrderby_quarter();
	
	/**
	 * ���ȱ���״̬ȡ��
	 *
	 * @return prdtatus ���ȱ���״̬
	 */
	public String getPrstatus();
	
	/**
	 * ���Ȳ�ѯ��ȡ��
	 * @return year ���Ȳ�ѯ��
	 */
	public String getYear();
	
	/**
	 * ���ȱ�ʶȡ��
	 * @return quarter ���ȱ�ʶ
	 */
	public String getQuarter();
	
	/**
	 * �������ѯ���ڵ���ȡ��
	 * @return year_GtEq �������ѯ���ڵ���
	 */
	public String getYear_GtEq();
	
	/**
	 * �������ѯ���ڵ���ȡ��
	 * @return year_GtEq �������ѯ���ڵ���
	 */
	public String getMonth();
	
	public String getReportman();
	
	public String getReportdepartment();

}