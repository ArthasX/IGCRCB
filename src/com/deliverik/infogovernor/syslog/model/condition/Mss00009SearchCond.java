/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.syslog.model.condition;

import java.util.List;

import com.deliverik.framework.model.CodeDetail;

/**
 * ����: mss00009���������ӿ� ��������: mss00009���������ӿ� ������¼: 2013/03/28 �޸ļ�¼:
 */
public interface Mss00009SearchCond {
	
	public String getState();
	
	public Integer[] getId();
	
	public String getWord_like();
	
	public String getEname();

	public String getAlarmtime_from();

	public String getAlarmtime_to();

	public String getEndtime_from();

	public String getEndtime_to();

	public String getStarttime_from();

	public String getStarttime_to();

	public String getIp_like();

	public String getPriority_eq();

	public String getEsyscoding();

	public String[] getPriority();
	
	public String getAlarmstate();
	
	public List<CodeDetail> getRuleli();
	
	public String[] getCvalue() ;
	

}