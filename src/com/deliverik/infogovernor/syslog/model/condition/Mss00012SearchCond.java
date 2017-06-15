/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.syslog.model.condition;

import java.util.List;

import com.deliverik.framework.model.CodeDetail;

/**
  * ����: MSS00012���������ӿ�
  * ��������: MSS00012���������ӿ�
  * ������¼: 2013/04/25
  * �޸ļ�¼: 
  */
public interface Mss00012SearchCond {
	
	public String getEndtime_from();

	public String getEndtime_to();

	public String getStarttime_from();

	public String getStarttime_to();
	
	public String getWord_like();
	
	public Integer[] getId();
	
	public String getEname();
	
    public List<CodeDetail> getRuleli();
	
	public String[] getCvalue() ;
	
	public String getAlarmtime_from();

	public String getAlarmtime_to();

	public String getIp_like();

	public String getPriority_eq();
	
	public String getEsyscoding();
	
	public String[] getPriority();
	
	public String getAlarmstate();
	
	public String getState();
}