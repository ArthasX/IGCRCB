/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.syslog.model.condition;

/**
  * ����: �澯�����������������ʵ��
  * ��������: �澯�����������������ʵ��
  * ������¼: 2013/03/28
  * �޸ļ�¼: 
  */
public class Mss00003SearchCondImpl implements
		Mss00003SearchCond {
	/** ����id */
	protected Integer ruleconditionid;

	/** �ȶ����� */
	protected String alarmmsg;

	/** �ȶ����� */
	protected Integer alarmcondition;
	
	/** ����ģ��id */
	protected Integer ruletempid;
	
	/** ����ʱ�� */
	protected String createtime;
	
	/** �Ƿ���ģ���ʾ */
	protected String isTemp;

	/**
	 * ����idȡ��
	 */
	public Integer getRuleconditionid() {
		return ruleconditionid;
	}

	/**
	 * ����id�趨
	 */
	public void setRuleconditionid(Integer ruleconditionid) {
		this.ruleconditionid = ruleconditionid;
	}

	/**
	 * �ȶ�����ȡ��
	 */
	public String getAlarmmsg() {
		return alarmmsg;
	}

	/**
	 * �ȶ������趨
	 */
	public void setAlarmmsg(String alarmmsg) {
		this.alarmmsg = alarmmsg;
	}

	/**
	 * �ȶ�����ȡ��
	 */
	public Integer getAlarmcondition() {
		return alarmcondition;
	}

	/**
	 * �ȶ������趨
	 */
	public void setAlarmcondition(Integer alarmcondition) {
		this.alarmcondition = alarmcondition;
	}

	/**
	 * ����ģ��idȡ��
	 */
	public Integer getRuletempid() {
		return ruletempid;
	}

	/**
	 * ����ģ��id�趨
	 */
	public void setRuletempid(Integer ruletempid) {
		this.ruletempid = ruletempid;
	}

	/**
	 * ����ʱ��ȡ��
	 */
	public String getCreatetime() {
		return createtime;
	}

	/**
	 * ����ʱ���趨
	 */
	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}

	/**
	 * �Ƿ���ģ���ʾȡ��
	 */
	public String getIsTemp() {
		return isTemp;
	}

	/**
	 * �Ƿ���ģ���ʾ�趨
	 */
	public void setIsTemp(String isTemp) {
		this.isTemp = isTemp;
	}
	
	
	

}