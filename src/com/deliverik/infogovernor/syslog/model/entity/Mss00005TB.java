/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.syslog.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.syslog.model.Mss00005Info;

/**
  * 概述: 告警信息天表实体
  * 功能描述: 告警信息天表实体
  * 创建记录: 2013/03/28
  * 修改记录: 
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
	 * alarmid取得
	 *
	 * @return alarmid
	 */
	public Integer getAlarmid() {
		return alarmid;
	}

	/**
	 * alarmid设定
	 *
	 * @param alarmid alarmid
	 */
	public void setAlarmid(Integer alarmid) {
		this.alarmid = alarmid;
	}

	/**
	 * devceid取得
	 *
	 * @return devceid
	 */
	public Integer getDevceid() {
		return devceid;
	}

	/**
	 * devceid设定
	 *
	 * @param devceid devceid
	 */
	public void setDevceid(Integer devceid) {
		this.devceid = devceid;
	}

	/**
	 * deviceip取得
	 *
	 * @return deviceip
	 */
	public String getDeviceip() {
		return deviceip;
	}

	/**
	 * deviceip设定
	 *
	 * @param deviceip deviceip
	 */
	public void setDeviceip(String deviceip) {
		this.deviceip = deviceip;
	}

	/**
	 * devicename取得
	 *
	 * @return devicename
	 */
	public String getDevicename() {
		return devicename;
	}

	/**
	 * devicename设定
	 *
	 * @param devicename devicename
	 */
	public void setDevicename(String devicename) {
		this.devicename = devicename;
	}

	/**
	 * ruleid取得
	 *
	 * @return ruleid
	 */
	public Integer getRuleid() {
		return ruleid;
	}

	/**
	 * ruleid设定
	 *
	 * @param ruleid ruleid
	 */
	public void setRuleid(Integer ruleid) {
		this.ruleid = ruleid;
	}

	/**
	 * ruleconditionid取得
	 *
	 * @return ruleconditionid
	 */
	public Integer getRuleconditionid() {
		return ruleconditionid;
	}

	/**
	 * ruleconditionid设定
	 *
	 * @param ruleconditionid ruleconditionid
	 */
	public void setRuleconditionid(Integer ruleconditionid) {
		this.ruleconditionid = ruleconditionid;
	}

	/**
	 * rulelevel取得
	 *
	 * @return rulelevel
	 */
	public String getRulelevel() {
		return rulelevel;
	}

	/**
	 * rulelevel设定
	 *
	 * @param rulelevel rulelevel
	 */
	public void setRulelevel(String rulelevel) {
		this.rulelevel = rulelevel;
	}

	/**
	 * alarmtime取得
	 *
	 * @return alarmtime
	 */
	public String getAlarmtime() {
		return alarmtime;
	}

	/**
	 * alarmtime设定
	 *
	 * @param alarmtime alarmtime
	 */
	public void setAlarmtime(String alarmtime) {
		this.alarmtime = alarmtime;
	}

	/**
	 * syslogmsg取得
	 *
	 * @return syslogmsg
	 */
	public String getSyslogmsg() {
		return syslogmsg;
	}

	/**
	 * syslogmsg设定
	 *
	 * @param syslogmsg syslogmsg
	 */
	public void setSyslogmsg(String syslogmsg) {
		this.syslogmsg = syslogmsg;
	}

	/**
	 * syslogtime取得
	 *
	 * @return syslogtime
	 */
	public String getSyslogtime() {
		return syslogtime;
	}

	/**
	 * syslogtime设定
	 *
	 * @param syslogtime syslogtime
	 */
	public void setSyslogtime(String syslogtime) {
		this.syslogtime = syslogtime;
	}

	/**
	 * alarmstate取得
	 *
	 * @return alarmstate
	 */
	public Integer getAlarmstate() {
		return alarmstate;
	}

	/**
	 * alarmstate设定
	 *
	 * @param alarmstate alarmstate
	 */
	public void setAlarmstate(Integer alarmstate) {
		this.alarmstate = alarmstate;
	}

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Serializable getPK() {
		return alarmid;
	}

}