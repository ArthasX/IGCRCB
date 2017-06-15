package com.deliverik.infogovernor.integration.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.integration.model.Notification;

/**
 * 
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name="Notification")
public class NotificationTB extends BaseEntity implements Serializable, Cloneable, Notification {

	@Id
	@TableGenerator(
		    name="NOTIFICATION_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE", 
		    pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE", 
		    pkColumnValue="NOTIFICATION_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="NOTIFICATION_TABLE_GENERATOR")

	protected Integer nfid;
	protected String nfinitime;
	protected String nfsdrtime;
	protected String nfexptime;
	protected String nftitle;
	protected Integer nfsdrrid;
	protected String nfsdrrname;
	protected String nfsdruid;
	protected String nfsdruname;
	protected String nftype;
	protected String nftarget;
	protected String nfstatus;
	

	/**
	 * 
	 * @return 
	 */
	public Serializable getPK() {
		return nfid;
	}

	/**
	 * @return 
	 */
	public boolean equals(Object obj) {
		if (!(obj instanceof NotificationTB))
			return false;
		Notification target = (Notification) obj;
		if (!(getNfid()==target.getNfid()))
			return false;

		return true;
	}

	/* (non-Javadoc)
	 * @see com.deliverik.infogovernor.model.entity.Notification#getNfid()
	 */
	public Integer getNfid() {
		return nfid;
	}

	public void setNfid(Integer nfid) {
		this.nfid = nfid;
	}

	/* (non-Javadoc)
	 * @see com.deliverik.infogovernor.model.entity.Notification#getNfinitime()
	 */
	public String getNfinitime() {
		return nfinitime;
	}

	public void setNfinitime(String nfinitime) {
		this.nfinitime = nfinitime;
	}

	/* (non-Javadoc)
	 * @see com.deliverik.infogovernor.model.entity.Notification#getNfsdrtime()
	 */
	public String getNfsdrtime() {
		return nfsdrtime;
	}

	public void setNfsdrtime(String nfsdrtime) {
		this.nfsdrtime = nfsdrtime;
	}

	/* (non-Javadoc)
	 * @see com.deliverik.infogovernor.model.entity.Notification#getNfexptime()
	 */
	public String getNfexptime() {
		return nfexptime;
	}

	public void setNfexptime(String nfexptime) {
		this.nfexptime = nfexptime;
	}

	/* (non-Javadoc)
	 * @see com.deliverik.infogovernor.model.entity.Notification#getNftitle()
	 */
	public String getNftitle() {
		return nftitle;
	}

	public void setNftitle(String nftitle) {
		this.nftitle = nftitle;
	}

	/* (non-Javadoc)
	 * @see com.deliverik.infogovernor.model.entity.Notification#getNfsdrrid()
	 */
	public Integer getNfsdrrid() {
		return nfsdrrid;
	}

	public void setNfsdrrid(Integer nfsdrrid) {
		this.nfsdrrid = nfsdrrid;
	}

	/* (non-Javadoc)
	 * @see com.deliverik.infogovernor.model.entity.Notification#getNfsdrrname()
	 */
	public String getNfsdrrname() {
		return nfsdrrname;
	}

	public void setNfsdrrname(String nfsdrrname) {
		this.nfsdrrname = nfsdrrname;
	}

	/* (non-Javadoc)
	 * @see com.deliverik.infogovernor.model.entity.Notification#getNfsdruid()
	 */
	public String getNfsdruid() {
		return nfsdruid;
	}

	public void setNfsdruid(String nfsdruid) {
		this.nfsdruid = nfsdruid;
	}

	/* (non-Javadoc)
	 * @see com.deliverik.infogovernor.model.entity.Notification#getNfsdruname()
	 */
	public String getNfsdruname() {
		return nfsdruname;
	}

	public void setNfsdruname(String nfsdruname) {
		this.nfsdruname = nfsdruname;
	}

	/* (non-Javadoc)
	 * @see com.deliverik.infogovernor.model.entity.Notification#getNftype()
	 */
	public String getNftype() {
		return nftype;
	}

	public void setNftype(String nftype) {
		this.nftype = nftype;
	}

	/* (non-Javadoc)
	 * @see com.deliverik.infogovernor.model.entity.Notification#getNftarget()
	 */
	public String getNftarget() {
		return nftarget;
	}

	public void setNftarget(String nftarget) {
		this.nftarget = nftarget;
	}

	/* (non-Javadoc)
	 * @see com.deliverik.infogovernor.model.entity.Notification#getNfstatus()
	 */
	public String getNfstatus() {
		return nfstatus;
	}

	public void setNfstatus(String nfstatus) {
		this.nfstatus = nfstatus;
	}

}

