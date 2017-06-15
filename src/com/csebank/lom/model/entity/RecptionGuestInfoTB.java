/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.csebank.lom.model.entity;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.csebank.lom.model.RecptionGuestInfo;
import com.deliverik.framework.user.model.entity.OrganizationTB;


/**
 * 
 * �Ӵ����˲�ѯʵ��
 * @author piaow@deliverik.com
 * 
 */
@SuppressWarnings("serial")
@javax.persistence.Entity
@Table(name="RecptionGuestInfo")
public class RecptionGuestInfoTB implements Serializable, Cloneable, RecptionGuestInfo {

	@Id
	protected Integer rid;

	/** �Ӵ��������� */
	protected String rname;
	
	/** ��Ҫ���벿�� */
	protected String rapporgid;
	
	/** �Ӵ���ʼ���� */
	protected String rstime;
	
	/** �Ӵ���������*/
	protected String retime;

	/** �������벿�� */
	protected String rpporg;
	
	/** �Ӵ��������� */
	protected String rdescription;

	  /** ������Ϣʵ�� */
	@OneToOne
	@JoinColumn(name="rapporgid", referencedColumnName="orgsyscoding", updatable=false, insertable= false)
	@Basic(fetch = FetchType.EAGER)
	@NotFound(action = NotFoundAction.IGNORE)
	
	protected OrganizationTB organizationTB;

	public Integer getRid() {
		return rid;
	}

	public void setRid(Integer rid) {
		this.rid = rid;
	}

	public String getRname() {
		return rname;
	}

	public void setRname(String rname) {
		this.rname = rname;
	}

	public String getRapporgId() { 
		return rapporgid;
	}

	public void setRapporgId(String rapporgid) {
		this.rapporgid = rapporgid;
	}

	public String getRstime() {
		return rstime;
	}

	public void setRstime(String rstime) {
		this.rstime = rstime;
	}

	public String getRetime() {
		return retime;
	}

	public void setRetime(String retime) {
		this.retime = retime;
	}

	public String getRpporg() {
		return rpporg;
	}

	public void setRpporg(String rpporg) {
		this.rpporg = rpporg;
	}

	public String getRdescription() {
		return rdescription;
	}

	public void setRdescription(String rdescription) {
		this.rdescription = rdescription;
	}

	public OrganizationTB getOrganizationTB() {
		return organizationTB;
	}

	public void setOrganizationTB(OrganizationTB organizationTB) {
		this.organizationTB = organizationTB;
	}



	
	
	
	

	
	
	
	

}
