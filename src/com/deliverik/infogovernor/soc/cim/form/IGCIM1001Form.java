package com.deliverik.infogovernor.soc.cim.form;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.framework.soc.asset.model.condition.SOC0437SearchCond;

/**
 * 表空间伐值设定画面FORM
 * 
 */
public class IGCIM1001Form extends BaseForm implements SOC0437SearchCond{

	private static final long serialVersionUID = 1L;
	
	protected String dB_eq;
	
	protected String instance_eq;
	
	protected String tablespace_eq;
	
	protected String eiid;
	
	protected String eid;
	
	protected String cvalue;

	public String getDB_eq() {
		return dB_eq;
	}

	public void setDB_eq(String db_eq) {
		dB_eq = db_eq;
	}

	public String getInstance_eq() {
		return instance_eq;
	}

	public void setInstance_eq(String instance_eq) {
		this.instance_eq = instance_eq;
	}

	public String getTablespace_eq() {
		return tablespace_eq;
	}

	public void setTablespace_eq(String tablespace_eq) {
		this.tablespace_eq = tablespace_eq;
	}

	public String getEiid() {
		return eiid;
	}

	public void setEiid(String eiid) {
		this.eiid = eiid;
	}

	public String getCvalue() {
		return cvalue;
	}

	public void setCvalue(String cvalue) {
		this.cvalue = cvalue;
	}

	public String getEid() {
		return eid;
	}

	public void setEid(String eid) {
		this.eid = eid;
	}
}
