/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.rpt.model.condition;

/**
  * ����: ������Դ��ͼ���������ӿ�
  * ��������: ������Դ��ͼ���������ӿ�
  * ������¼: 2011/11/24
  * �޸ļ�¼: 2012/08/09 ��ProcessRecordInfoVWSearchCond������ΪSOC0209SearchCond
  */
public interface SOC0209SearchCond {
	/**
	 * ���̷���ʱ��ȡ��
	 *
	 * @return ���̷���ʱ��
	 */
	public String getPropentime();

	
	/**
	 * ��������ȡ��
	 *
	 * @return ��������
	 */
	public String getPrtype();


}