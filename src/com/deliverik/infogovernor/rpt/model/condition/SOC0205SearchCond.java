/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.rpt.model.condition;

/**
  * ����: ����������������ӿ�
  * ��������: ����������������ӿ�
  * ������¼: 2012/06/06
  * �޸ļ�¼: 2012/08/10 ��ReportManageSearchCond�����޸�ΪSOC0205SearchCond
  */
public interface SOC0205SearchCond {
	/**
	 * rmName_likeȡ��
	 *
	 * @return rmName_like rmName_like
	 */
	public String getRmName_like();
	/**
	 * dateFromȡ��
	 *
	 * @return dateFrom dateFrom
	 */
	public String getDateFrom();
	/**
	 * dateToȡ��
	 *
	 * @return dateTo dateTo
	 */
	public String getDateTo();
	/**
	 * rmDateType_eqȡ��
	 *
	 * @return rmDateType_eq rmDateType_eq
	 */
	public String getRtdatetype_eq();
}