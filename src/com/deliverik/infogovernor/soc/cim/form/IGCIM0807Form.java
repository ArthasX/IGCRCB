package com.deliverik.infogovernor.soc.cim.form;


import javax.persistence.Id;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.framework.soc.asset.model.condition.Timer02SearchCond;

public class IGCIM0807Form extends BaseForm implements Timer02SearchCond{

	/** uuid */
	@Id
	protected String uuid;

	/** name */
	protected String name;

	/** type */
	protected String typename;

	/** collectdate */
	protected String collectdate;

	/** executrule */
	protected String executrule;

	/** periodtype */
	protected String periodtype;

	/** executstatus */
	protected String executstatus;

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTypename() {
		return typename;
	}

	public void setTypename(String typename) {
		this.typename = typename;
	}

	public String getCollectdate() {
		return collectdate;
	}

	public void setCollectdate(String collectdate) {
		this.collectdate = collectdate;
	}

	public String getExecutrule() {
		return executrule;
	}

	public void setExecutrule(String executrule) {
		this.executrule = executrule;
	}

	public String getPeriodtype() {
		return periodtype;
	}

	public void setPeriodtype(String periodtype) {
		this.periodtype = periodtype;
	}

	public String getExecutstatus() {
		return executstatus;
	}

	public void setExecutstatus(String executstatus) {
		this.executstatus = executstatus;
	}

	public String getType() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
