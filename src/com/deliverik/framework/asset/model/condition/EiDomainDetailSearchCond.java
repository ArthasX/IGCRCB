/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.asset.model.condition;

/**
  * ����: �ʲ�����ϸ����������ӿ�
  * ��������: �ʲ�����ϸ����������ӿ�
  * ������¼: 2011/04/20
  * �޸ļ�¼: 
  */
public interface EiDomainDetailSearchCond {
	
	/**��ȡ�ʲ���ID**/
	public Integer getEiddid();
	
	/**��ȡ�ʲ���汾**/
	public Integer getEiddversion();
	
	public String getDeleteflag();

}