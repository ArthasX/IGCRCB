package com.deliverik.infogovernor.soc.cim.form;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.framework.soc.asset.model.condition.SOC0107SearchCond;

@SuppressWarnings("serial")
public class IGCIM0138Form extends BaseForm implements SOC0107SearchCond{
	
	/** 资产ID */
	protected String eiid;

	/** 资产模型ID */
	protected String eid;
	
	/** 资产属性版本号 */
	protected String civersion;
	
	/** 资产模型属性ID */
	protected String cid;
	
	/** 资产模型属性值 */
	protected String civalue;

	/** 资产属性小版本号*/
	protected String cismallversion;

	public String getEiid() {
		return eiid;
	}

	public void setEiid(String eiid) {
		this.eiid = eiid;
	}

	public String getEid() {
		return eid;
	}

	public void setEid(String eid) {
		this.eid = eid;
	}

	public String getCiversion() {
		return civersion;
	}

	public void setCiversion(String civersion) {
		this.civersion = civersion;
	}

	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

	public String getCivalue() {
		return civalue;
	}

	public void setCivalue(String civalue) {
		this.civalue = civalue;
	}

	public String getCismallversion() {
		return cismallversion;
	}

	public void setCismallversion(String cismallversion) {
		this.cismallversion = cismallversion;
	}

	public String[] getCids() {
		// TODO Auto-generated method stub
		return null;
	}

	

}
