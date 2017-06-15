/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.soc.alarm.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.soc.alarm.model.CRM04Info;

/**
  * 概述: CRM04实体
  * 功能描述: CRM04实体
  * 创建记录: 2013/07/30
  * 修改记录: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="CRM04")
public  class CRM04TB extends BaseEntity implements Serializable,
		Cloneable, CRM04Info {

	/** alarmid */
	@Id
	@TableGenerator(
		name="CRM04_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="CRM04_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="CRM04_TABLE_GENERATOR")
	protected Integer alarmid;

	/** serverid */
	protected Integer serverid;

	/** RULETEMPID */
	protected Integer ruletempid;

	/** SERVERIP */
	protected String serverip;

	/** SERVERNAME */
	protected String servername;

	/** RULELEVEL */
	protected Integer rulelevel;

	/** ALARMTIME */
	protected String alarmtime;

	/** ALARMMSG */
	protected String alarmmsg;

	/** collecttime */
	protected String collecttime;

	/** ALARMSTATE */
	protected String alarmstate;
	
	/** category */
	protected String category;
	
	/** objectname */
	protected String objectname;
	
	/**
	 * ALARMID取得
	 *
	 * @return ALARMID
	 */
	public Integer getAlarmid() {
		return alarmid;
	}

	/**
	 * ALARMID设定
	 *
	 * @param ALARMID ALARMID
	 */
	public void setAlarmid(Integer alarmid) {
		this.alarmid = alarmid;
	}

	/**
	 * serverid取得
	 *
	 * @return serverid
	 */
	public Integer getServerid() {
		return serverid;
	}

	/**
	 * serverid设定
	 *
	 * @param serverid serverid
	 */
	public void setServerid(Integer serverid) {
		this.serverid = serverid;
	}

	/**
	 * RULETEMPID取得
	 *
	 * @return RULETEMPID
	 */
	public Integer getRuletempid() {
		return ruletempid;
	}

	/**
	 * RULETEMPID设定
	 *
	 * @param RULETEMPID RULETEMPID
	 */
	public void setRuletempid(Integer ruletempid) {
		this.ruletempid = ruletempid;
	}

	/**
	 * SERVERIP取得
	 *
	 * @return SERVERIP
	 */
	public String getServerip() {
		return serverip;
	}

	/**
	 * SERVERIP设定
	 *
	 * @param SERVERIP SERVERIP
	 */
	public void setServerip(String serverip) {
		this.serverip = serverip;
	}

	/**
	 * SERVERNAME取得
	 *
	 * @return SERVERNAME
	 */
	public String getServername() {
		return servername;
	}

	/**
	 * SERVERNAME设定
	 *
	 * @param SERVERNAME SERVERNAME
	 */
	public void setServername(String servername) {
		this.servername = servername;
	}

	/**
	 * RULELEVEL取得
	 *
	 * @return RULELEVEL
	 */
	public Integer getRulelevel() {
		return rulelevel;
	}

	/**
	 * RULELEVEL设定
	 *
	 * @param RULELEVEL RULELEVEL
	 */
	public void setRulelevel(Integer rulelevel) {
		this.rulelevel = rulelevel;
	}

	/**
	 * ALARMTIME取得
	 *
	 * @return ALARMTIME
	 */
	public String getAlarmtime() {
		return alarmtime;
	}

	/**
	 * ALARMTIME设定
	 *
	 * @param ALARMTIME ALARMTIME
	 */
	public void setAlarmtime(String alarmtime) {
		this.alarmtime = alarmtime;
	}

	/**
	 * ALARMMSG取得
	 *
	 * @return ALARMMSG
	 */
	public String getAlarmmsg() {
		return alarmmsg;
	}

	/**
	 * ALARMMSG设定
	 *
	 * @param ALARMMSG ALARMMSG
	 */
	public void setAlarmmsg(String alarmmsg) {
		this.alarmmsg = alarmmsg;
	}

	/**
	 * collecttime取得
	 *
	 * @return collecttime
	 */
	public String getCollecttime() {
		return collecttime;
	}

	/**
	 * collecttime设定
	 *
	 * @param collecttime collecttime
	 */
	public void setCollecttime(String collecttime) {
		this.collecttime = collecttime;
	}

	/**
	 * ALARMSTATE取得
	 *
	 * @return ALARMSTATE
	 */
	public String getAlarmstate() {
		return alarmstate;
	}

	/**
	 * ALARMSTATE设定
	 *
	 * @param ALARMSTATE ALARMSTATE
	 */
	public void setAlarmstate(String alarmstate) {
		this.alarmstate = alarmstate;
	}

	/**
	 * category取得
	 *
	 * @return category
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * category设定
	 *
	 * @param category category
	 */
	public void setCategory(String category) {
		this.category = category;
	}

	/**
	 * objectname取得
	 *
	 * @return objectname
	 */
	public String getObjectname() {
		return objectname;
	}
	
	/**
	 * objectname设定
	 *
	 * @param objectname objectname
	 */
	public void setObjectname(String objectname) {
		this.objectname = objectname;
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