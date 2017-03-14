/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.model.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Basic;
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

import com.csebank.lom.model.Recption;
import com.deliverik.framework.base.BaseEntity;
import com.deliverik.framework.user.model.entity.OrganizationTB;

/**
 * 
 * �Ӵ�����ʵ��
 *
 */
@SuppressWarnings("serial")
@javax.persistence.Entity
@Table(name="Recption")
public class RecptionTB extends BaseEntity implements Serializable, Cloneable, Recption {
	
	/** �Ӵ�����ID */
	@Id
	@TableGenerator(
		    name="RECPTION_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE", 
		    pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE", 
		    pkColumnValue="RECPTION_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="RECPTION_TABLE_GENERATOR")
	protected Integer rid;
	
	/** �Ӵ��������� */
	protected String rname;
	
	/** ��Ҫ���벿�Ų���� */
	protected String rapporgid;
	
	/** �Ӵ��������� */
	protected String retime;
	
	/** �Ӵ���ʼ���� */
	protected String rstime;
	
	/** �Ӵ�������ģ */
	protected String rscale;
	
	/** �Ӵ���׼ */
	protected String rstandard;
	
	/** �������벿������ */
	protected String rpporg;
	
	/** �Ӵ��������� */
	protected String rdescription;
	
	/** �Ǽ����� */
	protected String rdate;
	
	/** ״̬��1�����У�2������ */
	protected String rstatus;
	
	/** ס�޷��� */
	protected BigDecimal rlodgecost;

	/** ס�ޱ�׼ */
	protected String rlodgestandard;
	
	  /** ������Ϣʵ�� */
	@OneToOne
	@JoinColumn(name="rapporgid", referencedColumnName="orgsyscoding", updatable=false, insertable= false)
	@Basic(fetch = FetchType.EAGER)
	@NotFound(action = NotFoundAction.IGNORE)
	protected OrganizationTB organizationTB;

	/**
	 * ����ȡ��
	 * @return 
	 */
	public Serializable getPK() {
		return rid;
	}
	
	/**
	 * �Ӵ�����ID
	 * @return �Ӵ�����ID
	 */
	public Integer getRid() {
		return rid;
	}

	/**
	 * �Ӵ�����ID
	 * @param rid �Ӵ�����ID
	 */
	public void setRid(Integer rid) {
		this.rid = rid;
	}

	/**
	 * �Ӵ���������
	 * @return �Ӵ���������
	 */
	public String getRname() {
		return rname;
	}

	/**
	 * �Ӵ���������
	 * @param rname �Ӵ���������
	 */
	public void setRname(String rname) {
		this.rname = rname;
	}

	/**
	 * ��Ҫ���벿�Ų����
	 * @return ��Ҫ���벿�Ų����
	 */
	public String getRapporgid() {
		return rapporgid;
	}

	/**
	 * ��Ҫ���벿�Ų����
	 * @param rapporgid ��Ҫ���벿�Ų����
	 */
	public void setRapporgid(String rapporgid) {
		this.rapporgid = rapporgid;
	}

	/**
	 * �Ӵ��������� 
	 * @return �Ӵ��������� 
	 */
	public String getRetime() {
		return retime;
	}

	/**
	 * �Ӵ��������� 
	 * @param retime �Ӵ��������� 
	 */
	public void setRetime(String retime) {
		this.retime = retime;
	}

	/**
	 * �Ӵ���ʼ���� 
	 * @return �Ӵ���ʼ���� 
	 */
	public String getRstime() {
		return rstime;
	}

	/**
	 * �Ӵ���ʼ����
	 * @param rstime �Ӵ���ʼ����
	 */
	public void setRstime(String rstime) {
		this.rstime = rstime;
	}

	/**
	 * �Ӵ�������ģ
	 * @return �Ӵ�������ģ
	 */
	public String getRscale() {
		return rscale;
	}

	/**
	 * �Ӵ�������ģ
	 * @param rscale �Ӵ�������ģ
	 */
	public void setRscale(String rscale) {
		this.rscale = rscale;
	}

	/**
	 * �Ӵ���׼
	 * @return �Ӵ���׼
	 */
	public String getRstandard() {
		return rstandard;
	}

	/**
	 * �Ӵ���׼
	 * @param rstandard�Ӵ���׼
	 */
	public void setRstandard(String rstandard) {
		this.rstandard = rstandard;
	}

	/**
	 * �������벿������
	 * @return �������벿������
	 */
	public String getRpporg() {
		return rpporg;
	}

	/**
	 * �������벿������
	 * @param rpporg �������벿������
	 */
	public void setRpporg(String rpporg) {
		this.rpporg = rpporg;
	}

	/**
	 * �Ӵ���������
	 * @return �Ӵ���������
	 */
	public String getRdescription() {
		return rdescription;
	}

	/**
	 * �Ӵ���������
	 * @param rdescription �Ӵ���������
	 */
	public void setRdescription(String rdescription) {
		this.rdescription = rdescription;
	}

	/**
	 * �Ǽ�����
	 * @return �Ǽ�����
	 */
	public String getRdate() {
		return rdate;
	}

	/**
	 * �Ǽ�����
	 * @param rdate �Ǽ�����
	 */
	public void setRdate(String rdate) {
		this.rdate = rdate;
	}

	/**
	 * ״̬
	 * @return ״̬
	 */
	public String getRstatus() {
		return rstatus;
	}

	/**
	 * ״̬
	 * @param rstatus ״̬
	 */
	public void setRstatus(String rstatus) {
		this.rstatus = rstatus;
	}

	public OrganizationTB getOrganizationTB() {
		return organizationTB;
	}
	
	/**
	 * ס�޷���
	 * @return ס�޷���
	 */
	public BigDecimal getRlodgecost() {
		return rlodgecost;
	}
	
	/**
	 * ס�޷���
	 * @param rlodgecost ס�޷���
	 */
	public void setRlodgecost(BigDecimal rlodgecost) {
		this.rlodgecost = rlodgecost;
	}
	
	/**
	 * ס�ޱ�׼
	 * @return ס�ޱ�׼
	 */
	public String getRlodgestandard() {
		return rlodgestandard;
	}
	
	/**
	 * ס�ޱ�׼
	 * @param rlodgestandard ס�ޱ�׼
	 */
	public void setRlodgestandard(String rlodgestandard) {
		this.rlodgestandard = rlodgestandard;
	}
}
