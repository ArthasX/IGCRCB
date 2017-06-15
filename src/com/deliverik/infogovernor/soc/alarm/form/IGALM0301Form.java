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
public class IGALM0301Form extends BaseForm {
	
	protected String servername;
	
	protected String servername_like;
	
	protected String ip;
	
	protected String ip2;
	
	protected String ip_like;
	
	protected String serverid;
	
	protected String alarmstatus;
	
	protected String fileid;
	
	public String getFileid() {
		return fileid;
	}

	public void setFileid(String fileid) {
		this.fileid = fileid;
	}

	public String getServername_like() {
		return servername_like;
	}

	public void setServername_like(String servername_like) {
		this.servername_like = servername_like;
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

	public String getIp_like() {
		return ip_like;
	}

	public void setIp_like(String ip_like) {
		this.ip_like = ip_like;
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
	
	
	
}
