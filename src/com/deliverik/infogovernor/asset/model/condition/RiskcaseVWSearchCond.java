/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.asset.model.condition;

/**
  * ����: �����¼����������ӿ�
  * ��������: �����¼����������ӿ�
  * ������¼: 2014/07/18
  * �޸ļ�¼: 
  */
public interface RiskcaseVWSearchCond {
	public String getFcname();
	public String getFcorigin();
	public String getFccategory();
	public String getRiskcatchtime_from();
	public String getRiskcatchtime_to();
	public String getRiskid();
	public String getFcpolicy();
	public String getRiskreviewresult();
	public Integer getEiid();
	public String getVersion();
	/**
	 * �����¼�״̬ȡ��
	 *
	 * @return �����¼�״̬
	 */
	public String getEISTATUS();
}