/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.rpt.model.condition;

/**
  * ����: ����ģ����������ӿ�
  * ��������: ����ģ����������ӿ�
  * ������¼: 2012/06/06
  * �޸ļ�¼: 2012/08/10 ��ReportTemplateSearchCond�����޸�ΪSOC0207SearchCond
  */
public interface SOC0207SearchCond {
	/**
	 * rtname_likeȡ��
	 *
	 * @return rtname_like rtname_like
	 */
	public String getRtname_like();
	/**
	 * rtdatetype_eqȡ��
	 *
	 * @return rtdatetype_eq rtdatetype_eq
	 */
	public String getRtdatetype_eq();
}