package com.deliverik.infogovernor.drm.form;

import com.deliverik.framework.base.BaseForm;

/**
 * …Ë±∏±‡º≠ª≠√ÊFORM
 * 
 */
public class IGDRM2103Form extends BaseForm{

	private static final long serialVersionUID = 1L;
	
	private String eiid;
	
	private String eid;
	
	private String cid;
	
	private Integer ciid;
	
	private String ename;

	private String esyscoding;

	private String civalue;

	private Integer civersion;

	private Integer cismallversion;

	private String viewMode;
	
	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getEsyscoding() {
		return esyscoding;
	}

	public void setEsyscoding(String esyscoding) {
		this.esyscoding = esyscoding;
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

	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

	public Integer getCiid() {
		return ciid;
	}

	public void setCiid(Integer ciid) {
		this.ciid = ciid;
	}

	public void setCivalue(String civalue) {
		this.civalue = civalue;
	}

	public String getCivalue() {
		return civalue;
	}

	public void setCiversion(Integer civersion) {
		this.civersion = civersion;
	}

	public Integer getCiversion() {
		return civersion;
	}

	public void setCismallversion(Integer cismallversion) {
		this.cismallversion = cismallversion;
	}

	public Integer getCismallversion() {
		return cismallversion;
	}

	public void setViewMode(String viewMode) {
		this.viewMode = viewMode;
	}

	public String getViewMode() {
		return viewMode;
	}
	
}
