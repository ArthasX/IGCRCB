package com.deliverik.infogovernor.scheduling.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.scheduling.model.QuartzProcessInfo;

/**
 * 
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name="QuartzProcessInfo")
public class QuartzProcessInfoTB extends BaseEntity implements Serializable, Cloneable, QuartzProcessInfo {

	@Id
	@TableGenerator(
		    name="QUARTZPROCESSINFO_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE", 
		    pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE", 
		    pkColumnValue="QUARTZPROCESSINFO_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="QUARTZPROCESSINFO_TABLE_GENERATOR")
	protected Integer qpiid;
	
	protected Integer qprid;
	
	protected String qpivarname;
	
	protected String qpivarlabel;
	
	protected String qpivartype;
	
	protected String qpivarvalue;
	
	protected String qpiattkey;
	
	/**
	 * �����Զ���ǰ�����ʶ
	 */
	protected String qpidid;
	
	/** ���̱���ģʽ */
	public String qpidmode;
	
	/** ˽�б���Ȩ�޷�Χ */
	protected String qprivatescope;
	
	/** ��ע */
	protected String qpidcomment;
	
	/**
	 * �����߾��е����̱���Ȩ��
	 */
	protected String qpidaccess;

	@Override
	public Serializable getPK() {
		return qpiid;
	}

	public boolean equals(Object obj) {
		if (!(obj instanceof QuartzProcessInfoTB))
			return false;
		QuartzProcessInfo target = (QuartzProcessInfo) obj;
		if (!(getQpiid()==target.getQpiid()))
			return false;
		return true;
	}

	public Integer getQpiid() {
		return qpiid;
	}

	public void setQpiid(Integer qpiid) {
		this.qpiid = qpiid;
	}

	public Integer getQprid() {
		return qprid;
	}

	public void setQprid(Integer qprid) {
		this.qprid = qprid;
	}

	public String getQpivarname() {
		return qpivarname;
	}

	public void setQpivarname(String qpivarname) {
		this.qpivarname = qpivarname;
	}

	public String getQpivarlabel() {
		return qpivarlabel;
	}

	public void setQpivarlabel(String qpivarlabel) {
		this.qpivarlabel = qpivarlabel;
	}

	public String getQpivartype() {
		return qpivartype;
	}

	public void setQpivartype(String qpivartype) {
		this.qpivartype = qpivartype;
	}

	public String getQpivarvalue() {
		return qpivarvalue;
	}

	public void setQpivarvalue(String qpivarvalue) {
		this.qpivarvalue = qpivarvalue;
	}

	public String getQpiattkey() {
		return qpiattkey;
	}

	public void setQpiattkey(String qpiattkey) {
		this.qpiattkey = qpiattkey;
	}

	public String getQpidid() {
		return qpidid;
	}

	public void setQpidid(String qpidid) {
		this.qpidid = qpidid;
	}

	public String getQpidmode() {
		return qpidmode;
	}

	public void setQpidmode(String qpidmode) {
		this.qpidmode = qpidmode;
	}

	public String getQprivatescope() {
		return qprivatescope;
	}

	public void setQprivatescope(String qprivatescope) {
		this.qprivatescope = qprivatescope;
	}

	public String getQpidcomment() {
		return qpidcomment;
	}

	public void setQpidcomment(String qpidcomment) {
		this.qpidcomment = qpidcomment;
	}


	/**
	 * �����߾��е����̱���Ȩ��ȡ��
	 * @return �����߾��е����̱���Ȩ��
	 */
	public String getQpidaccess() {
		return qpidaccess;
	}

	/**
	 * �������߾��е����̱���Ȩ���趨
	 * @param pidaccess �����߾��е����̱���Ȩ��
	 */
	public void setQpidaccess(String qpidaccess) {
		this.qpidaccess = qpidaccess;
	}

}
