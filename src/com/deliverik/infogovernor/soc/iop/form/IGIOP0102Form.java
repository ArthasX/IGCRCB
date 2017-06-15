package com.deliverik.infogovernor.soc.iop.form;

import com.deliverik.framework.base.BaseForm;

/**
 * 设备影响分析画面FORM
 * 
 */
public class IGIOP0102Form extends BaseForm {

	private static final long serialVersionUID = 1L;

	protected String einame;
	protected String subnet;
	protected Integer eiid;
	protected String eid;
	protected Integer[] eiids;
	protected Integer[] delEiids;
	protected String[] eidesc;
	protected Integer upeiid;
	protected String upeidesc;
	
	
	
	
	public Integer[] getDelEiids() {
		return delEiids;
	}
	public void setDelEiids(Integer[] delEiids) {
		this.delEiids = delEiids;
	}
	public Integer getUpeiid() {
		return upeiid;
	}
	public void setUpeiid(Integer upeiid) {
		this.upeiid = upeiid;
	}
	public String getUpeidesc() {
		return upeidesc;
	}
	public void setUpeidesc(String upeidesc) {
		this.upeidesc = upeidesc;
	}
	public String[] getEidesc() {
		return eidesc;
	}
	public void setEidesc(String[] eidesc) {
		this.eidesc = eidesc;
	}
	public Integer[] getEiids() {
		return eiids;
	}
	public void setEiids(Integer[] eiids) {
		this.eiids = eiids;
	}
	public String getEid() {
		return eid;
	}
	public void setEid(String eid) {
		this.eid = eid;
	}
	public String getEiname() {
		return einame;
	}
	public void setEiname(String einame) {
		this.einame = einame;
	}
	public String getSubnet() {
		return subnet;
	}
	public void setSubnet(String subnet) {
		this.subnet = subnet;
	}
	public Integer getEiid() {
		return eiid;
	}
	public void setEiid(Integer eiid) {
		this.eiid = eiid;
	}

	
	

}
