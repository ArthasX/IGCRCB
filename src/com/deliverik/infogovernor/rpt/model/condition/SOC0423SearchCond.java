/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.rpt.model.condition;

/**
  * ����: �����������������ӿ�
  * ��������: �����������������ӿ�
  * ������¼: 2012/07/17
  * �޸ļ�¼: 2012/08/09 ��CapacityObjectListSearchCond������ΪSOC0423SearchCond
  */
public interface SOC0423SearchCond {
	
	public String getName();

	public String getObjectType();
	
	public String getObjectName();

	public String getName_like();
	
	public Integer getStatus();
}