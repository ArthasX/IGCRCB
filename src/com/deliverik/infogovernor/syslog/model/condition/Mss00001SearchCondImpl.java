/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.syslog.model.condition;

import java.io.Serializable;

/**
  * 概述: 设备信息表检索条件实现
  * 功能描述: 设备信息表检索条件实现
  * 创建记录: 2013/03/28
  * 修改记录: 
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
	 * typeid取得
	 *
	 * @return typeid
	 */
	public String getTypeid() {
		return typeid;
	}

	/**
	 * typeid设定
	 *
	 * @param typeid typeid
	 */
	public void setTypeid(String typeid) {
		this.typeid = typeid;
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
	 * devicedesc取得
	 *
	 * @return devicedesc
	 */
	public String getDevicedesc() {
		return devicedesc;
	}

	/**
	 * devicedesc设定
	 *
	 * @param devicedesc devicedesc
	 */
	public void setDevicedesc(String devicedesc) {
		this.devicedesc = devicedesc;
	}

	/**
	 * devicestate取得
	 *
	 * @return devicestate
	 */
	public Integer getDevicestate() {
		return devicestate;
	}

	/**
	 * devicestate设定
	 *
	 * @param devicestate devicestate
	 */
	public void setDevicestate(Integer devicestate) {
		this.devicestate = devicestate;
	}

	/**
	 * 主键取得
	 *
	 * @return 主键
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