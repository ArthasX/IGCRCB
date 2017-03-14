package com.deliverik.infogovernor.syslog.form;

import com.deliverik.framework.base.BaseForm;

@SuppressWarnings("serial")
public class IGLOG0022Form extends BaseForm{

	protected Integer ruleid;

	/** �������� */
	protected String rulename;

	/** �豸���� */
	protected String deviceid;
	
	/** �豸ip */
	protected String deviceip;
	
	/** �豸ip */
	protected String deviceip2;

	/** ���澯������� */
	protected Integer maxalarmnum;

	/** ���澯���ʱ�� */
	protected Integer maxalarmtime;

	/** ����״̬ */
	protected Integer rulestate;
	
	/** ��ѡ���������б� */
	protected String[] ruletempids;
	
	/** ������������ */
	protected String[] alarmconditions;
	
	/** �������ݼ��� */
	protected String[] alarmmsgs;
	
	protected String typeid;
	
	protected String devicename;
	
	protected String priority;
	
	protected String tempName;
	
	
	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public String getDevicename() {
		return devicename;
	}

	public void setDevicename(String devicename) {
		this.devicename = devicename;
	}

	public String getTypeid() {
		return typeid;
	}

	public void setTypeid(String typeid) {
		this.typeid = typeid;
	}

	/**
	 * ruleidȡ��
	 */
	public Integer getRuleid() {
		return ruleid;
	}

	/**
	 * ruleid�趨
	 */
	public void setRuleid(Integer ruleid) {
		this.ruleid = ruleid;
	}

	/**
	 * ��������ȡ��
	 */
	public String getRulename() {
		return rulename;
	}

	/**
	 * ���������趨
	 */
	public void setRulename(String rulename) {
		this.rulename = rulename;
	}

	/**
	 * ���澯�������ȡ��
	 */
	public Integer getMaxalarmnum() {
		return maxalarmnum;
	}

	/**
	 * ���澯��������趨
	 */
	public void setMaxalarmnum(Integer maxalarmnum) {
		this.maxalarmnum = maxalarmnum;
	}





	/**
	 * ���澯���ʱ��ȡ��
	 */
	public Integer getMaxalarmtime() {
		return maxalarmtime;
	}

	/**
	 * ���澯���ʱ���趨
	 */
	public void setMaxalarmtime(Integer maxalarmtime) {
		this.maxalarmtime = maxalarmtime;
	}

	/**
	 * ����״̬ȡ��
	 */
	public Integer getRulestate() {
		return rulestate;
	}

	/**
	 * ����״̬�趨
	 */
	public void setRulestate(Integer rulestate) {
		this.rulestate = rulestate;
	}

	

	public String getDeviceid() {
		return deviceid;
	}

	public void setDeviceid(String deviceid) {
		this.deviceid = deviceid;
	}

	/**
	 * �豸ipȡ��
	 */
	public String getDeviceip() {
		return deviceip;
	}

	/**
	 * �豸ip�趨
	 */
	public void setDeviceip(String deviceip) {
		this.deviceip = deviceip;
	}

	/**
	 * ��ѡ���������б�ȡ��
	 */
	public String[] getRuletempids() {
		return ruletempids;
	}

	/**
	 * ��ѡ���������б��趨
	 */
	public void setRuletempids(String[] ruletempids) {
		this.ruletempids = ruletempids;
	}

	/**
	 * ������������ȡ��
	 */
	public String[] getAlarmconditions() {
		return alarmconditions;
	}

	/**
	 * �������������趨
	 */
	public void setAlarmconditions(String[] alarmconditions) {
		this.alarmconditions = alarmconditions;
	}

	/**
	 * �������ݼ���ȡ��
	 */
	public String[] getAlarmmsgs() {
		return alarmmsgs;
	}

	/**
	 * �������ݼ����趨
	 */
	public void setAlarmmsgs(String[] alarmmsgs) {
		this.alarmmsgs = alarmmsgs;
	}

	public String getDeviceip2() {
		return deviceip2;
	}

	public void setDeviceip2(String deviceip2) {
		this.deviceip2 = deviceip2;
	}

	public String getTempName() {
		return tempName;
	}

	public void setTempName(String tempName) {
		this.tempName = tempName;
	}
	
}
