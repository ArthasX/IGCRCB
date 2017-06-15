/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 * Copyright 2009 Deliverik Co. Ltd.�� All rights reserved.
 */

package com.deliverik.infogovernor.soc.model.entity;

import java.io.Serializable;

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

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.soc.model.SocRelation;

/**
 * SOC��ϵʵ��
 *
 */
@SuppressWarnings("serial")
@javax.persistence.Entity
@Table(name="SocRelation")
public class SocRelationTB extends BaseEntity implements Serializable, Cloneable, SocRelation {

	/** ����ID */
	@Id
	@TableGenerator(
		    name="SOCRELATION_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE", 
		    pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE", 
		    pkColumnValue="SOCRELATION_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="SOCRELATION_TABLE_GENERATOR")
	protected Integer srid;

	/** �ʲ�label */
	protected String sreilabel;
	
	/** �����ʲ�label */
	protected String srpareilabel;
	
	/** �����ʲ�coding */
	protected String sresycoding;
	
	/** �����ʲ��������� */
	protected String srename;
	
	/** Ԥ��1(����汾��) */
	protected String srkey1;
	
	/** Ԥ��2 */
	protected String srkey2;
	
	/** �汾�� */
	protected Integer version;
	
	/** �ʲ���Ϣʵ�� */
	@OneToOne
	@JoinColumn(name="srpareilabel", referencedColumnName="eilabel", updatable=false, insertable= false)
	@Basic(fetch = FetchType.EAGER)
	@NotFound(action = NotFoundAction.IGNORE)
	//protected EntityItemTB entityItemTB;
	
	
	/**
	 * �ʲ���Ϣʵ��
	 * @return �ʲ���Ϣʵ��
	 */
//	public EntityItemTB getEntityItemTB() {
//		return entityItemTB;
//	}

	/**
	 * ����ȡ��
	 * @return 
	 */
	public Serializable getPK() {
		return srid;
	}

	/**
	 * ����ID
	 * @return ����ID
	 */
	public Integer getSrid() {
		return srid;
	}

	/**
	 * ����ID�趨
	 *
	 * @param srid ����ID
	 */
	public void setSrid(Integer srid) {
		this.srid = srid;
	}

	
	
	
	/**
	 * �汾��
	 * @return �汾��
	 */
	public Integer getVersion() {
		return version;
	}

	/**
	 * �汾���趨
	 *
	 * @param version �汾��
	 */
	public void setVersion(Integer version) {
		this.version = version;
	}

	/**
	 * �ʲ�label
	 * @return �ʲ�label
	 */
	public String getSreilabel() {
		return sreilabel;
	}

	/**
	 * �ʲ�label�趨
	 *
	 * @param sreilabel �ʲ�label
	 */
	public void setSreilabel(String sreilabel) {
		this.sreilabel = sreilabel;
	}

	
	/**
	 * �����ʲ�label
	 * @return �����ʲ�label
	 */
	public String getSrpareilabel() {
		return srpareilabel;
	}

	/**
	 * �����ʲ�label�趨
	 *
	 * @param srpareilabel �����ʲ�label
	 */
	public void setSrpareilabel(String srpareilabel) {
		this.srpareilabel = srpareilabel;
	}

	/**
	 * �����ʲ�coding
	 * @return �����ʲ�coding
	 */
	public String getSresycoding() {
		return sresycoding;
	}

	/**
	 * �����ʲ�coding�趨
	 *
	 * @param sresycoding �����ʲ�coding
	 */
	public void setSresycoding(String sresycoding) {
		this.sresycoding = sresycoding;
	}

	/**
	 * �����ʲ���������
	 * @return �����ʲ���������
	 */
	public String getSrename() {
		return srename;
	}

	/**
	 * �����ʲ����������趨
	 *
	 * @param srename �����ʲ���������
	 */
	public void setSrename(String srename) {
		this.srename = srename;
	}

	/**
	 * Ԥ��1
	 * @return Ԥ��1
	 */
	public String getSrkey1() {
		return srkey1;
	}

	/**
	 * Ԥ��1�趨
	 *
	 * @param srkey1 Ԥ��1
	 */
	public void setSrkey1(String srkey1) {
		this.srkey1 = srkey1;
	}

	/**
	 * Ԥ��2
	 * @return Ԥ��2
	 */
	public String getSrkey2() {
		return srkey2;
	}

	/**
	 * Ԥ��2�趨
	 *
	 * @param srkey2 Ԥ��2
	 */
	public void setSrkey2(String srkey2) {
		this.srkey2 = srkey2;
	}



}
