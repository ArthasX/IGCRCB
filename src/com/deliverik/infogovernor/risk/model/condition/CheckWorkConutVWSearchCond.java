/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.risk.model.condition;

/**
  * ����: ��鹤��ͳ�Ʊ�����������ӿ�
  * ��������: ��鹤��ͳ�Ʊ�����������ӿ�
  * ������¼: 2014/07/09
  * �޸ļ�¼: 
  */
public interface CheckWorkConutVWSearchCond {
	
	//��鷽ʽ��ѯ����
	public String getRcrtestmode();
	/**��ȡʱ��*/
	public String getDatetime();
	/**��ȡ����sql*/
	public String getQuart();
	/**��ȡ����sql*/
	public String getHalfyear();
	/**��ȡ��sql*/
	public String getYear();
	/**��ȡ����sql*/
	public String getCg() ;
}