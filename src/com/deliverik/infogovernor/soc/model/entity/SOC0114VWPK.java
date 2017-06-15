package com.deliverik.infogovernor.soc.model.entity;

import java.io.Serializable;

import com.deliverik.framework.base.BasePK;

@SuppressWarnings("serial")
public class SOC0114VWPK extends BasePK implements Serializable {
	
	protected Integer domainid;
	protected Integer domainversion;
	protected Integer linkid;
	protected String linkorder;
	
	/**
	 * ¹¹Ôìº¯Êý
	 */
	public SOC0114VWPK() {

	}

	public SOC0114VWPK(Integer domainid, Integer domainversion, Integer linkid, String linkorder) {
		super();
		this.domainid = domainid;
		this.domainversion = domainversion;
		this.linkid = linkid;
		this.linkorder = linkorder;
	}

	
	
	public Integer getDomainid() {
		return domainid;
	}
	public void setDomainid(Integer domainid) {
		this.domainid = domainid;
	}
	public Integer getDomainversion() {
		return domainversion;
	}
	public void setDomainversion(Integer domainversion) {
		this.domainversion = domainversion;
	}
	public Integer getLinkid() {
		return linkid;
	}
	public void setLinkid(Integer linkid) {
		this.linkid = linkid;
	}
	public String getLinkorder() {
		return linkorder;
	}
	public void setLinkorder(String linkorder) {
		this.linkorder = linkorder;
	}

}
