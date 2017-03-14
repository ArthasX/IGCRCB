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
import com.deliverik.infogovernor.syslog.model.Mss00001Info;

/**
  * ����: �豸��Ϣ��ʵ��
  * ��������: �豸��Ϣ��ʵ��
  * ������¼: 2013/03/28
  * �޸ļ�¼: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="mss00001")
public class Mss00001TB extends BaseEntity implements Serializable,
		Cloneable, Mss00001Info {

	/** deviceid */
	@Id
	@TableGenerator(
		name="MSS00001_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="MSS00001_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="MSS00001_TABLE_GENERATOR")
	protected Integer deviceid;

	/** typeid */
	protected String typeid;

	/** deviceip */
	protected String deviceip;
	
	/** deviceip2 */
	protected String deviceip2;

	/** devicename */
	protected String devicename;

	/** devicedesc */
	protected String devicedesc;

	/** devicestate */
	protected Integer devicestate;

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
	 * typeidȡ��
	 *
	 * @return typeid
	 */
	public String getTypeid() {
		return typeid;
	}

	/**
	 * typeid�趨
	 *
	 * @param typeid typeid
	 */
	public void setTypeid(String typeid) {
		this.typeid = typeid;
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
	 * devicedescȡ��
	 *
	 * @return devicedesc
	 */
	public String getDevicedesc() {
		return devicedesc;
	}

	/**
	 * devicedesc�趨
	 *
	 * @param devicedesc devicedesc
	 */
	public void setDevicedesc(String devicedesc) {
		this.devicedesc = devicedesc;
	}

	/**
	 * devicestateȡ��
	 *
	 * @return devicestate
	 */
	public Integer getDevicestate() {
		return devicestate;
	}

	/**
	 * devicestate�趨
	 *
	 * @param devicestate devicestate
	 */
	public void setDevicestate(Integer devicestate) {
		this.devicestate = devicestate;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Serializable getPK() {
		return deviceid;
	}

	public String getDeviceip2() {
		return deviceip2;
	}

	public void setDeviceip2(String deviceip2) {
		this.deviceip2 = deviceip2;
	}

}