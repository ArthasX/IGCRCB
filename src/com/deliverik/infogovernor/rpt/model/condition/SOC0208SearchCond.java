/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.rpt.model.condition;

/**
  * ����: �¼��������Ч�ʼ��������ӿ�
  * ��������: �¼��������Ч�ʼ��������ӿ�
  * ������¼: 2011/11/23
  * �޸ļ�¼: 2012/08/10 ��ServeEfficiencySearchCond�����޸�ΪSOC0208SearchCond
  */
public interface SOC0208SearchCond {
	/**
	 * ���������·�ȡ��
	 * @return ���������·�
	 */
	public String getIsNotTime();
	
	/**
	 * ��������ȡ��
	 * @return ��������
	 */
	public String getPrtype();


}