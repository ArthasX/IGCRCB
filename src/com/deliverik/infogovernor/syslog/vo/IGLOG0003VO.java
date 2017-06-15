package com.deliverik.infogovernor.syslog.vo;

import com.deliverik.framework.base.BaseVO;

@SuppressWarnings("serial")
public class IGLOG0003VO extends BaseVO{
	/** 流程ID */
	protected Integer prid;
	
	/** 设备告警id */
	protected Integer id;
	
	/** 告警级别 */
	protected String rulelevel;
	
	/** devceid */
	protected Integer devceid;

	/** deviceip */
	protected String deviceip;

	/** devicename */
	protected String devicename;

	/** alarmtime */
	protected String createtime;

	/** syslogmsg */
	protected String alarmmsg;

	/** alarmstate */
	protected Integer isalarm;
	
	protected Integer state;
	
	/**确认时间*/
	protected String starttime;
	
	/**修复时间*/
	protected String endtime;

	public Integer getPrid() {
		return prid;
	}

	public void setPrid(Integer prid) {
		this.prid = prid;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRulelevel() {
		return rulelevel;
	}

	public void setRulelevel(String rulelevel) {
		this.rulelevel = rulelevel;
	}

	public Integer getDevceid() {
		return devceid;
	}

	public void setDevceid(Integer devceid) {
		this.devceid = devceid;
	}

	public String getDeviceip() {
		return deviceip;
	}

	public void setDeviceip(String deviceip) {
		this.deviceip = deviceip;
	}

	public String getDevicename() {
		return devicename;
	}

	public void setDevicename(String devicename) {
		this.devicename = devicename;
	}

	public String getCreatetime() {
		return createtime;
	}

	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}

	public String getAlarmmsg() {
		return alarmmsg;
	}

	public void setAlarmmsg(String alarmmsg) {
		this.alarmmsg = alarmmsg;
	}

	public Integer getIsalarm() {
		return isalarm;
	}

	public void setIsalarm(Integer isalarm) {
		this.isalarm = isalarm;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

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

	
}
