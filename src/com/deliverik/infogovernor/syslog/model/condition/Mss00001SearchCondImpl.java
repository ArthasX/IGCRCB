/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.syslog.model.condition;

import java.io.Serializable;

/**
  * ����: �豸��Ϣ���������ʵ��
  * ��������: �豸��Ϣ���������ʵ��
  * ������¼: 2013/03/28
  * �޸ļ�¼: 
  */
public class Mss00001SearchCondImpl implements
		Mss00001SearchCond {
	
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
	
	protected String ip_like;
	
	protected String deviceip_like;
	

	public String getDeviceip_like() {
		return deviceip_like;
	}

	public void setDeviceip_like(String deviceip_like) {
		this.deviceip_like = deviceip_like;
	}

	public String getIp_like() {
		return ip_like;
	}

	public void setIp_like(String ip_like) {
		this.ip_like = ip_like;
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