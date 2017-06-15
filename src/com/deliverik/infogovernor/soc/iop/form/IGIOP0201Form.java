package com.deliverik.infogovernor.soc.iop.form;

import com.deliverik.framework.base.BaseForm;

/**
 * IPπ‹¿ÌFORM
 * 
 */
public class IGIOP0201Form extends BaseForm{

	private static final long serialVersionUID = 1L;
	

	private Integer eiid;
	
	private String eid;
	
	private String subnet;
	
	private String ipStatus;
	
	private String eiDesc;
	
	private String eiName;
	
	private Integer[] delEiids;
	
	

	public Integer[] getDelEiids() {
		return delEiids;
	}

	public void setDelEiids(Integer[] delEiids) {
		this.delEiids = delEiids;
	}
	

	public String getEiName() {
		return eiName;
	}

	public void setEiName(String eiName) {
		this.eiName = eiName;
	}

	public Integer getEiid() {
		return eiid;
	}

	public void setEiid(Integer eiid) {
		this.eiid = eiid;
	}

	public String getEid() {
		return eid;
	}

	public void setEid(String eid) {
		this.eid = eid;
	}

	public String getSubnet() {
		return subnet;
	}

	public void setSubnet(String subnet) {
		this.subnet = subnet;
	}

	public String getIpStatus() {
		return ipStatus;
	}

	public void setIpStatus(String ipStatus) {
		this.ipStatus = ipStatus;
	}

	public String getEiDesc() {
		return eiDesc;
	}

	public void setEiDesc(String eiDesc) {
		this.eiDesc = eiDesc;
	}
	
	
}
