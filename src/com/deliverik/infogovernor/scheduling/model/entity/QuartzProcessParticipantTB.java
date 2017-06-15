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
import com.deliverik.infogovernor.scheduling.model.QuartzProcessParticipant;

@SuppressWarnings("serial")
@Entity
@Table(name="QuartzProcessParticipant")
public class QuartzProcessParticipantTB extends BaseEntity implements Serializable, Cloneable, QuartzProcessParticipant {

	@Id
	@TableGenerator(
		    name="QUARTZPROCESSPARTICIPANT_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE", 
		    pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE", 
		    pkColumnValue="QUARTZPROCESSPARTICIPANT_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="QUARTZPROCESSPARTICIPANT_TABLE_GENERATOR")
	
	protected Integer qppid;
	protected Integer qprid;
	protected Integer qpproleid;
	protected String qpporgid;
	protected String qpporgname;
	protected String qpprolename;
	protected String qppuserid;
	protected String qppusername;
	protected String qpptype;
	protected String qppuserinfo;
	protected String qppcomment;
	protected String qppstatus;
	protected String qppattkey;
	protected String qppinittime;
	protected String qppproctime;
	/**
	 * 流程参与用户子状态
	 */
	protected String qppsubstatus;
	

	/** 机构实体 */
	@OneToOne
	@JoinColumn(name="qpporgid", referencedColumnName="orgsyscoding", updatable=false, insertable= false)
	@Basic(fetch = FetchType.EAGER)
	@NotFound(action = NotFoundAction.IGNORE)
	protected OrganizationTB organizationTB;
	
	public OrganizationTB getOrganizationTB() {
		return organizationTB;
	}

	public void setOrganizationTB(OrganizationTB organizationTB) {
		this.organizationTB = organizationTB;
	}
	
	public Serializable getPK() {
		return qppid;
	}

	public boolean equals(Object obj) {
		if (!(obj instanceof QuartzProcessParticipantTB))
			return false;
		QuartzProcessParticipant target = (QuartzProcessParticipant) obj;
		if (!(getQppid()==target.getQppid()))
			return false;

		return true;
	}

	public Integer getQppid() {
		return qppid;
	}

	public void setQppid(Integer qppid) {
		this.qppid = qppid;
	}

	public Integer getQprid() {
		return qprid;
	}

	public void setQprid(Integer qprid) {
		this.qprid = qprid;
	}

	public Integer getQpproleid() {
		return qpproleid;
	}

	public void setQpproleid(Integer qpproleid) {
		this.qpproleid = qpproleid;
	}

	public String getQpporgid() {
		return qpporgid;
	}

	public void setQpporgid(String qpporgid) {
		this.qpporgid = qpporgid;
	}

	public String getQpporgname() {
		if(getOrganizationTB()==null){
			return qpporgname;
		}else{
			return getOrganizationTB().getOrgname();
		}
		
	}

	public void setQpporgname(String qpporgname) {
		this.qpporgname = qpporgname;
	}

	public String getQpprolename() {
		return qpprolename;
	}

	public void setQpprolename(String qpprolename) {
		this.qpprolename = qpprolename;
	}

	public String getQppuserid() {
		return qppuserid;
	}

	public void setQppuserid(String qppuserid) {
		this.qppuserid = qppuserid;
	}

	public String getQppusername() {
		return qppusername;
	}

	public void setQppusername(String qppusername) {
		this.qppusername = qppusername;
	}

	public String getQpptype() {
		return qpptype;
	}

	public void setQpptype(String qpptype) {
		this.qpptype = qpptype;
	}

	public String getQppuserinfo() {
		return qppuserinfo;
	}

	public void setQppuserinfo(String qppuserinfo) {
		this.qppuserinfo = qppuserinfo;
	}

	public String getQppcomment() {
		return qppcomment;
	}

	public void setQppcomment(String qppcomment) {
		this.qppcomment = qppcomment;
	}

	public String getQppstatus() {
		return qppstatus;
	}

	public void setQppstatus(String qppstatus) {
		this.qppstatus = qppstatus;
	}

	public String getQppattkey() {
		return qppattkey;
	}

	public void setQppattkey(String qppattkey) {
		this.qppattkey = qppattkey;
	}

	public String getQppinittime() {
		return qppinittime;
	}

	public void setQppinittime(String qppinittime) {
		this.qppinittime = qppinittime;
	}

	public String getQppproctime() {
		return qppproctime;
	}

	public void setQppproctime(String qppproctime) {
		this.qppproctime = qppproctime;
	}


	public QuartzProcessParticipantTB clone(QuartzProcessParticipant qpp){
		this.qppattkey = qpp.getQppattkey();
		this.qppcomment = qpp.getQppcomment();
		this.qppid = qpp.getQppid();
		this.qppinittime = qpp.getQppinittime();
		this.qpporgid = qpp.getQpporgid();
		this.qppproctime = qpp.getQppproctime();
		this.qpproleid = qpp.getQpproleid();
		this.qpprolename = qpp.getQpprolename();
		this.qppstatus = qpp.getQppstatus();
		this.qpptype = qpp.getQpptype();
		this.qppuserid = qpp.getQppuserid();
		this.qppusername = qpp.getQppusername();
		this.qppuserinfo = qpp.getQppuserinfo();
		this.qprid = qpp.getQprid();
		this.qpporgname = qpp.getQpporgname();
		this.qppsubstatus = qpp.getQppsubstatus();
		return this;
	}

	public String getQppsubstatus() {
		return qppsubstatus;
	}

	public void setQppsubstatus(String qppsubstatus) {
		this.qppsubstatus = qppsubstatus;
	}


}
