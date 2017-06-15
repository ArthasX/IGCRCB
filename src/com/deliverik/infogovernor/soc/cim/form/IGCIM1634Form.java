package com.deliverik.infogovernor.soc.cim.form;

import com.deliverik.framework.base.BaseForm;

/**
 * 
 * @author Administrator
 *
 */
@SuppressWarnings("serial")
public class IGCIM1634Form extends BaseForm{
	
	protected String eiid;
	
	protected String eiversion;
	
	protected String eismallversion;
	
	protected String relationType;

	public String getEiid() {
		return eiid;
	}

	public void setEiid(String eiid) {
		this.eiid = eiid;
	}

	public String getEiversion() {
		return eiversion;
	}

	public void setEiversion(String eiversion) {
		this.eiversion = eiversion;
	}

	public String getEismallversion() {
		return eismallversion;
	}

	public void setEismallversion(String eismallversion) {
		this.eismallversion = eismallversion;
	}

	public String getRelationType() {
		return relationType;
	}

	public void setRelationType(String relationType) {
		this.relationType = relationType;
	}

	

}
