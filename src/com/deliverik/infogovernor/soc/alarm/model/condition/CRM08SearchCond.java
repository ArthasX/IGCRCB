/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.alarm.model.condition;

import java.util.List;


/**
  * ����: CRM08���������ӿ�
  * ��������: CRM08���������ӿ�
  * ������¼: 2013/07/30
  * �޸ļ�¼: 
  */
public interface CRM08SearchCond {
	
	public String getTypeccid_eq();
	
	public String getTypecid_eq();
	
	public List<Integer> getRuletempids();
	
	public String getRuletempname();

	public Integer getTempstate();

}