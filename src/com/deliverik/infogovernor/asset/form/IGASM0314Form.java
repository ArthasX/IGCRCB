package com.deliverik.infogovernor.asset.form;

import com.deliverik.framework.base.BaseForm;

public class IGASM0314Form extends BaseForm {

	private static final long serialVersionUID = 1L;
	protected Integer eiid;
	protected String eiversion;
	protected String type;
	public Integer getEiid() {
		return eiid;
	}

	public void setEiid(Integer eiid) {
		this.eiid = eiid;
	}

	public String getEiversion() {
		return eiversion;
	}

	public void setEiversion(String eiversion) {
		this.eiversion = eiversion;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
