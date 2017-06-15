/*
 * 沈阳递蓝科信息技术有限公司版权所有，保留所有权利。
 * Copyright 2009 Deliverik Co. Ltd.， All rights reserved.
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
 * SOC关系实体
 *
 */
@SuppressWarnings("serial")
@javax.persistence.Entity
@Table(name="SocRelation")
public class SocRelationTB extends BaseEntity implements Serializable, Cloneable, SocRelation {

	/** 主键ID */
	@Id
	@TableGenerator(
		    name="SOCRELATION_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE", 
		    pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE", 
		    pkColumnValue="SOCRELATION_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="SOCRELATION_TABLE_GENERATOR")
	protected Integer srid;

	/** 资产label */
	protected String sreilabel;
	
	/** 关联资产label */
	protected String srpareilabel;
	
	/** 关联资产coding */
	protected String sresycoding;
	
	/** 关联资产类型名称 */
	protected String srename;
	
	/** 预留1(保存版本号) */
	protected String srkey1;
	
	/** 预留2 */
	protected String srkey2;
	
	/** 版本号 */
	protected Integer version;
	
	/** 资产信息实体 */
	@OneToOne
	@JoinColumn(name="srpareilabel", referencedColumnName="eilabel", updatable=false, insertable= false)
	@Basic(fetch = FetchType.EAGER)
	@NotFound(action = NotFoundAction.IGNORE)
	//protected EntityItemTB entityItemTB;
	
	
	/**
	 * 资产信息实体
	 * @return 资产信息实体
	 */
//	public EntityItemTB getEntityItemTB() {
//		return entityItemTB;
//	}

	/**
	 * 主键取得
	 * @return 
	 */
	public Serializable getPK() {
		return srid;
	}

	/**
	 * 主键ID
	 * @return 主键ID
	 */
	public Integer getSrid() {
		return srid;
	}

	/**
	 * 主键ID设定
	 *
	 * @param srid 主键ID
	 */
	public void setSrid(Integer srid) {
		this.srid = srid;
	}

	
	
	
	/**
	 * 版本号
	 * @return 版本号
	 */
	public Integer getVersion() {
		return version;
	}

	/**
	 * 版本号设定
	 *
	 * @param version 版本号
	 */
	public void setVersion(Integer version) {
		this.version = version;
	}

	/**
	 * 资产label
	 * @return 资产label
	 */
	public String getSreilabel() {
		return sreilabel;
	}

	/**
	 * 资产label设定
	 *
	 * @param sreilabel 资产label
	 */
	public void setSreilabel(String sreilabel) {
		this.sreilabel = sreilabel;
	}

	
	/**
	 * 关联资产label
	 * @return 关联资产label
	 */
	public String getSrpareilabel() {
		return srpareilabel;
	}

	/**
	 * 关联资产label设定
	 *
	 * @param srpareilabel 关联资产label
	 */
	public void setSrpareilabel(String srpareilabel) {
		this.srpareilabel = srpareilabel;
	}

	/**
	 * 关联资产coding
	 * @return 关联资产coding
	 */
	public String getSresycoding() {
		return sresycoding;
	}

	/**
	 * 关联资产coding设定
	 *
	 * @param sresycoding 关联资产coding
	 */
	public void setSresycoding(String sresycoding) {
		this.sresycoding = sresycoding;
	}

	/**
	 * 关联资产类型名称
	 * @return 关联资产类型名称
	 */
	public String getSrename() {
		return srename;
	}

	/**
	 * 关联资产类型名称设定
	 *
	 * @param srename 关联资产类型名称
	 */
	public void setSrename(String srename) {
		this.srename = srename;
	}

	/**
	 * 预留1
	 * @return 预留1
	 */
	public String getSrkey1() {
		return srkey1;
	}

	/**
	 * 预留1设定
	 *
	 * @param srkey1 预留1
	 */
	public void setSrkey1(String srkey1) {
		this.srkey1 = srkey1;
	}

	/**
	 * 预留2
	 * @return 预留2
	 */
	public String getSrkey2() {
		return srkey2;
	}

	/**
	 * 预留2设定
	 *
	 * @param srkey2 预留2
	 */
	public void setSrkey2(String srkey2) {
		this.srkey2 = srkey2;
	}



}
