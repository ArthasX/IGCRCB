package com.deliverik.infogovernor.soc.cim.form;

import java.util.List;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.framework.soc.asset.model.condition.SOC0107SearchCond;
import com.deliverik.framework.soc.asset.model.condition.SOC0129SearchCond;

@SuppressWarnings("serial")
public class IGCIM0147Form extends BaseForm implements SOC0107SearchCond,SOC0129SearchCond{
	
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
	
	/** 模型层次码 */
	protected String esyscoding_q;
	
	/** 是否可继承标识，使用entity表中预留字段EKEY2, 0代表继承，1代表不继承*/
	protected String ekey2;
	
	public String getEkey2() {
		return ekey2;
	}

	public void setEkey2(String ekey2) {
		this.ekey2 = ekey2;
	}

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

	public String getClabel_q() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getCname() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Integer> getEiid_list() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getSreilabel_q() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getSrname_q() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getEsyscoding_q() {
		return esyscoding_q;
	}

	public void setEsyscoding_q(String esyscoding_q) {
		this.esyscoding_q = esyscoding_q;
	}

	public String[] getCids() {
		// TODO Auto-generated method stub
		return null;
	}

	public int getEiversion() {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see com.deliverik.framework.soc.asset.model.condition.SOC0129SearchCond#getCheckersion()
	 */
	public int getCheckersion() {
		// TODO Auto-generated method stub
		return 0;
	}

	public String getId() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
