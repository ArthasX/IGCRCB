/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.syslog.model.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.syslog.model.Mss00006Info;

/**
  * 概述: 告警信息月表实体
  * 功能描述: 告警信息月表实体
  * 创建记录: 2013/03/28
  * 修改记录: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="mss00006")
public class Mss00006TB extends BaseEntity implements Serializable,
		Cloneable, Mss00006Info {

	/** alarmid */
	@Id
	@TableGenerator(
		name="MSS00006_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="MSS00006_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="MSS00006_TABLE_GENERATOR")
	protected Integer alarmid;

	/** deviceid */
	protected Integer deviceid;

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
	
	/**systime trigger*/
	protected java.util.Date systime;
	
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
	 * deviceid取得
	 *
	 * @return deviceid
	 */
	public Integer getDeviceid() {
		return deviceid;
	}

	/**
	 * deviceid设定
	 *
	 * @param deviceid deviceid
	 */
	public void setDeviceid(Integer deviceid) {
		this.deviceid = deviceid;
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

	/**
	 * systime取得
	 *
	 * @return systime systime
	 */
	public Date getSystime() {
		return systime;
	}

	/**
	 * systime设定
	 *
	 * @param systime systime
	 */
	public void setSystime(Date systime) {
		this.systime = systime;
	}
	

}