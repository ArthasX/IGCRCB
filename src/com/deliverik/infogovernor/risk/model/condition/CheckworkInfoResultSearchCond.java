/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.risk.model.condition;

/**
  * ����: ��鹤����������������������ӿ�
  * ��������: ��鹤����������������������ӿ�
  * ������¼: 2014/09/02
  * �޸ļ�¼: 
  */
public interface CheckworkInfoResultSearchCond {

	

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Integer getCwirid();

	/**
	 * �������idȡ��
	 *
	 * @return �������id
	 */
	public Integer getCwrid();

	/**
	 * ��鹤��idȡ��
	 *
	 * @return ��鹤��id
	 */
	public Integer getRcrid();

}