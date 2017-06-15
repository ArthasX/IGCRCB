/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.syslog.model.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.syslog.model.Mss00011Info;

/**
  * ����: mss00011ʵ��
  * ��������: mss00011ʵ��
  * ������¼: 2013/04/16
  * �޸ļ�¼: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="mss00011")
public class Mss00011VW extends BaseEntity implements Serializable,
		Cloneable, Mss00011Info {

	/** deviceid */
	@Id
	protected Integer deviceid;

	/** devicename */
	protected String devicename;

	/** devicetype */
	protected String devicetype;

	/** tempcounts */
	protected Integer tempcounts;

	/** devicestate */
	protected Integer devicestate;

	/** devicedesc */
	protected String devicedesc;
	
	protected String typeid;

	public String getTypeid() {
		return typeid;
	}

	public void setTypeid(String typeid) {
		this.typeid = typeid;
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
	 * devicetypeȡ��
	 *
	 * @return devicetype
	 */
	public String getDevicetype() {
		return devicetype;
	}

	/**
	 * devicetype�趨
	 *
	 * @param devicetype devicetype
	 */
	public void setDevicetype(String devicetype) {
		this.devicetype = devicetype;
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
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Serializable getPK() {
		return deviceid;
	}

	public Integer getDeviceid() {
		return deviceid;
	}

	public void setDeviceid(Integer deviceid) {
		this.deviceid = deviceid;
	}

	public Integer getTempcounts() {
		return tempcounts;
	}

	public void setTempcounts(Integer tempcounts) {
		this.tempcounts = tempcounts;
	}

	public Integer getDevicestate() {
		return devicestate;
	}

	public void setDevicestate(Integer devicestate) {
		this.devicestate = devicestate;
	}
	
	

}