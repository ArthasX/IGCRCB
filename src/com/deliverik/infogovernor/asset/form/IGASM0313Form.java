package com.deliverik.infogovernor.asset.form;

import com.deliverik.framework.base.BaseForm;

public class IGASM0313Form extends BaseForm {

	private static final long serialVersionUID = 1L;
	protected Integer eiid;
	protected String orgid;
	protected String orgname;
	protected String reciveUser;
	protected String eiiorgid;
	/** 设备当前版本号 */
	protected String eiversion;
	protected String type;
	
	
	
	
	public String getEiversion() {
		return eiversion;
	}

	public void setEiversion(String eiversion) {
		this.eiversion = eiversion;
	}

	public String getEiiorgid() {
		return eiiorgid;
	}

	public void setEiiorgid(String eiiorgid) {
		this.eiiorgid = eiiorgid;
	}

	public String getOrgname() {
		return orgname;
	}

	public void setOrgname(String orgname) {
		this.orgname = orgname;
	}

	public String getOrgid() {
		return orgid;
	}

	public void setOrgid(String orgid) {
		this.orgid = orgid;
	}

	public String getReciveUser() {
		return reciveUser;
	}

	public void setReciveUser(String reciveUser) {
		this.reciveUser = reciveUser;
	}

	public Integer getEiid() {
		return eiid;
	}

	public void setEiid(Integer eiid) {
		this.eiid = eiid;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
}
