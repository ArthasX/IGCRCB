/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
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
  * 概述: SYSLOG信息表实体
  * 功能描述: SYSLOG信息表实体
  * 创建记录: 2013/03/28
  * 修改记录: 
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
	 * ID取得
	 *
	 * @return ID
	 */
	public Integer getID() {
		return ID;
	}

	/**
	 * ID设定
	 *
	 * @param ID ID
	 */
	public void setID(Integer ID) {
		this.ID = ID;
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
	 * alarmmsg取得
	 *
	 * @return alarmmsg
	 */
	public String getAlarmmsg() {
		return alarmmsg;
	}

	/**
	 * alarmmsg设定
	 *
	 * @param alarmmsg alarmmsg
	 */
	public void setAlarmmsg(String alarmmsg) {
		this.alarmmsg = alarmmsg;
	}

	/**
	 * isalarm取得
	 *
	 * @return isalarm
	 */
	public Integer getIsalarm() {
		return isalarm;
	}

	/**
	 * isalarm设定
	 *
	 * @param isalarm isalarm
	 */
	public void setIsalarm(Integer isalarm) {
		this.isalarm = isalarm;
	}

	/**
	 * 主键取得
	 *
	 * @return 主键
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