/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.syslog.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.syslog.model.Mss00005Info;

/**
  * ����: �澯��Ϣ���ʵ��
  * ��������: �澯��Ϣ���ʵ��
  * ������¼: 2013/03/28
  * �޸ļ�¼: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="mss00005")
public class Mss00005TB extends BaseEntity implements Serializable,
		Cloneable, Mss00005Info {

	/** alarmid */
	@Id
	protected Integer alarmid;

	/** devceid */
	protected Integer devceid;

	/** deviceip */
	protected String deviceip;

	/** devicename */
	protected String devicename;

	/** ruleid */
	protected Integer ruleid;

	/** ruleconditionid */
	protected Integer ruleconditionid;

	/** rulelevel */
	protected String rulelevel;

	/** alarmtime */
	protected String alarmtime;

	/** syslogmsg */
	protected String syslogmsg;

	/** syslogtime */
	protected String syslogtime;

	/** alarmstate */
	protected Integer alarmstate;
	
	
	
	/**
	 * alarmidȡ��
	 *
	 * @return alarmid
	 */
	public Integer getAlarmid() {
		return alarmid;
	}

	/**
	 * alarmid�趨
	 *
	 * @param alarmid alarmid
	 */
	public void setAlarmid(Integer alarmid) {
		this.alarmid = alarmid;
	}

	/**
	 * devceidȡ��
	 *
	 * @return devceid
	 */
	public Integer getDevceid() {
		return devceid;
	}

	/**
	 * devceid�趨
	 *
	 * @param devceid devceid
	 */
	public void setDevceid(Integer devceid) {
		this.devceid = devceid;
	}

	/**
	 * deviceipȡ��
	 *
	 * @return deviceip
	 */
	public String getDeviceip() {
		return deviceip;
	}

	/**
	 * deviceip�趨
	 *
	 * @param deviceip deviceip
	 */
	public void setDeviceip(String deviceip) {
		this.deviceip = deviceip;
	}

	/**
	 * devicenameȡ��
	 *
	 * @return devicename
	 */
	public String getDevicename() {
		return devicename;
	}

	/**
	 * devicename�趨
	 *
	 * @param devicename devicename
	 */
	public void setDevicename(String devicename) {
		this.devicename = devicename;
	}

	/**
	 * ruleidȡ��
	 *
	 * @return ruleid
	 */
	public Integer getRuleid() {
		return ruleid;
	}

	/**
	 * ruleid�趨
	 *
	 * @param ruleid ruleid
	 */
	public void setRuleid(Integer ruleid) {
		this.ruleid = ruleid;
	}

	/**
	 * ruleconditionidȡ��
	 *
	 * @return ruleconditionid
	 */
	public Integer getRuleconditionid() {
		return ruleconditionid;
	}

	/**
	 * ruleconditionid�趨
	 *
	 * @param ruleconditionid ruleconditionid
	 */
	public void setRuleconditionid(Integer ruleconditionid) {
		this.ruleconditionid = ruleconditionid;
	}

	/**
	 * rulelevelȡ��
	 *
	 * @return rulelevel
	 */
	public String getRulelevel() {
		return rulelevel;
	}

	/**
	 * rulelevel�趨
	 *
	 * @param rulelevel rulelevel
	 */
	public void setRulelevel(String rulelevel) {
		this.rulelevel = rulelevel;
	}

	/**
	 * alarmtimeȡ��
	 *
	 * @return alarmtime
	 */
	public String getAlarmtime() {
		return alarmtime;
	}

	/**
	 * alarmtime�趨
	 *
	 * @param alarmtime alarmtime
	 */
	public void setAlarmtime(String alarmtime) {
		this.alarmtime = alarmtime;
	}

	/**
	 * syslogmsgȡ��
	 *
	 * @return syslogmsg
	 */
	public String getSyslogmsg() {
		return syslogmsg;
	}

	/**
	 * syslogmsg�趨
	 *
	 * @param syslogmsg syslogmsg
	 */
	public void setSyslogmsg(String syslogmsg) {
		this.syslogmsg = syslogmsg;
	}

	/**
	 * syslogtimeȡ��
	 *
	 * @return syslogtime
	 */
	public String getSyslogtime() {
		return syslogtime;
	}

	/**
	 * syslogtime�趨
	 *
	 * @param syslogtime syslogtime
	 */
	public void setSyslogtime(String syslogtime) {
		this.syslogtime = syslogtime;
	}

	/**
	 * alarmstateȡ��
	 *
	 * @return alarmstate
	 */
	public Integer getAlarmstate() {
		return alarmstate;
	}

	/**
	 * alarmstate�趨
	 *
	 * @param alarmstate alarmstate
	 */
	public void setAlarmstate(Integer alarmstate) {
		this.alarmstate = alarmstate;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Serializable getPK() {
		return alarmid;
	}

}