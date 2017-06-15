/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.soc.alarm.form;

import com.deliverik.framework.base.BaseForm;

/**
 *
 * @author wangxing
 * 2013.08.01
 */
@SuppressWarnings("serial")
public class IGALM0302Form extends BaseForm {
	
	protected String servername;
	
	protected String ip;
	
	protected String ip2;
	
	protected String serverid;
	
	protected String alarmstatus;
	
	protected String type;
	
	protected String maxalarmtime;
	
	protected String maxalarmnum;
	
	protected String[] ruletempids;
	
	protected String flag;
	

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String[] getRuletempids() {
		return ruletempids;
	}

	public void setRuletempids(String[] ruletempids) {
		this.ruletempids = ruletempids;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getServername() {
		return servername;
	}

	public void setServername(String servername) {
		this.servername = servername;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getIp2() {
		return ip2;
	}

	public void setIp2(String ip2) {
		this.ip2 = ip2;
	}

	public String getServerid() {
		return serverid;
	}

	public void setServerid(String serverid) {
		this.serverid = serverid;
	}

	public String getAlarmstatus() {
		return alarmstatus;
	}

	public void setAlarmstatus(String alarmstatus) {
		this.alarmstatus = alarmstatus;
	}

	public String getMaxalarmtime() {
		return maxalarmtime;
	}

	public void setMaxalarmtime(String maxalarmtime) {
		this.maxalarmtime = maxalarmtime;
	}

	public String getMaxalarmnum() {
		return maxalarmnum;
	}

	public void setMaxalarmnum(String maxalarmnum) {
		this.maxalarmnum = maxalarmnum;
	}
	
	
	
}
