/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.soc.asset.model.condition;

/**
  * ����: SOC0107VW���������ӿ�
  * ��������: SOC0107VW���������ӿ�
  * ������¼: 2016/06/21
  * �޸ļ�¼: 
  */
public interface SOC0107VWSearchCond {
	/**
	 * �ʲ�IDȡ��
	 * @return �ʲ�ID
	 */
	public String getEiid();
	
	/**
	 * �ʲ�ģ��IDȡ��
	 * @return �ʲ�ģ��ID
	 */
	public String getEid();

	/**
	 * �ʲ����Դ�汾��ȡ��
	 * @return �ʲ����Դ�汾��
	 */
	public String getCiversion();
	
	/**
	 * �ʲ�ģ������IDȡ��
	 * @return �ʲ�ģ������ID
	 */
	public String getCid();
	
	/**
	 * �ʲ�ģ������ֵȡ��
	 * @return �ʲ�ģ������ֵ
	 */
	public String getCivalue();
	
	/**
	 * �ʲ�����С�汾��ȡ��
	 * @return �ʲ�����С�汾��
	 */
	public String getCismallversion();
	
	public String[] getCids();
	/**
	 * @return the id
	 */
	public Integer getId();
}