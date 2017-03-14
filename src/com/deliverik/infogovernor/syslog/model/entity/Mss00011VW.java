/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.syslog.model.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.syslog.model.Mss00011Info;

/**
  * 概述: mss00011实体
  * 功能描述: mss00011实体
  * 创建记录: 2013/04/16
  * 修改记录: 
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
	 * devicetype取得
	 *
	 * @return devicetype
	 */
	public String getDevicetype() {
		return devicetype;
	}

	/**
	 * devicetype设定
	 *
	 * @param devicetype devicetype
	 */
	public void setDevicetype(String devicetype) {
		this.devicetype = devicetype;
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
	 * 主键取得
	 *
	 * @return 主键
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