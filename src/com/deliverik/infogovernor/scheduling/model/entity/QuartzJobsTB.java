package com.deliverik.infogovernor.scheduling.model.entity;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Transient;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.framework.user.model.entity.OrganizationTB;
import com.deliverik.infogovernor.scheduling.model.QuartzJobs;

/**
 * 
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name="QuartzJobs")
public class QuartzJobsTB extends BaseEntity implements Serializable, Cloneable, QuartzJobs {

	@Id
	@TableGenerator(
		    name="QUARTZJOBS_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE", 
		    pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE", 
		    pkColumnValue="QUARTZJOBS_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="QUARTZJOBS_TABLE_GENERATOR")

	
	protected Integer qjid;
	protected String qjname;
	protected String qjdesc;
	protected String qjtriname;
	protected String qjtrigrp;
	protected String qjcrtuser;
	protected String qjimpluser;
	protected String qjcrttime;
	protected String qjendtime;
	protected String qjtype;
	protected String qjstatus;
	protected String qjinfo;
	protected String qjtricron;
	
	protected String qjcrtusername;
	protected String qjimplusername;
	protected String qjperiodinfo;
	protected String qjorgid;
	protected String qjorgname;
	protected String qjassetid;
	protected String qjassettypeid;
	
	@Transient
	protected String qjdtime;

	/** 机构实体 */
	@OneToOne
	@JoinColumn(name="qjorgid", referencedColumnName="orgsyscoding", updatable=false, insertable= false)
	@Basic(fetch = FetchType.EAGER)
	@NotFound(action = NotFoundAction.IGNORE)
	protected OrganizationTB organizationTB;
	
	public OrganizationTB getOrganizationTB() {
		return organizationTB;
	}

	public void setOrganizationTB(OrganizationTB organizationTB) {
		this.organizationTB = organizationTB;
	}
	/**
	 * 
	 * @return 
	 */
	public Serializable getPK() {
		return qjid;
	}

	/**
	 * @return 
	 */
	public boolean equals(Object obj) {
		if (!(obj instanceof QuartzJobsTB))
			return false;
		QuartzJobs target = (QuartzJobs) obj;
		if (!(getQjid()==target.getQjid()))
			return false;

		return true;
	}

	public Integer getQjid() {
		return qjid;
	}

	public void setQjid(Integer qjid) {
		this.qjid = qjid;
	}

	public String getQjname() {
		return qjname;
	}

	public void setQjname(String qjname) {
		this.qjname = qjname;
	}

	public String getQjdesc() {
		return qjdesc;
	}

	public void setQjdesc(String qjdesc) {
		this.qjdesc = qjdesc;
	}

	public String getQjtriname() {
		return qjtriname;
	}

	public void setQjtriname(String qjtriname) {
		this.qjtriname = qjtriname;
	}

	public String getQjtrigrp() {
		return qjtrigrp;
	}

	public void setQjtrigrp(String qjtrigrp) {
		this.qjtrigrp = qjtrigrp;
	}

	public String getQjcrtuser() {
		return qjcrtuser;
	}

	public void setQjcrtuser(String qjcrtuser) {
		this.qjcrtuser = qjcrtuser;
	}

	public String getQjimpluser() {
		return qjimpluser;
	}

	public void setQjimpluser(String qjimpluser) {
		this.qjimpluser = qjimpluser;
	}

	public String getQjcrttime() {
		return qjcrttime;
	}

	public void setQjcrttime(String qjcrttime) {
		this.qjcrttime = qjcrttime;
	}

	public String getQjendtime() {
		return qjendtime;
	}

	public void setQjendtime(String qjendtime) {
		this.qjendtime = qjendtime;
	}

	public String getQjtype() {
		return qjtype;
	}

	public void setQjtype(String qjtype) {
		this.qjtype = qjtype;
	}

	public String getQjstatus() {
		return qjstatus;
	}

	public void setQjstatus(String qjstatus) {
		this.qjstatus = qjstatus;
	}

	public String getQjinfo() {
		return qjinfo;
	}

	public void setQjinfo(String qjinfo) {
		this.qjinfo = qjinfo;
	}

	public String getQjtricron() {
		return qjtricron;
	}

	public void setQjtricron(String qjtricron) {
		this.qjtricron = qjtricron;
	}
	
	public String getQjcrtusername() {
		return qjcrtusername;
	}

	public void setQjcrtusername(String qjcrtusername) {
		this.qjcrtusername = qjcrtusername;
	}

	public String getQjimplusername() {
		return qjimplusername;
	}

	public void setQjimplusername(String qjimplusername) {
		this.qjimplusername = qjimplusername;
	}

	public String getQjperiodinfo() {
		return qjperiodinfo;
	}

	public void setQjperiodinfo(String qjperiodinfo) {
		this.qjperiodinfo = qjperiodinfo;
	}

	public String getQjorgid() {
		return qjorgid;
	}

	public void setQjorgid(String qjorgid) {
		this.qjorgid = qjorgid;
	}

	public String getQjorgname() {
		if(getOrganizationTB()==null){
			return qjorgname;
		}else{
			return getOrganizationTB().getOrgname();
		}
		
	}

	public void setQjorgname(String qjorgname) {
		this.qjorgname = qjorgname;
	}

	public String getQjassetid() {
		return qjassetid;
	}

	public void setQjassetid(String qjassetid) {
		this.qjassetid = qjassetid;
	}

	public String getQjassettypeid() {
		return qjassettypeid;
	}

	public void setQjassettypeid(String qjassettypeid) {
		this.qjassettypeid = qjassettypeid;
	}

	public QuartzJobsTB clone(QuartzJobs qj){
		this.qjname = qj.getQjname();
		this.qjdesc = qj.getQjdesc();
		this.qjtriname = qj.getQjtriname();
		this.qjtrigrp = qj.getQjtrigrp();
		this.qjcrtuser = qj.getQjcrtuser();
		this.qjimpluser = qj.getQjimpluser();
		this.qjcrttime = qj.getQjcrttime();
		this.qjendtime = qj.getQjendtime();
		this.qjtype = qj.getQjtype();
		this.qjstatus = qj.getQjstatus();
		this.qjinfo = qj.getQjinfo();
		this.qjtricron = qj.getQjtricron();
		
		this.qjcrtusername = qj.getQjcrtusername();
		this.qjimplusername = qj.getQjimplusername();
		this.qjperiodinfo = qj.getQjperiodinfo();
		
		this.qjorgid = qj.getQjorgid();
		this.qjorgname = qj.getQjorgname();
		
		this.qjassetid = qj.getQjassetid();
		this.qjassettypeid = qj.getQjassettypeid();
		return this;
	}

	public String getQjdtime() {
		return qjdtime;
	}

	public void setQjdtime(String qjdtime) {
		this.qjdtime = qjdtime;
	}
	
}