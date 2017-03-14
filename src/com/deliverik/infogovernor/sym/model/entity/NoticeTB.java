package com.deliverik.infogovernor.sym.model.entity;

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
import com.deliverik.infogovernor.sym.model.Notice;

/**
 * 
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name="Notice")
public class NoticeTB extends BaseEntity implements Serializable, Cloneable, Notice {

	@Id
	@TableGenerator(
		    name="NOTICE_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE", 
		    pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE", 
		    pkColumnValue="NOTICE_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="NOTICE_TABLE_GENERATOR")
	protected Integer nid;
	
	protected String nname;
	
	protected String ndesc;
	
	protected String nuserid;
	
	protected String nusername;
	
	protected String norgid;
	
	protected String norgname;
	
	protected String ntime;
	
	protected String nattkey;
	
	//通知管理 add 2015-2-3 12:19:13 begin
	protected String userid;
	
	protected String roleid;
	
	protected String ntargettype;

	protected String ntargetuserid;

	protected String ntargetusername;

	protected String ntargetroleid;

	protected String ntargetrolename;
	//通知管理 add 2015-2-3 12:19:13 end
	/** 机构实体 */
	@OneToOne
	@JoinColumn(name="norgid", referencedColumnName="orgsyscoding", updatable=false, insertable= false)
	@Basic(fetch = FetchType.EAGER)
	@NotFound(action = NotFoundAction.IGNORE)
	protected OrganizationTB organizationTB;
	

	/**
	 * 
	 * @return 
	 */
	@Override
	public Serializable getPK() {
		return nid;
	}

	/**
	 * @return 
	 */
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof NoticeTB))
			return false;
		Notice target = (NoticeTB) obj;
		if (!(getNid()==target.getNid()))
			return false;

		return true;
	}

	public Integer getNid() {
		return nid;
	}

	public void setNid(Integer nid) {
		this.nid = nid;
	}

	public String getNname() {
		return nname;
	}

	public void setNname(String nname) {
		this.nname = nname;
	}

	public String getNdesc() {
		return ndesc;
	}

	public void setNdesc(String ndesc) {
		this.ndesc = ndesc;
	}

	public String getNtime() {
		return ntime;
	}

	public void setNtime(String ntime) {
		this.ntime = ntime;
	}

	public String getNattkey() {
		return nattkey;
	}

	public void setNattkey(String nattkey) {
		this.nattkey = nattkey;
	}
	
	public String getNuserid() {
		return nuserid;
	}

	public void setNuserid(String nuserid) {
		this.nuserid = nuserid;
	}

	public String getNusername() {
		return nusername;
	}

	public void setNusername(String nusername) {
		this.nusername = nusername;
	}

	public String getNorgid() {
		return norgid;
	}

	public void setNorgid(String norgid) {
		this.norgid = norgid;
	}

	public String getNorgname() {
		if(getOrganizationTB() == null) {
			return norgname;
		} else {
			return getOrganizationTB().getOrgname();
		}
	}

	public void setNorgname(String norgname) {
		this.norgname = norgname;
	}

	public NoticeTB clone(Notice a){
		this.nid = a.getNid();
		this.nname = a.getNname();
		this.ndesc = a.getNdesc();
		this.nuserid = a.getNuserid();
		this.nusername = a.getNusername();
		this.ntime = a.getNtime();
		this.nattkey = a.getNattkey();
		this.norgid = a.getNorgid();
		this.norgname = a.getNorgname();
		this.ntargettype = a.getNtargettype();
		this.ntargetuserid = a.getNtargetuserid();
		this.ntargetusername = a.getNtargetusername();
		this.ntargetroleid = a.getNtargetroleid();
		this.ntargetrolename = a.getNtargetrolename();
		return this;
	}

	public OrganizationTB getOrganizationTB() {
		return organizationTB;
	}

	public void setOrganizationTB(OrganizationTB organizationTB) {
		this.organizationTB = organizationTB;
	}

	public String getNtargettype() {
		return ntargettype;
	}

	public void setNtargettype(String ntargettype) {
		this.ntargettype = ntargettype;
	}

	public String getNtargetuserid() {
		return ntargetuserid;
	}

	public void setNtargetuserid(String ntargetuserid) {
		this.ntargetuserid = ntargetuserid;
	}

	public String getNtargetusername() {
		return ntargetusername;
	}

	public void setNtargetusername(String ntargetusername) {
		this.ntargetusername = ntargetusername;
	}

	public String getNtargetroleid() {
		return ntargetroleid;
	}

	public void setNtargetroleid(String ntargetroleid) {
		this.ntargetroleid = ntargetroleid;
	}

	public String getNtargetrolename() {
		return ntargetrolename;
	}

	public void setNtargetrolename(String ntargetrolename) {
		this.ntargetrolename = ntargetrolename;
	}

	/**
	 * userid   取得
	 * @return userid userid
	 */
	public String getUserid() {
		return userid;
	}

	/**
	 * userid   设定
	 * @param userid userid
	 */
	public void setUserid(String userid) {
		this.userid = userid;
	}

	/**
	 * roleid   取得
	 * @return roleid roleid
	 */
	public String getRoleid() {
		return roleid;
	}

	/**
	 * roleid   设定
	 * @param roleid roleid
	 */
	public void setRoleid(String roleid) {
		this.roleid = roleid;
	}

	
}

