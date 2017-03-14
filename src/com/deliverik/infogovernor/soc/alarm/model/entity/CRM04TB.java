/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
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
  * ����: CRM04ʵ��
  * ��������: CRM04ʵ��
  * ������¼: 2013/07/30
  * �޸ļ�¼: 
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
	 * ALARMIDȡ��
	 *
	 * @return ALARMID
	 */
	public Integer getAlarmid() {
		return alarmid;
	}

	/**
	 * ALARMID�趨
	 *
	 * @param ALARMID ALARMID
	 */
	public void setAlarmid(Integer alarmid) {
		this.alarmid = alarmid;
	}

	/**
	 * serveridȡ��
	 *
	 * @return serverid
	 */
	public Integer getServerid() {
		return serverid;
	}

	/**
	 * serverid�趨
	 *
	 * @param serverid serverid
	 */
	public void setServerid(Integer serverid) {
		this.serverid = serverid;
	}

	/**
	 * RULETEMPIDȡ��
	 *
	 * @return RULETEMPID
	 */
	public Integer getRuletempid() {
		return ruletempid;
	}

	/**
	 * RULETEMPID�趨
	 *
	 * @param RULETEMPID RULETEMPID
	 */
	public void setRuletempid(Integer ruletempid) {
		this.ruletempid = ruletempid;
	}

	/**
	 * SERVERIPȡ��
	 *
	 * @return SERVERIP
	 */
	public String getServerip() {
		return serverip;
	}

	/**
	 * SERVERIP�趨
	 *
	 * @param SERVERIP SERVERIP
	 */
	public void setServerip(String serverip) {
		this.serverip = serverip;
	}

	/**
	 * SERVERNAMEȡ��
	 *
	 * @return SERVERNAME
	 */
	public String getServername() {
		return servername;
	}

	/**
	 * SERVERNAME�趨
	 *
	 * @param SERVERNAME SERVERNAME
	 */
	public void setServername(String servername) {
		this.servername = servername;
	}

	/**
	 * RULELEVELȡ��
	 *
	 * @return RULELEVEL
	 */
	public Integer getRulelevel() {
		return rulelevel;
	}

	/**
	 * RULELEVEL�趨
	 *
	 * @param RULELEVEL RULELEVEL
	 */
	public void setRulelevel(Integer rulelevel) {
		this.rulelevel = rulelevel;
	}

	/**
	 * ALARMTIMEȡ��
	 *
	 * @return ALARMTIME
	 */
	public String getAlarmtime() {
		return alarmtime;
	}

	/**
	 * ALARMTIME�趨
	 *
	 * @param ALARMTIME ALARMTIME
	 */
	public void setAlarmtime(String alarmtime) {
		this.alarmtime = alarmtime;
	}

	/**
	 * ALARMMSGȡ��
	 *
	 * @return ALARMMSG
	 */
	public String getAlarmmsg() {
		return alarmmsg;
	}

	/**
	 * ALARMMSG�趨
	 *
	 * @param ALARMMSG ALARMMSG
	 */
	public void setAlarmmsg(String alarmmsg) {
		this.alarmmsg = alarmmsg;
	}

	/**
	 * collecttimeȡ��
	 *
	 * @return collecttime
	 */
	public String getCollecttime() {
		return collecttime;
	}

	/**
	 * collecttime�趨
	 *
	 * @param collecttime collecttime
	 */
	public void setCollecttime(String collecttime) {
		this.collecttime = collecttime;
	}

	/**
	 * ALARMSTATEȡ��
	 *
	 * @return ALARMSTATE
	 */
	public String getAlarmstate() {
		return alarmstate;
	}

	/**
	 * ALARMSTATE�趨
	 *
	 * @param ALARMSTATE ALARMSTATE
	 */
	public void setAlarmstate(String alarmstate) {
		this.alarmstate = alarmstate;
	}

	/**
	 * categoryȡ��
	 *
	 * @return category
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * category�趨
	 *
	 * @param category category
	 */
	public void setCategory(String category) {
		this.category = category;
	}

	/**
	 * objectnameȡ��
	 *
	 * @return objectname
	 */
	public String getObjectname() {
		return objectname;
	}
	
	/**
	 * objectname�趨
	 *
	 * @param objectname objectname
	 */
	public void setObjectname(String objectname) {
		this.objectname = objectname;
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