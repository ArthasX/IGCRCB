/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.dut.model.condition;

/**
  * ����: ��ʱ������Ϣ����������ӿ�
  * ��������: ��ʱ������Ϣ����������ӿ�
  * ������¼: 2012/04/05
  * �޸ļ�¼: 
  */
public interface DelaySearchCond {
	
	/**
	 * ����ʱ���ȡ��
	 * @return
	 */
	public String getDatetime_from();
	
	/**
	 * ����ʱ�䵽ȡ��
	 * @return
	 */
	public String getDatetime_to();
	
	/**
	 * ���뵥λȡ��
	 *
	 * @return ���뵥λ
	 */
	public String getOrgname_eq();
	
	/**
	 * �������ȡ��
	 *
	 * @return �������
	 */
	public String getTitle_like();
}