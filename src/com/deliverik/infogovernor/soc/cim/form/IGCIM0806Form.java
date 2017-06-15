package com.deliverik.infogovernor.soc.cim.form;

import java.util.List;

import com.deliverik.framework.base.BaseForm;

public class IGCIM0806Form extends BaseForm{
private String uuid;
	
	protected String name;
	
	protected String starttime;
	
	private String stoptime;
	
	protected String newstarttime;
	
	private String newstoptime;
	
	protected String executstatus;
	
	protected String collectType;
	
	protected String typename;
	
	private String periodtype;
	
	private String starthour;
	
	private String startminute;
	
	private String stophour;
	
	private String stopminute;
	
	private int resourceId;

	
	
	public void setTypename(String typename) {
		this.typename = typename;
	}
	
	

	public void setCollectType(String collectType) {
		this.collectType = collectType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStarttime() {
		return starttime;
	}

	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}

	public String getNewstarttime() {
		return newstarttime;
	}

	public void setNewstarttime(String newstarttime) {
		this.newstarttime = newstarttime;
	}

	public String getExecutstatus() {
		return executstatus;
	}

	public void setExecutstatus(String executstatus) {
		this.executstatus = executstatus;
	}

	public String getNewstoptime() {
		return newstoptime;
	}

	public String getPeriodtype() {
		return periodtype;
	}

	public String getStoprule() {
		return null;
	}

	public String getStoptime() {
		return stoptime;
	}


	public String getType() {
		return null;
	}

	public String getUuid() {
		return uuid;
	}

	public String getStartrule() {
		return null;
	}

	public Integer getTypeid() {
		return null;
	}

	

	public String getTypename() {
		return typename;
	}



	public List<String> getTypeNames() {
		return null;
	}

	public String getCollectType() {
		return null;
	}



	public void setPeriodtype(String periodtype) {
		this.periodtype = periodtype;
	}



	public void setStarthour(String starthour) {
		this.starthour = starthour;
	}



	public String getStarthour() {
		return starthour;
	}



	public void setStartminute(String startminute) {
		this.startminute = startminute;
	}



	public String getStartminute() {
		return startminute;
	}



	public void setStophour(String stophour) {
		this.stophour = stophour;
	}



	public String getStophour() {
		return stophour;
	}



	public void setStopminute(String stopminute) {
		this.stopminute = stopminute;
	}



	public String getStopminute() {
		return stopminute;
	}



	public void setUuid(String uuid) {
		this.uuid = uuid;
	}



	public void setStoptime(String stoptime) {
		this.stoptime = stoptime;
	}



	public void setNewstoptime(String newstoptime) {
		this.newstoptime = newstoptime;
	}



	public void setResourceId(int resourceId) {
		this.resourceId = resourceId;
	}



	public int getResourceId() {
		return resourceId;
	}

}
