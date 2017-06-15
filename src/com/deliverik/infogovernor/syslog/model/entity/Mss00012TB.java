/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.syslog.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.syslog.model.Mss00012Info;

/**
  * 概述: MSS00012实体
  * 功能描述: MSS00012实体
  * 创建记录: 2013/04/25
  * 修改记录: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="MSS00012")
public class Mss00012TB extends BaseEntity implements Serializable,
		Cloneable, Mss00012Info {

	/** ID */
	@Id
	protected Integer id;

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
	
	protected Integer prid;

	public String getStarttime() {
		return starttime;
	}

	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}

	public String getEndtime() {
		return endtime;
	}

	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}

	/** isalarm */
	protected Integer isalarm;
	
	/** createtime */
	protected String createtime;
	/**确认时间*/
	protected String starttime;
	/**修复时间*/
	protected String endtime;
	
	
	
	
	
	protected Integer state;
	

	


	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	/**
	 * id取得
	 *
	 * @return id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * id设定
	 *
	 * @param id id
	 */
	public void setId(Integer id) {
		this.id = id;
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
		return id;
	}

	public String getCreatetime() {
		return createtime;
	}

	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}

	public Integer getPrid() {
		return prid;
	}

	public void setPrid(Integer prid) {
		this.prid = prid;
	}
	
	
}