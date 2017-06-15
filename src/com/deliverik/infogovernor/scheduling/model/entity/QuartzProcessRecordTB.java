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

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.framework.user.model.entity.OrganizationTB;
import com.deliverik.infogovernor.scheduling.model.QuartzProcessRecord;


/**
 * 
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name="QuartzProcessRecord")
public class QuartzProcessRecordTB extends BaseEntity implements Serializable, Cloneable, QuartzProcessRecord {

	@Id
	@TableGenerator(
		    name="QUARTZPROCESSRECORD_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE", 
		    pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE", 
		    pkColumnValue="QUARTZPROCESSRECORD_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="QUARTZPROCESSRECORD_TABLE_GENERATOR")
	protected Integer qprid;
	protected String qprtype;
	protected String qprsubtype;
	protected String qprstatus;
	protected String qprsubstatus;
	protected String qprtitle;
	protected String qprdesc;
	protected String qpropentime;
	protected String qprclosetime;
	protected String qprplantime;
	protected String qprduration;
	protected String qprurgency;
	protected String qprimpact;
	protected Integer qprassetid;
	protected String qprassetname;
	protected String qprbusiness;
	protected String qprimplplan;
	protected String qprbackplan;
	protected String qprvfyplan;
	protected Integer qpid;
	protected String qpcode;
	protected String qpname;
	protected String qprinfo;
	protected Integer qprcorid;
	protected String qprcortype;
	protected String qprcortitle;
	protected String qprassetcategory;
	protected String qpruserid;
	protected String qprusername;
	protected Integer qprroleid;
	protected String qprrolename;
	protected String qprpdid;
	protected String qprpdname;
	protected String qprorgid;
	protected String qprorgname;
	protected String qprattkey;
	
	/** 机构实体 */
	@OneToOne
	@JoinColumn(name="qprorgid", referencedColumnName="orgsyscoding", updatable=false, insertable= false)
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
		return qprid;
	}

	/**
	 * @return 
	 */
	public boolean equals(Object obj) {
		if (!(obj instanceof QuartzProcessRecordTB))
			return false;
		QuartzProcessRecord target = (QuartzProcessRecord) obj;
		if (!(getQprid()==target.getQprid()))
			return false;

		return true;
	}

	public QuartzProcessRecordTB clone(QuartzProcessRecord qpr){
		this.qprassetid = qpr.getQprassetid();
		this.qprassetname = qpr.getQprassetname();
		this.qprbackplan = qpr.getQprbackplan();
		this.qprbusiness = qpr.getQprbusiness();
		this.qprclosetime = qpr.getQprclosetime();
		this.qprdesc = qpr.getQprdesc();
		this.qprduration = qpr.getQprduration();
		this.qprid = qpr.getQprid();
		this.qprimpact = qpr.getQprimpact();
		this.qprimplplan = qpr.getQprimplplan();
		this.qpropentime = qpr.getQpropentime();
		this.qprplantime = qpr.getQprplantime();
		this.qprstatus = qpr.getQprstatus();
		this.qprsubstatus = qpr.getQprsubstatus();
		this.qprtitle = qpr.getQprtitle();
		this.qprtype = qpr.getQprtype();
		this.qprurgency = qpr.getQprurgency();
		this.qprvfyplan = qpr.getQprvfyplan();
		this.qprinfo = qpr.getQprinfo();
		this.qpid=qpr.getQpid();
		this.qpcode=qpr.getQpcode();
		this.qpname=qpr.getQpname();
		this.qprsubtype=qpr.getQprsubtype();
		this.qprcortype=qpr.getQprcortype();
		this.qprcorid=qpr.getQprcorid();
		this.qprcortitle=qpr.getQprcortitle();
		this.qprassetcategory=qpr.getQprassetcategory();
		this.qprusername = qpr.getQprusername();
		this.qprrolename = qpr.getQprrolename();
		this.qpruserid = qpr.getQpruserid();
		this.qprroleid = qpr.getQprroleid();
		this.qprpdid = qpr.getQprpdid();
		this.qprpdname = qpr.getQprpdname();
		this.qprorgid = qpr.getQprorgid();
		this.qprorgname = qpr.getQprorgname();
		this.qprattkey = qpr.getQprattkey();
		return this;
	}

	public Integer getQprid() {
		return qprid;
	}

	public void setQprid(Integer qprid) {
		this.qprid = qprid;
	}

	public String getQprtype() {
		return qprtype;
	}

	public void setQprtype(String qprtype) {
		this.qprtype = qprtype;
	}

	public String getQprsubtype() {
		return qprsubtype;
	}

	public void setQprsubtype(String qprsubtype) {
		this.qprsubtype = qprsubtype;
	}

	public String getQprstatus() {
		return qprstatus;
	}

	public void setQprstatus(String qprstatus) {
		this.qprstatus = qprstatus;
	}

	public String getQprsubstatus() {
		return qprsubstatus;
	}

	public void setQprsubstatus(String qprsubstatus) {
		this.qprsubstatus = qprsubstatus;
	}

	public String getQprtitle() {
		return qprtitle;
	}

	public void setQprtitle(String qprtitle) {
		this.qprtitle = qprtitle;
	}

	public String getQprdesc() {
		return qprdesc;
	}

	public void setQprdesc(String qprdesc) {
		this.qprdesc = qprdesc;
	}

	public String getQpropentime() {
		return qpropentime;
	}

	public void setQpropentime(String qpropentime) {
		this.qpropentime = qpropentime;
	}

	public String getQprclosetime() {
		return qprclosetime;
	}

	public void setQprclosetime(String qprclosetime) {
		this.qprclosetime = qprclosetime;
	}

	public String getQprplantime() {
		return qprplantime;
	}

	public void setQprplantime(String qprplantime) {
		this.qprplantime = qprplantime;
	}

	public String getQprduration() {
		return qprduration;
	}

	public void setQprduration(String qprduration) {
		this.qprduration = qprduration;
	}

	public String getQprurgency() {
		return qprurgency;
	}

	public void setQprurgency(String qprurgency) {
		this.qprurgency = qprurgency;
	}

	public String getQprimpact() {
		return qprimpact;
	}

	public void setQprimpact(String qprimpact) {
		this.qprimpact = qprimpact;
	}

	public Integer getQprassetid() {
		return qprassetid;
	}

	public void setQprassetid(Integer qprassetid) {
		this.qprassetid = qprassetid;
	}

	public String getQprassetname() {
		return qprassetname;
	}

	public void setQprassetname(String qprassetname) {
		this.qprassetname = qprassetname;
	}

	public String getQprbusiness() {
		return qprbusiness;
	}

	public void setQprbusiness(String qprbusiness) {
		this.qprbusiness = qprbusiness;
	}

	public String getQprimplplan() {
		return qprimplplan;
	}

	public void setQprimplplan(String qprimplplan) {
		this.qprimplplan = qprimplplan;
	}

	public String getQprbackplan() {
		return qprbackplan;
	}

	public void setQprbackplan(String qprbackplan) {
		this.qprbackplan = qprbackplan;
	}

	public String getQprvfyplan() {
		return qprvfyplan;
	}

	public void setQprvfyplan(String qprvfyplan) {
		this.qprvfyplan = qprvfyplan;
	}

	public Integer getQpid() {
		return qpid;
	}

	public void setQpid(Integer qpid) {
		this.qpid = qpid;
	}

	public String getQpcode() {
		return qpcode;
	}

	public void setQpcode(String qpcode) {
		this.qpcode = qpcode;
	}

	public String getQpname() {
		return qpname;
	}

	public void setQpname(String qpname) {
		this.qpname = qpname;
	}

	public String getQprinfo() {
		return qprinfo;
	}

	public void setQprinfo(String qprinfo) {
		this.qprinfo = qprinfo;
	}

	public Integer getQprcorid() {
		return qprcorid;
	}

	public void setQprcorid(Integer qprcorid) {
		this.qprcorid = qprcorid;
	}

	public String getQprcortype() {
		return qprcortype;
	}

	public void setQprcortype(String qprcortype) {
		this.qprcortype = qprcortype;
	}

	public String getQprcortitle() {
		return qprcortitle;
	}

	public void setQprcortitle(String qprcortitle) {
		this.qprcortitle = qprcortitle;
	}

	public String getQprassetcategory() {
		return qprassetcategory;
	}

	public void setQprassetcategory(String qprassetcategory) {
		this.qprassetcategory = qprassetcategory;
	}

	public String getQpruserid() {
		return qpruserid;
	}

	public void setQpruserid(String qpruserid) {
		this.qpruserid = qpruserid;
	}

	public String getQprusername() {
		return qprusername;
	}

	public void setQprusername(String qprusername) {
		this.qprusername = qprusername;
	}

	public Integer getQprroleid() {
		return qprroleid;
	}

	public void setQprroleid(Integer qprroleid) {
		this.qprroleid = qprroleid;
	}

	public String getQprrolename() {
		return qprrolename;
	}

	public void setQprrolename(String qprrolename) {
		this.qprrolename = qprrolename;
	}

	public String getQprpdid() {
		return qprpdid;
	}

	public void setQprpdid(String qprpdid) {
		this.qprpdid = qprpdid;
	}

	public String getQprpdname() {
		return qprpdname;
	}

	public void setQprpdname(String qprpdname) {
		this.qprpdname = qprpdname;
	}

	public String getQprorgid() {
		return qprorgid;
	}

	public void setQprorgid(String qprorgid) {
		this.qprorgid = qprorgid;
	}

	public String getQprorgname() {
		if(getOrganizationTB()==null){
			return qprorgname;
		}else{
			return getOrganizationTB().getOrgname();
		}
		
	}

	public void setQprorgname(String qprorgname) {
		this.qprorgname = qprorgname;
	}
	
	public String getQprattkey() {
		return qprattkey;
	}
	public void setQprattkey(String qprattkey) {
		this.qprattkey = qprattkey;
	}
}
