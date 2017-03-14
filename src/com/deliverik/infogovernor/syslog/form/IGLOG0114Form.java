package com.deliverik.infogovernor.syslog.form;


import com.deliverik.framework.base.BaseForm;
import com.deliverik.infogovernor.syslog.model.condition.Mss00013SearchCond;

/**
 * @author Administrator
 *
 */
public class IGLOG0114Form extends BaseForm  implements Mss00013SearchCond{

	private static final long serialVersionUID = 1L;
	
	protected Integer [] id;
	
	protected  String[] cvalue;
	
	protected String ip_like;
	
	protected String content_like;
	
	/** deviceip */
	protected String deviceip;

	/** rulelevel */
	protected String rulelevel;

	/** alarmmsg */
	protected String alarmmsg;
	
	protected String ip_eq;
	
	protected String priority_eq;
	
	protected String content;
	
	
	public String getIp_like() {
		return ip_like;
	}
	public void setIp_like(String ip_like) {
		this.ip_like = ip_like;
	}
	public String getContent_like() {
		return content_like;
	}
	public void setContent_like(String content_like) {
		this.content_like = content_like;
	}
	
	public String[] getCvalue() {
		return cvalue;
	}

	public void setCvalue(String[] cvalue) {
		this.cvalue = cvalue;
	}

	public void setPriority_eq(String priority_eq) {
		this.priority_eq = priority_eq;
	}

	public Integer[] getId() {
		return id;
	}

	public void setId(Integer[] id) {
		this.id = id;
	}

	public String getDeviceip() {
		return deviceip;
	}

	public void setDeviceip(String deviceip) {
		this.deviceip = deviceip;
	}

	public String getRulelevel() {
		return rulelevel;
	}

	public void setRulelevel(String rulelevel) {
		this.rulelevel = rulelevel;
	}

	public String getAlarmmsg() {
		return alarmmsg;
	}

	public void setAlarmmsg(String alarmmsg) {
		this.alarmmsg = alarmmsg;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getIp_eq() {
		return ip_eq;
	}

	public void setIp_eq(String ip_eq) {
		this.ip_eq = ip_eq;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getPriority_eq() {
		return priority_eq;
	}


}
