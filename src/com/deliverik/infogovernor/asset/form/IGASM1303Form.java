package com.deliverik.infogovernor.asset.form;

import com.deliverik.framework.asset.model.condition.IG445SearchCond;
import com.deliverik.framework.base.BaseForm;

/**
 * 设备统计分析信息FORM
 * 
 */
@SuppressWarnings("serial")
public class IGASM1303Form extends BaseForm implements IG445SearchCond{


	/** 开始时间从*/
	protected String ciupdtime_to;
	
	/** 开始时间至 */
	protected String ciupdtime_from;
	
	protected String eid;
	
	protected String eiorgsyscoding_q;
	
	protected String type;//0设备存量 1新进设备
	
	protected String orgname;
	
	protected String orgcode;
	
	
	/**
	 * @return the orgcode
	 */
	public String getOrgcode() {
		return orgcode;
	}

	/**
	 * @param orgcode the orgcode to set
	 */
	public void setOrgcode(String orgcode) {
		this.orgcode = orgcode;
	}

	public String getOrgname() {
		return orgname;
	}

	public void setOrgname(String orgname) {
		this.orgname = orgname;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	public String getCiupdtime_from() {
		return ciupdtime_from;
	}

	public void setCiupdtime_from(String ciupdtime_from) {
		this.ciupdtime_from = ciupdtime_from;
	}

	public String getCiupdtime_to() {
		return ciupdtime_to;
	}

	public void setCiupdtime_to(String ciupdtime_to) {
		this.ciupdtime_to = ciupdtime_to;
	}

	public String getEid() {
		return eid;
	}

	public void setEid(String eid) {
		this.eid = eid;
	}

	public String getEiorgsyscoding_q() {
		return eiorgsyscoding_q;
	}

	public void setEiorgsyscoding_q(String eiorgsyscoding_q) {
		this.eiorgsyscoding_q = eiorgsyscoding_q;
	}
	
	
}
