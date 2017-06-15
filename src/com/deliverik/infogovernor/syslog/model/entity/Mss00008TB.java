/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.syslog.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.syslog.model.Mss00008Info;

/**
  * ����: SYSLOG��Ϣ��ʵ��
  * ��������: SYSLOG��Ϣ��ʵ��
  * ������¼: 2013/03/28
  * �޸ļ�¼: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="mss00008")
public class Mss00008TB extends BaseEntity implements Serializable,
		Cloneable, Mss00008Info {

	/** ID */
	@Id
	@TableGenerator(
		name="MSS00008_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="MSS00008_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="MSS00008_TABLE_GENERATOR")
	protected Integer ID;

	/** deviceid */
	protected Integer deviceid;

	/** deviceip */
	protected String deviceip;

	/** devicename */
	protected String devicename;

	/** rulelevel */
	protected String rulelevel;

	/** alarmmsg */
	protected String alarmmsg;

	/** isalarm */
	protected Integer isalarm;
	
	/** createtime */
	protected String createtime;
	
	protected String starttime;
	
	

	public String getStarttime() {
		return starttime;
	}

	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}

	/**
	 * IDȡ��
	 *
	 * @return ID
	 */
	public Integer getID() {
		return ID;
	}

	/**
	 * ID�趨
	 *
	 * @param ID ID
	 */
	public void setID(Integer ID) {
		this.ID = ID;
	}

	/**
	 * deviceidȡ��
	 *
	 * @return deviceid
	 */
	public Integer getDeviceid() {
		return deviceid;
	}

	/**
	 * deviceid�趨
	 *
	 * @param deviceid deviceid
	 */
	public void setDeviceid(Integer deviceid) {
		this.deviceid = deviceid;
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
	 * alarmmsgȡ��
	 *
	 * @return alarmmsg
	 */
	public String getAlarmmsg() {
		return alarmmsg;
	}

	/**
	 * alarmmsg�趨
	 *
	 * @param alarmmsg alarmmsg
	 */
	public void setAlarmmsg(String alarmmsg) {
		this.alarmmsg = alarmmsg;
	}

	/**
	 * isalarmȡ��
	 *
	 * @return isalarm
	 */
	public Integer getIsalarm() {
		return isalarm;
	}

	/**
	 * isalarm�趨
	 *
	 * @param isalarm isalarm
	 */
	public void setIsalarm(Integer isalarm) {
		this.isalarm = isalarm;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Serializable getPK() {
		return ID;
	}
	
	/**
	 * 
	 * @return
	 */
	
	public String getCreatetime() {
		return createtime;
	}
	
	/**
	 * 
	 * @param createtime
	 */
	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}
	
	

}