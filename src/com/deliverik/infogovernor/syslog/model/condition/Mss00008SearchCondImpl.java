/*
 * ���������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.syslog.model.condition;

/**
  * ����: SYSLOG��Ϣ����������ʵ��
  * ��������: SYSLOG��Ϣ����������ʵ��
  * ������¼: 2013/03/28
  * �޸ļ�¼: 
  */
public class Mss00008SearchCondImpl implements
		Mss00008SearchCond {
	/** �澯���ȼ���ʶ */
	protected String[] priority;
	
	/** ��ʼ�ĸ澯����ʱ�� */
	protected String alarmtime_from;
	
	/** �����ĸ澯����ʱ�� */
	protected String alarmtime_to;
	
	/** �澯�豸IP */
	protected String ip_like;
	
	/** �豸���� */
	protected String ename;
	
	/** �ؼ��� */
	protected String word_like;
	
	protected String esyscoding;
	
	protected String isalarm;
	
	
	public String getIsalarm() {
		return isalarm;
	}
	public void setIsalarm(String isalarm) {
		this.isalarm = isalarm;
	}
	public String getEsyscoding() {
		return esyscoding;
	}
	public void setEsyscoding(String esyscoding) {
		this.esyscoding = esyscoding;
	}
	
	public String getWord_like() {
		return word_like;
	}
	public void setWord_like(String word_like) {
		this.word_like = word_like;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getAlarmtime_from() {
		return alarmtime_from;
	}
	public void setAlarmtime_from(String alarmtime_from) {
		this.alarmtime_from = alarmtime_from;
	}
	public String getAlarmtime_to() {
		return alarmtime_to;
	}
	public void setAlarmtime_to(String alarmtime_to) {
		this.alarmtime_to = alarmtime_to;
	}
	public String getIp_like() {
		return ip_like;
	}
	public void setIp_like(String ip_like) {
		this.ip_like = ip_like;
	}
	public String[] getPriority() {
		return priority;
	}
	public void setPriority(String[] priority) {
		this.priority = priority;
	}
}